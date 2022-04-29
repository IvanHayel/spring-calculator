package by.teachmeskills.calculator.service;

import by.teachmeskills.calculator.entity.Operand;
import by.teachmeskills.calculator.entity.Operation;
import by.teachmeskills.calculator.view.menu.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("menuService")
@Slf4j
public class MenuServiceImpl implements MenuService {
    private static final int FIRST_OPTION = 1;
    private static final int SECOND_OPTION = 2;
    private static final int THIRD_OPTION = 3;
    private static final int FOURTH_OPTION = 4;
    private static final int FIFTH_OPTION = 5;
    private static final int SIXTH_OPTION = 6;
    private static final int SEVENTH_OPTION = 7;

    private static final String WRONG_INPUT_MESSAGE = "Wrong input! Try again.";
    private static final String REAL_NUMBER_POSTFIX = "real number";

    private final Menu mainMenu;
    private final Menu calculateMenu;
    private final Menu historyMenu;
    private final OperationService operationService;

    @Autowired
    public MenuServiceImpl(
            @Qualifier("mainMenu") Menu mainMenu,
            @Qualifier("calculateMenu") Menu calculateMenu,
            @Qualifier("historyMenu") Menu historyMenu,
            OperationService operationService
    ) {
        this.mainMenu = mainMenu;
        this.calculateMenu = calculateMenu;
        this.historyMenu = historyMenu;
        this.operationService = operationService;
    }

    @Override
    public void forwardMainMenu() {
        mainMenu.show();
        selectMainMenuOption();
    }

    @Override
    public void forwardCalculateMenu() {
        calculateMenu.show();
        selectCalculateMenuOption();
    }

    @Override
    public void forwardHistoryMenu() {
        historyMenu.show();
        selectHistoryMenuOption();
    }

    @Override
    public void selectMainMenuOption() {
        Integer option = getInputOption();
        switch (option) {
            case FIRST_OPTION:
                forwardCalculateMenu();
                break;
            case SECOND_OPTION:
                forwardHistoryMenu();
                break;
            case THIRD_OPTION:
                mainMenu.close();
                break;
            default:
                log.warn(WRONG_INPUT_MESSAGE);
                forwardMainMenu();
        }
    }

    @Override
    public void selectCalculateMenuOption() {
        Operand operand = null;
        Integer option = getInputOption();
        switch (option) {
            case FIRST_OPTION:
                operand = Operand.ADDITION;
                break;
            case SECOND_OPTION:
                operand = Operand.SUBTRACTION;
                break;
            case THIRD_OPTION:
                operand = Operand.MULTIPLICATION;
                break;
            case FOURTH_OPTION:
                operand = Operand.DIVISION;
                break;
            case FIFTH_OPTION:
                operand = Operand.POWER;
                break;
            case SIXTH_OPTION:
                forwardMainMenu();
                break;
            case SEVENTH_OPTION:
                calculateMenu.close();
                break;
            default:
                log.warn(WRONG_INPUT_MESSAGE);
                forwardCalculateMenu();
        }
        if (operand != null) {
            double firstValue = getInputRealNumber();
            double secondValue = getInputRealNumber();
            Operation operation = operationService.calculate(firstValue, secondValue, operand);
            operationService.add(operation);
            forwardMainMenu();
        }
    }

    @Override
    public void selectHistoryMenuOption() {
        Integer option = getInputOption();
        switch (option) {
            case FIRST_OPTION:
                operationService.getAll();
                forwardHistoryMenu();
                break;
            case SECOND_OPTION:
                operationService.clear();
                forwardHistoryMenu();
                break;
            case THIRD_OPTION:
                forwardMainMenu();
                break;
            case FOURTH_OPTION:
                historyMenu.close();
                break;
            default:
                log.warn(WRONG_INPUT_MESSAGE);
                forwardHistoryMenu();
        }
    }

    private Integer getInputOption() {
        String input = mainMenu.getKeyboardInput();
        return isNumber(input) ? Integer.parseInt(input) : Integer.MIN_VALUE;
    }

    private boolean isNumber(String text) {
        return text.matches("[0-9]+");
    }

    private double getInputRealNumber() {
        String input = mainMenu.getKeyboardInput(REAL_NUMBER_POSTFIX);
        return isRealNumber(input) ? Double.parseDouble(input) : Double.MIN_VALUE;
    }

    private boolean isRealNumber(String text) {
        return text.matches("[0-9]+([.][0-9]+)?");
    }
}