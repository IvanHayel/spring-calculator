package by.teachmeskills.calculator.storage;

import by.teachmeskills.calculator.entity.Operation;

import java.util.List;

public interface OperationStorage {
    Operation add(Operation operation);

    List<Operation> getAll();

    void clear();
}
