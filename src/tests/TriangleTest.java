package tests;

import domains.Triangle;
import enums.TriangleType;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void resolveTriangleTypeShouldReturnScalene() {
        // given
        String[] arguments = {"5.396", "6.456", "7.906"};
        Triangle triangle = new Triangle(arguments);
        // when
        TriangleType result = triangle.getTriangleType();
        // then
        Assert.assertEquals(TriangleType.SCALENE, result);
    }

    @Test
    public void resolveTriangleTypeShouldReturnIsosceles() {
        // given
        String[] arguments = {"5.396", "5.396", "7.906"};
        Triangle triangle = new Triangle(arguments);
        // when
        TriangleType result = triangle.getTriangleType();
        // then
        Assert.assertEquals(TriangleType.ISOSCELES, result);
    }

    @Test
    public void resolveTriangleTypeShouldReturnEquilateral() {
        // given
        String[] arguments = {"5.396", "5.396", "5.396"};
        Triangle triangle = new Triangle(arguments);
        // when
        TriangleType result = triangle.getTriangleType();
        // then
        Assert.assertEquals(TriangleType.EQUILATERAL, result);
    }

}