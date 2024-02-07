package pl.kotzur.zast.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.kotzur.zast.util.RoleEnum;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private RoleEnum shortName;
}
