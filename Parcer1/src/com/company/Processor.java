package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Processor {

    public Processor (String regex, List<File> lst, String name) throws IOException {

        File result = new File(name + ".txt");

        Iterator<File> iterator = lst.iterator();
        while (iterator.hasNext()) {

            List<String> lines = Files.readAllLines(iterator.next().toPath());
            PrintStream listOut = new PrintStream(result);
            Pattern pattern = Pattern.compile(regex);
            Iterator<String> iteratorString = lines.iterator();

            while (iteratorString.hasNext()) {
                String str = iteratorString.next();
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    listOut.println(str);
                }
            }
            listOut.close();
        }
    }
}
