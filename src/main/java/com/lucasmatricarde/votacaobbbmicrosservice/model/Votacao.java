package com.lucasmatricarde.votacaobbbmicrosservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "votacao")
public class Votacao {

    @Id
    private String id;
    private Participante participante;
    private Date dataHora;
}
