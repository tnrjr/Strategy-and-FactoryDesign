# Strategy-and-FactoryDesign

O Strategy Pattern é um padrão de projeto comportamental que tem como objetivo encapsular diferentes algoritmos ou comportamentos em classes distintas e permitir que eles sejam utilizados de forma intercambiável por um mesmo contexto.

Ao invés de colocar toda a lógica condicional (como if/else ou switch) dentro de uma única classe para tratar variações de comportamento, o Strategy separa cada variação em uma estratégia específica, que implementa uma interface comum. Dessa forma, o código que utiliza essas estratégias não precisa conhecer os detalhes de implementação de cada uma — ele apenas delega o trabalho para a estratégia adequada.

## Vantagens do uso do Strategy Pattern:

- Substituição dinâmica de comportamento: é possível alterar a lógica de execução em tempo de execução, sem alterar o código do objeto que a utiliza.

- Organização do código: cada comportamento fica isolado em sua própria classe, facilitando a leitura, testes e manutenção.

- Extensibilidade: novas estratégias podem ser adicionadas sem modificar as classes existentes, favorecendo o princípio do aberto para extensão e fechado para modificação.

Esse padrão é especialmente útil quando múltiplas variações de lógica precisam ser aplicadas a um mesmo processo, de maneira flexível e desacoplada.
