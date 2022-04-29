package by.teachmeskills.calculator.service;

import by.teachmeskills.calculator.entity.Operand;
import by.teachmeskills.calculator.entity.Operation;

import java.util.List;

public interface OperationService {
    Operation add(Operation operation);

    List<Operation> getAll();

    void clear();

    Operation calculate(double firstValue, double secondValue, Operand operand);
}
