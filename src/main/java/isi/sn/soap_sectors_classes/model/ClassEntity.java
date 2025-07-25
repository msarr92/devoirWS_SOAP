package isi.sn.soap_sectors_classes.model;

import jakarta.persistence.*;

@Entity
@Table(name="classes")
public class ClassEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private String description;

    @ManyToOne
    @JoinColumn(name="sector_id", nullable=false)
    private Sector sector;

    // getters / setters
}
