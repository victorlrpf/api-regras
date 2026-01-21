package com.ruleengine.rules;

public interface Regra<T> {
    boolean aplica(T entidade);
    T executar(T entidade);
}
