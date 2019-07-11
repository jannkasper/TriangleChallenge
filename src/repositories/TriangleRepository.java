package repositories;

import domains.Triangle;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository {

    private static LinkedList<Triangle> triangleLinkedList = new LinkedList<>();

    public static void addTriangle(Triangle triangle) {
        triangleLinkedList.add(triangle);
    }

    /**
     * Method returns List of Triangle class object without duplicates.
     * @return List of Triangle objects
     */
    public static List<Triangle> getUniqueTriangleList() {

        return triangleLinkedList
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Method returns last added Triangle object
     * @return Triangle object
     */
    public static Triangle getLastTriangle() {
        return triangleLinkedList.get(triangleLinkedList.size() - 1);
    }

    public static void setTriangleLinkedList(LinkedList<Triangle> triangleLinkedList) {
        TriangleRepository.triangleLinkedList = triangleLinkedList;
    }
}
