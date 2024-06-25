package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized // e utilizado reconhecer  para o formato Json
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String name;

    private String phone;

    private String email;

    private String address;

    private Long age;

}
