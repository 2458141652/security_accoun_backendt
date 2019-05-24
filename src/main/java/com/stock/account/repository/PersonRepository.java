package com.stock.account.repository;

import com.stock.account.model.PersonAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.lang.model.element.PackageElement;


@Repository
public interface PersonRepository extends JpaRepository<PersonAccount, Long> {
    PersonAccount findByIdNum (String id_num);

}