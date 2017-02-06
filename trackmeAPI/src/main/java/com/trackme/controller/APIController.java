package com.trackme.controller;

import static com.trackme.service.APIStatusService.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trackme.dto.LocationInfo;
import com.trackme.dto.ServiceStatus;
import com.trackme.service.APIStatusService;
import com.trackme.service.LoactionService;


@RestController
public class APIController {
	
	@Autowired
	private LoactionService loactionService;
	
	@Autowired
	private APIStatusService statusService;
	
	@RequestMapping(value="/location", method=RequestMethod.POST)
    public ServiceStatus greeting(LocationInfo req) {
		boolean success = loactionService.pushToDB();
		
        return statusService.getStatus(success, LOC_POST);
    }

}
