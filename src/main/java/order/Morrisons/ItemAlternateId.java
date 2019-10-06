package order.Morrisons;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ItemAlternateId {
    private @Id @GeneratedValue long id;
    private String skuMin;
    private String skuPin;
    private String skuLegacy;
    private String barcodeAsin;
    private String barcodeEan;
    @OneToOne
    @JsonBackReference
    private Item item;
}