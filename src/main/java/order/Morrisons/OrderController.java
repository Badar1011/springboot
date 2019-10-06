package order.Morrisons;


import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

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
    public Order getOneOrder(@PathVariable Long id) {
        return orderService.getOneOrder(id);
    }

    @PostMapping("/orders")
    public Order newOrder(@RequestBody Order order) {
        return orderService.save(order);
    }
}
