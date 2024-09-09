package com.DINESH.commonManagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sequence_generator")
public class AutoGenerateSequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String master;

    @Column
    private String type;

    @Column
    private int sequenceNo;

    @Column
    private String code;

}
