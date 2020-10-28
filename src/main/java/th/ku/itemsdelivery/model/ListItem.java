package th.ku.itemsdelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ListItem {
    @Id
    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName="id")
    private OrderRequest orderRequest;

    @Id
    @ManyToOne
    @JoinColumn(name="item_id", referencedColumnName="id")
    private Item item;

    private int quantity;
}
