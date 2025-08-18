Ce projet est un Web Service SOAP développé en **Spring Boot**, exposant deux entités principales :
-Sector
-ClassEntity
Le projet s'appuie sur une architecture SOAP standard avec génération de WSDL, requêtes XSD, endpoints annotés, et persistance via JPA + PostgreSQL.
  -------------------------------------------------------
Technologies utilisées
    Java 17
    Spring Boot
    Spring Web Services (SOAP)
    JPA / Hibernate
    PostgreSQL
    JAXB / XSD
------------------Structure de ce projet------------------
  -config/
WebServiceConfig.java
Configure Spring-WS.
Elle déclare :
un MessageDispatcherServlet qui intercepte les requêtes SOAP,
un Wsdl11Definition qui génère automatiquement un WSDL à partir de l’XSD fourni (sector-classes.xsd).
 Sans cette config, ton service SOAP ne saurait pas exposer ses endpoints.
  -endpoint/

Ce sont les points d’entrée SOAP (équivalent des contrôleurs REST en Spring MVC).
Ils reçoivent les requêtes SOAP et appellent la couche service.
SectorEndpoint.java: Définit des opérations SOAP pour les Secteurs (ajout, récupération, etc.).
Utilise l’annotation @Endpoint et @PayloadRoot pour mapper une requête SOAP vers une méthode Java.
Il traduit entre XML reçu et objets Java.

ClassEndpoint.java: Similaire, mais pour les Classes (ajout, récupération, liste) et
gere la logique SOAP liée aux entités "ClassEntity".

  -repository/

Interfaces qui héritent de JpaRepository.
Spring Data JPA génère automatiquement les requêtes CRUD.
SectorRepository.java : persistance des secteurs.
ClassRepository.java : persistance des classes.

-service/
Couche intermédiaire entre endpoint et repository.
Elle contient la logique métier.
SectorService.java : méthodes pour gérer les secteurs (ajout, liste, recherche).
ClassService.java : méthodes pour gérer les classes, toujours reliées à un secteur.
sector-classes.xsd
Le schéma XML qui définit les types et requêtes SOAP (structure des messages AddSectorRequest, AddClassRequest, GetSectorResponse, etc.).




------------------Tester le Web Service-----------------------
Une fois l'application démarrée, le WSDL est disponible à l’URL suivante :
http://localhost:8080/ws/sector-classes.wsdl
on peut le tester sur postman:
Pour la Requête SOAP: getAllSectors

<img width="624" height="615" alt="Screenshot 2025-07-25 042009" src="https://github.com/user-attachments/assets/8a585572-3ba3-4362-956f-876b085723f0" />


Pour la Requête SOAP getAllClasses

<img width="591" height="576" alt="Screenshot 2025-07-25 042131" src="https://github.com/user-attachments/assets/1861bfd7-cc08-4bd9-9e15-5c7071d0fcf2" />

