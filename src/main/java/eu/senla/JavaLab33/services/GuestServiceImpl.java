package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.GuestRepository;
import eu.senla.JavaLab33.api.services.GuestService;
import eu.senla.JavaLab33.dto.GuestDto;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Guest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GuestDto create(Guest entity) {
        for (Guest guest : guestRepository.findAll()) {
            if (guest.getPhone().equals(entity.getPhone()) &&
                    guest.getFirstName().equals(entity.getFirstName()) &&
                    guest.getSecondName().equals(entity.getSecondName())) {
                entity.setId(guest.getId());
                return modelMapper.map(guest, GuestDto.class);
            }
        }
        entity.setId(guestRepository.save(entity).getId());
        return modelMapper.map(guestRepository.save(entity), GuestDto.class);
    }

    @Override
    public List<GuestDto> getAll() {
        return modelMapper.map(guestRepository.findAll(), new TypeToken<List<GuestDto>>(){}.getType());
    }

    @Override
    public GuestDto getById(Long id) throws NoRecordException {
        return modelMapper.map(guestRepository.findById(id).orElseThrow(() -> new NoRecordException("Guest", id)),
                GuestDto.class);
    }

}
