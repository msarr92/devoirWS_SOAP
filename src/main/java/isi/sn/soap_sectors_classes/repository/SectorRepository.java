package isi.sn.soap_sectors_classes.repository;

import isi.sn.soap_sectors_classes.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository  extends JpaRepository<Sector, Long> {
}
