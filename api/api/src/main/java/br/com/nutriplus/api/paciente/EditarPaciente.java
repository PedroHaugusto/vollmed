package br.com.nutriplus.api.paciente;

import br.com.nutriplus.api.endereco.DadosEndereco;
import jakarta.validation.Valid;

public record EditarPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}
