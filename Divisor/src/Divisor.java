import java.io.IOException;
import java.nio.file.Paths;


public class Divisor {

    public static void main(String[] args) throws IOException {
        DivisorAction.fileDivider(Reader.readFile(Paths.get(args[0])), args[1]);

    }
}
