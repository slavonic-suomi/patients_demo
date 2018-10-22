package com.itsm.pub.courses.patients.common.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "audit")
@Table(name = "audit")
public class AuditRecord implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String data;
    private Date date;
    private boolean success;
}
