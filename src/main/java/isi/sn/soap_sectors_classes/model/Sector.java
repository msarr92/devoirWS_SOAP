package isi.sn.soap_sectors_classes.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Sector {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy="sector", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ClassEntity> classes = new ArrayList<>();

    // getters / setters
}
