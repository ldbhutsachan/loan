package com.ldb.loanapi.Entities.Respone;

import com.ldb.loanapi.Entities.BrandUnit;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "BRANCH")
public class BranchRespone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",nullable = false)
    private String iD;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "BRANCH_CODE",nullable = false)
    private String branchCode;

    @OneToMany
    @JoinColumn(name = "BRANCH_CODE")
    private List<BrandUnit> brandUnits;

}
