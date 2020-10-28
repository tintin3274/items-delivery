package th.ku.itemsdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ku.itemsdelivery.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
