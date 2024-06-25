package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.acme.dto.CustomerDTO;

@Entity
@Table(name="customer")
@Data // cria automaticamente os Gets e Sets para os Atributos
@AllArgsConstructor // cria um contrutor com os atributos da classe
@NoArgsConstructor  // cria o contrutor padrão sem argumentos
public class CustomerEntity extends CustomerDTO {

    @Id // gera o Id para cada cliente criado no banco de dados
    @GeneratedValue // faz a sequencia dos ids criados no banco na tabela do banco de dados
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;
}
