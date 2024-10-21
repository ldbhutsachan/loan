package com.ldb.loanapi.Entities.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Setter
@Getter
@Entity
@Table(name = "USER_LOGIN")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "KEY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keyId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "ACCOUNT_NON_EXPIRED", nullable = false)
    private Long accountNonExpired;

    @Column(name = "ACCOUNT_NON_LOCKED", nullable = false)
    private Long accountNonLocked;

    @Column(name = "CREDENTIALS_NON_EXPIRED", nullable = false)
    private Long credentialsNonExpired;

    @Column(name = "ENABLED", nullable = false)
    private Long enabled;

    @Column(name = "PASSWORD", nullable = false, length = 128)
    private String password;

    @Column(name = "USER_NAME", nullable = false, length = 200)
    private String userName;

    @Column(name = "BRANCH_ID", nullable = false, length = 100)
    private String branchId;

    @Column(name = "PROID", length = 200)
    private String proId;

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "SURNAME", length = 200)
    private String surname;

    @Column(name = "MOBILE", length = 100)
    private String mobile;

    @Column(name = "MAIL", length = 200)
    private String mail;

    @Column(name = "SEX", length = 200)
    private String sex;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "POSITION_NO", length = 200)
    private String positionNo;

    @Column(name = "IMAGEPATH", length = 1500)
    private String imagePath;

    @Column(name = "ROLE_ID", length = 200)
    private String roleId;

    @Column(name = "EMP_NO", length = 200)
    private String empNo;

    @Column(name = "ROLE_MENU", length = 200)
    private String roleMenu;

    // Constructors
    public UserEntity() {
    }

    public UserEntity(Long keyId, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt, Long accountNonExpired,
                      Long accountNonLocked, Long credentialsNonExpired, Long enabled, String password, String userName,
                      String branchId, String proId, String name, String surname, String mobile, String mail,
                      String sex, Date dob, String positionNo, String imagePath, String roleId, String empNo, String roleMenu) {
        this.keyId = keyId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.password = password;
        this.userName = userName;
        this.branchId = branchId;
        this.proId = proId;
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
        this.mail = mail;
        this.sex = sex;
        this.dob = dob;
        this.positionNo = positionNo;
        this.imagePath = imagePath;
        this.roleId = roleId;
        this.empNo = empNo;
        this.roleMenu = roleMenu;
    }
}
