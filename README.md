# Transpilador de Java para Dart com Java CC

## Resumo

O projeto visa criar um transpilador que converte código da linguagem de programação Java para Dart, utilizando a biblioteca JavaCC. A abordagem adotada é algorítmica bottom-up, começando pela compreensão e definição das declarações em Java.

### Metodologia

1. **Declarações**: O projeto define uma declaração em Java como uma estrutura que inclui o tipo da variável, o nome da variável, um sinal de igual, um valor e um ponto e vírgula.

   - Exemplo: `int x = 5;`

2. **Expressões**: Introduz o conceito de "expression" para qualquer entidade que possa retornar um valor para uma variável. Vários tipos de expressões foram definidos:

   - **Boolean Expression**: Trabalha com valores booleanos.
   - **Arithmetic Expression**: Envolve operações com inteiros, como `3 + 2` ou `3`.
   - **String Expression**: Lida com valores de strings.
   - **Function Expression**: Representa o valor retornado por uma função.

3. **Statements**: Define as partes essenciais de um código como "statements", que podem incluir declarações, condições, loops, atribuições a variáveis já existentes e comandos de saída de dados (print statements).

4. **Bloco de Código (Code Block)**: Um bloco de código é uma construção abstrata que agrupa múltiplos statements, permitindo a criação de algoritmos complexos.
   - Um `code block` pode conter qualquer combinação de statements, como loops dentro de condições, ou loops aninhados, ou simplesmente um programa que imprime uma variável.

### Construção Algorítmica

A estrutura do projeto permite a criação e expansão de novos conceitos e expressões, tornando o transpilador flexível e extensível. A partir dos fundamentos das declarações e expressões, foram desenvolvidos blocos de código que encapsulam a lógica de programação, facilitando a transpilação de Java para Dart de maneira eficiente.

## Análise de Complexidade Assintótica

A função com a maior magnitude de complexidade no projeto é o conceito de `codeBlock`. Esse conceito encapsula um conjunto de `statements`, que pode incluir `condition statements` e `loop statements`. Cada um desses statements pode, por sua vez, conter outros `codeBlocks`, criando uma estrutura recursiva.

### Complexidade do `codeBlock`

- **Complexidade Básica**: O `codeBlock` possui uma complexidade linear \(O(n)\), onde `n` é o número de statements.
- **Complexidade Recursiva**: Quando analisamos `condition` e `loop statements`, a complexidade aumenta devido à potencial recursão. Um `condition statement` contém um `codeBlock`, que pode conter um outro `condition statement`, causando a recursividade, aumentando a profundidade de análise e, consequentemente, a complexidade.

### Sugestões de Otimização

- **Análise Estática**: Adotar análise estática para simplificar e reduzir a necessidade de múltiplas análises recursivas dentro de `codeBlocks`.
