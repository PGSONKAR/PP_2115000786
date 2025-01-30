public class ToggleCase {
    public static void main(String[] args) {
        String input = "Hello World!";
        String toggledString = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {
                toggledString += Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                toggledString += Character.toUpperCase(ch);
            } else {
                toggledString += ch;
            }
        }

        System.out.println("Original String: " + input);
        System.out.println("Toggled String: " + toggledString);
    }
}