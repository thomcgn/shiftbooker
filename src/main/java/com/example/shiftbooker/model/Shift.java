package com.example.shiftbooker.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity(name = "schichten")
public class Shift implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Date workday;
    private LocalTime earlyShiftStart;
    private LocalTime lateShiftStart;
    private LocalTime shiftEnding;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "earlyWorker_ID")
    private Employee earlyWorker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lateWorker_ID")
    private Employee lateWorker;
}
