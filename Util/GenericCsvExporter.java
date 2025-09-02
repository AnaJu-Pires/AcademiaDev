package Util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class GenericCsvExporter {

    /**
     * Finds a field in the given class or any of its superclasses.
     *
     * @param clazz 
     * @param fieldName 
     * @return 
     * @throws NoSuchFieldException 
     */
    private static Field findFieldInHierarchy(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        Class<?> current = clazz;
        while (current != null) {
            try {
               
                return current.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {

                current = current.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field '" + fieldName + "' not found in class " + clazz.getName() + " or its superclasses.");
    }

    public static <T> String export(List<T> data, List<String> fieldsToInclude) {
        if (data == null || data.isEmpty() || fieldsToInclude == null || fieldsToInclude.isEmpty()) {
            return "";
        }

        try {
            StringBuilder csvBuilder = new StringBuilder();


            String header = String.join(",", fieldsToInclude);
            csvBuilder.append(header).append("\n");


            for (T item : data) {

                Class<?> itemClass = item.getClass(); 
                
                String row = fieldsToInclude.stream()
                        .map(fieldName -> {
                            try {

                                Field field = findFieldInHierarchy(itemClass, fieldName);
                                field.setAccessible(true);
                                Object value = field.get(item);
                                return value != null ? value.toString() : "";
                            } catch (NoSuchFieldException | IllegalAccessException e) {

                                return ""; 
                            }
                        })
                        .collect(Collectors.joining(","));
                csvBuilder.append(row).append("\n");
            }

            return csvBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating CSV: " + e.getMessage();
        }
    }
}