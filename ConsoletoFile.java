import java.io.*;
public class ConsoletoFile {

    public static void main(String[] args) {
        String filePath = "output.txt";
        try (
            InputStreamReader inputStreamReader = new InputStreamReader(System.in); 
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); 
            FileWriter writer = new FileWriter(filePath, true); 
            BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            System.out.println("Enter the text (Enter 'exit' to stop writing)");
            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("====EXITED======");
    }
}