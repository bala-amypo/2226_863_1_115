package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shipment_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String shipmentCode;

    private String origin;
    private String destination;
    private String status;

    @PrePersist
    public void setDefaultStatus() {
        if (status == null) {
            status = "IN_TRANSIT";
        }
    }
}
