package ex42;

public class FileOut implements File, Out{
    private String fileName;

    public FileOut(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public java.io.File openFile() {
        return null;
    }

    @Override
    public void writeLine() {

    }
}
