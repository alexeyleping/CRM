package com.alexeyleping.crm.controllers;

import com.alexeyleping.crm.controllers.dto.ApplicationDto;
import com.alexeyleping.crm.controllers.dto.ReturnApplicationDto;
import com.alexeyleping.crm.entity.Application;
import com.alexeyleping.crm.service.ApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/main")
    public Page<Application> mainPage(@RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                      @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return applicationService.getAll(limit, page);
    }

    @GetMapping("/getApplicationId{id}")
    public ReturnApplicationDto getApplication(@PathVariable UUID id) {
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
    public String deleteApplication(@PathVariable UUID id) {
        return applicationService.deleteApplication(id);
    }
}
