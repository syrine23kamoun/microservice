package com.assurance.assuranceback.Entity.CarrieresEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter

public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private LocalDate datePublication;
    private LocalDate dateExpiration;
    private String lieu; // Tunis, Nabeul, Sousse...
    private String typeContrat; // CDI, CDD, Stage...
    private String salaire;
    private String competencesRequises; // Stocké en JSON ou String
    private int experienceMinimale;
    private int nbrVacant;
    @Enumerated(EnumType.STRING)
    private WebConfig.StatutOffre statut = WebConfig.StatutOffre.ACTIVE;


}
