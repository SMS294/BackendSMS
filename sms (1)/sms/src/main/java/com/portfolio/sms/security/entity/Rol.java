package com.portfolio.sms.security.entity;

import com.portfolio.sms.security.enums.RolNombre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @Enumerated (EnumType.STRING)
    private RolNombre rolNombre;

    //Constructor

    public Rol(@NotNull RolNombre rolNombre) {

        this.rolNombre = rolNombre;
    }

    public Rol() {
    }

    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}

