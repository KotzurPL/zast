package pl.kotzur.zast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.model.entity.Hour;
import pl.kotzur.zast.repository.HourRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HourService {

    private final HourRepository hourRepository;

    public List<Hour> getHours() {
        return hourRepository.findAll();
    }

    public Hour getSingleHour(Long id) {
        return hourRepository.getReferenceById(id);
    }
}
