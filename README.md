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
------------------Tester le Web Service-----------------------
Une fois l'application démarrée, le WSDL est disponible à l’URL suivante :
http://localhost:8080/ws/sector-classes.wsdl
on peut le tester sur postman:
Pour la Requête SOAP: getAllSectors
<img width="624" height="615" alt="Screenshot 2025-07-25 042009" src="https://github.com/user-attachments/assets/8a585572-3ba3-4362-956f-876b085723f0" />
Pour la Requête SOAP getAllClasses
<img width="591" height="576" alt="Screenshot 2025-07-25 042131" src="https://github.com/user-attachments/assets/1861bfd7-cc08-4bd9-9e15-5c7071d0fcf2" />

