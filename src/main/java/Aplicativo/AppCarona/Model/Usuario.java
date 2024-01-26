package Aplicativo.AppCarona.Model;

import Aplicativo.AppCarona.Model.Enum.UsuarioEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "cpf", nullable = false, unique = true)
    @Digits(integer = 11, fraction = 0, message = "O CPF deve conter apenas dígitos")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 dígitos")
    private String cpf;
    @Column(name = "name", nullable = false)
    private String nome;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "tipo_usuario", nullable = false)
    private UsuarioEnum usuarioEnum;




}
