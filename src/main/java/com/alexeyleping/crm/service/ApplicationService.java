package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.ApplicationDto;
import com.alexeyleping.crm.controllers.dto.ReturnApplicationDto;
import com.alexeyleping.crm.entity.Application;
import com.alexeyleping.crm.repository.ApplicationRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ApplicationService {

    private final ApplicationRepository applicationRepository;


    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ReturnApplicationDto getApplication(UUID id) {
        Application application = applicationRepository.findById(id).get();
        ReturnApplicationDto returnApplicationDto = new ReturnApplicationDto(application.getId(), application.getNumber(), application.getCreator(),
                application.getOwner(), application.getApplicationType(), application.getDescription(), application.getCreate(), application.getChange(),
                application.getPrice());
        return returnApplicationDto;
    }

    @Transactional
    public ReturnApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application = new Application(applicationDto.id(), applicationDto.number(), applicationDto.creator(), applicationDto.owner(),
                applicationDto.applicationType(), applicationDto.description(), applicationDto.create(), applicationDto.change(), applicationDto.price());
        UUID uuid = UUID.randomUUID();
        application.setId(uuid);
        application.setCreate(LocalDate.now());
        application.setChange(LocalDate.now());
        applicationRepository.save(application);
        ReturnApplicationDto returnApplicationDto = new ReturnApplicationDto(application.getId(), application.getNumber(), application.getCreator(), application.getOwner(),
                application.getApplicationType(), application.getDescription(), application.getCreate(), application.getChange(), application.getPrice());
        return returnApplicationDto;

    }

    public void updateApplication(UUID id, ApplicationDto applicationDto) {
        Application application = applicationRepository.getReferenceById(id);
        if (!applicationDto.description().equals(application.getDescription()))
            application.setDescription(applicationDto.description());
        if (!applicationDto.owner().equals(application.getOwner()))
            application.setOwner(applicationDto.owner());
        application.setChange(LocalDate.now());
    }

    public void deleteApplication(UUID id) {
        applicationRepository.deleteById(id);
    }

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }
}
