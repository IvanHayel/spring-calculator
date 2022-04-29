package by.teachmeskills.calculator.view.menu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("historyMenu")

@Slf4j
public class HistoryMenu implements Menu {
    @Value("#{${menu.options.history}}")
    private Map<Integer, String> options;

    @Override
    public void show() {
        for (Map.Entry<Integer, String> entry : options.entrySet()) {
            log.info("{}. {}", entry.getKey(), entry.getValue());
        }
    }
}