package com.ruleengine.rules;

import com.ruleengine.domain.CategoriaCliente;
import com.ruleengine.domain.Cliente;
import java.math.BigDecimal;

public class RegraClassificacaoCliente implements Regra<Cliente> {

    @Override
    public boolean aplica(Cliente cliente) {
        return cliente.getValorTotalGasto() != null;
    }

    @Override
    public Cliente executar(Cliente cliente) {
        BigDecimal gasto = cliente.getValorTotalGasto();
        
        if (gasto.compareTo(new BigDecimal("10000")) > 0) {
            cliente.setCategoria(CategoriaCliente.DIAMANTE);
        } else if (gasto.compareTo(new BigDecimal("5000")) > 0) {
            cliente.setCategoria(CategoriaCliente.OURO);
        } else if (gasto.compareTo(new BigDecimal("2000")) > 0) {
            cliente.setCategoria(CategoriaCliente.PRATA);
        } else {
            cliente.setCategoria(CategoriaCliente.BRONZE);
        }
        
        return cliente;
    }
}
