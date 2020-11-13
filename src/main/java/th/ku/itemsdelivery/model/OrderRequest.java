package th.ku.itemsdelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;
    private String status; // PENDING, PROGRESS, SUCCESS, CANCEL

    @NotBlank
    private String address;

    private String description;
    private LocalDateTime createDatetime;
    private LocalDateTime dueDatetime;
    private LocalDateTime lastUpdateDatetime;

    private int customer_id;
}
