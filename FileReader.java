import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) throws IOException {

        File file = new File("/Users/ruby_/Desktop/UoB/TryCatch/captmidn.txt");
        Scanner sc = new Scanner(file);

        String fileContent= "THIS IS A FILE MADE BY RUBY\n";

        while(sc.hasNextLine()){
            fileContent = fileContent.concat(sc.nextLine() + "\n");
            // System.out.printf(sc.nextLine());
        }
        FileWriter writer = new FileWriter("/Users/ruby_/Desktop/UoB/TryCatch/createdfile.txt");
        writer.write(fileContent);
        writer.close();
    }
}
