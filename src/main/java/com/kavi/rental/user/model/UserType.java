package com.kavi.rental.user.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;

@Entity
@Table(name = "user_type")
public class UserType implements Serializable {
    public final static int USER_TYPE_GUEST = 0;
    public final static int USER_TYPE_SUPER_ADMIN = 2;
    public final static int USER_TYPE_ADMIN = 3;
    public final static int USER_TYPE_VEHICLE_OWNER = 1;
    public final static int USER_TYPE_DRIVER = 14;
    public final static int USER_TYPE_MANAGER = 15;
    public final static int USER_TYPE_REGISTERED_USER = 16;

    public final static HashMap<Integer, String> USER_ROLES = new HashMap<Integer, String>() {{
        put(USER_TYPE_GUEST, "ROLE_GUEST");
        put(USER_TYPE_SUPER_ADMIN, "ROLE_SUPERADMIN");
        put(USER_TYPE_ADMIN, "ROLE_ADMIN");
        put(USER_TYPE_DRIVER, "ROLE_DRIVER");
    }};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = USER_TYPE_GUEST;
    private String type = USER_ROLES.get(USER_TYPE_GUEST);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}