package com.ldb.loanapi.services.Impl;

import com.ldb.loanapi.Entities.Customer.CustomerEntity;
import com.ldb.loanapi.Messages.response.DataResponse;
import com.ldb.loanapi.Repositories.CustomerRepository;
import com.ldb.loanapi.services.CustomerService;
import com.ldb.loanapi.Utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class CustomerImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public DataResponse getCustomerList(CustomerEntity customerEntity) {
        DataResponse response = new DataResponse();
        try {
            response.setDataResponse(customerRepository.findAll());
            if(response.equals("")){
                response.setStatus(Constant.RESPONSE_CODE.DATA_NOT_FOUND);
                response.setMessage(Constant.RESPONSE_MESSAGE.DATA_NOT_FOUND_MSG);
            }
            response.setStatus(Constant.RESPONSE_CODE.SUCCESS);
            response.setMessage(Constant.RESPONSE_MESSAGE.SUCCESS_MSG);
        }catch (Exception e){
            response.setStatus(Constant.RESPONSE_CODE.DATA_NOT_FOUND);
            response.setMessage(Constant.RESPONSE_MESSAGE.DATA_NOT_FOUND_MSG);
        }
        return response;
    }

    @Override
    public DataResponse saveCustomer(CustomerEntity customerEntity) {
        DataResponse response = new DataResponse();
        try {
            response.setDataResponse(customerRepository.save(customerEntity));
            if(response.equals("")){
                response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
                response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.STORE_MSG);
            }
            response.setStatus(Constant.RESPONSE_CODE.SUCCESS);
            response.setMessage(Constant.RESPONSE_MESSAGE.STORE_MSG);
        }catch (Exception e){
            response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
            response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.STORE_MSG);
        }
        return response;
    }

    @Override
    public DataResponse updateCustomer(CustomerEntity customerEntity) {
        DataResponse response = new DataResponse();
        try {
            Object updateResult = customerRepository.updateCustomer(customerEntity);
            if (updateResult == null) {  // Assuming no update result implies failure
                response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
                response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.UPDATE_MSG);
            } else {
                response.setDataResponse(updateResult);
                response.setStatus(Constant.RESPONSE_CODE.SUCCESS);
                response.setMessage(Constant.RESPONSE_MESSAGE.UPDATE_MSG);
            }
        } catch (Exception e) {
            response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
            response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.UPDATE_MSG);
        }
        return response;
    }
    @Override
    public DataResponse delCustomer(CustomerEntity customerEntity) {
        DataResponse response = new DataResponse();
        try {
            // Check if the province exists before attempting to delete
            boolean exists = customerRepository.deleteById(customerEntity.getKeyId());
            if (!exists) {
                response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
                response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.DEL_MSG);  // Adjust the message for deletion
            } else {
                // Proceed to delete if the entity exists
                customerRepository.deleteById(customerEntity.getKeyId());
                response.setStatus(Constant.RESPONSE_CODE.SUCCESS);
                response.setMessage(Constant.RESPONSE_MESSAGE.DEL_MSG);  // Adjust the message for deletion
            }
        } catch (Exception e) {
            response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
            response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.DEL_MSG);
        }
        return response;
    }
}
