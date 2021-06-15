package ex42;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputFormatter {
    private InputFormatter() {}

    public static Employee convertStringToEmployee(String strToConvert) {
        List<String> employeeProperties = Arrays.stream(strToConvert.split("%s,%s,%s")).collect(Collectors.toList());
        return new Employee(employeeProperties.get(1), employeeProperties.get(0), Double.parseDouble(employeeProperties.get(2)));
    }
}
