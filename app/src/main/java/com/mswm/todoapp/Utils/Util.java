package com.mswm.todoapp.Utils;

import android.content.Context;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<String> readItems(Context context) {
        List<String> list = null;
        File filesDir = context.getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try {
            list = new ArrayList<>(FileUtils.readLines(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void writeItems(Context context, List<String> list) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(file, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
