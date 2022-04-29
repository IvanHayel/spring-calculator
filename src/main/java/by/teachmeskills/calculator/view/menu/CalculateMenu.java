package by.teachmeskills.calculator.view.menu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("calculateMenu")

@Slf4j
public class CalculateMenu implements Menu {
    @Value("#{${menu.options.calculate}}")
    private Map<Integer, String> options;

    @Override
    public void show() {
        for (Map.Entry<Integer, String> entry : options.entrySet()) {
            log.info("{}. {}", entry.getKey(), entry.getValue());
        }
    }
}