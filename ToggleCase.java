public class ToggleCase {
    public static void main(String[] args) {
        String input = "Hello World!";
        StringBuilder toggledString = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {
                toggledString.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                toggledString.append(Character.toUpperCase(ch));
            } else {
                toggledString.append(ch);
            }
        }

        System.out.println("Original String: " + input);
        System.out.println("Toggled String: " + toggledString.toString());
    }
}