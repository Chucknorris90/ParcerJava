import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;


public class DivisorAction {

    public static void fileDivider(ArrayList<String> arrayLines, String name) throws FileNotFoundException {
        int k = arrayLines.size()/5;
        File theDir = new File("ResultFolder");
        theDir.mkdir();

        for (int i = 0; i<4; i++) {
            File file = new File(theDir, name + i + ".txt");
            PrintStream listOut = new PrintStream(file);
            for (int j = 0; j<=k; j++) {
                listOut.println(arrayLines.get(j+k*i));

            }
            listOut.close();
        }

        File file = new File(theDir,name + 4 + ".txt");
        PrintStream listOut = new PrintStream(file);
        for (int j = 4*k; j<=arrayLines.size()-1; j++) {
            listOut.println(arrayLines.get(j));

        }
        listOut.close();

    }
}
