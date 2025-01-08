package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        var result = new ArrayList<String>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class)
                        && field.get(address) == null) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                List<String> value = new ArrayList<>();
                if (field.isAnnotationPresent(NotNull.class)
                        && field.get(address) == null) {
                    value.add("can not be null");
                }
                if (field.isAnnotationPresent(MinLength.class)
                        && field.get(address).toString().length() < field.getAnnotation(MinLength.class).minLength()) {
                    var size = field.getAnnotation(MinLength.class).minLength();
                    value.add("length less than " + size);
                }
                if (!value.isEmpty()) {
                    result.put(field.getName(), value);
                }

            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }
}
// END
