package com.stock.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stock.account.repository.AccountRepository;
import com.stock.account.repository.LegalRepository;
import com.stock.account.repository.PersonRepository;
import com.stock.account.model.Account;
import com.stock.account.model.PersonAccount;
import com.stock.account.model.LegalAccount;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Resource
    private AccountRepository accountRepository;
    @Resource
    private LegalRepository legalRepository;
    @Resource
    private PersonRepository personRepository;

    @Test
    public void testCreateLegalAccount() {
        Long account_id = 111l;
        String legal_num = "222222222";
        String license_num = "1";
        String legal_name = "1";
        String legal_idnum = "1";
        String legal_address = "1";
        String legal_phone = "1";
        String grantor_name = "1";
        String grantor_idnum = "1";
        String grantor_address = "1";
        String grantor_phone = "1";

        if (!accountRepository.findById(account_id).isPresent()) {
            if (legalRepository.findByLegalNum(legal_num) == null) {
                LegalAccount legal = new LegalAccount(account_id, legal_num, license_num, legal_name,
                        legal_idnum, legal_address, legal_phone, grantor_name,
                        grantor_idnum, grantor_address, grantor_phone);
                Account account = new Account(account_id, "LEGAL");
                legalRepository.save(legal);
                accountRepository.save(account);

                System.out.println("success\n");
            }
            else
                System.out.println("fail\n" + "legal_num exists\n");

        }
        else
            System.out.println("fail\n" + "account_id exists\n");
    }

    @Test
    public void testLossAccount() {

        Long accout_id = 111l;
        Optional<Account> optionalAccount = accountRepository.findById(accout_id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setLoss(true);
            accountRepository.save(account);
            System.out.println("success\n");
        }
        else
            System.out.println("fail\n" + "account_id doesn't exist\n");
    }

    @Test
    public void deleteAccount() {
        Long accout_id = 111l;
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

            System.out.println("success\n");
        }
        else
            System.out.println("fail\n" + "account_id doesn't exist\n");
    }

}




