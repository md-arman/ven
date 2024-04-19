package com.dev.ven.service;

import com.dev.ven.exception.BadRequestException;
import com.dev.ven.exception.CropNotFoundException;
import com.dev.ven.exception.FarmNotFoundException;
import com.dev.ven.model.FarmDetails;
import com.dev.ven.repo.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private FarmRepository farmRepository;

    //business logic processing for gtting the report based on farm
    public String getFarmReport(String farmId) {
        Integer expectedAmount=0;
        Integer harvestedAmount=0;
        List<FarmDetails> farmDetailsList;
        if (Objects.nonNull(farmId) && !farmId.trim().isEmpty()) {
            //case senstive checks can be placed for cropName, or at the time of save
            // save it all small/caps, and then the same can be done here before fetching
            farmDetailsList = this.farmRepository.findByFarmId(farmId);
            if (Objects.nonNull(farmDetailsList) && !farmDetailsList.isEmpty()) {
                for (FarmDetails farmDetails : farmDetailsList) {
                    expectedAmount = expectedAmount + farmDetails.getExpectedAmount();
                    harvestedAmount = harvestedAmount + farmDetails.getHarvestedAmount();
                }
                return "Report for Farm "+farmId+" is::: Expected Amount is: "+expectedAmount+
                        " & Actual Amount is: "+harvestedAmount;
            } else {
                throw new FarmNotFoundException(404, "No data found for farm: " + farmId);
            }
        } else {
            throw new BadRequestException(400, "Please provide the farm id");
        }
    }

    //business logic processing for getting report based on crop name
    public String getCropReport(String cropName) {
        Integer expectedAmount=0;
        Integer harvestedAmount=0;
        List<FarmDetails> farmDetailsList;
        if (Objects.nonNull(cropName) && !cropName.trim().isEmpty()) {
            //case senstive checks can be placed for cropName, or at the time of save
            // save it all small/caps, and then the same can be done here before fetching
            farmDetailsList = this.farmRepository.findByCropType(cropName);
            if (Objects.nonNull(farmDetailsList) && !farmDetailsList.isEmpty()) {
                for (FarmDetails farmDetails : farmDetailsList) {
                    expectedAmount = expectedAmount + farmDetails.getExpectedAmount();
                    harvestedAmount = harvestedAmount + farmDetails.getHarvestedAmount();
                }
                return "Report for Crop "+cropName+" is::: Expected Amount is: "+expectedAmount+
                        " & Actual Amount is: "+harvestedAmount;
            } else {
                throw new CropNotFoundException(404, "No data found for crop: " + cropName);
            }
        } else {
            throw new BadRequestException(400, "Please provide the crop name");
        }
    }
}
