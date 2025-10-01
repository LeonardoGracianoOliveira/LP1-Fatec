package util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

    private static final String FILE_PATH = "omnitrix.csv";

    public static void salvar(String linha) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.append(linha).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}