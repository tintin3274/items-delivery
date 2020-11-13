package th.ku.itemsdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ku.itemsdelivery.model.ListItem;
import th.ku.itemsdelivery.model.ListItemId;

import java.util.List;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, ListItemId> {
    List<ListItem> findByListItemId_OrderId(int orderId);
}
