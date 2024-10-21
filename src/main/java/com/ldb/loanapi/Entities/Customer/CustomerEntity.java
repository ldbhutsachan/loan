package com.ldb.loanapi.Entities.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Setter
@Getter
@Entity
@Table(name = "LOAN_CUSTOMER")
public class CustomerEntity {
    @Id
    @Column(name = "KEY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keyId;

    @Column(name = "CUSTOMER_ID", length = 200)
    private String customerId;

    @Column(name = "FULLNAME", length = 200)
    private String fullName;

    @Column(name = "LASTNAME", length = 200)
    private String lastName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PASSPORT", length = 200)
    private String passport;

    @Column(name = "MOBILE_NO")
    private Long mobileNo;

    @Column(name = "MOBILE_NO1")
    private Long mobileNo1;

    @Column(name = "BIRTHDATE")
    private Date birthDate;

    @Column(name = "COMPANY_ID", length = 200)
    private String companyId;

    @Column(name = "COMPANY_NAME", length = 200)
    private String companyName;

    @Column(name = "COMPANY_TYPE", length = 200)
    private String companyType;

    @Column(name = "VILLNO")
    private Integer villNo;

    @Column(name = "BRANCH_CODE", length = 100)
    private String branchCode;

    @Column(name = "LOCATION", length = 1500)
    private String location;

    @Column(name = "STATUS", length = 10)
    private String status;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @Column(name = "USER_CREATE", length = 100)
    private String userCreate;

    @Column(name = "USER_UPDATE", length = 100)
    private String userUpdate;

    // Constructors
    public CustomerEntity() {
    }

    public CustomerEntity(Long keyId, String customerId, String fullName, String lastName, Integer age, String passport,
                          Long mobileNo, Long mobileNo1, Date birthDate, String companyId, String companyName, String companyType,
                          Integer villNo, String branchCode, String location, String status, LocalDateTime createDate,
                          LocalDateTime updateDate, String userCreate, String userUpdate) {
        this.keyId = keyId;
        this.customerId = customerId;
        this.fullName = fullName;
        this.lastName = lastName;
        this.age = age;
        this.passport = passport;
        this.mobileNo = mobileNo;
        this.mobileNo1 = mobileNo1;
        this.birthDate = birthDate;
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyType = companyType;
        this.villNo = villNo;
        this.branchCode = branchCode;
        this.location = location;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.userCreate = userCreate;
        this.userUpdate = userUpdate;
    }
    }