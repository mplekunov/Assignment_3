package ex45;

import org.javatuples.Pair;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Pattern {
    private Pattern() {}

    public static List<Pair<String, String>> convert(String pattern) {
        return Arrays.stream(pattern.split("\n"))
                .map(o -> new Pair<>(o.substring(0, o.indexOf(",")), o.substring(o.indexOf(",") + 1)))
                    .collect(Collectors.toList());
    }
}
