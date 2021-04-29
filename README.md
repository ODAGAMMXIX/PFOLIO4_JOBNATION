![image](/uploads/a731dea501986315250e1d9ab33fe996/image.png)

<h1 align="center">JOBNATION</h1>

## Proposta comercial

A aplicação consiste numa  interface de recepção de currículos, com banco de dados,  que permitirá a busca de candidatos por vaga a partir de filtros configuráveis.

Deverão ser destaques a segurança e desempenho da aplicação.

 Nossa proposta de funcionamento para esses recursos serão detalhados logo abaixo:
 
- Busca por localização: funcionará utilizando as coordenadas de latitude e longitude.

- Busca por diferentes critérios: rotas de pesquisa estão sendo desenhadas para propiciar liberdade ao agende de consulta ao BD. Então, a aplicação fará uma varredura nos currículos já cadastrados e identificará os candidatos que mais se adequam aos critérios informados.

## Descrição do projeto integrador

Baseado no modelo de Aprendizado Por Projeto, nossa equipe trabalha para entregar uma solução operante para uma empresa parceira - Jet Soft - com o apoio do Docente desta instituição de ensino superior.


Navegue entre as seções
=================
<!--ts-->
   * [Proposta comercial](#proposta-comercial)
   * [Descrição do Projeto](#descricao-do-projeto)
   * [Navegue entre as seções](#navegue-entre-as-secoes)
   * [Status do Projeto](#status-do-projeto)
   * [Features](#features)
   * [Entregas](#entregas)
   * [Requisitos](#requisitos)
      * [Funcionais](#funcionais)
      * [Não Funcionais](#nao-funcionais)
   * [User Stories](#user-stories)
   * [Banco de dados: Modelo relacional](#banco-de-dados)
   * [Banco de dados: Diagrama Lógico](#banco-de-dados)
      * [Propostas de inovação](#proposta-de-inovacao)
   * [Backlog do projeto](#backlog-do-projeto)
      * [Sprint 00](#sprint-00)
      * [Sprint 01](#sprint-01)
      * [Sprint 02](#sprint-02)
      * [Sprint 03](#sprint-03)
      * [Sprint 04](#sprint-04)
   * [Equipe](#equipe)
   * [Como Instalar o Projeto na Máquina](#como-instalar-o-projeto-na-maquina)
   * [Tecnologias](#tecnologias)
<!--te-->

## Status do projeto

<h4 align="center"> 
	Job Nation  SPRINT 02 - 18/ABR/2021 = OK; 
	
</h4>

## Features

- [x] Diagrama-Base da JOBNATION
![01-APPLICATION-FULL-](/uploads/089115b4466546461e51ac523f68da27/01-APPLICATION-FULL-.png)

- [x]  API JOBNATION
![02-JN-API](/uploads/7d566f3198f060ba024b3ef4a03fa626/02-JN-API.png)


- [x] JOBNATION's DATABASE

![03-JN-DB](/uploads/e22f22f0c02b924bf06d0aef1a8c14ff/03-JN-DB.png)

- [x]  BANCO DE DADOS JOBNATION - PEQUISA CANDIDATO POR DISTÂNCIA

![07-LAT-LONG-PROCEDURE-W-QUERY](/uploads/033a931cb97772d18addc21209037ac3/07-LAT-LONG-PROCEDURE-W-QUERY.mp4)

- [x] APLICAÇÃO JOBNATION FUCIONANDO

![06-SPRINT-01-BK-END](/uploads/226f36a4bda28a6333393d012525ad17/06-SPRINT-01-BK-END.mp4)

- [x]  BONUS-ENTENDENDO A API (Visão de front-end)

![BONUS-FEND-EMULATION](/uploads/65e04f805ea0972f0f8161f50f0d0395/BONUS-FEND-EMULATION.mp4)

## Entregas

| Sprint | Data  | Vídeo                                       |
|--------|-------|---------------------------------------------|
| 1      | 28/03 |----(no video for this sprint)---------------|
| 2      | 18/04 |--![APRESENTACAO-SPRINT-02](/uploads/473105bcdf168d7dbe708defdb127857/APRESENTACAO-SPRINT-02.mp4)--|
| 3      | 16/05 |---------------------------------------------|
| 4      | 05/06 |---------------------------------------------|

## Requisitos

#### Funcionais

| Requisitos Funcionais                                                  | Código | Prioridade | Sprint |
|------------------------------------------------------------------------|--------|------------|--------|
| Inicializa uma API e se conecta ao/cria BD                | RF01   | 1          | 1      |
| Executa Requisição de Terceiro | RF02   | 1          | 2      |
| Busca candidatos mais pŕoximos de um endereço                                | RF03   | 1          | 2      |
| Busca candidatos a partir de uma vaga                                                 | RF04  | 1          | 3     |
| Filtra resultado da Busca | RF05  | 1          | 3      |
| Importa BD do Cliente                            | RF06   | 1          | 4      |



#### Não funcionais

| Requisitos Não Funcionais                            | Código | 
|------------------------------------------------------|--------|
| Regras de segurança da informação           | RNF01  |
| Integridade (BD relacional)                   | RNF02  |
| Flexibilidade quanto aos critérios                                    | RNF03  |
| Regras de performance   | RNF04  |
| Documentação  | RNF05 |

## User Stories

| Quem? | O que? | Por que? |
|-------|--------|----------|
| API de Terceiros | Fornece critérios de busca | Quer  processo de recrutamento em massa
| Jet Soft | Disponibiliza JOBNATION aos seus clientes (terceiros) | Velocidade |
| Tecno Code | Desenvolve a JOBNATION | Para aplicar na prática os conhecimentos de programação adquiridos, além de adquirir experiência profissional em desenvolvimento de projetos |

## Banco de dados
##DIAGRAMA ENTIDADE-RELACIONAMENTO
![04-DER-SPRINT-02-](/uploads/43ab9dae9c03891562a4f95a384b60f7/04-DER-SPRINT-02-.png)

## DIAGRAMA LÓGICO
![05-LOGICAL-SPRINT-02-](/uploads/80221f57c968b73183896074cca9503a/05-LOGICAL-SPRINT-02-.png)


## Propostas de inovação

Criamos o 1o BD com benchmarking no LINKEDIN, subsequentemente alterando o protagonismo para a entidade vaga (VACANCY).

Estudamos ainda quais ferramentas servirão aos requisitos não funcionais de Flexibilidade: 

- No código - Rotas fixas em REST para Swagger ou GRAPHiQL;

- No BD - PROCEDURES ou algum tipo de inteligência;


## Backlog do Projeto
Atividades de cada sprint, com prioridade.

#### Sprint 00
- reunião de kickoff  com JETSOFT
- Criação de repositório
- Definição de cargos (SM e PO)
- Definição de nome para a equipe
- Brainstorm para discussão de primeiras ideias
- Apresntação de proposta de aplicação;

#### Sprint 01
- Criação do README.MD com informações sobre o projeto e instruções para execução da aplicação;

- Criação de modelo entidade relacionamento para definir como os dados serão estruturados;

- Início do Desenvolvimento do Core da Aplicação: Controller, Model (Arquitetura REST) e Banco de Dados (Oracle)

- Associação das informações do banco de dados a um diagrama de classes;

- BONUS; FRONT-END - Construção do design da plataforma;

- BONUS: FRONT-END - Desenvolvimento do recurso de busca por proximidade do local da vaga


#### Sprint 02

- Core da Aplicação Funcionando: Controller, Model (Arquitetura REST) e Banco de Dados (Oracle);

- CRUD: 1a Rota de submissão de requisições:  Benefícios oferecidos pela vaga (via POSTMAN);

- Criação ou atualização automática das tabelas (Hibernate- MODEL);

- Segurança no Código: Sigilo de dados sensíveis/prescindíveis (payloads, DTO,Converter);
	
- Validação de Dados: Campos que NÃO  podem estar vazios;

- Testes - Início de implementação de teste unitário de métodos;

- PROCEDURE PL/SQL: Consulta candidatos por distância (LAT,LONG);

#### Sprint 03 - 16 de maio de 2021.

- Criação de Multiplas Rotas x Múltiplos Critérios;

- Novos testes unitários de métodos;

- Novas procedures de devolução de listas por outros critérios;

- População do BD com dados fictícios para teste de performance;

#### Sprint 04 - 05 de junho de 2021.

- Busca por qualquer critério;

- Importação do BD do cliente;

- Adaptação do Código para novas classes e tabelas;

- Adaptação do BD para novas tabelas;

#### Apresentação Final - 11 de junho de 2021.

- Bugs e Documentação;

#### Feira de Soluções - 18 de junho de 2021.


## Equipe:

#### Caroline Paz de Sousa (Java back-end developer)
* [Git Lab](https://gitlab.com/CarolPaz)
* [Linkedin](https://www.linkedin.com/in/caroline-sousa-53a27972/)
* RA: 1460281923049

#### Fabio Odaguiri LL.M.(Scrum master e database developer)
* [Git Lab](https://gitlab.com/ODAGAMMXIX)
* [Linkedin]()
* RA: 1460281923008

#### Felipe Santos Carvalho (Product owner e database developer)
* [Git Lab](https://gitlab.com/felipefsc)
* [Linkedin](https://www.linkedin.com/in/felipe-santos-carvalho-454060187/)
* RA: 1460281923011

#### Gabriela Momilli ((Java back-end developer)
* [Git Lab](https://gitlab.com/gabsmomilli)
* [Linkedin](https://www.linkedin.com/in/gabriela-momilli-105b1a184/)
* RA: 1460281923058

#### Nathan Augusto Bugni Naressi (Java back-end developer)
* [Git Lab](https://gitlab.com/nathanaugusto10)
* [Linkedin](https://www.linkedin.com/in/nathan-naressi-b529081b2)
* RA: 1460281923027

#### Rafael Estevam de Oliveira (Oracle tabase developer)
* [Git Lab](https://gitlab.com/rafaelEstevam)
* [Linkedin](https://www.linkedin.com/in/rafael-estevam-de-oliveira/)
* RA: 1460281823040

#### Wilson Amore Vieira Filho ((Java back-end developer)
* [Git Lab](https://gitlab.com/ZVIEWIL)
* [Linkedin](www.linkedin.com/in/wilson-amore-vieira-filho-7a4420183)
* RA: 1460281923041

## Como Instalar o projeto na máquina:

- Selecione uma pasta de sua preferência, através do comando "cd Pasta Escolhida"
- Abra o terminal clicando dentro de uma pasta com o botão direito e selecione a opção git bash here
- Utilize a função git clone https://gitlab.com/gabsmomilli/tecnocode para instalar os arquivos no seu computador
- Abra o SQL DEVELOPER (com Oracle 11g instalado);
- Execute o SCRIPT:

|-------------------------|
|CREATE TABLESPACE  tecnocode|
|DATAFILE  'C:\BD\tecnocode.dbf' SIZE 1M|
|AUTOEXTEND ON;|
|------------------
|----CRIA USUÁRIO --|
|------------------
|CREATE USER tecnocode|
|IDENTIFIED BY tecnocode|
|DEFAULT TABLESPACE tecnocode|
|TEMPORARY TABLESPACE TEMP|
|QUOTA UNLIMITED ON tecnocode;|
|-----------------
|----PRIVILÉGIOS --|
|-----------------
|GRANT DBA TO tecnocode WITH ADMIN OPTION;|

- Na sua IDE, importe o projeto Tecnocode;
- Abra o arquivo "application.properties" e altere a seguinte linha "spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe";

- Abra o INSOMNIA e escreva uma das rotas criadas nas clases "controller", com os dados ali exigidos e envie a requisição;


## 💻 Tecnologias

As ferramentasutilizadas na construção deste projeto:

- Oracle 11g (Sql developer)
- Java (IntelliJ / Eclipse))
- React (Insomnia/POSTMAN);
- Git;
- OBS Studio / Kdenlive;
- Html
- Css
- Javascript

