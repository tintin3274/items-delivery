package th.ku.itemsdelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ItemExportId.class)
public class ItemExport {
    @Id
    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName="id")
    private OrderRequest orderRequest;

    @Id
    @ManyToOne
    @JoinColumn(name="item_id", referencedColumnName="id")
    private Item item;

    private int exportQuantity;
    private LocalDateTime exportDatetime;
}
