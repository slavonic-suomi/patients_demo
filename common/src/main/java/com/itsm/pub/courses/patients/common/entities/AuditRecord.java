package com.itsm.pub.courses.patients.common.entities;

import lombok.Data;

import java.util.Date;

@Data
public class AuditRecord implements IEntity {
    private Integer id;
    private String data;
    private Date date;
    private boolean success;
}
