package th.ku.itemsdelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemExport {
    @EmbeddedId
    private ItemExportId itemExportId;

    private int exportQuantity;
    private LocalDateTime exportDatetime;
}
