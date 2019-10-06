package order.Morrisons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "order_table")
public class Order {

    private @Id
    @GeneratedValue
    long id;
    private String orderId;
    private String orderReferenceCode;
    private String messageId;
    private String messageType;
    private String messageCreatedAt; // Date
    private String shipToLocationId;
    private String shipToAddressName;
    private String shipToAddressLine1;
    private String shipToAddressLine2;
    private String shipToAddressCity;
    private String shipToAddressState;
    private String shipToAddressPostCode;
    private String shipToAddressCountryCode;
    private String shipToDeliverAt; // Date
    private String shipToDeliverLatestAt; // Date
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orderedBy")
    @JsonManagedReference
    private List<Item> items;
/*
    public Order(String orderId, String orderReferenceCode, String messageId, String messageType, String messageCreatedAt, String shipToLocationId, String shipToAddressName, String shipToAddressLine1, String shipToAddressLine2, String shipToAddressCity, String shipToAddressState, String shipToAddressPostCode, String shipToAddressCountryCode, String shipToDeliverAt, String shipToDeliverLatestAt, List<Item> items) {
        this.orderId = orderId;
        this.orderReferenceCode = orderReferenceCode;
        this.messageId = messageId;
        this.messageType = messageType;
        this.messageCreatedAt = messageCreatedAt;
        this.shipToLocationId = shipToLocationId;
        this.shipToAddressName = shipToAddressName;
        this.shipToAddressLine1 = shipToAddressLine1;
        this.shipToAddressLine2 = shipToAddressLine2;
        this.shipToAddressCity = shipToAddressCity;
        this.shipToAddressState = shipToAddressState;
        this.shipToAddressPostCode = shipToAddressPostCode;
        this.shipToAddressCountryCode = shipToAddressCountryCode;
        this.shipToDeliverAt = shipToDeliverAt;
        this.shipToDeliverLatestAt = shipToDeliverLatestAt;
        this.items.forEach(item -> item.setOrderedBy(this));
    }*/
}

