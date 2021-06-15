package ex42;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputFormatter {
    private InputFormatter() {}

    public static Employee convertStringToEmployee(String strToConvert)
            throws IndexOutOfBoundsException {
        List<String> employeeProperties = Arrays.stream(strToConvert.split(",")).map(String::toString).collect(Collectors.toList());
        if (employeeProperties.size() < 3)
            throw new IndexOutOfBoundsException();
        return new Employee(employeeProperties.get(1), employeeProperties.get(0), Double.parseDouble(employeeProperties.get(2)));
    }
}
