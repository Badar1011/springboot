package order.Morrisons;


import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

 /*   @GetMapping("/orders")
    public Resources<Resource<Order>> getAllOrders() {
        return orderService.getAllOrder();
    }*/

    @GetMapping("/orders")
    public Resources<Resource<Order>> getAllOrders() {
        return orderService.all();
    }

    @GetMapping("/orders/{id}")
    public Resource<Order> getOneOrder(@PathVariable Long id) {
        return orderService.getOneOrder(id);
    }

    @PostMapping("/orders")
    public ResponseEntity<Resource<Order>> newOrder(@Valid @RequestBody Order order) throws URISyntaxException {
        Resource<Order> orderResource = orderService.save(order);
        return ResponseEntity
                .created(new URI(orderResource.getId().expand().getHref()))
                .body(orderResource);
    }
}