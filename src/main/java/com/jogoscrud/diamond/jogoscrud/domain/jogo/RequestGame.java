package com.jogoscrud.diamond.jogoscrud.domain.jogo;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record RequestGame(
        Long id,
        @NotBlank
        String name,
        String descricao,
        String dataLancamento,
        String website,
        Integer desenvolvedor_codigo,
        String genero,
        String urlCapa,
        List<Integer> console_codigo
) {
}