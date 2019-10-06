package order.Morrisons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(OrderService orderService)
    {
        return args -> {
       //     log.info("Preloading " + orderService.save(new Order("Bilbo Baggins", "burglar")));
       //     log.info("Preloading " + orderService.save(new Order("Bilbo Baggins", "burglar")));
        };
    }
}
