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
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Reception reception;

    private String info;

}
