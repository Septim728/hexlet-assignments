package exercise;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Object object) {
        Class<?> aClass = object.getClass();
        List<Field> declareField = Arrays.stream(aClass.getDeclaredFields())
                .toList();
        return declareField.stream()
                .filter(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(object) == null && field.getAnnotation(NotNull.class) != null;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(Field::getName)
                .toList();
    }

    public static <T> Map<String, List<String>> advancedValidate(T object) {
        Class<?> aClass = object.getClass();
        List<Field> declareField = Arrays.stream(aClass.getDeclaredFields())
                .toList();
        Map<String, List<String>> result = new HashMap<>();
        declareField.stream().
                forEach(f -> {
                    if (f.isAnnotationPresent(NotNull.class)) {
                        NotNull notNull = f.getAnnotation(NotNull.class);
                        try {
                            if (f.get(object) == null && f.getAnnotation(NotNull.class) != null) {
                                result.put(f.getName(), List.of("can not be null"));
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (f.isAnnotationPresent(MinLength.class)) {
                        MinLength minLength = f.getAnnotation(MinLength.class);
                        try {
                            if (Integer.getInteger(f.get(object).toString()) < minLength.minLength()) {
                                result.put(f.getName(), List.of("length less than 4"));
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
        });

        return result;
    }

}
// END
