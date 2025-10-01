package util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private static final String FILE_NAME = "pc_data.csv";

    public static void salvar(String linha) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(linha + "\n");
            System.out.println("Salvo: " + linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}