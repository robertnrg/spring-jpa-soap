package com.robert.spring.jpa.soap.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Roberto Noriega
 * @version 1.0.0
 * @since 24/10/17
 **/
@Entity
@Table(name = "t_status")
public class Status extends Catalog {

    private static final long serialVersionUID = -1232636724592862808L;

}