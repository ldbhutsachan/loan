package com.ldb.loanapi.services;

import com.ldb.loanapi.Entities.Location.DistrictEntity;
import com.ldb.loanapi.Entities.Location.ProvinceEntity;
import com.ldb.loanapi.Entities.Location.VillageEntity;
import com.ldb.loanapi.Messages.response.DataResponse;

public interface ProvinceService {
    public DataResponse getProvinceList(ProvinceEntity provinceEntity);
    public DataResponse saveProvince(ProvinceEntity provinceEntity);
    public DataResponse updateProvince(ProvinceEntity provinceEntity);
    public DataResponse delProvince(ProvinceEntity provinceEntity);

    public DataResponse getDistrictList (DistrictEntity districtEntity);
    public DataResponse saveDistrict(DistrictEntity districtEntity);
    public DataResponse updateDistrict(DistrictEntity districtEntity);
    public DataResponse delDistrict(DistrictEntity districtEntity);

    public DataResponse getVillageList(VillageEntity villageEntity);
    public DataResponse saveVillage(VillageEntity villageEntity);
    public DataResponse updateVillage(VillageEntity villageEntity);
    public DataResponse delVillage(VillageEntity villageEntity);


}
