package th.ku.itemsdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ku.itemsdelivery.model.OrderRequest;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequest, Integer> {
}
