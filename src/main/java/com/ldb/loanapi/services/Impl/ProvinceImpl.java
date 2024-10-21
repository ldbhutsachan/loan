package com.ldb.loanapi.services.Impl;

import com.ldb.loanapi.Entities.Location.DistrictEntity;
import com.ldb.loanapi.Entities.Location.ProvinceEntity;
import com.ldb.loanapi.Entities.Location.VillageEntity;
import com.ldb.loanapi.Messages.response.DataResponse;
import com.ldb.loanapi.Repositories.DistrictRepository;
import com.ldb.loanapi.Repositories.ProvinceRepository;
import com.ldb.loanapi.Repositories.VillageRepository;
import com.ldb.loanapi.services.ProvinceService;
import com.ldb.loanapi.Utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProvinceImpl implements ProvinceService {
    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;
    private final VillageRepository villageRepository;

    public ProvinceImpl(ProvinceRepository provinceRepository, DistrictRepository districtRepository, VillageRepository villageRepository) {
        this.provinceRepository = provinceRepository;
        this.districtRepository = districtRepository;
        this.villageRepository = villageRepository;
    }

    @Override
    public DataResponse getProvinceList(ProvinceEntity provinceEntity) {
        DataResponse response = new DataResponse();
        try {
            response.setDataResponse(provinceRepository.findAll());
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
    public DataResponse saveProvince(ProvinceEntity provinceEntity) {
        DataResponse response = new DataResponse();
        try {
            response.setDataResponse(provinceRepository.save(provinceEntity));
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
    public DataResponse updateProvince(ProvinceEntity provinceEntity) {
        DataResponse response = new DataResponse();
        try {
            Object updateResult = provinceRepository.updateProvince(provinceEntity);

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
    public DataResponse delProvince(ProvinceEntity provinceEntity) {
        DataResponse response = new DataResponse();
        try {
            // Check if the province exists before attempting to delete
            boolean exists = provinceRepository.deleteById(provinceEntity.getKeyId());
            if (!exists) {
                response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
                response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.DEL_MSG);  // Adjust the message for deletion
            } else {
                // Proceed to delete if the entity exists
                provinceRepository.deleteById(provinceEntity.getKeyId());
                response.setStatus(Constant.RESPONSE_CODE.SUCCESS);
                response.setMessage(Constant.RESPONSE_MESSAGE.DEL_MSG);  // Adjust the message for deletion
            }
        } catch (Exception e) {
            response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
            response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.DEL_MSG);
        }
        return response;
    }

    @Override
    public DataResponse getDistrictList(DistrictEntity districtEntity) {
        DataResponse response = new DataResponse();
        try {
            response.setDataResponse(districtRepository.findAll());
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
    public DataResponse saveDistrict(DistrictEntity districtEntity) {
        DataResponse response = new DataResponse();
        try {
            response.setDataResponse(districtRepository.save(districtEntity));
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
    public DataResponse updateDistrict(DistrictEntity districtEntity) {
        DataResponse response = new DataResponse();
        try {
            Object updateResult = districtRepository.updateDistrict(districtEntity);

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
    public DataResponse delDistrict(DistrictEntity districtEntity) {
        DataResponse response = new DataResponse();
        try {
            // Check if the province exists before attempting to delete
            boolean exists = provinceRepository.deleteById(districtEntity.getKeyId());
            if (!exists) {
                response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
                response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.DEL_MSG);  // Adjust the message for deletion
            } else {
                // Proceed to delete if the entity exists
                provinceRepository.deleteById(districtEntity.getKeyId());
                response.setStatus(Constant.RESPONSE_CODE.SUCCESS);
                response.setMessage(Constant.RESPONSE_MESSAGE.DEL_MSG);  // Adjust the message for deletion
            }
        } catch (Exception e) {
            response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
            response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.DEL_MSG);
        }
        return response;
    }

    @Override
    public DataResponse getVillageList(VillageEntity villageEntity) {
        DataResponse response = new DataResponse();
        try {
            response.setDataResponse(villageRepository.findAll());
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
    public DataResponse saveVillage(VillageEntity villageEntity) {
        DataResponse response = new DataResponse();
        try {
            response.setDataResponse(villageRepository.save(villageEntity));
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
    public DataResponse updateVillage(VillageEntity villageEntity) {
        DataResponse response = new DataResponse();
        try {
            Object updateResult = villageRepository.updateVillage(villageEntity);

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
    public DataResponse delVillage(VillageEntity villageEntity) {
        DataResponse response = new DataResponse();
        try {
            // Check if the province exists before attempting to delete
            boolean exists = provinceRepository.deleteById(villageEntity.getKeyId());
            if (!exists) {
                response.setStatus(Constant.RESPONSE_CODE.DATA_PASS);
                response.setMessage(Constant.RESPONSE_FAIL_MESSAGE.DEL_MSG);  // Adjust the message for deletion
            } else {
                // Proceed to delete if the entity exists
                provinceRepository.deleteById(villageEntity.getKeyId());
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
