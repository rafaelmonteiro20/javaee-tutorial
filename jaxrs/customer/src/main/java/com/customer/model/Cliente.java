package com.customer.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cliente")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int id;

    @XmlElement(required = true)
    private String nome;

    @XmlElement(required = true)
    private String email;

    
    public Cliente() {
       
    }

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
