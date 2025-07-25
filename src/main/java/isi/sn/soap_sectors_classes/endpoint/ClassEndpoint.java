package isi.sn.soap_sectors_classes.endpoint;

import isi.sn.soap_sectors_classes.model.ClassEntity;
import isi.sn.soap_sectors_classes.repository.ClassRepository;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.ws.server.endpoint.annotation.*;

import java.util.List;

@Endpoint
public class ClassEndpoint {
    private static final String NAMESPACE_URI = "http://soap_sectors_classes.sn.isi";
    private final ClassRepository classRepository;

    public ClassEndpoint(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllClassesRequest")
    @ResponsePayload
    public GetAllClassesResponse getAllClasses() {
        List<ClassEntity> classes = classRepository.findAll();
        GetAllClassesResponse response = new GetAllClassesResponse();
        response.setClasses(classes);
        return response;
    }

    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class GetAllClassesResponse {
        private List<ClassEntity> classes;
        public List<ClassEntity> getClasses() { return classes; }
        public void setClasses(List<ClassEntity> classes) { this.classes = classes; }
    }
}
