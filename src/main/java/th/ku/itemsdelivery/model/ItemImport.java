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
public class ItemImport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="item_id", referencedColumnName="id")
    private Item item;

    private int importQuantity;
    private LocalDateTime importDatetime;
    private String importRemark; // ARRIVAL, RETURN

    public ItemImport(Item item, int importQuantity) {
    }
}
