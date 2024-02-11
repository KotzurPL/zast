package pl.kotzur.zast.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_generator")
    @SequenceGenerator(name = "subject_generator", sequenceName = "subject_id_seq", allocationSize=1)
    private Long id;
    private String name;
    private String shortName;

}
