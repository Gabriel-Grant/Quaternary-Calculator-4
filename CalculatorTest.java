import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    CalculatorLogic calc = new CalculatorLogic();

    @Test
    public void conversionToQuaternaryTest() {
        String expected = "1210";
        String actual = calc.toQuad("100");
        assertEquals(expected, actual);
    }

    @Test
    public void conversionToDecimalTest() {
        String expected = "100";
        String actual = calc.toDecimal("1210");
        assertEquals(expected, actual);
    }

    @Test
    public void additionTest() throws Exception {
        String expected = "1";
        String actual = calc.twoValueOperation("0", "+", "1");
        assertEquals(expected, actual);
    }


    @Test
    public void additionTest2() throws Exception {
        String expected = "10";
        String actual = calc.twoValueOperation("3", "+", "1");
        assertEquals(expected, actual);
    }

    @Test
    public void additionLargeNumberTest() throws Exception {
        String expected = "2303";
        String actual = calc.twoValueOperation("1111", "+", "1132");
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionTest() throws Exception {
        String expected = "10";
        String actual = calc.twoValueOperation("22", "-", "12");
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionTest2() throws Exception {
        String expected = "2";
        String actual = calc.twoValueOperation("13", "-", "11");
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionLargeNumberTest() throws Exception {
        String expected = "1210";
        String actual = calc.twoValueOperation("2101", "-", "231");
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationTest() throws Exception {
        String expected = "210";
        String actual = calc.twoValueOperation("21", "*", "10");
        assertEquals(expected, actual);
    }

    @Test
    public void divisionTest() throws Exception {
        String expected = "13";
        String actual = calc.twoValueOperation("111", "/", "3");
        assertEquals(expected, actual);
    }

    @Test
    public void divisionByZeroTest() throws Exception {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () ->{
                calc.twoValueOperation("10", "/", "0");
        }, "ArithmeticException was expected");
    }

    @Test
    public void quatDecSanityTest() {
        String originalInput = "10";
        String quat = calc.toQuad(originalInput);
        String result = calc.toDecimal(quat);
        assertEquals(originalInput, result);
    }

    @Test
    public void squareTest(){
        assertEquals("0", calc.square("0"));
        assertEquals("1", calc.square("1"));
        assertEquals("23121", calc.square("123"));
    }

    @Test
    public void squareRootTest(){
        assertEquals("0", calc.squareRoot("0"));
        assertEquals("1", calc.squareRoot("1"));
        assertEquals("123", calc.squareRoot("23121"));
    }

    @Test
    public void operationExceptionTest(){
        assertThrows(Exception.class, () -> {
                calc.twoValueOperation("10", "&", "10");
            });
        }
}
