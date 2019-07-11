package domains;

import enums.TriangleType;
import java.util.Arrays;
import java.util.Objects;

public class Triangle {

    private double triangleSides[];
    private TriangleType triangleType;

    public Triangle(String[] triangleSides) {

        this.triangleSides = Arrays
                .asList(triangleSides)
                .stream()
                .mapToDouble(Double::parseDouble)
                .sorted()
                .toArray();

        this.triangleType = resolveTriangleType();
    }

    /**
     * Method returns Triangle Type based on study of the Triangle Sides length
     * @return enum Triangle Type
     */
    private TriangleType resolveTriangleType() {

        if (triangleSides[0] == triangleSides[1] && triangleSides[1] == triangleSides[2]) {
            return TriangleType.EQUILATERAL;
        } else if (triangleSides[0] == triangleSides[1] || triangleSides[1] == triangleSides[2]) {
            return TriangleType.ISOSCELES;
        } else {
            return TriangleType.SCALENE;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Triangle triangle = (Triangle) object;

        if (triangleType != triangle.triangleType) return false;

        for (int i = 0; i < triangle.triangleSides.length; i++) {
            if (this.triangleSides[i] != triangle.triangleSides[i]) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(triangleType);
        result = 31 * result + Arrays.hashCode(triangleSides);
        return result;
    }

    public double[] getTriangleSides() {
        return triangleSides;
    }

    public TriangleType getTriangleType() {
        return triangleType;
    }

}
