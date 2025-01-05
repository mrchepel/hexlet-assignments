package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> homeList, int numberOfElements) {
        return homeList.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .map(Object::toString)
                .limit(numberOfElements)
                .collect(Collectors.toList());
    }
}
// END
