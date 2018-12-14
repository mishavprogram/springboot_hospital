package com.mvp.springboot.hospital.entities;

import lombok.*;

import javax.persistence.*;

@Entity
//@Table(name = "candidate")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String speciality;

}
