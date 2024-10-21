package com.ldb.loanapi.Entities.Respone;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SECTION")
public class SectionResponse {

    @Id
    @Column(name = "SEC_ID", length = 10, nullable = false)
    private String secId;

    @Column(name = "NAME", nullable = false)
    private String secName;

}
