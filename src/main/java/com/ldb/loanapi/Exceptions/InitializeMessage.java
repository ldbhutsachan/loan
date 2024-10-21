package com.ldb.loanapi.Exceptions;

import com.ldb.loanapi.Exceptions.DetailMessage.DetailedErrorItem;
import com.ldb.loanapi.Exceptions.DetailMessage.ErrorInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class InitializeMessage {

    private static InitializeMessage instance = new InitializeMessage();

    private InitializeMessage(){

    }

    public static InitializeMessage getInstance(){
        if(instance == null){
            instance = new InitializeMessage();
        }
        return instance;
    }

    public ErrorInfo errorMessage(String msg, String msgDetail) {

        List<DetailedErrorItem> detailedErrorItems = new ArrayList<>();
        DetailedErrorItem detailedErrorItem = new DetailedErrorItem();
        detailedErrorItem.message = msgDetail;

        ErrorInfo errorInfo = new ErrorInfo();
        detailedErrorItems.add(detailedErrorItem);
        errorInfo.message = msg;
        errorInfo.detailedErrors = msgDetail;
//        errorInfo.detailedErrors = detailedErrorItem;

        return errorInfo;
    }

    public ErrorInfo errorMessage(String code, String msg, String msgDetail) {

        List<DetailedErrorItem> detailedErrorItems = new ArrayList<>();
        DetailedErrorItem detailedErrorItem = new DetailedErrorItem();
        detailedErrorItem.message = msgDetail;

        ErrorInfo errorInfo = new ErrorInfo();
        detailedErrorItems.add(detailedErrorItem);
        errorInfo.code = code;
        errorInfo.message = msg;
        errorInfo.detailedErrors = msgDetail;
//        errorInfo.detailedErrors = detailedErrorItem;

        return errorInfo;
    }

}
