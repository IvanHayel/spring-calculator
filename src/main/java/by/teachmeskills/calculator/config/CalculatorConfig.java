package by.teachmeskills.calculator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "by.teachmeskills.calculator")
@EnableAspectJAutoProxy
@PropertySource("classpath:calculator.properties")
public class CalculatorConfig {
}