package pl.kotzur.zast.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.kotzur.zast.util.ClassGroupTypeEnum;

@Data
@Entity
@Table(name="class")
public class ClassGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_generator")
    @SequenceGenerator(name = "class_generator", sequenceName = "class_id_seq", allocationSize=1)
    private Long id;

    private int level;

    private String symbol;

    @Enumerated(EnumType.STRING)
    private ClassGroupTypeEnum type;

    private boolean active;

    private int duration;

    public String nameToString() {
        String name = level + symbol;
        if (type == ClassGroupTypeEnum.W) {
            name += "x";
        }
        return name;
    }

}
