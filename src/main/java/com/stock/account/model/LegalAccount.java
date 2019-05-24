package com.stock.account.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LegalAccount")
//public class LegalAccount extends Account {
public class LegalAccount {

    @Id
    //@GeneratedValue
    private Long account_id;  // 法人股票账户号码

    @Column(nullable = false, unique = true)
    private String legalNum;  //法人注册登记号码

    @Column(nullable = false)
    private String license_num;

    @Column(nullable = false)
    private String legal_name;

    @Column(nullable = false)
    private String legal_idnum;   // 法定代表人身份证号码

    @Column(nullable = false)
    private String legal_address;

    @Column(nullable = false)
    private String legal_phone;

    @Column(nullable = false)
    private String grantor_name;

    @Column(nullable = false)
    private String grantor_idnum;

    @Column(nullable = false)
    private String grantor_address;

    @Column(nullable = false)
    private String grantor_phone;

    public LegalAccount() {
        //super();
    }
    public LegalAccount(Long account_id, String legal_num, String license_num,
                        String legal_name, String legal_idnum, String legal_address,
                        String legal_phone, String grantor_name, String grantor_idnum,
                        String grantor_address, String grantor_phone) {
        //super(account_id,"LEGAL");
        this.account_id = account_id;
        this.legalNum = legal_num;
        this.license_num = license_num;
        this.legal_name = legal_name;
        this.legal_idnum = legal_idnum;
        this.legal_address = legal_address;
        this.legal_phone = legal_phone;
        this.grantor_name = grantor_name;
        this.grantor_idnum = grantor_idnum;
        this.grantor_address = grantor_address;
        this.grantor_phone = grantor_phone;
    }
    public Long getAccount_id() {
        return account_id;
    }
    public void setAccount_id(Long id) {
        this.account_id = id;
    }
    public String getLegal_num() {
        return legalNum;
    }
    public void setLegal_num(String legal_num) {
        this.legalNum = legal_num;
    }
    public String getLicense_num() {
        return license_num;
    }
    public void setLicense_num(String license_num) {
        this.license_num = license_num;
    }
    public String getLegal_name() {
        return legal_name;
    }
    public void setLegal_name(String legal_name) {
        this.legal_name = legal_name;
    }
    public String getLegal_idnum() {
        return legal_idnum;
    }
    public void setLegal_idnum(String legal_idnum) {
        this.legal_idnum = legal_idnum;
    }
    public String getLegal_address() {
        return legal_address;
    }
    public void setLegal_address(String legal_address) {
        this.legal_address = legal_address;
    }
    public String getLegal_phone() {
        return legal_phone;
    }
    public void setLegal_phone(String legal_phone) {
        this.legal_phone = legal_phone;
    }
    public String getGrantor_name() {
        return grantor_name;
    }
    public void setGrantor_name(String grantor_name) {
        this.grantor_name = grantor_name;
    }
    public String getGrantor_idnum() {
        return grantor_idnum;
    }
    public void setGrantor_idnum(String grantor_idnum) {
        this.grantor_idnum = grantor_idnum;
    }
    public String getGrantor_address() {
        return grantor_address;
    }
    public void setGrantor_address(String grantor_address) {
        this.grantor_address = grantor_address;
    }
    public String getGrantor_phone() {
        return grantor_phone;
    }
    public void setGrantor_phone(String grantor_phone) {
        this.grantor_phone = grantor_phone;
    }
//    public Account getAccount() {
//        return super.getAccount();
//    }
}


