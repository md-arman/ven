package com.dev.ven.controller;

import com.dev.ven.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ven/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    //this api will return the report in text based on the farmID
    // report will contain expected vs actual amount data
    @GetMapping("/getFarmReport/{farmId}")
    public String getFarmReport(@PathVariable String farmId){
        return reportService.getFarmReport(farmId);

    }

    //this api will return the report in text based on the cropName
    // report will contain expected vs actual amount data for that crop
    @GetMapping("/getCropReport/{cropName}")
    public String getCropReport(@PathVariable String cropName){
        return reportService.getCropReport(cropName);
    }

}
