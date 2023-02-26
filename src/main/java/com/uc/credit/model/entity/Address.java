package com.uc.credit.model.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String country;
    @NotBlank(message = "İl alanı boş olmaz.")
    private String province;
    @NotBlank(message = "İlçe alanı boş olmaz.")
    private String district;
    private String neighborhood;
    private String street;
    private String buildingInformation;
    private String fullAddress;



}
