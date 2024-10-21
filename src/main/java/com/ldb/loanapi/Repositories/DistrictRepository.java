package com.ldb.loanapi.Repositories;

import com.ldb.loanapi.Entities.Location.DistrictEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DistrictRepository extends CrudRepository<DistrictEntity,DistrictEntity> {
   default DistrictEntity updateDistrict(DistrictEntity districtEntity){
       return save(districtEntity);
   }


    @Modifying
    @Query("DELETE FROM DistrictEntity p WHERE p.keyId = :keyId")
    boolean deleteById(@Param("keyId") Long keyId);

}
