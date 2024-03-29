## PORTFOLIO ACADÊMICO - PROJETOS INTEGRADORES:

[SEMESTRE-01-2019.2 - *Python-Sqlite3 Web Scrapper - Monitor de Segurança Pública*](https://github.com/ODAGAMMXIX/PFOLIO1_DANZO) 

[SEMESTRE-02-2020.1 - *Java-MySQL Stand Alone App - Gráfico de GANTT para Gestores*](https://github.com/ODAGAMMXIX/PFOLIO2_GANTT)

[SEMESTRE-03-2020.2 - *Java-Oracle - Cadastro Positivo e Desbancarizados*](https://github.com/ODAGAMMXIX/PFOLIO3_VALCODE)

## [SEMESTRE-04-2021.1 - *Java-Oracle API - Recrutamento por Geolocalização et al.*](https://github.com/ODAGAMMXIX/PFOLIO4_JOBNATION)

[SEMESTRE-05-2021.2 - *Java-Pentaho-My(SQL)Server-MongoDB-Engajamento Estudantil*](https://github.com/ODAGAMMXIX/PFOLIO5_EDUCALYTICS)

[SEMESTRE-06-2022.1 - *Python-MongoDB-LGPD Opt-in, Opt-out*](https://github.com/ODAGAMMXIX/PFOLIO6_OPTIN_OUT)

***

<h1 align="center">[Java-Oracle API - Recrutamento por Geolocalização e Outros Critérios.]</h1>


<h1 align="center">JOBNATION</h1>


# I - RESUMO DO PROJETO 

**Desafio**: desenvolver *Application Programming Interface* para ***recrutamento em massa***, que possibilite a busca de candidatos a partir de critérios de uma determinada vaga, possibilitando contração veloz e assertiva, com segurança e desempenho.

 Nossa proposta:
 
- Busca por geolocalização ![Google](https://img.shields.io/badge/google-4285F4?style=for-the-badge&logo=google&logoColor=white) , para saber o número de conduções do itinerário.

- Busca por função no ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white), por diferentes critérios: a aplicação varrerá  currículos já cadastrados e identificará candidato(s)  mais adequados à vaga.

<h3 align="center">Arquitetura da Aplicação</h3>
<img src="https://user-images.githubusercontent.com/54047352/168492368-15f3ef36-b057-4b68-9026-8ebdbd1a7994.png">

<details open><summary> As 08 camadas.</summary>
<img src="https://user-images.githubusercontent.com/54047352/168496089-a6b1081c-4416-4144-8933-970728bfc6ac.png">
<p align="center"> 
 </details open>
 
<details open><summary> Destaque: 02 CONTROLLERS, 02 Linguagens.</summary>
<p align="center"> 
 <img src="https://user-images.githubusercontent.com/54047352/168492370-04046bc7-4c06-424e-b8b7-e47418df0374.png">
 <h5 align="center">(!!!---DOIS CONTROLLERS---!!!)</h5>
 <p align="center"> 
 </details open>
 
 <details open><summary> 1) CONTROLLER 01​ NODEJS ​& ​ GOOGLE MAPS API.</summary>
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168495627-6af7c575-284c-4139-993a-0e79d0b51729.png">
<h4 align="center">(Com origem,destino = número de conduções, itinerário completo, tempo etc.)</h4>
 <img src="https://user-images.githubusercontent.com/54047352/168495647-69e687a7-ae71-44c6-b667-db7c130d0d3a.png">
 <h6 align="center">(https://www.youtube.com/watch?v=61kPu1F-87I)</h6>
<h6 align="center">(assista ao vídeo)</h6>
 </p>
</details open> 


<details open><summary> 2) CONTROLLER 02 - APPLY & MATCH​ - BACK-END JAVA​.</summary>
<p align="center">
 <img src="https://user-images.githubusercontent.com/54047352/168495710-11abeb3f-2b51-4b3b-b8a8-5262d9606b9a.png">
 <h5 align="center">(Pessoa "5" candidata-se à vaga "8" - APPLY)</h5>
 <p align="center">
 <img src="https://user-images.githubusercontent.com/54047352/168495721-819ca1c6-3d5c-4520-9384-b2a0d1df9c3f.png">
 <h5 align="center">(Candidato "5" inserido no Oracle)</h5>
 <p align="center">
 <img src="https://user-images.githubusercontent.com/54047352/168495814-c865340c-4ca8-4fc8-a947-f7532dacbb3a.png">
 <h5 align="center">(Busca: até 05 Vales-Transportes - MATCH by VTn)</h5>
 <p align="center">
 <img src="https://user-images.githubusercontent.com/54047352/168495827-dab61186-fbfb-42f5-8236-9ec59b9e38b0.png">(https://youtu.be/zzFnECMKS2E87I) 
<h5 align="center">(Com 03 VT: apenas um candidato, *i.e.* "Joao Santo" - MATCH by VTn)</h5>
<h6 align="center">(Assista ao vídeo)</h6> 
</p>
</details open>


<details open><summary> 3) FUNÇÃO NO ORACLE​ BUSCA POR MÚLTIPLOS CRITÉRIOS​.</summary>
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168495926-26f04dc1-4f8e-4c07-95bb-3794eaff3582.png">
<h5 align="center">(Ativando FUNCTION do Oracle - veja "Parameters")</h5>
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168495951-ed487a38-0644-4849-b93a-10f7364c1df8.png">
<h5 align="center">(e.g. critério "gender" no Java, passa apenas parâmetros ao Oracle!)</h5> 
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168495982-52bfcc57-bd3a-4bd3-97d4-7bfafd8571c9.png">
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168495991-ebdcb868-1ad6-4193-9e16-74aff633ade1.png">
<p align="center">
<h5 align="center">(Busca é feita pelo Oracle!!!)</h5>
<h6 align="center"> (https://youtu.be/Nd3y7Bh1Ii8)</h6>

<h6 align="center">(Assista ao vídeo)</h6>
</p>
</details open>


<details open><summary> 4) PERFORMANCE  TEST​ 5.000 REGITROS.</summary>
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168496013-9658afeb-b4a4-4ce3-8b94-c00e97c2747a.png">
<h5 align="center">((5.000 registros; teste feito em um laptop doméstico, sem servidor)</h5>
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168496028-9c8491d4-e011-44cb-8e26-769ca0bea382.png">
<h5 align="center">((200 SELECTS X 5 sessões concorrentes)</h5>
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168496045-8ca1fb10-3c43-435a-a84a-46dd21da62f7.png">
<h5 align="center">(Oracle Instance Viewer)</h5>
 <p align="center">
(https://youtu.be/sdIkBLKfvh0)

<h6 align="center">(Assista ao vídeo)</h6>
</p>
</details open>

<h3 align="center">Casos de Uso.</h3>
 <details open><summary> API para API (sem usuário humano).</summary>
<p align="center">
 <img src="https://user-images.githubusercontent.com/54047352/168492361-9d1803d4-6bf7-45cb-80ec-a70784c50e0c.png">
</p>
 </details open>

# II - TECNOLOGIAS ADOTADAS NA SOLUÇÃO 

:wrench:  **Banco de Dados** ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white).


:wrench:  linguagem: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white): Controller 02.


:wrench:  ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E): Controller 01.

:wrench:  ![NodeJS](https://img.shields.io/badge/node.js-6DA55F?style=for-the-badge&logo=node.js&logoColor=white).


 
:wrench:  ![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)


:wrench: SQL DEVELOPER.

:wrench:  IDE: ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white).

:wrench:  Metodologia *Scrum* e Ágil;

:wrench: OBS Studio / Kdenlive

# III - CONTRIBUIÇÕES INDIVIDUAS/PESSOAIS

:axe: Atuei como *Product Owner* e **desenvolvi toda a linha de negócios da plafaforma**, especialmente a possibillidade de contratação por qualquer empresa de recrutamento e seleção em seus próprios bancos de dados, por meio da nossa API que permite:

:small_blue_diamond: à *Application Programming Interface* de qualquer site de recrutamento poderia otimizar suas buscas, mais econômicas e velozes,  conectar-se à nossa API, que funciona como um motor.

:small_blue_diamond: **"FLASH-RECRUITMENT"**: Ideal para recrutamento de massa, ex: obra com milhares de colaboradores, por tempo determinado;

:axe::axe: **Fui o Data Analyst do projeto**, para entender o nível de relevâcia dos tipos de dados do ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white), trabalhando com os desenvolvedores para etender o que o Google Maps poderia oferecer de dado externo e atualizado.

:earth_africa: Dados de itinerário, tempo, com a busca de qualquer dado, tanto no campo *destino* como o campo *origem*, tornaram-se o **diferencial exclusivo** da plataforma.

:axe::axe::axe: **Fui o Data Modeler do projeto**, para desenhar a modelagem segundo as funcionalidades **busca por geolocalização*** e *busca por qualquer critério*, alinhando com as possibilidades e capacidades dos nossos  desenvolvedores ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white).

:axe::axe::axe::axe: **Fui o DataBase Administrator do projeto**, para testar performance do nosso banco no ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white), segundo o requisito funcional de **performance**.
 
# IV - APRENDIZADOS EFETIVOS

:heavy_check_mark: Aprofundei na programação de banco de dados com o SQL DEVELOPER [Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white), por meio de *Functions*, trazendo o processamento e regras de negócio do backend para o banco de dados.

:orange_circle: **DIAGRAMAS DO BANCO DE DADOS **

<details open><summary> Diagramas:</summary>
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168496064-d2daee94-5d0f-482d-80af-6659a14cbadb.png">
<h5 align="center">((Diagrama Entidade-Relacionamento)</h5>
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168496081-311df7d2-7398-4249-aa3f-ea6f50465a35.png">
<h5 align="center">((Diagrama Lógico)</h5> 
</p>
</details open>

:heavy_check_mark: Aprofundei nas ferramentas de adminitração do Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white) SQL DEVELOPER (Instance Viewer).

:heavy_check_mark: Meu primeiro trabalho com **mútiplas linguagens de programação numa única aplicação:** [JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) + [Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white).

:heavy_check_mark: Implementação de novos padrões de projeto (*Strategy*): um *Bevavioural Design Pattern* voltado para o reaproveitmento de código, de acordo com o comportamento de classes derivadas. 

Referências:

https://refactoring.guru/pt-br/design-patterns/strategy

http://olivieraubert.net/download/koalaplop01.pdf


## Running it up
Deployment (No seu dispositivo): Vide Pasta "DEPLOYMENT-FIND-STEPS-HERE" acima)

The End.
:arrow_up: 
[`Go Back Up`](#java-oracle-api---recrutamento-por-geolocaliza%C3%A7%C3%A3o-e-outros-crit%C3%A9rios).
