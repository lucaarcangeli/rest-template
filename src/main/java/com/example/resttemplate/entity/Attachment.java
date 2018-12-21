package com.example.resttemplate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author OITECH develop team - 19/12/2018
 */
@Entity
@Table(name = "allegato")
@Getter
@Setter
public class Attachment extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "entity")
    private String entity;

    @Column(name = "eid")
    private Integer eid;

    @Column(name = "idcliente")
    private Integer idcliente;

    @Column(name = "idfattura")
    private Integer idfattura;

    @Column(name = "idpa")
    private Integer idpa;

    @Column(name = "documento")
    private String documento;

    @Column(name = "file")
    private String file;

    @Column(name = "mandatorio")
    private Integer mandatorio;

    @Column(name = "controllato")
    private Boolean controllato;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "scadenza")
    private String scadenza;

    @Column(name = "aggiornato")
    private Integer aggiornato;

    @Column(name = "added")
    private Integer added;

    @Column(name = "idcontratto")
    private Integer idcontratto;

    @Column(name = "contratto")
    private String contratto;
}
