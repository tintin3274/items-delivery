package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.*;
import th.ku.itemsdelivery.repository.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/items-delivery/order_request")
public class OrderRequestRestController {
    private OrderRequestRepository orderRequestRepository;
    private ItemRepository itemRepository;
    private ListItemRepository listItemRepository;
    private ItemImportRepository itemImportRepository;
    private ItemExportRepository itemExportRepository;

    public OrderRequestRestController(OrderRequestRepository orderRequestRepository, ItemRepository itemRepository, ListItemRepository listItemRepository, ItemImportRepository itemImportRepository, ItemExportRepository itemExportRepository) {
        this.orderRequestRepository = orderRequestRepository;
        this.itemRepository = itemRepository;
        this.listItemRepository = listItemRepository;
        this.itemImportRepository = itemImportRepository;
        this.itemExportRepository = itemExportRepository;
    }

    @GetMapping
    public List<OrderRequest> getAll() {
        return orderRequestRepository.findAll();
    }

    @GetMapping("/{id}")
    public OrderRequest getOne(@PathVariable int id) {
        try {
            return orderRequestRepository.findById(id).get();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/status={status}")
    public List<OrderRequest> getStatusAll(@PathVariable String status) {
        return orderRequestRepository.findByStatusEquals(status);
    }

    @PostMapping
    public OrderRequest create(@RequestBody OrderRequest orderRequest) {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        orderRequest.setId(0);
        orderRequest.setStatus("PENDING");
        orderRequest.setCreateDatetime(localDateTimeNow);
        orderRequest.setLastUpdateDatetime(localDateTimeNow);
        orderRequestRepository.saveAndFlush(orderRequest);
        return orderRequest;
    }

    @GetMapping("/progress/{id}")
    public OrderRequest progress(@PathVariable int id) {
        OrderRequest orderRequest = getOne(id);
        if(orderRequest.getStatus().equals("PENDING")) {
            if(pendingCheckOrderRequestItem(id)) {
                LocalDateTime localDateTimeNow = LocalDateTime.now();
                orderRequest.setStatus("PROGRESS");
                orderRequest.setLastUpdateDatetime(localDateTimeNow);
                orderRequestRepository.save(orderRequest);
                for(ListItem listItem : listItemRepository.findByListItemId_OrderId(id)) {
                    ListItemId listItemId = listItem.getListItemId();

                    ItemExportId itemExportId = new ItemExportId(listItemId.getOrderId(), listItemId.getItemId());
                    ItemExport itemExport = new ItemExport(itemExportId, listItem.getQuantity(), localDateTimeNow);
                    itemExportRepository.save(itemExport);

                    Item item = itemRepository.findById(listItemId.getItemId()).get();
                    item.setRequired(item.getRequired() - listItem.getQuantity());
                    item.setQuantity(item.getQuantity() - listItem.getQuantity());
                    itemRepository.save(item);
                }
            }
        }
        return orderRequest;
    }

    @GetMapping("/success/{id}")
    public OrderRequest success(@PathVariable int id) {
        OrderRequest orderRequest = getOne(id);
        if(orderRequest.getStatus().equals("PROGRESS")) {
            orderRequest.setStatus("SUCCESS");
            orderRequest.setLastUpdateDatetime(LocalDateTime.now());
            orderRequestRepository.save(orderRequest);
        }
        return orderRequest;
    }

    @GetMapping("/cancel/{id}")
    public OrderRequest cancel(@PathVariable int id) {
        OrderRequest orderRequest = getOne(id);
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        if(orderRequest.getStatus().equals("PROGRESS")) {
            orderRequest.setStatus("CANCEL");
            orderRequest.setLastUpdateDatetime(localDateTimeNow);
            orderRequestRepository.save(orderRequest);
            for(ListItem listItem : listItemRepository.findByListItemId_OrderId(id)) {
                ListItemId listItemId = listItem.getListItemId();

                ItemImport itemImport = new ItemImport();
                itemImport.setItemId(listItemId.getItemId());
                itemImport.setImportQuantity(listItem.getQuantity());
                itemImport.setImportRemark("RETURN");
                itemImport.setImportDatetime(localDateTimeNow);
                itemImportRepository.saveAndFlush(itemImport);

                Item item = itemRepository.findById(listItemId.getItemId()).get();
                item.setQuantity(item.getQuantity() + listItem.getQuantity());
                itemRepository.save(item);
            }
        }
        else if(orderRequest.getStatus().equals("PENDING")) {
            orderRequest.setStatus("CANCEL");
            orderRequest.setLastUpdateDatetime(localDateTimeNow);
            orderRequestRepository.save(orderRequest);
            for(ListItem listItem : listItemRepository.findByListItemId_OrderId(id)) {
                ListItemId listItemId = listItem.getListItemId();

                Item item = itemRepository.findById(listItemId.getItemId()).get();
                item.setRequired(item.getRequired() - listItem.getQuantity());
                itemRepository.save(item);
            }
        }
        return orderRequest;
    }

    @GetMapping("/pending/{id}")
    public boolean pendingCheckOrderRequestItem(@PathVariable int id) {
        OrderRequest orderRequest = getOne(id);
        if(orderRequest.getStatus().equals("PENDING")) {
            for(ListItem listItem : listItemRepository.findByListItemId_OrderId(id)) {
                ListItemId listItemId = listItem.getListItemId();

                Item item = itemRepository.findById(listItemId.getItemId()).get();
                if(item.getQuantity() < listItem.getQuantity()) return false;
            }
            return true;
        }
        return false;
    }

    @GetMapping("/pending-available")
    public HashMap<Integer, Boolean> pendingCheckOrderRequestItemAll() {
        HashMap<Integer, Boolean> allPendingStatusAvailable = new HashMap<>();
        for(OrderRequest orderRequest : getStatusAll("PENDING")) {
            allPendingStatusAvailable.put(orderRequest.getId(), pendingCheckOrderRequestItem(orderRequest.getId()));
        }
        return allPendingStatusAvailable;
    }
}
