package order.Morrisons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderResourceAssembler orderResourceAssembler;

  /*  public Resources<Resource<Order>> getAllOrder()
    {
        List<Resource<Order>> orders =  orderRepository.findAll().stream()
                .map(orderResourceAssembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(orders, linkTo(methodOn(OrderService.class).getAllOrder()).withSelfRel());
    }*/

    public Resource<Order> getOneOrder(Long id) {
        Order order =  orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return orderResourceAssembler.toResource(order);
    }

    public Resources<Resource<Order>> all(){
        List<Resource<Order>> orders =  orderRepository.findAll().stream()
                .map(orderResourceAssembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(orders, linkTo(methodOn(OrderController.class).getAllOrders()).withSelfRel());
    }

    public Resource<Order> save(Order order)
    {
        return orderResourceAssembler.toResource(orderRepository.save(order));
    }


}