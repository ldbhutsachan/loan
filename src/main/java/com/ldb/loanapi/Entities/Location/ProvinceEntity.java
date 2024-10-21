package com.ldb.loanapi.Entities.Location;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "Province")
public class ProvinceEntity {

    @Id
    @Column(name = "KEY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keyId;

    @Column(name = "PRONO", length = 100)
    private String proNo;

    @Column(name = "PRONAME", length = 200)
    private String proName;


}
