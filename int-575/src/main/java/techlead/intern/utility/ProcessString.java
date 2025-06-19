package techlead.intern.utility;

public class ProcessString {
    public static String[] splitString(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        return input.trim().split("\\s+");
    }
}
