package th.ku.itemsdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ku.itemsdelivery.model.ItemExport;
import th.ku.itemsdelivery.model.ItemExportId;

@Repository
public interface ItemExportRepository extends JpaRepository<ItemExport, ItemExportId> {
}
