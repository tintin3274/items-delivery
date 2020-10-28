package th.ku.itemsdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ku.itemsdelivery.model.ListItem;
import th.ku.itemsdelivery.model.ListItemId;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, ListItemId> {
}
