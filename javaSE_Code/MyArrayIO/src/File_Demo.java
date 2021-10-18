import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class File_Demo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fw = new FileOutputStream(".");
        File f = new File(".");
        System.out.println(f);
    }
}
