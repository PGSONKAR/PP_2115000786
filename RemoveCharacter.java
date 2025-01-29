public class RemoveCharacter {
    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        StringBuilder modifiedString = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != charToRemove) {
                modifiedString.append(input.charAt(i));
            }
        }

        System.out.println("Modified String: " + modifiedString.toString());
    }
}