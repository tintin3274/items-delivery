package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.repository.OrderRequestRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/items-delivery/order_request")
public class OrderRequestRestController {
    private OrderRequestRepository orderRequestRepository;

    public OrderRequestRestController(OrderRequestRepository orderRequestRepository) {
        this.orderRequestRepository = orderRequestRepository;
    }

    @GetMapping
    public List<OrderRequest> getAll() {
        return orderRequestRepository.findAll();
    }

    @GetMapping("/{id}")
    public OrderRequest getOne(@PathVariable int id){
        try {
            return orderRequestRepository.findById(id).get();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @PostMapping
    public OrderRequest create(@RequestBody OrderRequest orderRequest) {
        orderRequest.setStatus("PENDING");
        orderRequest.setCreateDatetime(LocalDateTime.now());
        orderRequestRepository.saveAndFlush(orderRequest);
        return orderRequest;
    }
}
