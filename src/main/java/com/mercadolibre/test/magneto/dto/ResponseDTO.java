package com.mercadolibre.test.magneto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseDTO {

    @JsonProperty("count_mutant_dna")
    private String countMutantDna;
    @JsonProperty("count_human_dna")
    private String countHumanDna;
    private String ratio;

}
