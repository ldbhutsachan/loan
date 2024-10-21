package com.ldb.loanapi.Repositories;

import com.ldb.loanapi.Entities.Location.DistrictEntity;
import com.ldb.loanapi.Entities.Location.ProvinceEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProvinceRepository extends CrudRepository<ProvinceEntity,ProvinceEntity> {
    default ProvinceEntity updateProvince(ProvinceEntity provinceEntity){
        return save(provinceEntity);
    }


    @Modifying
    @Query("DELETE FROM ProvinceEntity p WHERE p.keyId = :keyId")
    boolean deleteById(@Param("keyId") Long keyId);

    boolean existsById(Long keyId);
}
