package ex42;

public class FileIn implements File, In {
    private String fileName;

    public FileIn(String fileName) {
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
    public String readLine() {
        return null;
    }
}
