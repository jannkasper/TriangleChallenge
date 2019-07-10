package repositories;

import domains.Triangle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository {

    private static LinkedList<Triangle> triangleLinkedList = new LinkedList<>();

    public static void addTriangle(Triangle triangle) {
        triangleLinkedList.add(triangle);
    }

    public static List<Triangle> getTriangleList() {

//        return new LinkedList<>(new HashSet<>(triangleLinkedList));

        return triangleLinkedList
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static Triangle getTriangleLast() {
        return triangleLinkedList.get(triangleLinkedList.size()-1);
    }


}
