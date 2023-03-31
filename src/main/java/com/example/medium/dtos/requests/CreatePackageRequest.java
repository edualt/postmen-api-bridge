package com.example.medium.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter @Setter
public class CreatePackageRequest implements Serializable {

    @NotBlank
    @NotNull
    private Float weight;

    @NotBlank
    @NotNull
    private Float width;

    @NotBlank
    @NotNull
    private Float height;

}
