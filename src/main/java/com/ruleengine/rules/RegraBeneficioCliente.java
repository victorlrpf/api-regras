package com.ruleengine.rules;

import com.ruleengine.domain.CategoriaCliente;
import com.ruleengine.domain.Cliente;
import java.math.BigDecimal;

public class RegraBeneficioCliente implements Regra<Cliente> {

    @Override
    public boolean aplica(Cliente cliente) {
        return cliente.getCategoria() == CategoriaCliente.OURO || 
               cliente.getCategoria() == CategoriaCliente.DIAMANTE;
    }

    @Override
    public Cliente executar(Cliente cliente) {
        BigDecimal gasto = cliente.getValorTotalGasto();
        BigDecimal percentual = (cliente.getCategoria() == CategoriaCliente.DIAMANTE) ? 
                                 new BigDecimal("0.05") : new BigDecimal("0.02");
        
        cliente.setCashback(gasto.multiply(percentual));
        return cliente;
    }
}
