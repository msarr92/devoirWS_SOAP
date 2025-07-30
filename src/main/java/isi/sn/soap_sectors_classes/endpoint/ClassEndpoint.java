package isi.sn.soap_sectors_classes.endpoint;

import isi.sn.soap_sectors_classes.model.ClassEntity;
import isi.sn.soap_sectors_classes.repository.ClassRepository;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.ws.server.endpoint.annotation.*;

import java.util.List;

// Annotation qui marque cette classe comme un endpoint SOAP
@Endpoint
public class ClassEndpoint {

    // URI du namespace défini dans le fichier XSD
    private static final String NAMESPACE_URI = "http://soap_sectors_classes.sn.isi";
    // Injection du repository permettant d'accéder aux entités ClassEntity (depuis la BDD)
    private final ClassRepository classRepository;

    // Injection du repository
    public ClassEndpoint(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    // Méthode mappée sur la requête SOAP
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllClassesRequest")
    // Indique que la valeur retournée doit être incluse dans la réponse SOAP
    @ResponsePayload
    public GetAllClassesResponse getAllClasses() {
        // Récupère toutes les entités ClassEntity depuis la base de données
        List<ClassEntity> classes = classRepository.findAll();
        // Crée un objet de réponse SOAP
        GetAllClassesResponse response = new GetAllClassesResponse();
        // Injecte la liste des classes dans la réponse
        response.setClasses(classes);
        // Retourne la réponse complète à l’appelant SOAP
        return response;
    }

    // Définition de la classe de réponse (sera convertie en XML via JAXB)
    // Elle est visible comme élément XML racine dans le namespace défini
    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class GetAllClassesResponse {
        // Liste des classes retournées dans la réponse
        private List<ClassEntity> classes;
        // Getter standard pour JAXB
        public List<ClassEntity> getClasses() { return classes; }
        // Setter standard pour JAXB
        public void setClasses(List<ClassEntity> classes) { this.classes = classes; }
    }
}
