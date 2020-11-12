package kr.ac.dongseo.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.ac.dongseo.reservation.dao", "kr.ac.dongseo.reservation.service", })
@Import({DBConfig.class})
public class ApplicationConfig {

}
