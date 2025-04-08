package com.example.Avitidade.Controller;

import com.example.Avitidade.Model.PersonagemEntity;
import com.example.Avitidade.Service.ServicePersonagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Personagem")
public class PersonagemController {
    @Autowired
    private ServicePersonagem servicePersonagem;

    @PostMapping
    public ResponseEntity<List<PersonagemEntity>> createPersonagem(@RequestBody PersonagemEntity personagem) {
        PersonagemEntity createdPersonagem = servicePersonagem.craetePersonagem(personagem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public Map<String, List<PersonagemEntity>> getAllPersonagens() {
        List<PersonagemEntity> personagem = servicePersonagem.getAllPersonagens();
        return personagem.stream()
                .collect(Collectors.groupingBy(PersonagemEntity::getNamePersonagem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemEntity> updatePersonagem(@PathVariable() long id, @RequestBody PersonagemEntity updatePersonagem) {
        PersonagemEntity personagem = servicePersonagem.updatePersonagem(id, updatePersonagem);
        return new ResponseEntity<>(personagem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonagem(@PathVariable Long id) {
        servicePersonagem.deleteByIdPersonagem(id);
        return ResponseEntity.noContent().build();
    }


}
