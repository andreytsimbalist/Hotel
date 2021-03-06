package eu.senla.JavaLab33.configs.converters;

import eu.senla.JavaLab33.model.enums.RoomStatus;
import org.springframework.core.convert.converter.Converter;

public class StringToRoomStatusConverter implements Converter<String, RoomStatus> {

    @Override
    public RoomStatus convert(String source) {
        return RoomStatus.valueOf(source.toUpperCase());
    }

}
