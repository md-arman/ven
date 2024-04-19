package com.dev.ven.repo;

import com.dev.ven.model.FarmDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmRepository extends JpaRepository<FarmDetails, Integer> {

    @Query(value = "SELECT * FROM FARM_DETAILS WHERE CROP_TYPE = ? ", nativeQuery = true)
    List<FarmDetails> findByCropType(String crop);

    @Query(value = "SELECT * FROM FARM_DETAILS WHERE FARM_ID = ? ", nativeQuery = true)
    List<FarmDetails> findByFarmId(String farmId);

}
