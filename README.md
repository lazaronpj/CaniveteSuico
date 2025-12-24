
# CaniveteSuico

## Descrição do Projeto

Aplicação desktop desenvolvida em Java com interface gráfica usando Swing (projeto educacional).
O projeto reúne diversas ferramentas de cálculo em uma única aplicação, com validação de entrada e tratamento de erros, organizadas em telas separadas.
O objetivo é oferecer soluções rápidas para cálculos matemáticos, conversões e operações financeiras de forma simples, intuitiva e didática.

---

## Funcionalidades

* Calculadora com múltiplas operações matemáticas
* Conversor de temperatura (Celsius ↔ Fahrenheit)
* Assistente financeiro com diversos cálculos
* Regra de três (diretamente e inversamente proporcional)
* Resolução de equações do primeiro e segundo grau
* Estrutura inicial para inequações (planejado, não implementado completamente)

---

## Telas e Comportamento do Sistema

### Tela Principal

Ao iniciar a aplicação, o usuário é apresentado a um menu com botões para acessar cada ferramenta:

* Calculadora
* Conversor de temperatura
* Assistente financeiro
* Regra de três
* Equações e inequações

### Calculadora

* O usuário escolhe uma operação a partir de um menu suspenso.
* Dois campos aceitam apenas números (validação simples com regex).
* Botões disponíveis: **Calcular** e **Limpar campos**.
* Operações disponíveis incluem adição, subtração, multiplicação, divisão, resto da divisão, porcentagem, potenciação, radiciação, exponencial e logarítmico.
* Em operações que exigem apenas um valor, o segundo campo é bloqueado.
* Resultados são exibidos em um pop-up e, ao fechar, os campos são limpos.

### Conversor de Temperatura

* Permite converter entre graus Celsius e Fahrenheit.
* Interface com um campo numérico (com validação de entrada) e os botões **Converter** e **Limpar campos**.
* O resultado é exibido em um pop-up.

### Assistente Financeiro

* Oferece cálculos como valor presente e futuro (simples e composto), juros simples e composto, taxa e tempo.
* Os campos de entrada aceitam apenas números e ponto decimal.
* Campos são bloqueados dinamicamente conforme o tipo de cálculo selecionado.
* O usuário deve selecionar uma operação antes de calcular.
* Mensagens de erro são exibidas em caso de entrada inválida ou campos faltantes.

### Regra de Três

* Permite cálculos de regra de três diretamente e inversamente proporcional.
* Três campos numéricos com validação.
* Mensagens de erro são exibidas se entradas estiverem vazias ou se nenhuma opção for selecionada.

### Equações e Inequações

* O sistema permite resolver equações do primeiro e segundo grau.
* Inequações estão planejadas e presentes no menu, mas o cálculo completo ainda não está implementado.
* Entrada numérica com validação e tratamento de erros.

---

## Testes Manuais Realizados

### Calculadora

* **Resto da divisão:** 100 e 10 → Resultado: 0,0000
* **Potenciação:** 8 e 3 → Resultado: 512,0000
* **Radiciação:** 81 → Resultado: 9,0000
* **Exponenciação:** 3 → Resultado: 20,0855
* **Logaritmização:** 2 → Resultado: 0,6931

### Conversor de Temperatura

* 55 °F para °C → Resultado: 13
* 18 °C para °F → Resultado: 64

### Assistente Financeiro

* Valor presente composto: futuro = 5000, taxa = 0.05, tempo = 48 → Resultado: 480,7105
* Juros simples: presente = 900, taxa = 0.11, tempo = 12 → Resultado: 1188,0000
* Tempo em juros simples: presente = 60000, futuro = 150000, taxa = 0.006 → Resultado: 250 meses (20 anos e 8 meses)

### Regra de Três

* Diretamente proporcional: A = 4, B = 12, C = 10 → Resultado: 30
* Inversamente proporcional: A = 80, B = 3, C = 120 → Resultado: 2

### Equações

* Equação do primeiro grau: A = -2, B = 1 → Resultado: 0,5000
* Equação do segundo grau: A = 2, B = 4, C = 1 → Resultado: X1 = -0,2247
  *(Os cálculos de inequações estão planejados mas ainda não implementados.)*

---

## Tecnologias Utilizadas

* Java
* Java Swing para interface gráfica
* Validação de entrada com expressões regulares simples (`[^0-9]`)
* IDE recomendada: Eclipse ou IntelliJ

---

## Como Executar o Projeto

1. Escolha um diretório para clonar o repositório.
2. Abra o terminal nessa pasta.
3. Clone com:

   ```
   git clone https://github.com/lazaronpj/CaniveteSuico.git
   ```
4. Abra o projeto em sua IDE Java preferida.
5. Execute a classe principal que inicia a interface gráfica.
6. A aplicação será aberta e você poderá utilizar as ferramentas.

---

## Estrutura do Projeto

```text
src/
  controller/
    LogicaCalculadora.java
    LogicaConversor.java
    LogicaEquacaolnequacao.java
    LogicaFinanceira.java
    LogicaRegraDeTres.java
  view/
    Calculadora.java
    Conversor.java
    Equacaolnequacao.java
    Financeiro.java
    RegraDeTres.java
    TelaPrincipal.java
```

---

## Aprendizados

Durante o desenvolvimento deste projeto, foram aprendidos e praticados:

* Criação de interfaces gráficas com Java Swing
* Validação de entrada do usuário com expressões regulares simples
* Tratamento de erros e exibição de mensagens ao usuário
* Organização do projeto em pacotes (view e controller)
* Implementação de lógica de negócio em classes dedicadas

---

## Estado Atual do Projeto

* Projeto funcional com múltiplos módulos implementados
* Cálculos de inequações planejados, mas não totalmente implementados
* Sem testes automatizados no momento
* Validações funcionais básicas aplicadas

---

## Possíveis Melhorias Futuras

* Implementar cálculos de inequações completos
* Adicionar testes automatizados com JUnit
* Refatorar validações para um módulo central
* Melhorar a interface gráfica e usabilidade

---

## Observação Final

Este projeto foi documentado de forma honesta, com foco em clareza técnica e aprendizado contínuo, sem prometer funcionalidades que ainda não foram implementadas. Com foco em evolução contínua.
