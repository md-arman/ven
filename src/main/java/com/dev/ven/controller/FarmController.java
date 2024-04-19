package com.dev.ven.controller;

import com.dev.ven.model.FarmDetails;
import com.dev.ven.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ven/farm")
public class FarmController {

    @Autowired
    FarmService farmService;

    @PostMapping("/addCropDetails")
    public String addCropDetails(@RequestBody FarmDetails farmDetails){
        return farmService.addCropDetails(farmDetails);
    }


}
