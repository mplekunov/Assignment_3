package ex42;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;

public final class OutputFormatter {
    private static int firstNameLength = 0;
    private static int lastNameLength = 0;
    private static int salaryLength = 0;

    private OutputFormatter() {}

    public static String convertEmployeeToString(List<Employee> employees) {
        firstNameLength = employees.stream().map(o -> o.getFirstName().length()).max(Comparator.comparing(Integer::intValue)).get() + 1;
        lastNameLength = employees.stream().map(o -> o.getLastName().length()).max(Comparator.comparing(Integer::intValue)).get() + 1;
        salaryLength = employees.stream().map(o -> String.valueOf(o.getSalary()).length()).max(Comparator.comparing(Integer::intValue)).get() + 1;

        StringBuilder sBuilder = new StringBuilder();

        sBuilder.append(String.format("%-" + lastNameLength + "s%-" + firstNameLength + "s%-" + salaryLength + "s\n", "Last", "First", "Salary"));

        employees.forEach(o ->
            sBuilder.append(String.format("%-" + lastNameLength + "s%-" + firstNameLength + "s%-" + salaryLength + "s\n",
                    o.getLastName(), o.getFirstName(), NumberFormat.getCurrencyInstance().format(o.getSalary())))
        );

        return sBuilder.toString();
    }
}
