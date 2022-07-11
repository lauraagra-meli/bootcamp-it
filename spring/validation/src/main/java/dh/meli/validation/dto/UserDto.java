package dh.meli.validation.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
    @NotBlank(message = "Name is a mandatory field.") // não pode ser nulo e precisa conter algo dentro
    private String name;

    @NotBlank(message = "Email is a mandatory field.")
    @Email(message = "It must be a valid e-mail.")
    private String email;

    @Min(value = 18, message = "It must be over 18 years old.")
    private int age;
}

// validações personalizadas com regex
// @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ/s]+", message = "O nome do aluno deve começar com letra maiúscula.")
