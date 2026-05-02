package com.klef.fsaad.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_id", nullable = false)
    private Integer transportId;

    @NotBlank(message = "name must not be blank")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "date must not be null")
    @Column(nullable = false)
    private LocalDate date;

    @NotBlank(message = "status must not be blank")
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String type;

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
