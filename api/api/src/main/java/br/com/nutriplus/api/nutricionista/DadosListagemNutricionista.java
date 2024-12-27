package br.com.nutriplus.api.nutricionista;

public record DadosListagemNutricionista(Long id, String nome, String email, String crn) {

    public DadosListagemNutricionista(Nutricionista nutricionista) {
        this(nutricionista.getId(), nutricionista.getNome(), nutricionista.getEmail(), nutricionista.getCrn());
    }
}
