package com.ldb.loanapi.Repositories;

import com.ldb.loanapi.Entities.Customer.CustomerEntity;
import com.ldb.loanapi.Entities.Location.ProvinceEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, CustomerEntity>{

    default CustomerEntity updateCustomer(CustomerEntity customerEntity){
        return save(customerEntity);
    }

    boolean deleteById(Long keyId);

    boolean existsById(Long keyId);
}

