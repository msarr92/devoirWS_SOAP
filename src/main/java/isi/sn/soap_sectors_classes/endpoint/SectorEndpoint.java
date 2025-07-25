package isi.sn.soap_sectors_classes.endpoint;

import isi.sn.soap_sectors_classes.model.Sector;
import isi.sn.soap_sectors_classes.repository.SectorRepository;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.ws.server.endpoint.annotation.*;

import java.util.List;

@Endpoint
public class SectorEndpoint {
    private static final String NAMESPACE_URI = "http://soap_sectors_classes.sn.isi";
    private final SectorRepository sectorRepository;

    public SectorEndpoint(SectorRepository repo) {
        this.sectorRepository = repo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllSectorsRequest")
    @ResponsePayload
    public GetAllSectorsResponse getAllSectors() {
        List<Sector> sectors = sectorRepository.findAll();
        GetAllSectorsResponse response = new GetAllSectorsResponse();
        response.setSectors(sectors);
        return response;
    }

    @XmlRootElement(namespace = NAMESPACE_URI)
    public static class GetAllSectorsResponse {
        private List<Sector> sectors;
        public List<Sector> getSectors() { return sectors; }
        public void setSectors(List<Sector> sectors) { this.sectors = sectors; }
    }
}
