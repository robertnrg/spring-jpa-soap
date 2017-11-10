package com.robert.spring.jpa.soap.endpoint;

import com.robert.spring.jpa.soap.service.UserService;
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
public class UserEndpoint {

    @Autowired
    @Getter(AccessLevel.PRIVATE)
    private UserService srvUser;

    private static final String NAMESPACE_URI = "http://spring-jpa-soap.com/web-service";

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByUsernameRequest")
    public GetUserByUsernameResponse getUserByUsername(@RequestPayload GetUserByUsernameRequest getUserByUsernameRequest) throws Exception {
        LOGGER.info("{}", getUserByUsernameRequest);
        final UserDTO userDTO = this.getSrvUser().getByUsername(getUserByUsernameRequest.getUsername());
        LOGGER.info("{}", userDTO);

        return new GetUserByUsernameResponse(userDTO);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUserRequest")
    public GetAllUserResponse getAllUsers(@RequestPayload Void getVoid) throws Exception {
        final List<UserDTO> lstUsersDTO = this.getSrvUser().getAll();
        LOGGER.debug("{}", lstUsersDTO);

        return new GetAllUserResponse(lstUsersDTO);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "filterUserByUsernameRequest")
    public FilterUserByUsernameResponse filterUserByUsername(@RequestPayload FilterUserByUsernameRequest filterUserByUsername) throws Exception {
        LOGGER.info("{}", filterUserByUsername);
        final List<UserDTO> lstUsersDTO = this.getSrvUser().filterByUsername(filterUserByUsername.getUsername());
        LOGGER.debug("{}", lstUsersDTO);

        return new FilterUserByUsernameResponse(lstUsersDTO);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveUserRequest")
    public SaveUserResponse saveUser(@RequestPayload SaveUserRequest saveUserRequest) throws Exception {
        LOGGER.info("{}", saveUserRequest);
        final Long idUser = this.getSrvUser().saveUser(saveUserRequest.getUser());
        LOGGER.info("idUser={}", idUser);

        return new SaveUserResponse(idUser);
    }

}