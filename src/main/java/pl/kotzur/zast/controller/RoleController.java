package pl.kotzur.zast.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kotzur.zast.model.entity.Hour;
import pl.kotzur.zast.model.entity.Role;
import pl.kotzur.zast.service.RoleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    public Role getSingleRole(@PathVariable Long id) {
        return roleService.getSingleRole(id);
    }

}
