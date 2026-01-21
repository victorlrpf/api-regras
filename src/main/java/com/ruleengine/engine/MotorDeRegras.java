package com.ruleengine.engine;

import com.ruleengine.rules.Regra;
import java.util.List;
import java.util.stream.Collectors;

public class MotorDeRegras<T> {

    private final List<Regra<T>> regras;

    public MotorDeRegras(List<Regra<T>> regras) {
        this.regras = regras;
    }

    public List<T> processar(List<T> entidades) {
        return entidades.stream()
            .map(entidade ->
                regras.stream()
                    .filter(regra -> regra.aplica(entidade))
                    .reduce(entidade,
                        (e, regra) -> regra.executar(e),
                        (e1, e2) -> e1
                    )
            )
            .collect(Collectors.toList());
    }
}
