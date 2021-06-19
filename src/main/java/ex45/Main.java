package ex45;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileIn = new File(Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\java\\ex45\\"), "exercise45_input.txt");

        TextManager textManager = new TextManager(fileIn.readAllLines());

        File fileOut = new File(Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\java\\ex45\\"), "output.txt");

        int counter = textManager.replaceAll("utilize", "use");
        fileOut.writeLine(textManager.getText());
        System.out.println(counter);
    }
}
