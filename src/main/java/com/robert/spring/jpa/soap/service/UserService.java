package com.robert.spring.jpa.soap.service;

import com.robert.spring.jpa.soap.ws.UserDTO;

import java.util.List;

/**
 * @author Roberto Noriega
 * @version 1.0.0
 * @since 24/10/17
 **/
public interface UserService {

    Long saveUser(UserDTO userDTO) throws Exception;

    UserDTO getByUsername(String username) throws Exception;

    List<UserDTO> getAll() throws Exception;

    List<UserDTO> filterByUsername(String username) throws Exception;

    Boolean exist(String username) throws Exception;

}