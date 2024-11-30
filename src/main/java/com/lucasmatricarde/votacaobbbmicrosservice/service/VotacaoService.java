package com.lucasmatricarde.votacaobbbmicrosservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasmatricarde.votacaobbbmicrosservice.model.Participante;
import com.lucasmatricarde.votacaobbbmicrosservice.model.Votacao;
import com.lucasmatricarde.votacaobbbmicrosservice.repository.VotacaoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class VotacaoService {

    private final VotacaoRepository votacaoRepository;

    private static final String TOPICO_VOTACAO = "votacao";

    @KafkaListener(groupId = "microServiceVotacao", topics = TOPICO_VOTACAO)
    private void execute(ConsumerRecord<String, String> registry) {
        String participanteStr = registry.value();
        log.info("Voto recebido = {}" + participanteStr);

        Participante participante = null;
        try {
            participante = new ObjectMapper().readValue(participanteStr, Participante.class);
        }catch (JsonProcessingException e) {
            log.error("Falha ao converter voto [{}]", participanteStr, e);
            return;
        }

        Votacao votacaoSaved = votacaoRepository.save(new Votacao(null, participante, new java.util.Date()));

        log.info("Voto registrado com sucesso = [id={}, dataHora={}]" + votacaoSaved.getId(), votacaoSaved.getDataHora());
    }
}
