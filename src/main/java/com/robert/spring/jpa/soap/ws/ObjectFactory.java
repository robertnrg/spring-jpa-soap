//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.10.25 a las 05:32:21 PM CDT 
//


package com.robert.spring.jpa.soap.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.robert.spring.jpa.soap.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllUserRequest_QNAME = new QName("http://spring-jpa-soap.com/web-service", "getAllUserRequest");
    private final static QName _GetAllStatusRequest_QNAME = new QName("http://spring-jpa-soap.com/web-service", "getAllStatusRequest");
    private final static QName _SaveUserResponse_QNAME = new QName("http://spring-jpa-soap.com/web-service", "saveUserResponse");
    private final static QName _GetAllPermissionsRequest_QNAME = new QName("http://spring-jpa-soap.com/web-service", "getAllPermissionsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.robert.spring.jpa.soap.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserByUsernameResponse }
     * 
     */
    public GetUserByUsernameResponse createGetUserByUsernameResponse() {
        return new GetUserByUsernameResponse();
    }

    /**
     * Create an instance of {@link UserDTO }
     * 
     */
    public UserDTO createUserDTO() {
        return new UserDTO();
    }

    /**
     * Create an instance of {@link GetPermissionByCodeRequest }
     * 
     */
    public GetPermissionByCodeRequest createGetPermissionByCodeRequest() {
        return new GetPermissionByCodeRequest();
    }

    /**
     * Create an instance of {@link FilterUserByUsernameResponse }
     * 
     */
    public FilterUserByUsernameResponse createFilterUserByUsernameResponse() {
        return new FilterUserByUsernameResponse();
    }

    /**
     * Create an instance of {@link SaveUserRequest }
     * 
     */
    public SaveUserRequest createSaveUserRequest() {
        return new SaveUserRequest();
    }

    /**
     * Create an instance of {@link FilterPermissionByCodeRequest }
     * 
     */
    public FilterPermissionByCodeRequest createFilterPermissionByCodeRequest() {
        return new FilterPermissionByCodeRequest();
    }

    /**
     * Create an instance of {@link Void }
     * 
     */
    public Void createVoid() {
        return new Void();
    }

    /**
     * Create an instance of {@link GetAllUserResponse }
     * 
     */
    public GetAllUserResponse createGetAllUserResponse() {
        return new GetAllUserResponse();
    }

    /**
     * Create an instance of {@link GetPermissionByCodeResponse }
     * 
     */
    public GetPermissionByCodeResponse createGetPermissionByCodeResponse() {
        return new GetPermissionByCodeResponse();
    }

    /**
     * Create an instance of {@link PermissionDTO }
     * 
     */
    public PermissionDTO createPermissionDTO() {
        return new PermissionDTO();
    }

    /**
     * Create an instance of {@link GetAllPermissionsResponse }
     * 
     */
    public GetAllPermissionsResponse createGetAllPermissionsResponse() {
        return new GetAllPermissionsResponse();
    }

    /**
     * Create an instance of {@link FilterPermissionByCodeResponse }
     * 
     */
    public FilterPermissionByCodeResponse createFilterPermissionByCodeResponse() {
        return new FilterPermissionByCodeResponse();
    }

    /**
     * Create an instance of {@link FilterUserByUsernameRequest }
     * 
     */
    public FilterUserByUsernameRequest createFilterUserByUsernameRequest() {
        return new FilterUserByUsernameRequest();
    }

    /**
     * Create an instance of {@link FilterStatusByCodeRequest }
     * 
     */
    public FilterStatusByCodeRequest createFilterStatusByCodeRequest() {
        return new FilterStatusByCodeRequest();
    }

    /**
     * Create an instance of {@link GetUserByUsernameRequest }
     * 
     */
    public GetUserByUsernameRequest createGetUserByUsernameRequest() {
        return new GetUserByUsernameRequest();
    }

    /**
     * Create an instance of {@link GetAllStatusResponse }
     * 
     */
    public GetAllStatusResponse createGetAllStatusResponse() {
        return new GetAllStatusResponse();
    }

    /**
     * Create an instance of {@link StatusDTO }
     * 
     */
    public StatusDTO createStatusDTO() {
        return new StatusDTO();
    }

    /**
     * Create an instance of {@link FilterStatusByCodeResponse }
     * 
     */
    public FilterStatusByCodeResponse createFilterStatusByCodeResponse() {
        return new FilterStatusByCodeResponse();
    }

    /**
     * Create an instance of {@link GetStatusByCodeRequest }
     * 
     */
    public GetStatusByCodeRequest createGetStatusByCodeRequest() {
        return new GetStatusByCodeRequest();
    }

    /**
     * Create an instance of {@link GetStatusByCodeResponse }
     * 
     */
    public GetStatusByCodeResponse createGetStatusByCodeResponse() {
        return new GetStatusByCodeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://spring-jpa-soap.com/web-service", name = "getAllUserRequest")
    public JAXBElement<Void> createGetAllUserRequest(Void value) {
        return new JAXBElement<Void>(_GetAllUserRequest_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://spring-jpa-soap.com/web-service", name = "getAllStatusRequest")
    public JAXBElement<Void> createGetAllStatusRequest(Void value) {
        return new JAXBElement<Void>(_GetAllStatusRequest_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://spring-jpa-soap.com/web-service", name = "saveUserResponse")
    public JAXBElement<Void> createSaveUserResponse(Void value) {
        return new JAXBElement<Void>(_SaveUserResponse_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://spring-jpa-soap.com/web-service", name = "getAllPermissionsRequest")
    public JAXBElement<Void> createGetAllPermissionsRequest(Void value) {
        return new JAXBElement<Void>(_GetAllPermissionsRequest_QNAME, Void.class, null, value);
    }

}
