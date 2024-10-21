package com.ldb.loanapi.Entities.Location;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "LOAN_VILLAGE")
public class VillageEntity {

    @Id
    @Column(name = "KEY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keyId;

    @Column(name = "VILLNO")
    private Integer villNo;

    @Column(name = "NAME", length = 200)
    private String name;
    @Column(name = "DISNO")
    private Integer disNo;
    public VillageEntity() {
    }
    public VillageEntity(Long keyId, Integer villNo, String name, Integer disNo) {
        this.keyId = keyId;
        this.villNo = villNo;
        this.name = name;
        this.disNo = disNo;
    }

}