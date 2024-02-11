package pl.kotzur.zast.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hour_generator")
    @SequenceGenerator(name = "hour_generator", sequenceName = "hour_id_seq", allocationSize=1)
    private long id;
    private LocalTime startTime;
    private LocalTime endTime;

}
