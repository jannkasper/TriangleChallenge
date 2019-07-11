package tests;

import org.junit.Assert;
import org.junit.Test;
import validators.TriangleValidator;

public class TriangleValidatorTest {

    @Test
    public void checkNumberOfArgumentsShouldReturnTrue() {
        // given
        String[] arguments = {"5.396", "6.456", "7.906"};
        // when
        boolean result = TriangleValidator.checkNumberOfArguments(arguments);
        // then
        Assert.assertTrue(result);
    }

    @Test
    public void checkNumberOfArgumentsShouldReturnFalse() {
        // given
        String[] arguments = {"5.396", "6.456", "7.906", "8.123"};
        // when
        boolean result = TriangleValidator.checkNumberOfArguments(arguments);
        // then
        Assert.assertFalse(result);
    }

    @Test
    public void checkIfValueIsNumericShouldReturnTrue() {
        // given
        String[] arguments = {"5.396", "6.456", "7.906"};
        // when
        boolean result = TriangleValidator.checkIfValueIsNumeric(arguments);
        // then
        Assert.assertTrue(result);
    }

    @Test
    public void checkIfValueIsNumericShouldReturnFalse() {
        // given
        String[] arguments = {"5.396", "6.4ff", "7.906"};
        // when
        boolean result = TriangleValidator.checkIfValueIsNumeric(arguments);
        // then
        Assert.assertFalse(result);
    }

    @Test
    public void checkIfSidesCanBuildTriangleShouldReturnTrue() {
        // given
        String[] arguments = {"5.396", "6.456", "7.906"};
        // when
        boolean result = TriangleValidator.checkIfSidesCanBuildTriangle(arguments);
        // then
        Assert.assertTrue(result);
    }

    @Test
    public void checkIfSidesCanBuildTriangleShouldReturnFalse() {
        // given
        String[] arguments = {"5.396", "60.456", "7.906"};
        // when
        boolean result = TriangleValidator.checkIfSidesCanBuildTriangle(arguments);
        // then
        Assert.assertFalse(result);
    }
}