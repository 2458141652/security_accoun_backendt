package com.stock.account.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "PersonAccount")
//public class PersonAccount extends Account {
public class PersonAccount {

    @Id
    //@GeneratedValue
    private Long account_id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String idNum;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private String organization;

    @Column(nullable = false)
    private String phone_num;

    @Column(nullable = false)
    private boolean agency;

    @Column
    private String agent_idnum;

    public PersonAccount() {
        //super();
    }
    public PersonAccount(Long account_id, Date date, String name, String gender,
                         String id_num, String address, String job, String degree,
                         String org, String phone_num, boolean agency, String agent_id) {
        //super(account_id, "PERSON");
        this.account_id = account_id;
        this.date = date;
        this.name = name;
        this.gender = gender;
        this.idNum = id_num;
        this.address = address;
        this.job = job;
        this.degree = degree;
        this.organization = org;
        this.phone_num = phone_num;
        this.agency = agency;
        if (this.agency) {
            this.agent_idnum = agent_id;
        }

    }
    public Long getAccount_id() {
        return account_id;
    }
    public void setAccount_id(Long id) {
        this.account_id = id;
    }
    public String getDate() {
        return date.toString();
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getId_num() {
        return idNum;
    }
    public void setId_num(String idnum) {
        this.idNum = idnum;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String org) {
        this.organization = org;
    }

    public String getPhone_num() {
        return phone_num;
    }
    public void setPhone_num(String phone) {
        this.phone_num = phone;
    }

    public boolean getAgency() {
        return agency;
    }
    public void setAgency(boolean agency) {
        this.agency = agency;
    }

    public String getAgent_idnum() {
        return agent_idnum;
    }
    public void setAgent_idnum(String agentid) {
        this.agent_idnum = agentid;
    }
//    public Account getAccount() {
//        return super.getAccount();
//    }

}


