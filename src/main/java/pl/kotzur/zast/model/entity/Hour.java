package pl.kotzur.zast.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Hour {

    @Id
    private long id;
    private LocalTime startTime;
    private LocalTime endTime;

}
