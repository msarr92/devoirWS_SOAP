package isi.sn.soap_sectors_classes.repository;

import isi.sn.soap_sectors_classes.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
// Cette interface hérite de JpaRepository, ce qui signifie qu'elle bénéficie automatiquement
public interface SectorRepository  extends JpaRepository<Sector, Long> {
}
