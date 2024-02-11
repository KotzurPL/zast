package pl.kotzur.zast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.model.entity.Hour;
import pl.kotzur.zast.model.entity.Role;
import pl.kotzur.zast.repository.HourRepository;
import pl.kotzur.zast.repository.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getSingleRole(Long id) {
        return roleRepository.getReferenceById(id);
    }

}
