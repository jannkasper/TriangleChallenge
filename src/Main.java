import domains.Triangle;
import repositories.TriangleRepository;
import validators.TriangleValidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String choice = null;
        Scanner scan = new Scanner(System.in);
        do {
            displayMenu();
            System.out.println("--- Select something ---");
            System.out.print("Select: ");
            choice = scan.nextLine();

            switch (choice) {
                case "d":
                    System.out.println("--- Enter new Triangle ---");
                    System.out.print("Write down sides: ");
                    String enterSides = scan.nextLine();
                    enterSingleTriangle(enterSides);
                    break;

                case "e":
                    System.out.println("--- Display last Triangle ---");
                    Triangle triangle = TriangleRepository.getLastTriangle();
                    System.out.println(triangle.getTriangleType() + " \t " + Arrays.toString(triangle.getTriangleSides()));
                    break;

                case "f":
                    System.out.println("--- Upload file with Triangles ---");
                    System.out.print("Write down File name: ");
                    String fileName = scan.nextLine();
                    loadTrianglesFromFile(fileName);
                    break;

                case "g":
                    System.out.println("--- Display all Triangle ---");
                    for (Triangle triangleObject : TriangleRepository.getUniqueTriangleList()) {
                        System.out.println(triangleObject.getTriangleType() + " \t " + Arrays.toString(triangleObject.getTriangleSides()));
                    }
                    break;
            }

        } while (!choice.equals("q"));
    }

    private static void enterSingleTriangle(String enterSides) {
        String[] triangleSides = enterSides.split(" ");
        if (TriangleValidator.checkNumberOfArguments(triangleSides) && TriangleValidator.checkIfValueIsNumeric(triangleSides) && TriangleValidator.checkIfSidesCanBuildTriangle(triangleSides)) {
            Triangle triangle = new Triangle(triangleSides);
            TriangleRepository.addTriangle(triangle);
        } else {
            System.out.println("!!! Wrong input date !!!");
        }
    }

    private static void loadTrianglesFromFile(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./resources/" + fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] triangleSidesFile = line.split(" ");
                if (TriangleValidator.checkNumberOfArguments(triangleSidesFile) && TriangleValidator.checkIfValueIsNumeric(triangleSidesFile) && TriangleValidator.checkIfSidesCanBuildTriangle(triangleSidesFile)) {
                    Triangle triangleFile = new Triangle(triangleSidesFile);
                    TriangleRepository.addTriangle(triangleFile);
                }
                line = reader.readLine();
            }
            reader.close();
        }catch (FileNotFoundException e){
            System.out.println("!!! File Not Found !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayMenu() {
        System.out.println("--- Command Options ---");
        System.out.println("d: Enter new single Triangle");
        System.out.println("e: Display last Triangle");
        System.out.println("f: Upload file with Triangles");
        System.out.println("g: Display all Triangles");
        System.out.println("q: Quit");
    }
}
