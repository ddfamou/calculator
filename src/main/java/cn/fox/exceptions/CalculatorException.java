package cn.fox.exceptions;

public class CalculatorException extends RuntimeException {

    String calculatorExceptionMessage;

    public CalculatorException() {
        super();
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(Throwable cause) {
        super(cause);
    }

    public String getErrorMessage() {
        if (calculatorExceptionMessage == null || calculatorExceptionMessage.isEmpty()) {
            return getMessage();
        }
        return calculatorExceptionMessage;
    }

    public void setErrorMessage(String errorMessage) {
        calculatorExceptionMessage = errorMessage;
    }
}
