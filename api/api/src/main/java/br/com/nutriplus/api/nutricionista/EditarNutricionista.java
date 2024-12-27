package br.com.nutriplus.api.nutricionista;

import br.com.nutriplus.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record EditarNutricionista(

        @NotNull
        Long id,

        String nome,
        String telefone,
        String email,
        DadosEndereco endereco) {

}
