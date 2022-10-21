package com.alexeyleping.crm.controllers;

import com.alexeyleping.crm.controllers.dto.ApplicationDto;
import com.alexeyleping.crm.controllers.dto.ReturnApplicationDto;
import com.alexeyleping.crm.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/getApplicationId{id}")
    public ReturnApplicationDto getApplication(@PathVariable Long id) {
        return applicationService.getApplication(id);
    }

    @PostMapping
    public String createApplication (@RequestBody ApplicationDto applicationDto){
        return  applicationService.createApplication(applicationDto);
    }
    @PutMapping
    public String updateApplication(@RequestBody ApplicationDto applicationDto) {
        return applicationService.updateApplication(applicationDto);
    }

    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        return applicationService.deleteApplication(id);
    }
}
