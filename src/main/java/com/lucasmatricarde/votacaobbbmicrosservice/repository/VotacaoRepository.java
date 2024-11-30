package com.lucasmatricarde.votacaobbbmicrosservice.repository;

import com.lucasmatricarde.votacaobbbmicrosservice.model.Votacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotacaoRepository extends MongoRepository<Votacao, String> {


}
