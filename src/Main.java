import domains.Triangle;
import repositories.TriangleRepository;
import validators.TriangleValidator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Command Options ---");
        System.out.println("d: Enter new Triangle");
        System.out.println("e: Display last Triangle");
        System.out.println("f: Upload file with Triangles");
        System.out.println("g: Display all Triangles");
        System.out.println("q: Quit");

        String choice = null;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("--- Select something ---");
            System.out.print("Select: ");
            choice = scan.nextLine();

            switch (choice){
                case "d":
                    System.out.println("--- Enter new Triangle ---");
                    System.out.print("Write down sides: ");
                    String enterSides = scan.nextLine();

                    String[] triangleSides = enterSides.split(" ");
                    if (TriangleValidator.checkIfThreeSides(triangleSides) && TriangleValidator.checkIfValueIsNumeric(triangleSides) && TriangleValidator.checkIfSidesCanBuildTriangle(triangleSides)) {
                        Triangle triangle = new Triangle(triangleSides);
                        TriangleRepository.addTriangle(triangle);
                    } else {
                        System.out.println("!!! Problem with input !!!");
                    }
                    break;

                case "e":
                    System.out.println("--- Display last Triangle ---");
                    Triangle triangle = TriangleRepository.getTriangleLast();
                    System.out.println(triangle.getTriangleType() + " | " + Arrays.toString(triangle.getTriangleSides()));
                    break;

                case "f":
                    break;

                case "g":
                    System.out.println("--- Display all Triangle ---");
                    for (Triangle trianglee : TriangleRepository.getTriangleList()){
                        System.out.println(trianglee.getTriangleType() + " | " + Arrays.toString(trianglee.getTriangleSides()));
                    }
                    break;
            }

        } while (!choice.equals("q"));
    }
}
