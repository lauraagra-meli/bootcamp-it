package br.dh.meli.sprintdata01.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity // tem que ter uma tabela no bd pra guardar isso - JAVAX
@Table(name = "tb_user") // nome da tabela no banco
public class UserBD {
    // passar as informacoes por JPA
    @Id // passa a ser a chave primaria no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) // valor gerado automaticamente pelo bd - strategy significa que vai ser numerado sequencialmente
    private long id;

    @Column (name = "name", length = 100, nullable = false) // nome no bd, tamanho maximo do campo, pode ser null ou nao
    private String name;

    @Column(length = 80, nullable = false, unique = true) // unique tambem gera index - se não como um name, o nome abaixo é usado
    private String email;
}

// Hibernate - cria o bd