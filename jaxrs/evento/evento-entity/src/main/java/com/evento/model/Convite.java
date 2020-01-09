package com.evento.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "convite")
@XmlRootElement(name = "Convite")
@XmlAccessorType(XmlAccessType.FIELD)
public class Convite implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8188690304868834266L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @XmlTransient
    @ManyToOne
    private Evento evento;
    
    @ManyToOne
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;
    
    @Enumerated(EnumType.STRING)
    private StatusConvite status;

    public Convite() {
        this.status = StatusConvite.NAO_RESPONDIDO;
    }

    public Convite(Evento evento, Pessoa pessoa) {
        this(evento, pessoa, StatusConvite.NAO_RESPONDIDO);
    }

    public Convite(Evento evento, Pessoa pessoa, StatusConvite status) {
        this.evento = evento;
        this.pessoa = pessoa;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public StatusConvite getStatus() {
        return status;
    }

    public void setStatus(StatusConvite status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Convite [" + id + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Convite other = (Convite) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
