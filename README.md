## PORTFOLIO ACADÊMICO - PROJETOS INTEGRADORES:

[SEMESTRE-01-2019.2 - *Python-Sqlite3 Web Scrapper - Monitor de Segurança Pública*](https://github.com/ODAGAMMXIX/PFOLIO1_DANZO) 

[SEMESTRE-02-2020.1 - *Java-MySQL Stand Alone App - Gráfico de GANTT para Gestores*](https://github.com/ODAGAMMXIX/PFOLIO2_GANTT)

[SEMESTRE-03-2020.2 - *Java-Oracle - Cadastro Positivo e Desbancarizados*](https://github.com/ODAGAMMXIX/PFOLIO3_VALCODE)

## [SEMESTRE-04-2021.1 - *Java-Oracle API - Recrutamento por Geolocalização et al.*](https://github.com/ODAGAMMXIX/PFOLIO4_JOBNATION)

[SEMESTRE-05-2021.2 - *Java-Pentaho-My(SQL)Server-MongoDB - Engajamento Estudantil*](https://github.com/ODAGAMMXIX/PFOLIO4_JOBNATION)

[SEMESTRE-06-2022.1 - *Python-MongoDB-LGPD opt-in opt-out ou Análise de Dados Eleitorais*](https://github.com/ODAGAMMXIX/PFOLIO4_JOBNATION)

***

<h1 align="center">[Java-Oracle API - Recrutamento por Geolocalização e Outros Critérios.]</h1>


<h1 align="center">JOBNATION</h1>



# I - RESUMO DO PROJETO 

Objetivando vencer os desafios do ***recrutamento em massa***, desenvolveu-se uma API que possibilita a busca de candidatos a partir de critérios de uma determinada vaga, possibilitando  contração veloz e assertiva, com segurança e desempenho.

 Nossa proposta:
 
- Busca por geolocalização ![Google](https://img.shields.io/badge/google-4285F4?style=for-the-badge&logo=google&logoColor=white) , para saber o número de conduções do itinerário.

- Busca por função no ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white), por diferentes critérios: a aplicação varrerá  currículos já cadastrados e identificará candidato(s)  mais adequados à vaga.

Empresa parceira JetSoft figurou como cliente.

<h3 align="center">Arquitetura da Aplicação</h3>


![Screenshot from 2022-05-15 17-20-11](https://user-images.githubusercontent.com/54047352/168492368-15f3ef36-b057-4b68-9026-8ebdbd1a7994.png)

<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168492370-04046bc7-4c06-424e-b8b7-e47418df0374.png">
 </p>


<h5 align="center">(!!!---DOIS CONTROLLERS---!!!)</h5>


<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168492361-9d1803d4-6bf7-45cb-80ec-a70784c50e0c.png">
 </p>

<h5 align="center">API para API (sem usuário humano)</h5>


#### 1) CONTROLLER 01​ NODEJS ​& ​ GOOGLE MAPS API.

<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168495627-6af7c575-284c-4139-993a-0e79d0b51729.png">
 </p>
 
![Screenshot from 2022-05-15 17-45-49](https://user-images.githubusercontent.com/54047352/168495647-69e687a7-ae71-44c6-b667-db7c130d0d3a.png)

(https://youtu.be/61kPu1F-87I)

<h4 align="center">(Com origem,destino = número de conduções, itinerário compelto, tempo etc.)</h4>

#### 2) CONTROLLER 02 - APPLY & MATCH​ - BACK-END JAVA​.

![Screenshot from 2022-05-15 17-51-01](https://user-images.githubusercontent.com/54047352/168495710-11abeb3f-2b51-4b3b-b8a8-5262d9606b9a.png)

<h5 align="center">(Pessoa "5" candidata-se à vaga "8" - APPLY)</h5>


![Screenshot from 2022-05-15 17-55-15](https://user-images.githubusercontent.com/54047352/168495721-819ca1c6-3d5c-4520-9384-b2a0d1df9c3f.png)

<h5 align="center">(Candidato "5" inserido no Oracle)</h5>

![Screenshot from 2022-05-15 17-56-57](https://user-images.githubusercontent.com/54047352/168495814-c865340c-4ca8-4fc8-a947-f7532dacbb3a.png)


<h5 align="center">(Busca: até 05 Vales-Transportes - MATCH by VTn)</h5>

![Screenshot from 2022-05-15 17-57-22](https://user-images.githubusercontent.com/54047352/168495827-dab61186-fbfb-42f5-8236-9ec59b9e38b0.png)

<h5 align="center">(Com 03 VT: apenas o candidato "Joao Santo" - MATCH by VTn)</h5>

(https://youtu.be/zzFnECMKS2E)


#### 3) FUNÇÃO ORACLE​ BUSCA POR MÚLTIPLOS CRITÉRIOS​.

<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168495926-26f04dc1-4f8e-4c07-95bb-3794eaff3582.png">
 </p>

<h5 align="center">(Ativando FUNCTION do Oracle)</h5>

![Screenshot from 2022-05-15 18-04-53](https://user-images.githubusercontent.com/54047352/168495951-ed487a38-0644-4849-b93a-10f7364c1df8.png)

<h5 align="center">(e.g. critério "gender" no Java, passa apenas parâmetros ao Oracle)</h5> 

<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168495982-52bfcc57-bd3a-4bd3-97d4-7bfafd8571c9.png">
 </p>


<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168495991-ebdcb868-1ad6-4193-9e16-74aff633ade1.png">
 </p>

<h5 align="center">(Busca é feita pelo Oracle!!!)</h5>

(https://youtu.be/Nd3y7Bh1Ii8)


#### 4) PERFORMANCE  TEST​ 5.000 REGITROS.

<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168496013-9658afeb-b4a4-4ce3-8b94-c00e97c2747a.png">
 </p>
 

<h5 align="center">((5.000 registros; home laptop)</h5>
<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168496028-9c8491d4-e011-44cb-8e26-769ca0bea382.png">
 </p>
 

<h5 align="center">((200 SELECTS X 5 sessões concorrentes)</h5>


![Screenshot from 2022-05-15 18-14-37](https://user-images.githubusercontent.com/54047352/168496045-8ca1fb10-3c43-435a-a84a-46dd21da62f7.png)
 

<h5 align="center">((Oracle Instance Viewer)</h5>


https://youtu.be/sdIkBLKfvh0

# II - TECNOLOGIAS ADOTADAS NA SOLUÇÃO 

:wrench:  **Banco de Dados** ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white).

:orange_circle: **DIAGRAMA ENTIDADE-RELACIONAMENTO **

![Screenshot from 2022-05-15 18-23-44](https://user-images.githubusercontent.com/54047352/168496064-d2daee94-5d0f-482d-80af-6659a14cbadb.png)

<h5 align="center">((Diagrama Entidade-Relacionamento)</h5>

![Screenshot from 2022-05-15 18-24-04](https://user-images.githubusercontent.com/54047352/168496081-311df7d2-7398-4249-aa3f-ea6f50465a35.png)

<h5 align="center">((Diagrama Lógico)</h5> 


:wrench:  linguagem: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)

<p align="center">
<img src="https://user-images.githubusercontent.com/54047352/168496089-a6b1081c-4416-4144-8933-970728bfc6ac.png">
 </p>


<h5 align="center">((Backend Java e Controller 02)</h5> 


:wrench:  JavaScript.
:wrench:  NodeJS.

}

<h5 align="center">((Controller 01)</h5> 


 
:wrench:  ![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)  idem.


:orange_circle: **Data Grip:** IDE de banco de dados que detecta bugs no código e sugere correções.

:wrench:  IDE: ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white).

:wrench:  Metodologia *Scrum* e Ágil;

Estudamos e deixamos de implementar:

:wrench:  ![TensorFlow](https://img.shields.io/badge/TensorFlow-%23FF6F00.svg?style=for-the-badge&logo=TensorFlow&logoColor=white)  *Machine Learning* através de **redes neurais**;

![image](imgs/MicrosoftTeams-image4.png)

💻

- Oracle 11g (Sql developer)
- Java (IntelliJ / Eclipse))
- Javascript )Node-JS)
- React (Insomnia/POSTMAN)
- Git (GitLab)
- OBS Studio / Kdenlive

# III - CONTRIBUIÇÕES INDIVIDUAS/PESSOAIS

:axe: Atuei como *Product Owner*.

:axe::axe: **Desenvolvi toda a linha de negócios da plafaforma**, ______:

:small_blue_diamond: API de qq site de recrutamento pode conectar-se à nossa API para disponibilizar seus canditados e e otimizar suas buscas;

:small_blue_diamond: "FLASH-RECRUITMENT": Ideal para recrutamento de massa, ex: obra com milhares de colaboradores, por tempo determinado;

:axe::axe::axe::axe: **Fui o Data Analyst do projeto**, para entender o nível de relevâcia dos tipos de dados do ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white).

:axe::axe::axe::axe: **Fui o Data Modeler do projeto**, para desenhar a modelagem segundo as possibilidades e capacidades dos desenvolvedores ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white).

:axe::axe::axe::axe: **Fui o DataBase Administrator do projeto**, para testar performance do nosso banco no ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white).
 
# IV - APRENDIZADOS EFETIVOS

:heavy_check_mark: Aprofundei nas ferramentas do SQL DEVELOPER (Instance Viewer): ____.

:heavy_check_mark: Aprofundei na programação do Oracle (*Functions*): Trazendo o processamento e regras de negócio do backend para o banco de dados.

:heavy_check_mark: Meu primeiro trabalho com **mútiplass linguagens de programação numa única aplicação:** ______.

:heavy_check_mark: Implementação de novos padrões de projeto (*Strategy*): .


![image](imgs/MicrosoftTeams-image5.png)

:heavy_check_mark:![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)

:heavy_check_mark: ![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)

:heavy_check_mark: ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

:heavy_check_mark: ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)



## Running it up
Deployment
No seu dispositivo
Vide Pasta "DEPLOYMENT-FIND-STEPS-HERE" acima)


The End.
:arrow_up: 
[`Go Back Up`](#java-oracle-api---recrutamento-por-geolocaliza%C3%A7%C3%A3o-e-outros-crit%C3%A9rios).


