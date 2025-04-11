package com.example.Avitidade.Service;

import com.example.Avitidade.Model.ItemMagicoEntity;
import com.example.Avitidade.Model.PersonagemEntity;
import com.example.Avitidade.Repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServicePersonagem {
    @Autowired
    private PersonagemRepository repository;

    public PersonagemEntity createPersonagem(PersonagemEntity personagemEntity) {
        int total = personagemEntity.getForcaPersonagem() + personagemEntity.getDefPersonagem();
        if (total > 10) {
            throw new IllegalArgumentException("você está usando mais ponto do que o permitido :(");
        }
        return repository.save(personagemEntity);
    }

    public Map<String, List<PersonagemEntity>> getTasksOrganizedByColumn() {
        List<PersonagemEntity> personagem = repository.findAll();
        return personagem.stream()
                .collect(Collectors.groupingBy(PersonagemEntity::getNamePersonagem));
    }

    public PersonagemEntity getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Personagem Fugiu"));
    }

    @PutMapping
    public  PersonagemEntity updatePersonagem(Long id, PersonagemEntity updatePersonagem) {
        PersonagemEntity personagem = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personagem não Fugiu"));
        personagem.setNamePersonagem(updatePersonagem.getNamePersonagem());
        personagem.setNomeAventureiro(updatePersonagem.getNomeAventureiro());
        personagem.setLevel(updatePersonagem.getLevel());
        personagem.setClasse(updatePersonagem.getClasse());
        personagem.setForcaPersonagem(updatePersonagem.getForcaPersonagem());
        personagem.setDefPersonagem(updatePersonagem.getDefPersonagem());
        List<ItemMagicoEntity> novosItens = updatePersonagem.getItensMagicos();
        return repository.save(personagem);
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    public void deleteByIdPersonagem(Long id) {
        repository.deleteById(id);
    }

    public  List<PersonagemEntity> getAllPersonagens() {
        return repository.findAll();
    }

    public PersonagemEntity adicionarItemAoPersonagem(Long idPersonagem, ItemMagicoEntity novoItem) {
        PersonagemEntity personagem = repository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem Fugiu"));
        personagem.adicionarItem(novoItem);
        return repository.save(personagem);
    }
}
