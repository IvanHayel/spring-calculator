package by.teachmeskills.calculator.service;

import by.teachmeskills.calculator.entity.Operand;
import by.teachmeskills.calculator.entity.Operation;
import by.teachmeskills.calculator.storage.OperationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service(value = "operationService")
public class OperationServiceImpl implements OperationService {
    private final OperationStorage STORAGE;

    @Autowired
    public OperationServiceImpl(OperationStorage storage) {
        STORAGE = storage;
    }

    @Override
    public Operation add(Operation operation) {
        return STORAGE.add(operation);
    }

    @Override
    public List<Operation> getAll() {
        return STORAGE.getAll();
    }

    @Override
    public void clear() {
        STORAGE.clear();
    }

    @Override
    public Operation calculate(double firstValue, double secondValue, Operand operand) {
        Operation operation = new Operation();
        operation.setTimestamp(LocalDateTime.now());
        operation.setFirstValue(firstValue);
        operation.setSecondValue(secondValue);
        operation.setOperand(operand);
        switch (operand) {
            case ADDITION:
                operation.setResult(firstValue + secondValue);
                break;
            case SUBTRACTION:
                operation.setResult(firstValue - secondValue);
                break;
            case MULTIPLICATION:
                operation.setResult(firstValue * secondValue);
                break;
            case DIVISION:
                operation.setResult(firstValue / secondValue);
                break;
            case POWER:
                operation.setResult(Math.pow(firstValue, secondValue));
                break;
            default:
                operation.setResult(Double.NaN);
        }
        return operation;
    }
}