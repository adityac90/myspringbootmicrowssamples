package com.example.microservices.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "license_details", schema = "testschema")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class LicenseDetails implements Serializable {
    @Column(name = "license_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("license_id")
    private long license_id;
    @Column(name = "license_vendor")
    @JsonProperty("vendor")
    private String license_vendor;
    @Temporal(TemporalType.DATE)
    @Column(name = "license_expiration_date")
    @JsonProperty("expiration_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date license_expiration_date;
    @Column(name = "software_name")
    @JsonProperty("software_name")
    private String softwareName;
}
