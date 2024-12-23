package com.lucasmatricarde.votacaobbbmicrosservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "participante")
public class Participante {

    @Id
    private String id;
    private String name;
}
