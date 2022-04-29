package by.teachmeskills.calculator.storage;

import by.teachmeskills.calculator.entity.Operation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository(value = "operationStorage")
public class OperationStorageImpl implements OperationStorage {
    private static final Collection<Operation> OPERATIONS = new ArrayList<>();

    @Override
    public Operation add(Operation operation) {
        boolean isAdded = OPERATIONS.add(operation);
        return isAdded ? operation : null;
    }

    @Override
    public List<Operation> getAll() {
        return new ArrayList<>(OPERATIONS);
    }

    public void clear() {
        OPERATIONS.clear();
    }
}