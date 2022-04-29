package by.teachmeskills.calculator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

@NoArgsConstructor
@Getter
public enum Operand {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    POWER("^");

    private String symbol;

    Operand(String symbol) {
        this.symbol = symbol;
    }
}