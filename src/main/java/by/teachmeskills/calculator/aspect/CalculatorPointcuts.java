package by.teachmeskills.calculator.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CalculatorPointcuts {
    private CalculatorPointcuts() {
    }

    @Pointcut("execution(* by.teachmeskills.calculator.storage.OperationStorage.add(..))")
    public void addOperationToStorage() {
    }

    @Pointcut("execution(* by.teachmeskills.calculator.storage.OperationStorage.getAll())")
    public void getAllOperations() {
    }

    @Pointcut("execution(* by.teachmeskills.calculator.storage.OperationStorage.clear())")
    public void clearOperationStorage() {
    }

    @Pointcut("execution(* by.teachmeskills.calculator.view.menu.*.show())")
    public void showMenu() {
    }

    @Pointcut("execution(* by.teachmeskills.calculator.view.menu.*.close())")
    public void closeMenu() {
    }

    @Pointcut("execution(* by.teachmeskills.calculator.view.menu.*.getKeyboardInput())")
    public void getKeyboardInput() {
    }

    @Pointcut("execution(* by.teachmeskills.calculator.view.menu.*.getKeyboardInput(String))")
    public void getKeyboardInputWithKey() {
    }

    @Pointcut("execution(* by.teachmeskills.calculator.view.menu.*.getKeyboardInput*(..))")
    public void getAnyInput() {
    }
}