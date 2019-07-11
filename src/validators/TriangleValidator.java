package validators;

public class TriangleValidator {

    private final static int APPROPRIATE_NUMBER_OF_SIDES = 3;

    /**
     * Method check Number of Arguments
     * @return true if Number of Arguments is equal APPROPRIATE_NUMBER_OF_SIDES
     */
    public static boolean checkNumberOfArguments(String[] args) {
        return args.length == APPROPRIATE_NUMBER_OF_SIDES;
    }

    /**
     * Method compare all Arguments as Double Value
     * @return true if all Arguments can switch into Double Value
     */
    public static boolean checkIfValueIsNumeric(String[] args) {

        for (String arg : args) {
            try {
                Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    /**
     * Mathod check relations between all Triangle Sides
     * @return true if each Triangle Side is shorter than the sum of the other two
     */
    public static boolean checkIfSidesCanBuildTriangle(String[] args) {

        return Double.parseDouble(args[0]) < Double.parseDouble(args[1]) + Double.parseDouble(args[2]) &&
                Double.parseDouble(args[1]) < Double.parseDouble(args[0]) + Double.parseDouble(args[2]) &&
                Double.parseDouble(args[2]) < Double.parseDouble(args[0]) + Double.parseDouble(args[1]);

    }
}
