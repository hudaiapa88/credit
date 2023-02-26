package com.uc.credit.model.dto.customer.request;

import com.uc.credit.model.entity.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class UpdateCustomerRequest {
    @NotEmpty(message = "Ad alanı boş olamaz.")
    @Size(min = 2,max = 40,message = "Ad en az 2 en fazla 40 karakter girebilirsiniz.")
    @Pattern(regexp = "^[a-zA-ZçÇğĞöÖşŞüÜİı ]*$",message = "Lütfen geçerli bir ad giriniz.")
    private String firstname;
    @NotEmpty(message = "Soyad alanı boş olamaz.")
    @Size(min = 2, max = 40, message = "Soyad en az 2 en fazla 40 karakter girebilirsiniz.")
    @Pattern(regexp = "^[a-zA-ZçÇğĞöÖşŞüÜİı ]*$", message = "Lütfen geçerli bir soyad giriniz.")
    private String lastname;
    @Size(min = 11,max = 11,message = "Lütfen geçerli bir tc numarası giriniz.")
    private String citizenId;
    @NotEmpty(message = "Telefon alanı boş olamaz.")
    @Pattern(regexp = "^[0-9+]*$",message = "Lütfen geçerli bir telefon numarası giriniz.")
    @Size(min = 2,max = 13,message = "Lütfen geçerli bir telefon numarası giriniz.")
    private String phone;
    @Past(message = "Doğum gününüz geçmiş bir tarih olmalıdır.")
    private LocalDate birthDate;
    @Positive(message = "Geçerli bir gelir giriniz.")
    private BigDecimal monthlyIncome;
    @Valid
    private Address address;
}
