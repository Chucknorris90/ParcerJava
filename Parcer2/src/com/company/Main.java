package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        File dir = new File(args[1]);
        List<File> lst = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                lst.add(file);
        }

        File result = new File( args[2] + ".csv");

        Iterator<File> iterator = lst.iterator();
        while (iterator.hasNext()) {

            List<String> lines = Files.readAllLines(iterator.next().toPath());
            PrintStream listOut = new PrintStream(result, Charset.forName("windows-1251"));
            Pattern pattern = Pattern.compile("TRACE:");
            Iterator<String> iteratorString = lines.iterator();

            while (iteratorString.hasNext()) {
                String str = iteratorString.next();
                str = str.replaceAll("WARN :", "WARN_:");
                str = str.replaceAll("INFO :", "INFO_:");
                str = str.replaceAll("\\.SETv5", ";\\.SETv5");
                str = str.replaceAll("Исключаем", ";Исключаем");

                for (int k = 1; k<4; k++) {
                    str = str.replaceFirst("\\s", args[0]);
                }

                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    str = str.replaceFirst("\\s", args[0]);

                }

                listOut.println(str);
            }
            listOut.close();
        }
    }
}
