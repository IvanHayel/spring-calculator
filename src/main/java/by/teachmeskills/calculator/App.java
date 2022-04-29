package by.teachmeskills.calculator;

import by.teachmeskills.calculator.config.CalculatorConfig;
import by.teachmeskills.calculator.service.MenuService;
import lombok.Cleanup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        @Cleanup AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CalculatorConfig.class);
        MenuService menuService = context.getBean("menuService", MenuService.class);
        menuService.forwardMainMenu();
    }
}
