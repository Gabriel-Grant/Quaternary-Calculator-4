public class CalculatorLogic {

    public String toQuad(String decimalNumber) {
        return Integer.toString(Integer.parseInt(decimalNumber, 10), 4);
    }

    public String toDecimal(String quadNumber) {
        return Integer.toString(Integer.parseInt(quadNumber, 4), 10);
    }

    public String twoValueOperation(String firstValue, char operation, String secondValue) throws Exception {
        int firstValueDecimal = Integer.parseInt(toDecimal(firstValue));
        int secondValueDecimal = Integer.parseInt(toDecimal(secondValue));

        return switch (operation) {
            case '+' -> toQuad(Integer.toString(firstValueDecimal + secondValueDecimal));
            case '-' -> toQuad(Integer.toString(firstValueDecimal - secondValueDecimal));
            case '*' -> toQuad(Integer.toString(firstValueDecimal * secondValueDecimal));
            case '/' -> toQuad(Integer.toString(firstValueDecimal / secondValueDecimal));
            default -> throw new Exception("Must be a valid operation");
        };
    }

    public String square(String value){
        int valueDecimal = Integer.parseInt(toDecimal(value));
        return toQuad(Integer.toString(valueDecimal * valueDecimal));
    }

    public String squareRoot(String value){
        int valueDecimal = Integer.parseInt(toDecimal(value));
        return toQuad(Integer.toString((int)(Math.sqrt(valueDecimal))));
    }
}