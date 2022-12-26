package br.com.axolot.animal.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "ANIMALIA")
public class AnimaliaEntity {

    @Id
    @Column(name = "ANIMALIA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FAMILY")
    private String family;

    @Column(name = "GENUS")
    private String genus;

    @Column(name = "INITIAL_GEOLOGIC_TIME")
    private String initialGeologicTime;

    @Column(name = "FINAL_GEOLOGIC_TIME")
    private String finalGeologicTime;
    
}
