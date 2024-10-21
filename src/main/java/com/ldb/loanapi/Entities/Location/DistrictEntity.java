package com.ldb.loanapi.Entities.Location;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
        import java.io.Serializable;
@Setter
@Getter
@Entity
@Table(name = "LOAN_DISTRICT")
public class DistrictEntity  {

    @Id
    @Column(name = "KEY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keyId;

    @Column(name = "DISNO")
    private Integer disNo;

    @Column(name = "PRONO")
    private Integer proNo;

    @Column(name = "DISNAME", length = 20)
    private String disName;

    // Constructors
    public DistrictEntity() {
    }

    public DistrictEntity(Long keyId, Integer disNo, Integer proNo, String disName) {
        this.keyId = keyId;
        this.disNo = disNo;
        this.proNo = proNo;
        this.disName = disName;
    }
    // toString Method
    @Override
    public String toString() {
        return "YourEntityClass{" +
                "keyId=" + keyId +
                ", disNo=" + disNo +
                ", proNo=" + proNo +
                ", disName='" + disName + '\'' +
                '}';
    }
}
