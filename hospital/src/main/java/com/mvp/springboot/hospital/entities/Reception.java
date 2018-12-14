package com.mvp.springboot.hospital.entities;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "candidate")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="DOCTOR_ID", unique = true)
    private Doctor doctor;

    @OneToOne()
    private Patient patient;

    /*private Date date;*/

}
