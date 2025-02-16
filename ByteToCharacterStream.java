import java.io.*;
public class ByteToCharacterStream {

    public static void main(String[] args) {
        try (
            FileInputStream fileInputStream = new FileInputStream("example.txt"); 
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream); 
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}