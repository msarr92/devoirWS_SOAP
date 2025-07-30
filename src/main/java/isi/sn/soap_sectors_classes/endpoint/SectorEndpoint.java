package isi.sn.soap_sectors_classes.endpoint;

import isi.sn.soap_sectors_classes.model.Sector;
import isi.sn.soap_sectors_classes.repository.SectorRepository;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.ws.server.endpoint.annotation.*;

import java.util.List;

// Annotation qui marque cette classe comme un endpoint SOAP
@Endpoint
public class SectorEndpoint {

    // URI du namespace défini dans le fichier XSD
    private static final String NAMESPACE_URI = "http://soap_sectors_classes.sn.isi";
    // Injection du repository permettant d'accéder aux entités Sector (depuis la BDD)
    private final SectorRepository sectorRepository;
    // Constructeur avec injection de dépendance de Spring
    public SectorEndpoint(SectorRepository repo) {
        this.sectorRepository = repo;
    }
    // Cette annotation lie la méthode à une requête SOAP spécifique
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllSectorsRequest")
    // Indique que le résultat de cette méthode sera inséré dans le body de la réponse SOAP
    @ResponsePayload
    public GetAllSectorsResponse getAllSectors() {
        // Récupération de tous les secteurs enregistrés en base de données
        List<Sector> sectors = sectorRepository.findAll();
        // Création d'un objet de réponse pour le SOAP
        GetAllSectorsResponse response = new GetAllSectorsResponse();
        // Injection des secteurs dans la réponse
        response.setSectors(sectors);
        // Retour de la réponse au client SOAP
        return response;
    }

    // Classe représentant la structure XML de la réponse SOAP
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class GetAllSectorsResponse {
        // Liste des secteurs à inclure dans la réponse SOAP
        private List<Sector> sectors;
        // Getter standard pour JAXB
        public List<Sector> getSectors() { return sectors; }
        // Setter standard pour JAXB
        public void setSectors(List<Sector> sectors) { this.sectors = sectors; }
    }
}
