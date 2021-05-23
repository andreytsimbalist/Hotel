package eu.senla.JavaLab33.configs.converters;

import eu.senla.JavaLab33.model.enums.SortKey;
import org.springframework.core.convert.converter.Converter;

public class StringToSortKeyConverter implements Converter<String, SortKey> {

    @Override
    public SortKey convert(String source) {
        return SortKey.valueOf(source.toUpperCase());
    }

}
