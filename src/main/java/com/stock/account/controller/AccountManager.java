package com.stock.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.account.model.Account;
import com.stock.account.model.LegalAccount;
import com.stock.account.model.PersonAccount;
import com.stock.account.repository.AccountRepository;
import com.stock.account.repository.LegalRepository;
import com.stock.account.repository.PersonRepository;

import java.util.Date;
import java.util.Optional;

@RestController
public class AccountManager {

    @Autowired
    private AccountRepository accountRepository ;
    @Autowired
    private LegalRepository legalRepository;
    @Autowired
    private PersonRepository personRepository;


    @RequestMapping("/create/legal")
    public String createLegal(@RequestParam Long account_id, @RequestParam String legal_num,
                                    @RequestParam String license_num,  @RequestParam String legal_name,
                                    @RequestParam String legal_idnum,  @RequestParam String legal_address,
                                    @RequestParam String legal_phone,  @RequestParam String grantor_name,
                                    @RequestParam String grantor_idnum,  @RequestParam String grantor_address,
                                    @RequestParam String grantor_phone) {

        Optional<Account> optionalAccount = accountRepository.findById(account_id);
        if (!optionalAccount.isPresent()) {
            if (legalRepository.findByLegalNum(legal_num) == null) {
                LegalAccount legal = new LegalAccount(account_id, legal_num, license_num, legal_name,
                        legal_idnum, legal_address, legal_phone, grantor_name,
                        grantor_idnum, grantor_address, grantor_phone);
                Account account = new Account(account_id, "LEGAL");
                legalRepository.save(legal);
                accountRepository.save(account);

                return "success";
            }
            else
                return "fail\n" + "legal_num exists";

        }
        else {
            Account loss = optionalAccount.get();
            if (loss.getLoss()) {
                loss.setLoss(false);
                accountRepository.save(loss);
                LegalAccount legal = new LegalAccount(account_id, legal_num, license_num, legal_name,
                        legal_idnum, legal_address, legal_phone, grantor_name,
                        grantor_idnum, grantor_address, grantor_phone);
                legalRepository.save(legal);
                return "recreation succeeds";
            }
            else {
                return "fail\n" + "account_id exists";
            }

        }
    }

    @RequestMapping(value = "/create/person")
    public String createPerson(@RequestParam Long account_id, @RequestParam Date date,
                                      @RequestParam String name,  @RequestParam String gender,
                                      @RequestParam String id_num,  @RequestParam String address,
                                      @RequestParam String job,  @RequestParam String degree,
                                      @RequestParam String org, @RequestParam String phone_num,
                                      @RequestParam boolean agency, @RequestParam String agent_idnum) {

        Optional<Account> optionalAccount = accountRepository.findById(account_id);
        if (!optionalAccount.isPresent()) {
            if (personRepository.findByIdNum(id_num) == null) {
                PersonAccount person = new PersonAccount (account_id, date, name, gender,id_num,
                        address, job, degree, org, phone_num,
                        agency, agent_idnum);
                Account account = new Account(account_id, "PERSON");
                personRepository.save(person);
                accountRepository.save(account);
                return "success";
            }
            else
                return  "fail\n" + "id_num exists";
        }
        else {
            Account loss = optionalAccount.get();
            if (loss.getLoss()) {
                loss.setLoss(false);
                accountRepository.save(loss);
                PersonAccount person = new PersonAccount (account_id, date, name, gender,id_num,
                        address, job, degree, org, phone_num,
                        agency, agent_idnum);
                personRepository.save(person);
                return "recreation succeeds";
            }
            else {
                return "fail\n" + "account_id exists";
            }

        }
    }

    @RequestMapping(value = "/loss")
    public String lossAccount(@RequestParam Long accout_id) {

        Optional<Account> optionalAccount = accountRepository.findById(accout_id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setLoss(true);
            accountRepository.save(account);
            return "success";
        }
        else
            return "fail\n" + "account_id doesn't exist";
    }

    @RequestMapping(value = "/reassociate")
    public String reassociate(@RequestParam Long accout_id) {

        return "";
    }


    @RequestMapping(value = "/freeze")
    public String freezeaccount(@RequestParam Long accout_id) {

        return "";
    }


    @RequestMapping(value = "/delete")
    public String deleteAccount(@RequestParam Long accout_id) {
        Optional<Account> optionalAccount = accountRepository.findById(accout_id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            //检查证券是否为0
            if (account.getType().equals("LEGAL")) {
                legalRepository.deleteById(accout_id);
            }
            else if (account.getType().equals("PERSON")) {
                personRepository.deleteById(accout_id);
            }

            accountRepository.deleteById(accout_id);

            return "success";
        }
        else
            return "fail\n" + "account_id doesn't exist";
    }

}