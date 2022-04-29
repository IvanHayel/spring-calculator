package by.teachmeskills.calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Scope("prototype")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private double firstValue;
    private double secondValue;
    private double result;
    private Operand operand;
    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return String.format(
                "[%s]: %f %s %f = %f",
                timestamp.format(TIMESTAMP_FORMAT),
                firstValue,
                operand.getSymbol(),
                secondValue,
                result
        );
    }
}