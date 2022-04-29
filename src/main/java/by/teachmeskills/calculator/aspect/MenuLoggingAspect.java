package by.teachmeskills.calculator.aspect;

import by.teachmeskills.calculator.entity.Operation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Aspect
@Component
public class MenuLoggingAspect {
    private static final String MENU_HEADER = "~~~~~~~~~~~~~~~~~~~CALCULATOR~~~~~~~~~~~~~~~~~~~";
    private static final String MENU_FOOTER = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    @Before(
            value = "by.teachmeskills.calculator.aspect.CalculatorPointcuts.getKeyboardInput()"
    )
    public void beforeGetKeyboardInputLoggingAdvice() {
        log.info("Enter option:");
    }

    @Before(
            value = "by.teachmeskills.calculator.aspect.CalculatorPointcuts.getKeyboardInputWithKey() && args(key)"
    )
    public void beforeGetKeyboardInputWithKeyLoggingAdvice(String key) {
        log.info("Enter {}:", key);
    }

    @AfterReturning(
            value = "by.teachmeskills.calculator.aspect.CalculatorPointcuts.getAnyInput()",
            returning = "input"
    )
    public void afterGettingAnyInputLoggingAdvice(String input) {
        Marker inputMarker = MarkerFactory.getMarker("INPUT");
        log.info(inputMarker, "User input: {}", input);
    }

    @AfterReturning(
            value = "by.teachmeskills.calculator.aspect.CalculatorPointcuts.addOperationToStorage()",
            returning = "operation"
    )
    public void afterAddingOperationLoggingAdvice(Operation operation) {
        log.info("Operation was added to storage - {}", operation);
    }

    @AfterReturning(
            value = "by.teachmeskills.calculator.aspect.CalculatorPointcuts.getAllOperations()",
            returning = "operations"
    )
    public void afterGettingAllOperationsLoggingAdvice(List<Operation> operations) {
        log.info("List of all operations in storage:");
        operations.forEach(operation -> log.info(operation.toString()));
        log.info("End of list...");
    }

    @AfterReturning(
            value = "by.teachmeskills.calculator.aspect.CalculatorPointcuts.closeMenu()"
    )
    public void afterClosingMenuLoggingAdvice() {
        log.info("See you later!");
    }

    @Around(
            value = "by.teachmeskills.calculator.aspect.CalculatorPointcuts.clearOperationStorage()"
    )
    public Object aroundClearOperationStorageLoggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.warn("Request for clearing operation storage was received!");
        Object proceed = joinPoint.proceed();
        log.info("Operation storage was cleared!");
        return proceed;
    }

    @Around(
            value = "by.teachmeskills.calculator.aspect.CalculatorPointcuts.showMenu()"
    )
    public Object aroundShowMenuLoggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(MENU_HEADER);
        Object proceed = joinPoint.proceed();
        log.info(MENU_FOOTER);
        return proceed;
    }
}