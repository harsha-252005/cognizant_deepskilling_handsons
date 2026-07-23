package com.fse.country;
import jakarta.persistence.Entity; import jakarta.persistence.Id; import jakarta.validation.constraints.NotBlank;
@Entity public class Country { @Id @NotBlank private String code; @NotBlank private String name; protected Country() { } public Country(String code, String name) { this.code = code.toUpperCase(); this.name = name; } public String getCode() { return code; } public String getName() { return name; } }
