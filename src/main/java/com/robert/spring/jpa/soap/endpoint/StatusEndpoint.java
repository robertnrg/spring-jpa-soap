package com.robert.spring.jpa.soap.endpoint;

import com.robert.spring.jpa.soap.service.StatusService;
import com.robert.spring.jpa.soap.ws.*;
import com.robert.spring.jpa.soap.ws.Void;
import lombok.AccessLevel;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * @author Roberto Noriega
 * @version 1.0.0
 * @since 25/10/17
 **/
@Endpoint
public class StatusEndpoint {

    @Autowired
    @Getter(AccessLevel.PRIVATE)
    private StatusService srvStatus;

    private static final String NAMESPACE_URI = "http://spring-jpa-soap.com/web-service";

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStatusByCodeRequest")
    public GetStatusByCodeResponse getStatusByCode(@RequestPayload GetStatusByCodeRequest getStatusByCodeRequest) throws Exception {
        LOGGER.info("{}", getStatusByCodeRequest);
        final StatusDTO statusDTO = this.getSrvStatus().getByCode(getStatusByCodeRequest.getCode());
        LOGGER.info("{}", statusDTO);

        return new GetStatusByCodeResponse(statusDTO);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStatusRequest")
    public GetAllStatusResponse getAllStatus(@RequestPayload Void getVoid) throws Exception {
        final List<StatusDTO> lstStatusDTO = this.getSrvStatus().getAll();
        LOGGER.debug("{}", lstStatusDTO);

        return new GetAllStatusResponse(lstStatusDTO);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "filterStatusByCodeRequest")
    public FilterStatusByCodeResponse filterStatusByCode(@RequestPayload FilterStatusByCodeRequest filterStatusByCodeRequest) throws Exception {
        LOGGER.info("{}", filterStatusByCodeRequest);
        final List<StatusDTO> lstStatusDTO = this.getSrvStatus().filterByCode(filterStatusByCodeRequest.getCode());
        LOGGER.debug("{}", lstStatusDTO);

        return new FilterStatusByCodeResponse(lstStatusDTO);
    }

}