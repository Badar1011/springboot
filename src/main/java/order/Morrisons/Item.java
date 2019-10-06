package order.Morrisons;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NoArgsConstructor
@Data
public class Item {

    private @Id
    @GeneratedValue
    long id;
    @NotBlank(message = "Item id must be given")
    private String itemId;
    @NotNull(message = "item line id must be given")
    @Positive(message = "integer value must be given")
    private int itemLineId;
    @NotBlank(message = "item base type must be given")
    private String itemBaseType;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private ItemAlternateId itemAlternateId;
    @NotBlank(message = "item description must be given")
    private String itemDescription;
    @NotBlank(message = "quantity type must be given")
    private String quantityType;
    @NotNull(message = "quantity ordered must be given")
    @Positive(message = "positive value must be given")
    private int quantityOrdered;
    @NotBlank(message = "price ordered currency must be given")
    private String priceOrderedCurrency;
    @NotNull(message = "price ordered amount must be given")
    @Positive(message = "positive value must be given")
    private double priceOrderedAmount;
    @NotNull(message = "price ordered tax rate must be given")
    @Positive(message = "positive integer value must be given")
    private int priceOrderedTaxRate;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order orderedBy;
}