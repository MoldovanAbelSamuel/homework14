package org.fasttrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormatFile {
    public static List<String> readFile (String path) throws FileNotFoundException {
        List<String> textFromFile = new ArrayList<>();
        File quotes = new File(path);
        Scanner scanner = new Scanner(quotes);
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            textFromFile.add(currentLine);
        }
        return textFromFile;
    }


}
