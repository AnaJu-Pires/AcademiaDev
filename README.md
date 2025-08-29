# Projeto AcademiaDev
### Nome: Ana Júlia Pires Oliveira   Prontuário:GU3042138
### Nome: Gabriel de Souza Costa     Prontuário:GU3046583
---

## Modelagem e Estrutura do Projeto:
### Classes Model:
- Course (com enum DifficultyLevel e boolean Status)
- User (classe abstrata)
- Admin (herda de User)
- Student (herda de User)
- SubscriptionPlan (classe Abstrata)
- BasicPan(herda de SubscriptionPlan)
- PremiumPlan(herda de SUbscriptionPlan)
- Enrollment (conecta Student e Course)
- SupportTicket
### Diagrama de Classes UML
(Docs/diagramaDeClasses.puml)

## Memoria e Initial Data
### Criar a Camada de Memória:
(*Repository* com Collections)
- Map<String, Course> (chave: title)
- Map<String, User> (chave: email)
- List<Enrollment>
- Queue<SupportTicket>
### Initial Data
(2 admins, 6 alunos com planos diferentes, 10 cursos, algumas matrículas e 3 tickets)

## Regras de Negócio e Lógica
### Matrículas:
- Um Student só pode se matricular se o curso estiver status(TRUE)
- Um Student só pode se matricular em um curso se não estiver já matriculado
- Um Student com BasicPlan só pode estar matriculado em, no máximo, 3 cursos simultaneamente
*OBS(o que fazer caso o curso vá pra false mas ele estava matriculado anteriormente)* 
- O progresso sempre começa em 0% e só pode ser atualizado para valores entre 0 e 100
### Fila de Suporte:
- Qualquer User pode criar um ticket
- Apenas Admin pode processar/atender um ticket
- O atendimento segue a ordem de chegada
### Lógica
#### Matriculas:
- Matricular um aluno (verificando plano, status do curso, se já está matriculado)
- Cancelar matrícula
- Atualizar progresso(manual)
*Exceções customizadas quando as regras forem violadas*
#### Fila de Suporte:
- Adicionar um ticket à fila (offer/add) - (Users)
- atender um ticket da fila (poll/remove) - (Admins)

## Views e suas Funcionalidade
- MainView(menu principal e lógica de login)
- StudentView(menu do estudante)
- AdminView(menu do administrador)
- UserView(cadastro de novo estudante)
### MainView:
- Gerencia as outras Views
#### UserView
- Pede nome, email e plano para cadastrar novo aluno
### AdminView:
- Criar novo curso (opcional) ✅
- Gerenciar Status de Cursos  ✅
- Gerenciar Planos de Alunos    
- Atender Tickets de Suporte
- Gerar Relatórios(submenu para acessar todas as análises)
*Obs(não fizemos assim, mas o que acha?)*
- Exportar Dados CSV
### StudentView:
- Matricular-se em Curso
- Consultar Minhas Matrículas (listar os cursos em que está ou foi matriculado, o progresso em cada um e seu status)
- Atualizar Progresso
- Cancelar Matrícula(status FALSE)
## Operações Gerais(Admin e Student):
- Catálogo de Cursos
- Abrir Ticket de Suporte
*Obs(vamos fazer cada um no seu controller ou criar um pra isso)*

## Relatórios e Análises
*Obs(submenu de admin)*
- Cursos por Nível(receber um difficultyLevel e retornar uma lista de cursos ordenada alfabeticamente)
- Instrutores Únicos(retornar uma lista de nomes de instrutores, sem repetição de cursos ACTIVE)
- Alunos por Plano(Map<SubscriptionPlan, List<Student>>)
- Calcular Média de Progresso Geral(todas as matriculas)
- Aluno Mais Engajado(identificar o aluno com o maior número de matrículas ativas e retornar Optional<Student>)

## Exportar CSV
- Deve funcionar para qualquer lista de objetos (List<Course>, List<Student>)
- O admin deve poder fornecer uma lista de nomes de campos (colunas) que deseja exportar
- A função deve usar Reflection para acessar os valores desses campos nos objetos

## Exceções Customizadas:
- EnrollmentException
- CourseNotFoundException

## Finalização
- Testar manualmente o sistema
- Documento explicativo de decisões(Docs/explicaDecisoes.md)
