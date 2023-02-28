package com.Shrishti.chatApplication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tabl_Status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="StatusId")
    private Integer statusId;
    @Column(name="StatusName")
    private String statusName;
    @Column(name="StatusDesc")
    private String statusDescription;
}
