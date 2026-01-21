# 📐 Motor de Regras (Rule Engine) em Java

Este projeto implementa um **Motor de Regras** genérico, extensível e orientado a domínio. O objetivo principal é permitir a aplicação de regras de negócio dinâmicas sobre coleções de dados de forma elegante, utilizando a **Java Stream API** e princípios de **Programação Funcional**.

## 🧠 O Problema

Em sistemas corporativos, as regras de negócio mudam constantemente. Implementações baseadas em longas cadeias de `if/else` ou `switch/case` tornam o código rígido, difícil de testar e propenso a erros. Este motor de regras resolve esse problema ao:

- **Desacoplar** a lógica de negócio do fluxo de execução.
- Permitir a criação de regras **isoladas e testáveis**.
- Facilitar a **extensibilidade** sem modificar o código existente (Open/Closed Principle).

## 🛠 Tecnologias Utilizadas

- **Java 17**: Utilizando recursos modernos como Records (opcional), Stream API e Lambdas.
- **Maven**: Gerenciamento de dependências e build.
- **JUnit 5**: Testes unitários para garantir a integridade das regras.

## 🏗 Arquitetura do Projeto

O projeto está estruturado da seguinte forma:

| Pacote | Responsabilidade |
| :--- | :--- |
| `domain` | Entidades de negócio (ex: `Cliente`) e Enums de estado. |
| `rules` | Interface base `Regra<T>` e suas implementações concretas. |
| `engine` | O `MotorDeRegras<T>`, responsável por orquestrar a execução. |
| `test` | Suíte de testes para validação dos cenários de negócio. |

## ⚙️ Como Funciona

### 1. A Interface Regra
Cada regra implementa a interface `Regra<T>`, que define dois métodos:
- `aplica(T entidade)`: Verifica se a regra deve ser executada para aquela entidade.
- `executar(T entidade)`: Aplica a transformação ou lógica de negócio.

### 2. O Motor de Execução
O `MotorDeRegras` utiliza o método `reduce` da Stream API para encadear as regras de forma funcional, garantindo que o estado seja processado de maneira sequencial e limpa.

## 🚀 Como Executar

### Pré-requisitos
- JDK 17 ou superior.
- Apache Maven instalado.

### Comandos Principais

```bash
# Clonar o repositório (ou extrair o zip)
cd rule-engine

# Compilar o projeto
mvn clean compile

# Executar os testes unitários
mvn test
```

## 🧪 Exemplo de Regras Implementadas

1. **Classificação**: Define se o cliente é `BRONZE`, `PRATA`, `OURO` ou `DIAMANTE` com base no gasto total.
2. **Bloqueio**: Bloqueia automaticamente clientes com perfil de risco `ALTO`.
3. **Benefício**: Calcula *cashback* progressivo para clientes de categorias superiores.

---
Desenvolvido com foco em **Clean Code** e **S.O.L.I.D**.
