package com.nogran.food.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.nogran.food.domain.model.Cozinha;
import java.util.List;
import lombok.Data;
import lombok.NonNull;

@JsonRootName("cozinhas")
//@JacksonXmlRootElement(localName = "cozinhas")
@Data
public class CozinhasJacksonXmlElementWrapper {
    /*
     * @JacksonXmlRootElement é uma alternativa à @JsonRootName e
     * @JacksonXmlProperty à @JsonProperty.
     *
     * A diferença é que as anotações iniciadas com @JacksonXml só afetam
     * a serialização em XML. Já as anotações iniciadas com @Json
     * afetam tanto a serialização JSON como também XML.
     */

    @JsonProperty("cozinha")
//	@JacksonXmlProperty(localName = "cozinha")
    @JacksonXmlElementWrapper(useWrapping = false)
    @NonNull
    private List<Cozinha> cozinhas;

}
