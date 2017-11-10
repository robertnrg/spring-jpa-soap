package com.robert.spring.jpa.soap.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Roberto Noriega
 * @version 1.0.0
 * @since 24/10/17
 **/
@Entity
@Table(name = "t_permission")
public class Permission extends Catalog {

    private static final long serialVersionUID = 4098235356608001836L;

}