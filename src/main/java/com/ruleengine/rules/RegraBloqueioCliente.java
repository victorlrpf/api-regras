package com.ruleengine.rules;

import com.ruleengine.domain.Cliente;
import com.ruleengine.domain.RiscoCliente;
import com.ruleengine.domain.StatusCliente;

public class RegraBloqueioCliente implements Regra<Cliente> {

    @Override
    public boolean aplica(Cliente cliente) {
        return cliente.getRisco() == RiscoCliente.ALTO;
    }

    @Override
    public Cliente executar(Cliente cliente) {
        cliente.setStatus(StatusCliente.BLOQUEADO);
        return cliente;
    }
}
