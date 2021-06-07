![image](/uploads/a731dea501986315250e1d9ab33fe996/image.png)

<h1 align="center">JOBNATION</h1>

## Proposta comercial

Desenvolver uma API que possibilita a busca de candidatos a partir de uma vaga, buscando uma contração veloz e assertiva. Dentre os critérios, deverão ser destaques a segurança e o desempenho da aplicação.

 Nossa proposta:
 
- Busca por localização: número de conduções para chegar ao local de trabalho ou coordenadas de latitude e longitude.

- Busca por diferentes critérios: rota(s) de pesquisa estão sendo desenhadas para propiciar liberdade de consulta ao BD. Nesse passo, a aplicação varrerá  currículos já cadastrados e identificará candidato(s)  mais adequados à vaga.

## Descrição do projeto integrador

Baseado no modelo de Aprendizado Por Projeto, nossa equipe trabalha para entregar uma solução operante para uma empresa parceira - Jet Soft - com o apoio do Docente desta instituição de ensino superior.


Navegue entre as seções
=================
<!--ts-->
   * [Proposta comercial](## Proposta comercial)
   * [Descrição do Projeto](#descricao-do-projeto)
   * [Navegue entre as seções](#navegue-entre-as-secoes)
   * [Status do Projeto](#status-do-projeto)
   * [Features](#features)
   * [Entregas](#entregas)
   * [Requisitos](#requisitos)
      * [Funcionais](#funcionais)
      * [Não Funcionais](#nao-funcionais)
   * [User Stories](#user-stories)
   * [Diagrama de Casos de Uso](#user-stories)
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

## Status do projeto Job Nation 

<h4 align="center"> 
	SPRINT 04 - 06/JUNHO/2021 = OK; 
	
</h4>

## Features

- [x] 1) DIAGRAMA-BASE JOBNATION

![01-APPLICATION-FULL-](/uploads/6127191a6d0335a0d320b70e0d4f58de/MicrosoftTeams-image__1_.png)


![image](/uploads/13a7f6370fecad7d70911e3c1b645a69/image.png)



<details><summary>DUMP.SQL [CRIA AS TABELAS]:</summary><img src="/uploads/63a54f1a92f9b07bbbdab48be138dfc1/1.png" name="1"></details>
  <details><summary>VALIDACÃO DE PREENCHIMENTO DE CAMPOS:</summary><img src="/uploads/12b31e00d9b78283fc5e315a29eba3d5/2.png" name="2"><img src="/uploads/1e507b31e0e997fa66f8e8f9c1c7cdc4/3.png" name="3"></details>
  <details><summary>CAMADA "SERVICE": (LÓGICA DE VALIDAÇÃO)</summary><img src="/uploads/2b49fa8629c6c80507680fc21642e7db/4.png" name="4"></details>
  <details><summary>ROTAS:</summary><img src="/uploads/a0f93b9663ba6210a1c11d2e15882bcb/5.png" name="5"></details>
  <details><summary>PROTEÇÃO DE DADOS SENSÍVEIS:</summary><img src="/uploads/8701ac30a50ff29aadd1dc2f5b112b4d/6.png" name="6"></details>
  <details><summary>ESTRUTURA DO CÓDIGO JAVA - BACKEND:</summary><img src="/uploads/9c9ff99ccc800eb5f36f44e215e39e6d/7.png" name="7"><img src="/uploads/2df96e095229bcd428f5bce621126eb1/8.png" name="8"></details>
  <details><summary>DATA TRANSFER OBJECT:</summary><img src="/uploads/a553e6dec0666f9a5c5f5242eef1cfc3/9.png" name="9"></details>
  <details><summary>CandidateToDtoConverter</summary><img src="/uploads/4295082a6717542a4e7281465f941348/10.png" name="10"></details>
  <details><summary>DtoToCandidateConverter</summary><img src="/uploads/05359c0ec858394f366dac6111615d34/11.png" name="11"></details>
  <details><summary>COM AS VAGAS CADASTRADAS + CANDIDATOS CADASTRADOS = CANDIDATAR-SE À VAGA (APPLY):</summary><img src="/uploads/e4d8e42660bfa2c8dc88f76411388c4c/12.png" name="12"></details>
  <details><summary>APÓS O APPLY, É POSSÍVEL CONCILIAR CANDIDATOS E VAGAS ATRAVES DO MÉTODO MATCH:</summary><img src="/uploads/e4909dc5812f040574277091e215e744/13.png" name="13"></details>
  <details><summary>DEPLOY EM PRODUÇÃO:</summary><img src="/uploads/6b94cdffba2c26439d5f03d50b14cea3/14.png" name="14"></details>
  <details><summary>NODEJS - MAPS:</summary><img src="/uploads/13fac9a7213d4256bb41f2c90a0d3604/15.png" name="15"></details>
  <details><summary>GOOGLE_MAPS_API_KEY:</summary><img src="/uploads/5408653e11c231fc7e84ba656b78145f/16.png" name="16"></details>
  <details><summary>API EXECUTADA:</summary><img src="/uploads/24cf645c4f783288196aa4d7f50e9cf3/17.png" name="17"></details>

- [x]  2) API JOBNATION

![02-JN-API](/uploads/86eb66876ffa54385ee99b9fae7258e8/MicrosoftTeams-image__3_.png)

- [x] 3) API JOBNATION - NODE-JS - BUSCA QUANTIDADE DE MEIOS DE TRANSPORTES NO GOOGLE MAPS.

![03-JN-API](/uploads/b8be1ac87ec9fdc6db5cdd8641094e2a/MicrosoftTeams-image__7_.png)

- [x] 4) API JOBNATION - MATCH DE CANDIDATOS (MOST SUITED FOR THE JOB)

![JN-API-MATCH](/uploads/2a223e4711dc9aa2117ff9ef40948f68/MATCH.mp4)

- [x] 5) JOBNATION's DATABASE

![05-JN-DB](/uploads/eb3c887e0cab35f4979a1512aa154453/MicrosoftTeams-image__4_.png)

- [x]  6) BANCO DE DADOS JOBNATION - PROCEDURE MÚLTIPLOS CRITÉRIOS COM CURSOR.

![06-JN-CURSOR-PROCEDURE-SEARCH](/uploads/f9712ad20ad02d0f7e22d4db1f597d18/CURSOR-PROCEDURE-SEARCH.mp4)

- [x] 7) BANCO DE DADOS JOBNATION - PEQUISA CANDIDATO POR LAT-LOG

![07-JN-DB - CANDIDATO POR LAT-LONG ](/uploads/800d1feede969d62c5cac5930dd8f67c/LAT-LONG-ORACLE.mp4)

- [x]  8) BANCO DE DADOS JOBNATION - ANÁLISE DE PERFORMANCE COM MILHARES DE REGISTROS FICTÍCIOS.

![08-JN-DB - PERFORMANCE-ANTES](/uploads/72c6849e98ebb4b2f464d8b9da78a0b3/Performance_antes_dos_5k.mp4)

![08-A-JN-DB - PERFORMANCE-DEPOIS](/uploads/fa91f82f7ea2dc3df12765133838d457/Performance_depois_dos_5k.mp4)


## Entregas

| Sprint | Data  | Vídeo                                       |
|--------|-------|---------------------------------------------|
| 1      | 28/03 |----(no video for this sprint)---------------|
| 2      | 18/04 |--![APRESENTACAO-SPRINT-02](/uploads/473105bcdf168d7dbe708defdb127857/APRESENTACAO-SPRINT-02.mp4)--|
| 3      | 16/05 |----[APRESENTACAO-SPRINT-03-18/05 (COMING SOON)]-----|
| 4      | 05/06 |---------------------------------------------|

## Requisitos

#### Funcionais

| Requisitos Funcionais                                                  | Código | Prioridade | Sprint |
|------------------------------------------------------------------------|--------|------------|--------|
| Inicializa uma API e se conecta ao/cria BD                | RF01   | 1          | 1      |
| Executa Requisição de Terceiro | RF02   | 1          | 2      |
| Busca candidatos x No de conduções do para chegar ao trabalho                                 | RF03   | 1          | 2      |
| MATCH Candidato-Vaga                                                 | RF04  | 1          | 3     |
| Filtra resultado da Busca | RF05  | 1          | 3      |
| Busca x critérios de uma vaga                            | RF06   | 1          | 4      |



#### Não funcionais

| Requisitos Não Funcionais                            | Código | 
|------------------------------------------------------|--------|
| Regras de segurança da informação           | RNF01  |
| Integridade (BD relacional)                   | RNF02  |
| Flexibilidade quanto aos critérios                                    | RNF03  |
| Regras de performance   | RNF04  |
| Documentação  | RNF05 |


INSERIR TESTES NO README;


## User Stories

| Quem? | O que? | Por quê? |
|-------|--------|----------|
| API de Terceiros | Fornece critérios de busca | Quer  processo de recrutamento em massa
| Jet Soft | Disponibiliza JOBNATION aos seus clientes (terceiros) | Velocidade |
| Tecno Code | Desenvolve a JOBNATION | Para aplicar na prática os conhecimentos de programação adquiridos, além de adquirir experiência profissional em desenvolvimento de projetos |


## Diagrama de Casos de Uso

![CASOS DE USO](/uploads/18cb3c6e95bcaf600b618b6e2199230b/MicrosoftTeams-image__8_.png)


## Banco de dados
## Diagrama Entidade-Relacionamento

![DER-SPRINT-03-](/uploads/19fc541596b0e39ab528b13fbf1c2be7/MicrosoftTeams-image__5_.png)

## Diagrama Lógico
![LOGICAL-SPRINT-03-](/uploads/ea7c9eade4119499aa05097656d7389c/MicrosoftTeams-image__6_.png)


## Propostas de inovação

Criamos o 1o BD com benchmarking no LINKEDIN, subsequentemente alterando o protagonismo para a entidade vaga (VACANCY).

Então, estudamos quais ferramentas servirão aos requisitos (não) funcionais: 

- No BACK-END - Mais de uma linguagem de programação;

- No BD - PROCEDURES com CURSORES e FUNCTIONS para dar flexibilidade às QUERIES;


## Backlog do Projeto
Atividades de cada sprint, com prioridade.

#### Sprint 00
- reunião de kick-off  com JETSOFT
- Criação de repositório
- Definição de cargos (SM e PO)
- Definição de nome para a equipe
- Brainstorm para discussão de primeiras ideias
- Apresentação de proposta de aplicação;

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

- BD - PROCEDURE  de devolução de listas por Múltiplos  Critérios com CURSOR;

- BD - População do BD com dados fictícios para teste de PERFORMANCE;

- Back-end - 2a API-JN para buscar quantidade de meios de transporte necessárias ao candidato chegar ao local de trabalho;

- Back-end - MATCH Candidato-Vaga;

#### Sprint 04 - 05 de junho de 2021.

- Back-end - Criação pesquisa por Múltiplos Critérios;

- Busca por qualquer critério;

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

#### Fabio Odaguiri LL.M. (Scrum master e database developer)
* [Git Lab](https://gitlab.com/ODAGAMMXIX)
* [Linkedin]()
* RA: 1460281923008

#### Felipe Santos Carvalho (Product owner e database developer)
* [Git Lab](https://gitlab.com/felipefsc)
* [Linkedin](https://www.linkedin.com/in/felipe-santos-carvalho-454060187/)
* RA: 1460281923011

#### Gabriela Momilli (Java back-end developer)
* [Git Lab](https://gitlab.com/gabsmomilli)
* [Linkedin](https://www.linkedin.com/in/gabriela-momilli-105b1a184/)
* RA: 1460281923058

#### Rafael Estevam de Oliveira (Oracle dabase developer)
* [Git Lab](https://gitlab.com/rafaelEstevam)
* [Linkedin](https://www.linkedin.com/in/rafael-estevam-de-oliveira/)
* RA: 1460281823040

#### Wilson Amore Vieira Filho (Java back-end developer)
* [Git Lab](https://gitlab.com/ZVIEWIL)
* [Linkedin](www.linkedin.com/in/wilson-amore-vieira-filho-7a4420183)
* RA: 1460281923041

## Como Instalar a aplicação: Vide Pasta "DEPLOYMENT-FIND-STEPS-HERE" acima)

## 💻 Tecnologias

As ferramentas utilizadas na construção deste projeto:

- Oracle 11g (Sql developer)
- Java (IntelliJ / Eclipse))
- Node-JS;
- React (Insomnia/POSTMAN);
- Git;
- OBS Studio / Kdenlive;
- Html
- Css
- Javascript
