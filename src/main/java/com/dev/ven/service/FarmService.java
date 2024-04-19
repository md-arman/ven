package com.dev.ven.service;

import com.dev.ven.model.FarmDetails;
import com.dev.ven.repo.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;

    public String addCropDetails(FarmDetails farmDetails) {
        //some field validations can also be put manually here,
        // or in the model class itself using @NotNull, @NotEmpty, etc.
        // and then custom exception handling can also be put in ControllerAdvice
        try {
            FarmDetails data = this.farmRepository.save(farmDetails);
            return "Data for crop: "+data.getCropType()+" in farm: "+data.getFarmId()+ " is saved successfully";
        } catch (Exception e) {
            return "Data CANNOT be saved for crop: "+ farmDetails.getCropType()+
                    " in farm: "+ farmDetails.getFarmId();
        }

    }
}
