package com.alexeyleping.crm.controllers;

import com.alexeyleping.crm.controllers.dto.ApplicationDto;
import com.alexeyleping.crm.controllers.dto.ReturnApplicationDto;
import com.alexeyleping.crm.entity.Application;
import com.alexeyleping.crm.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/main")
    public List<Application> mainPage() {
        return applicationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReturnApplicationDto getApplication(@PathVariable UUID id) {
        return applicationService.getApplication(id);
    }

    @PostMapping("/")
    public ResponseEntity<ReturnApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto) throws URISyntaxException {
        System.out.println(applicationDto);
        ReturnApplicationDto returnApplicationDto = applicationService.createApplication(applicationDto);
        return ResponseEntity.created(new URI("/application/main" + returnApplicationDto.id()))
                .body(returnApplicationDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateApplication(@PathVariable UUID id, @RequestBody ApplicationDto applicationDto) {
        applicationService.updateApplication(id, applicationDto);
    }
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable UUID id) {
        applicationService.deleteApplication(id);
    }
}
