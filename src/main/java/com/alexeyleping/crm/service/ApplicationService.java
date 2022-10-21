package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.ApplicationDto;
import com.alexeyleping.crm.controllers.dto.ReturnApplicationDto;
import com.alexeyleping.crm.entity.Application;
import com.alexeyleping.crm.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;


    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ReturnApplicationDto getApplication(Long id){
        Optional<Application> application = applicationRepository.findById(id);
        ReturnApplicationDto returnApplicationDto = new ReturnApplicationDto();
        returnApplicationDto.setId(application.get().getId());
        returnApplicationDto.setApplicationType(application.get().getApplicationType());
        returnApplicationDto.setCreator(application.get().getCreator());
        returnApplicationDto.setDateChanged(application.get().getDateChanged());
        returnApplicationDto.setDateCreated(application.get().getDateCreated());
        returnApplicationDto.setDescription(application.get().getOwner());
        returnApplicationDto.setPrice(application.get().getPrice());
        return returnApplicationDto;
    }

    public String createApplication(ApplicationDto applicationDto){
        Application application = new Application();
        application.setApplicationType(applicationDto.getApplicationType());
        application.setCreator(applicationDto.getCreator());
        application.setDateChanged(applicationDto.getDateChanged());
        application.setDescription(applicationDto.getDescription());
        application.setOwner(applicationDto.getOwner());
        application.setPrice(applicationDto.getPrice());
        Date timeStamp = Calendar.getInstance().getTime();
        application.setDateCreated(timeStamp);
        applicationRepository.save(application);
        return "200 OK";
    }

    public String updateApplication(ApplicationDto applicationDto){
        Application application = applicationRepository.getReferenceById(applicationDto.getId());
        if(applicationDto.getApplicationType() != null)
            application.setApplicationType(applicationDto.getApplicationType());
        if(applicationDto.getDescription() != null)
            application.setDescription(applicationDto.getDescription());
        if(applicationDto.getOwner() != null)
            application.setOwner(applicationDto.getOwner());
        if(application.getPrice() != applicationDto.getPrice())
            application.setPrice(applicationDto.getPrice());
        Date timeStamp = Calendar.getInstance().getTime();
        application.setDateChanged(timeStamp);
        return "OK. OBJECT UPDATE.";
    }

    public String deleteApplication(Long id){
        applicationRepository.deleteById(id);
        return "OK. OBJECT DELETE.";
    }
}
