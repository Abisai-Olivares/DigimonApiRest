package com.example.ApiDigimon.Model;

import java.time.Year;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Digimon {
    @Id
    private long id;

    @Column
    private String name;

    @Column
    private boolean xAntibody;

    @Column
    private Year releaseDate;
    

    @ElementCollection
    @CollectionTable(name = "images", joinColumns = @JoinColumn(name = "digimon_id"))
    private List<Images> images;
    
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "digimon_id")
    private List<Levels> levels;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "digimon_id")
    private List<Types> types;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "digimon_id")
    private List<Attributes> attributes;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "digimon_id")
    private List<Fields> fields;

    @ElementCollection
    @CollectionTable(name = "descriptions", joinColumns = @JoinColumn(name = "digimon_id"))
    private List<Descriptions> descriptions;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "digimon_id")
    private List<Skills> skills;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "digimon_id")
    private List<PriorEvolutions> priorEvolutions;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "digimon_id")
    private List<NextEvolutions> nextEvolutions;
    


  
}