package com.mercadolibre.test.magneto.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Stats {

    @JsonProperty("count_mutant_dna")
    private String countMutantDna;
    @JsonProperty("count_human_dna")
    private String countHumanDna;
    private String ratio;

}
