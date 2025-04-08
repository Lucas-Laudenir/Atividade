package com.example.Avitidade.Service;

import com.example.Avitidade.Model.PersonagemEntity;
import com.example.Avitidade.Repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServicePersonagem {
    @Autowired
    private PersonagemRepository repository;

public PersonagemEntity craetePersonagem (PersonagemEntity personagemEntity){
    personagemEntity.setDefPersonagem(56);
    personagemEntity.setForcaPersonagem(56);
    personagemEntity.setNamePersonagem("Rogerio");
//    personagemEntity.setLIstaitemMagico();
    personagemEntity.setClasse("Barbaro");
    personagemEntity.setNomeAventureiro("Oliver");
    personagemEntity.setLevel(56);
    PersonagemEntity savePersonagem =  repository.save(personagemEntity);
    System.out.println("Personagem salvo: " + savePersonagem);
    return savePersonagem;
}

@GetMapping
public Map<String, List<PersonagemEntity>> getTasksOrganizedByColumn() {
    List<PersonagemEntity> tasks = repository.findAll();
    return tasks.stream()
            .collect(Collectors.groupingBy(PersonagemEntity::getNamePersonagem));
}

    public  PersonagemEntity updatePersonagem(Long id, PersonagemEntity updatePersonagem) {
        PersonagemEntity personagem = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        personagem.setNamePersonagem(updatePersonagem.getNamePersonagem());
        //personagem.setLIstaitemMagico(updatePersonagem.getLIstaitemMagico());
        personagem.setNomeAventureiro(updatePersonagem.getNomeAventureiro());
        personagem.setLevel(updatePersonagem.getLevel());
        personagem.setClasse(personagem.getClasse());
        personagem.setDefPersonagem(personagem.getDefPersonagem());
        personagem.setForcaPersonagem(personagem.getForcaPersonagem());
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

}
