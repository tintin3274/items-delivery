package th.ku.itemsdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ku.itemsdelivery.model.OrderRequest;

import java.util.List;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequest, Integer> {
    List<OrderRequest> findByStatusEquals(String status);
}
