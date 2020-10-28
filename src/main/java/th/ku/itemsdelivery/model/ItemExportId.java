package th.ku.itemsdelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemExportId implements Serializable {
    private int orderId;
    private int itemId;
}
