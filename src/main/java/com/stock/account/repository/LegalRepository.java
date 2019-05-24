package com.stock.account.repository;

import com.stock.account.model.LegalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LegalRepository extends JpaRepository<LegalAccount, Long> {

    LegalAccount findByLegalNum(String legal_num);
}
