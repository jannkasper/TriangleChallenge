package tests;

import domains.Triangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositories.TriangleRepository;
import java.util.LinkedList;

public class TriangleRepositoryTest {

    @Before
    public void setUp() throws Exception {
        TriangleRepository.setTriangleLinkedList(new LinkedList<>());
    }

    @Test
    public void addTriangleShouldResultEquals() {
        //given
        String[] arguments = {"5.396", "6.456", "7.906"};
        Triangle triangle = new Triangle(arguments);
        TriangleRepository.addTriangle(triangle);
        //when
        Triangle validationResult = TriangleRepository.getLastTriangle();
        //then
        Assert.assertEquals(triangle, validationResult);
    }

    @Test
    public void getUniqueTriangleListShouldReturnEquals() {
        //given
        String[] argumentsFirst = {"5.396", "6.456", "7.906"};
        Triangle triangle = new Triangle(argumentsFirst);
        TriangleRepository.addTriangle(triangle);

        String[] argumentsSecond = {"5.555", "6.666", "7.777"};
        triangle = new Triangle(argumentsSecond);
        TriangleRepository.addTriangle(triangle);

        triangle = new Triangle(argumentsSecond);
        TriangleRepository.addTriangle(triangle);

        //when
        long validationResult = TriangleRepository.getUniqueTriangleList().size();
        //then
        Assert.assertEquals(2, validationResult);
    }
}