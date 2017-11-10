package com.robert.spring.jpa.soap.service.impl;

import com.robert.spring.jpa.soap.domain.Permission;
import com.robert.spring.jpa.soap.ws.PermissionDTO;
import com.robert.spring.jpa.soap.repository.PermissionRepository;
import com.robert.spring.jpa.soap.service.PermissionService;
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
 * @since 23/10/17
 **/
@Service("srvPermission")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    @Getter(AccessLevel.PRIVATE)
    private PermissionRepository permissionRepository;

    @Autowired
    @Getter(AccessLevel.PRIVATE)
    private DozerBeanMapperFactoryBean dozerBean;

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public PermissionDTO getByCode(String code) throws Exception {
        PermissionDTO permissionDTO = null;
        try {
            final Permission permission = this.getPermissionRepository().findByCode(code);
            if (null != permission) {
                permissionDTO = new PermissionDTO();
                dozerBean.getObject().map(permission, permissionDTO, "permissionDTO");
            }
        } catch (Exception ex) {
            LOGGER.error("{}", ex.getMessage());
            throw ex;
        }

        return permissionDTO;
    }

    @Override
    public List<PermissionDTO> getAll() throws Exception {
        List<PermissionDTO> lstPermissionsDTO;
        try {
            final List<Permission> lstPermissions = this.getPermissionRepository().findAll();
            lstPermissionsDTO = new ArrayList<>();
            for (final Permission permission : lstPermissions) {
                final PermissionDTO permissionDTO = new PermissionDTO();
                dozerBean.getObject().map(permission, permissionDTO, "permissionDTO");
                lstPermissionsDTO.add(permissionDTO);
            }
        } catch (Exception ex) {
            LOGGER.error("{}", ex.getMessage());
            throw ex;
        }

        return lstPermissionsDTO;
    }

    @Override
    public List<PermissionDTO> filterByCode(String code) throws Exception {
        List<PermissionDTO> lstPermissionsDTO;
        try {
            final List<Permission> lstPermissions = this.getPermissionRepository().filterByCode("%" + (null != code ? code : "") + "%");
            lstPermissionsDTO = new ArrayList<>();
            for (final Permission permission : lstPermissions) {
                final PermissionDTO permissionDTO = new PermissionDTO();
                dozerBean.getObject().map(permission, permissionDTO, "permissionDTO");
                lstPermissionsDTO.add(permissionDTO);
            }
        } catch (Exception ex) {
            LOGGER.error("{}", ex.getMessage());
            throw ex;
        }

        return lstPermissionsDTO;
    }

}