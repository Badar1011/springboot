package order.Morrisons;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Item {

    private @Id @GeneratedValue long id;
    private String itemId;
    private int itemLineId;
    private String itemBaseType;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private ItemAlternateId itemAlternateId;
    private String itemDescription;
    private String quantityType;
    private int quantityOrdered;
    private String priceOrderedCurrency;
    private double priceOrderedAmount;
    private int priceOrderedTaxRate;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order orderedBy;

/*    public Item(String itemId, int itemLineId, String itemBaseType, ItemAlternateId itemAlternateId, String itemDescription, String quantityType, int quantityOrdered, String priceOrderedCurrency, double priceOrderedAmount, int priceOrderedTaxRate) {
        this.itemId = itemId;
        this.itemLineId = itemLineId;
        this.itemBaseType = itemBaseType;
        this.itemAlternateId = itemAlternateId;
        this.itemDescription = itemDescription;
        this.quantityType = quantityType;
        this.quantityOrdered = quantityOrdered;
        this.priceOrderedCurrency = priceOrderedCurrency;
        this.priceOrderedAmount = priceOrderedAmount;
        this.priceOrderedTaxRate = priceOrderedTaxRate;
    }*/
}