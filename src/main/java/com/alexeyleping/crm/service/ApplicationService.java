package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.ApplicationDto;
import com.alexeyleping.crm.controllers.dto.ReturnApplicationDto;
import com.alexeyleping.crm.entity.Application;
import com.alexeyleping.crm.repository.ApplicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    ModelMapper mapper = new ModelMapper();

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ReturnApplicationDto getApplication(UUID id) {
        Application application = applicationRepository.findById(id).get();
        ReturnApplicationDto returnApplicationDto = mapper.map(application, ReturnApplicationDto.class);
        return returnApplicationDto;
    }

    public String createApplication(ApplicationDto applicationDto) {
        Application application = mapper.map(applicationDto, Application.class);
        application.setCreate(LocalDate.now());
        application.setChange(LocalDate.now());
        applicationRepository.save(application);
        return "200 OK";
    }

    public String updateApplication(ApplicationDto applicationDto) {
        Application application = applicationRepository.getReferenceById(applicationDto.id());
        if (!applicationDto.applicationType().equals(application.getApplicationType()))
            application.setApplicationType(applicationDto.applicationType());
        if (!applicationDto.description().equals(application.getDescription()))
            application.setDescription(applicationDto.description());
        if (!applicationDto.owner().equals(application.getOwner()))
            application.setOwner(applicationDto.owner());
        if (application.getPrice() != application.getPrice())
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
