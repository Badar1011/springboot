package order.Morrisons;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;



import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@Component
public class OrderResourceAssembler implements ResourceAssembler<Order, Resource<Order>> {

    @Override
    public Resource<Order> toResource(Order order) {
        return new Resource<>(order,
                linkTo(methodOn(OrderController.class).getOneOrder(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).getAllOrders()).withRel("orders"));
    }
}