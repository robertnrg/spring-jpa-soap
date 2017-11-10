package com.robert.spring.jpa.soap.service.impl;

import com.robert.spring.jpa.soap.domain.Status;
import com.robert.spring.jpa.soap.ws.StatusDTO;
import com.robert.spring.jpa.soap.repository.StatusRepository;
import com.robert.spring.jpa.soap.service.StatusService;
import lombok.AccessLevel;
import lombok.Getter;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roberto Noriega
 * @version 1.0.0
 * @since 24/10/17
 **/
@Service("srvStatus")
public class StatusServiceImpl implements StatusService {

    @Autowired
    @Getter(AccessLevel.PRIVATE)
    private StatusRepository statusRepository;

    @Autowired
    @Getter(AccessLevel.PRIVATE)
    private DozerBeanMapperFactoryBean dozerBean;

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public StatusDTO getByCode(String code) throws Exception {
        StatusDTO statusDTO = null;
        try {
            final Status status = this.getStatusRepository().findByCode(code);
            if (null != status) {
                statusDTO = new StatusDTO();
                dozerBean.getObject().map(status, statusDTO, "statusDTO");
            }
        } catch (Exception ex) {
            LOGGER.error("{}", ex.getMessage());
            throw ex;
        }

        return statusDTO;
    }

    @Override
    public List<StatusDTO> getAll() throws Exception {
        List<StatusDTO> lstStatusDTO;
        try {
            final List<Status> lstStatus = this.getStatusRepository().findAll();
            lstStatusDTO = new ArrayList<>();
            for (final Status status : lstStatus) {
                final StatusDTO statusDTO = new StatusDTO();
                dozerBean.getObject().map(status, statusDTO, "statusDTO");
                lstStatusDTO.add(statusDTO);
            }
        } catch (Exception ex) {
            LOGGER.error("{}", ex.getMessage());
            throw ex;
        }

        return lstStatusDTO;
    }

    @Override
    public List<StatusDTO> filterByCode(String code) throws Exception {
        List<StatusDTO> lstStatusDTO;
        try {
            final List<Status> lstStatus = this.getStatusRepository().filterByCode("%" + (null != code ? code : "") + "%");
            lstStatusDTO = new ArrayList<>();
            for (final Status status : lstStatus) {
                final StatusDTO statusDTO = new StatusDTO();
                dozerBean.getObject().map(status, statusDTO, "statusDTO");
                lstStatusDTO.add(statusDTO);
            }
        } catch (Exception ex) {
            LOGGER.error("{}", ex.getMessage());
            throw ex;
        }

        return lstStatusDTO;
    }

}