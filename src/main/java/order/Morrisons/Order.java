package order.Morrisons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "order_table")
public class Order {

    private @Id
    @GeneratedValue
    long id;
    @NotBlank(message = "Order id must be given")
    private String orderId;
    private String orderReferenceCode;
    private String messageId;
    @NotBlank(message = "message type must be given")
    private String messageType;
    @NotBlank(message = "message created date must be given")
    private String messageCreatedAt; // Date
    @NotBlank(message = "ship to location id must be given")
    private String shipToLocationId;
    @NotBlank(message = "ship to address name must be given")
    private String shipToAddressName;
    @NotBlank(message = "address line 1 must be given")
    private String shipToAddressLine1;
    private String shipToAddressLine2;
    @NotBlank(message = "ship to address city must be given")
    private String shipToAddressCity;
    @NotBlank(message = "ship to address state must be given")
    private String shipToAddressState;
    @NotBlank(message = "ship to address postcode must be given")
    private String shipToAddressPostCode;
    @NotBlank(message = "ship to address country must be given")
    private String shipToAddressCountryCode;
    @NotBlank(message = "ship to deliver at date must be given")
    private String shipToDeliverAt; // Date
    @NotBlank(message = "ship to deliver latest at date must be given")
    private String shipToDeliverLatestAt; // Date
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orderedBy")
    @JsonManagedReference
    @NotNull(message = "item must be given")
    @Valid
    private List<Item> items;

}

