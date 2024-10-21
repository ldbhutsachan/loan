package com.ldb.loanapi.Repositories;

import com.ldb.loanapi.Entities.Customer.CustomerEntity;
import com.ldb.loanapi.Entities.Location.VillageEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface VillageRepository extends CrudRepository<VillageEntity,VillageEntity> {

    default VillageEntity updateVillage(VillageEntity villageEntity){
        return save(villageEntity);
    }

    boolean deleteById(Long keyId);
}
