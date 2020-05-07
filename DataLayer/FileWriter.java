package DataLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
    public static void writeOutput(String writeOut, int tableNo) throws FileNotFoundException {
        File output = new File("check_" + "table" + tableNo + ".txt");
        PrintWriter printer = new PrintWriter(output);
        printer.printf(writeOut);
        printer.close() ;
    }
}
