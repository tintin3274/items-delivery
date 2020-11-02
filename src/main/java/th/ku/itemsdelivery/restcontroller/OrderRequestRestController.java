package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.repository.OrderRequestRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/items-delivery/order_request")
public class OrderRequestRestController {
    private OrderRequestRepository repository;

    public OrderRequestRestController(OrderRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<OrderRequest> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public OrderRequest getOne(@PathVariable int id){
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @PostMapping
    public OrderRequest create(@RequestBody OrderRequest orderRequest) {
        OrderRequest record = repository.saveAndFlush(orderRequest);
        return record;
    }
}
