package Util;

import java.util.List;
import java.util.stream.Collectors;

import java.lang.reflect.Field;

public class GenericCsvExporter {

    public static <T> String export(List<T> data, List<String> fieldsToInclude) {
        if (data == null || data.isEmpty() || fieldsToInclude == null || fieldsToInclude.isEmpty()) {
            return "";
        }

        try {
            Class<?> clazz = data.get(0).getClass();
            StringBuilder csvBuilder = new StringBuilder();


            String header = String.join(",", fieldsToInclude);
            csvBuilder.append(header).append("\n");


            for (T item : data) {
                String row = fieldsToInclude.stream()
                        .map(fieldName -> {
                            try {
                                Field field = clazz.getDeclaredField(fieldName);
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
            return "Erro ao gerar CSV: " + e.getMessage();
        }
    }
}
