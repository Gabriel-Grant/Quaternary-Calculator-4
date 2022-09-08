import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    CalculatorLogic calc = new CalculatorLogic();

    @Test
    public void conversionToQuaternaryTest(){
        String expected = "1210";
        String actual = calc.toQuad("100");
        assertEquals(expected, actual);
    }

    @Test
    public void conversionToDecimalTest(){
        String expected = "100";
        String actual = calc.toDecimal("1210");
        assertEquals(expected, actual);
    }

    @Test
    public void additionTest(){
        String expected = "1";
        String actual = calc.addition("0", "1");
        assertEquals(expected, actual);
    }

    @Test
    public void additionTest2(){
        String expected = "10";
        String actual = calc.addition("3", "1");
        assertEquals(expected, actual);
    }

    @Test
    public void additionLargeNumberTest(){
        String expected = "2303";
        String actual = calc.addition("1111", "1132");
        assertEquals(expected, actual);
    }
    @Test
    public void subtractionTest(){
        String expected = "10";
        String actual = calc.subtraction("22", "12");
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionTest2(){
        String expected = "2";
        String actual = calc.subtraction("13", "11");
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionLargeNumberTest(){
        String expected = "1210";
        String actual = calc.subtraction("2101", "231");
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationTest(){
        String expected = "210";
        String actual = calc.multiplication("21", "10");
        assertEquals(expected, actual);
    }

    @Test
    public void divisionTest(){
        String expected = "13";
        String actual = calc.division("111", "3");
        assertEquals(expected, actual);
    }

    @Test
    public void divisionByZeroTest(){
        String expected = "error";
        String actual = calc.division("100", "0");
        assertEquals(expected, actual);
    }

    @Test
    public void quatDecSanityTest(){
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
}


