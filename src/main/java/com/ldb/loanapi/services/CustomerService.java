package com.ldb.loanapi.services;

import com.ldb.loanapi.Entities.Customer.CustomerEntity;
import com.ldb.loanapi.Messages.response.DataResponse;

public interface CustomerService {
    public DataResponse getCustomerList(CustomerEntity customerEntity);
    public DataResponse saveCustomer(CustomerEntity customerEntity);
    public DataResponse updateCustomer(CustomerEntity customerEntity);
    public DataResponse delCustomer(CustomerEntity customerEntity);
}
