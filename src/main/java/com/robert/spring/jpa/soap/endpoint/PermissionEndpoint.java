package com.robert.spring.jpa.soap.endpoint;

import com.robert.spring.jpa.soap.service.PermissionService;
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
public class PermissionEndpoint {

    @Autowired
    @Getter(AccessLevel.PRIVATE)
    private PermissionService srvPermission;

    private static final String NAMESPACE_URI = "http://spring-jpa-soap.com/web-service";

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPermissionByCodeRequest")
    public GetPermissionByCodeResponse getPermissionByCode(@RequestPayload GetPermissionByCodeRequest getPermissionByCodeRequest) throws Exception {
        LOGGER.info("{}", getPermissionByCodeRequest);
        final PermissionDTO permissionDTO = this.getSrvPermission().getByCode(getPermissionByCodeRequest.getCode());
        LOGGER.info("{}", permissionDTO);

        return new GetPermissionByCodeResponse(permissionDTO);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPermissionsRequest")
    public GetAllPermissionsResponse getAllPermissions(@RequestPayload Void getVoid) throws Exception {
        final List<PermissionDTO> lstPermissionsDTO = this.getSrvPermission().getAll();
        LOGGER.debug("{}", lstPermissionsDTO);

        return new GetAllPermissionsResponse(lstPermissionsDTO);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "filterPermissionByCodeRequest")
    public FilterPermissionByCodeResponse filterPermissionByCode(@RequestPayload FilterPermissionByCodeRequest filterPermissionByCodeRequest) throws Exception {
        LOGGER.info("{}", filterPermissionByCodeRequest);
        final List<PermissionDTO> lstPermissionsDTO = this.getSrvPermission().filterByCode(filterPermissionByCodeRequest.getCode());
        LOGGER.debug("{}", lstPermissionsDTO);

        return new FilterPermissionByCodeResponse(lstPermissionsDTO);
    }

}