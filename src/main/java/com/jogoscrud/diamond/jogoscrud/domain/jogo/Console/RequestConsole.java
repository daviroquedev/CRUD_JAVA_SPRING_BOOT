package com.jogoscrud.diamond.jogoscrud.domain.jogo.Console;

import jakarta.validation.constraints.NotBlank;

public record RequestConsole(
        @NotBlank
        String nome,
        String dataLancamento,
        String empresa
) {
}