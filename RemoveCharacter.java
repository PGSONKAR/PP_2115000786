public class RemoveCharacter {
    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        String modifiedString = "";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != charToRemove) {
                modifiedString += input.charAt(i);
            }
        }

        System.out.println("Modified String: " + modifiedString);
    }
}