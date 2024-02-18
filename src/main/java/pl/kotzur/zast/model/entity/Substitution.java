package pl.kotzur.zast.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Substitution {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "substitution_generator")
    @SequenceGenerator(name = "substitution_generator", sequenceName = "substitution_id_seq", allocationSize=1)
    private Long id;

    private LocalDate substitutionDate;

    @ManyToOne
    @JoinColumn(name = "id_absent_teacher")
    private Person absentTeacher;

    @ManyToOne
    @JoinColumn(name = "id_hour")
    private Hour hour;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassGroup classGroup;

    @ManyToOne
    @JoinColumn(name = "id_original_subject")
    private Subject originalSubject;

    @ManyToOne
    @JoinColumn(name = "id_substitute_teacher")
    private Person substituteTeacher;

    @ManyToOne
    @JoinColumn(name = "id_target_subject")
    private Subject targetSubject;

}
