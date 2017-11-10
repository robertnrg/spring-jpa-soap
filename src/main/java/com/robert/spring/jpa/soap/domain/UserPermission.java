package com.robert.spring.jpa.soap.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Roberto Noriega
 * @version 1.0.0
 * @since 24/10/17
 **/
@Data
@Entity
@Table(name = "t_user_permission")
public class UserPermission implements java.io.Serializable {

    private static final long serialVersionUID = -5104143425120891828L;

    @Id
    @ManyToOne
    @JoinColumn(name="user_id", updatable = false, insertable = false, referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="permission_id", updatable = false, insertable = false, referencedColumnName = "id")
    private Permission permission;

}