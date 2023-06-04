package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.ApplicationDto;
import com.alexeyleping.crm.controllers.dto.ReturnApplicationDto;
import com.alexeyleping.crm.entity.Application;
import com.alexeyleping.crm.repository.ApplicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;


    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ReturnApplicationDto getApplication(UUID id) {
        Optional<Application> application = applicationRepository.findById(id);
        ReturnApplicationDto returnApplicationDto = new ReturnApplicationDto(
                application.get().getId(),
                application.get().getNumber(),
                application.get().getCreator(),
                application.get().getOwner(),
                application.get().getApplicationType(),
                application.get().getDescription(),
                application.get().getCreate(),
                application.get().getChange(),
                application.get().getPrice());
        return returnApplicationDto;
    }

    public String createApplication(ApplicationDto applicationDto) {
        Application application = new Application();
        application.setApplicationType(applicationDto.applicationType());
        application.setCreator(applicationDto.creator());
        application.setChange(applicationDto.change());
        application.setDescription(applicationDto.description());
        application.setOwner(applicationDto.owner());
        application.setPrice(applicationDto.price());
        application.setCreate(LocalDate.now());
        applicationRepository.save(application);
        return "200 OK";
    }

    public String updateApplication(ApplicationDto applicationDto) {
        Application application = applicationRepository.getReferenceById(applicationDto.id());
        if (applicationDto.applicationType() != null)
            application.setApplicationType(applicationDto.applicationType());
        if (applicationDto.description() != null)
            application.setDescription(applicationDto.description());
        if (applicationDto.owner() != null)
            application.setOwner(applicationDto.owner());
        if (application.getPrice() != applicationDto.price())
            application.setPrice(applicationDto.price());
        application.setChange(LocalDate.now());
        return "OK. OBJECT UPDATE.";
    }

    public String deleteApplication(UUID id) {
        applicationRepository.deleteById(id);
        return "OK. OBJECT DELETE.";
    }

    public Page<Application> getAll(Integer limit, Integer page) {
        return applicationRepository.findAll(PageRequest.of(page, limit));
    }
}
