import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.nio.file.*;
import java.util.List;

public class Reader {
    public static ArrayList<String> readFile(Path file ) throws IOException {
        List<String> lines = Files.readAllLines(file, Charset.forName("windows-1251"));
        ArrayList<String> arrayLines = (ArrayList<String>) lines;
        return arrayLines;

    }
}
