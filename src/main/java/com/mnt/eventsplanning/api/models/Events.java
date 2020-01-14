package com.mnt.eventsplanning.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Events {
    @Id
    private Long id;

    private String name;

    private String description;

    //private Date startDate;

    //private Date endDate;

    private String location;
}
