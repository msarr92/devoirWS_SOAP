Ce projet est un Web Service SOAP développé en **Spring Boot**, exposant deux entités principales :
-Sector
-ClassEntity
Le projet s'appuie sur une architecture SOAP standard avec génération de WSDL, requêtes XSD, endpoints annotés, et persistance via JPA + PostgreSQL.
Structure du projet
soap-sector-class/
  src/
    main/
      java/isi/sn/soap_sectors_classes/
        config/
          WebServiceConfig.java
        endpoint/
          SectorEndpoint.java
          ClassEndpoint.java
        model/
          Sector.java
          ClassEntity.java
        repository/
          SectorRepository.java
          ClassRepository.java
      resources/
        sector-classes.xsd
        application.properties
  pom.xml
  README.md
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
on peut le tester sur postman
<img width="624" height="615" alt="Screenshot 2025-07-25 042009" src="https://github.com/user-attachments/assets/8a585572-3ba3-4362-956f-876b085723f0" />

