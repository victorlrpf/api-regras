package com.ruleengine.engine;

import com.ruleengine.domain.*;
import com.ruleengine.rules.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MotorDeRegrasTest {

    @Test
    public void deveProcessarRegrasCorretamente() {
        // Cenário
        Cliente c1 = new Cliente(1L, "Alice", 30, 5, new BigDecimal("12000"), StatusCliente.ATIVO, CategoriaCliente.BRONZE, RiscoCliente.BAIXO);
        Cliente c2 = new Cliente(2L, "Bob", 45, 2, new BigDecimal("6000"), StatusCliente.ATIVO, CategoriaCliente.BRONZE, RiscoCliente.BAIXO);
        Cliente c3 = new Cliente(3L, "Charlie", 25, 10, new BigDecimal("1000"), StatusCliente.ATIVO, CategoriaCliente.BRONZE, RiscoCliente.ALTO);

        List<Cliente> clientes = Arrays.asList(c1, c2, c3);

        List<Regra<Cliente>> regras = Arrays.asList(
            new RegraClassificacaoCliente(),
            new RegraBloqueioCliente(),
            new RegraBeneficioCliente()
        );

        MotorDeRegras<Cliente> motor = new MotorDeRegras<>(regras);

        // Ação
        List<Cliente> resultado = motor.processar(clientes);

        // Validações
        
        // Alice: > 10000 -> DIAMANTE, Cashback 5% de 12000 = 600
        Cliente alice = resultado.stream().filter(c -> c.getNome().equals("Alice")).findFirst().get();
        assertEquals(CategoriaCliente.DIAMANTE, alice.getCategoria());
        assertEquals(0, new BigDecimal("600.00").compareTo(alice.getCashback()));
        assertEquals(StatusCliente.ATIVO, alice.getStatus());

        // Bob: > 5000 -> OURO, Cashback 2% de 6000 = 120
        Cliente bob = resultado.stream().filter(c -> c.getNome().equals("Bob")).findFirst().get();
        assertEquals(CategoriaCliente.OURO, bob.getCategoria());
        assertEquals(0, new BigDecimal("120.00").compareTo(bob.getCashback()));

        // Charlie: Risco ALTO -> BLOQUEADO, Categoria BRONZE (gasto 1000)
        Cliente charlie = resultado.stream().filter(c -> c.getNome().equals("Charlie")).findFirst().get();
        assertEquals(StatusCliente.BLOQUEADO, charlie.getStatus());
        assertEquals(CategoriaCliente.BRONZE, charlie.getCategoria());
    }
}
