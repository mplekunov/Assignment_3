package ex44;

public class ConsoleOut implements Output {
    public ConsoleOut() {}

    @Override
    public void writeLine(String input) {
        System.out.print(input);
    }
}
