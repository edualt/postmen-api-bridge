package com.example.medium.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateOrderRequest {

    @NotBlank
    @NotNull
    private String address;

    private String city;

    @NotBlank
    @NotNull
    private String state;


    private String postalCode;


    private String shipTo;

    private String associatedEmail;

}
