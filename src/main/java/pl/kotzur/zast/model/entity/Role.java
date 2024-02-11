package pl.kotzur.zast.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.kotzur.zast.util.RoleEnum;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_generator")
    @SequenceGenerator(name = "role_generator", sequenceName = "role_id_seq", allocationSize=1)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private RoleEnum shortName;
}
