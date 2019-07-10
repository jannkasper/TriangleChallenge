package domains;

import enums.TriangleType;

import java.util.Arrays;
import java.util.Objects;

public class Triangle {

    private double triangleSides[];
    private TriangleType triangleType;

    public Triangle(String[] triangleSides) {

        Arrays.sort(triangleSides);

        this.triangleSides = Arrays
                .asList(triangleSides)
                .stream()
                .mapToDouble(Double::parseDouble)
                .sorted()
                .toArray();

        this.triangleType = TrinagleAnalyzer();
    }

    private TriangleType TrinagleAnalyzer () {

        if (triangleSides[0] == triangleSides[1] && triangleSides[1] == triangleSides[2])
            return TriangleType.EQUILATERAL;

        if (triangleSides[0] == triangleSides[1] || triangleSides[1] == triangleSides[2])
            return TriangleType.ISOSCELES;

        return TriangleType.SCALENE;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if(triangleType != triangle.triangleType) return false;

        for (int i = 0; i <triangle.triangleSides.length; i++){
            if( this.triangleSides[i] != triangle.triangleSides[i]) return false;
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

    public void setTriangleSides(double[] triangleSides) {
        this.triangleSides = triangleSides;
    }

    public TriangleType getTriangleType() {
        return triangleType;
    }

    public void setTriangleType(TriangleType triangleType) {
        this.triangleType = triangleType;
    }



}
