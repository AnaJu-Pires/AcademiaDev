# Documento de Justificativa de Design - Protótipo AcademiaDev
### Projeto: Protótipo da Plataforma "AcademiaDev"
### Autores: Ana Júlia Pires Oliveira, Gabriel de Souza Costa
---

## 1. Arquitetura e Organização do Projeto
#### O projeto foi estruturado com base no padrão arquitetural MVC (Model-View-Controller). A organização do código buscou separar as responsabilidades em diferentes camadas, incluindo:
- DTO (Data Transfer Object): Objetos para transferir dados entre as camadas, especialmente entre o Controller e a View.
- Service: Camada responsável por conter as regras de negócio da aplicação.
- Repository: Camada de abstração para o acesso e a persistência dos dados.
- Exceptions: Implementação de classes de exceção customizadas para um tratamento de erros mais específico.
#### Pontos de Melhoria Identificados:
- Separação de Camadas: Embora o padrão MVC tenha sido a base, reconhecemos que a separação entre as camadas poderia ter sido mais rigorosa em alguns pontos.
- Controle de Versão: O Git foi utilizado para o controle do código-fonte. No entanto, a colaboração poderia ter sido otimizada com o uso mais sistemático de branches e práticas de desenvolvimento simultâneo.

## 2. Modelagem e Criação de Classes
#### As classes do sistema foram modeladas a partir das entidades principais especificadas nos requisitos do projeto. Durante esse processo, tomamos decisões importantes e identificamos pontos de aprendizado:
- Classe SubscriptionPlan: Houve uma dúvida inicial entre usar um enum ou classes distintas (BasicPlan, PremiumPlan). Optamos por uma classe abstrata SubscriptionPlan com implementações concretas. A justificativa é a extensibilidade: essa abordagem permite adicionar novos tipos de planos no futuro com mínimo impacto no código existente, enquanto um enum é mais adequado para um conjunto fixo e imutável de constantes.
- Atributo status como Boolean: Na modelagem inicial, o status de entidades (como "ativo" e "inativo") foi implementado com o tipo boolean. Percebemos tardiamente que esta foi uma limitação de design. Uma abordagem mais robusta e escalável seria o uso de um enum (ex: Status.ATIVO, Status.INATIVO). Isso evitaria uma refatoração complexa caso um terceiro estado, como Status.SUSPENSO, se tornasse necessário.
- Gerenciamento de Matrículas (Enrollment): Identificamos a omissão de um atributo de status na entidade de matrícula. Essa falha nos levou a implementar a funcionalidade de "cancelar matrícula" através da exclusão completa do registro. Reconhecemos que isso é um erro grave, pois leva à perda de dados históricos. A abordagem correta seria a inativação da matrícula, preservando o registro para futuras auditorias ou reativações.

## 3. Persistência de Dados
#### Para este protótipo, a persistência de dados foi simulada em memória através da camada de Repositório. Foram utilizadas as seguintes estruturas de dados:
- Map: Para armazenar e gerenciar a maioria das entidades, permitindo acesso rápido por meio de uma chave única.
- Queue (Fila): Especificamente para a entidade SupportTicket (Ticket de Suporte), garantindo que os tickets fossem processados na ordem de chegada (FIFO - First-In, First-Out).

## 4. Funcionalidades Especiais
#### Exportação de Dados em CSV: Foi implementada uma funcionalidade para exportar dados no formato CSV (Comma-Separated Values). A versão atual exibe os dados formatados diretamente no console do terminal, servindo como uma prova de conceito para uma futura implementação que gere um arquivo .csv para download.

## 5. Tratamento de Erros e Exceções
#### A gestão de erros foi um processo iterativo e de grande aprendizado. Devido ao curto prazo, as versões iniciais do projeto possuíam um tratamento de exceções mínimo. No entanto, com o avanço do desenvolvimento, evoluímos nossa abordagem:
- Implementamos exceções customizadas para representar erros de negócio específicos.
- As camadas de Controller e Service foram progressivamente refatoradas para capturar e tratar esses erros de forma mais estruturada.
- Essa melhoria tornou a camada de View mais resiliente a entradas inválidas e estados inesperados do sistema, melhorando a experiência do usuário.

## Conclusão
#### A construção do protótipo da "AcademiaDev" foi uma experiência de aprendizado fundamental. O projeto nos proporcionou uma compreensão prática e aprofundada dos princípios da Engenharia de Software(outra matéria), especialmente sobre o valor do desenvolvimento incremental, que se mostrou perfeitamente ajustado ao nosso processo de descoberta e resolução de problemas.
#### Embora reconheçamos as falhas técnicas e os pontos que necessitam de melhoria, o processo de projetar, desenvolver e refletir sobre o software foi extremamente gratificante. Essa experiência consolidou conceitos importantes de design, arquitetura de software e a importância de planejar para a escalabilidade futura.
