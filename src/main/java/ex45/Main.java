package ex45;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileIn = new File(Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\resources\\ex45\\"), "exercise45_input.txt");
        File matcher = new File(Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\resources\\ex45\\"), "pattern.txt");

        TextManager textManager = new TextManager(fileIn.readAllLines());

        ConsoleOut cout = new ConsoleOut();
        ConsoleIn cin = new ConsoleIn();

        cout.writeLine("Enter the name of output file (e.g. output.txt): ");
        var outputFileName = cin.readLine();

        File fileOut = new File(Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\resources\\ex45\\"), outputFileName);

        int counter = textManager.replaceAll(Pattern.convert(matcher.readAllLines()));

        fileOut.writeLine(textManager.getText());

        System.out.printf(counter == 1 ? "%d match was found" : "%d matches were found", counter);
    }
}
