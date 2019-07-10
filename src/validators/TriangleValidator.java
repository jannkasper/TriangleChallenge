package validators;

public class TriangleValidator {

    public static boolean checkIfThreeSides (String[] args) {
        return args.length == 3;
    }

    public static boolean checkIfValueIsNumeric (String[] args) {

        for (String arg : args) {
            try {
                Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkIfSidesCanBuildTriangle (String[] args) {

        return Double.parseDouble(args[0]) < Double.parseDouble(args[1]) + Double.parseDouble(args[2]) &&
                Double.parseDouble(args[1]) < Double.parseDouble(args[0]) + Double.parseDouble(args[2]) &&
                Double.parseDouble(args[2]) < Double.parseDouble(args[0]) + Double.parseDouble(args[1]);

    }
}
