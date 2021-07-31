package com.company;

import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader {

    public static List<File> readDir(Path path) {
        File dir = new File(String.valueOf(path)); //path указывает на директорию
        List<File> lst = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                lst.add(file);
        }


        return lst;
    }
}
