package com.ldb.loanapi.Entities;

import com.ldb.loanapi.Entities.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SECTION")
public class Section extends DateAudit {

    @Id
    @Column(name = "SEC_ID", length = 10, nullable = false)
    private String secId;

    @Column(name = "NAME", nullable = false)
    private String secName;

    @Column(name = "code", length = 5)
    private String code;

    @Column(name = "enable")
    private Boolean enable;


}
