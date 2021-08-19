package com.org.queue.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ae_dt1")
@Data

//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AEData implements Serializable {
    @Id
    @Column(name = "docid")
    private int  id;
    private int field1;
    private String field2;
    @Temporal(TemporalType.TIMESTAMP)
    private Date field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    private String field8;
    private String field9;
    private String field10;
    private String field11;
    private String field12;
    private String field13;
    private int numobjects;
    private int iscom;

    @Column(name = "receipt_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiptDt;

    @Column(name = "process_dt")
    @Temporal(TemporalType.TIMESTAMP)
     private Date processDt;

}
