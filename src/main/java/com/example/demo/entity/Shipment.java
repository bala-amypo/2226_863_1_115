package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shipments")

public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shipmentCode;
    private String origin;
    private String destination;
    private String status;

    public Shipment() {

    }

    public Shipment(String shipmentCode, String origin, String destination, String status) {
            this.shipmentCode = shipmentCode;
            this.origin = origin;
            this.destination = destination;
            this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
     }



    public String getDestination() {

        return destination;

    }



    public void setDestination(String destination) {

        this.destination = destination;

    }



    public String getStatus() {

                                                                                                    return status;

                                                                                        }



                                                                                            public void setStatus(String status) {

                                                                                                        this.status = status;

                                                                                            }

                                                                                            }
                                                                                           