package com.example.Avitidade.Controller;

import com.example.Avitidade.Model.ItemMagicoEntity;
import com.example.Avitidade.Model.PersonagemEntity;
import com.example.Avitidade.Service.ServicePersonagem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(description = "Cria um novo personagem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Personagem criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<PersonagemEntity> createPersonagem(@Valid @RequestBody PersonagemEntity personagem) {
        try {
            PersonagemEntity createdPersonagem = servicePersonagem.createPersonagem(personagem);
            return new ResponseEntity<>(createdPersonagem, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(description = "Busca todos os personagem pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de personagens agrupados por nome")
    })
    @GetMapping()
    public Map<String, List<PersonagemEntity>> getAllPersonagens() {
        List<PersonagemEntity> personagem = servicePersonagem.getAllPersonagens();
        return personagem.stream()
                .collect(Collectors.groupingBy(PersonagemEntity::getNamePersonagem));
    }

    @Operation(description = "Busca um personagem pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personagem encontrado"),
            @ApiResponse(responseCode = "404", description = "Personagem não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonagemEntity> getPersonagemById(@PathVariable Long id) {
        PersonagemEntity personagem = servicePersonagem.getById(id); // Crie esse método no service
        return ResponseEntity.ok(personagem);
    }

    @Operation(description = "Atualiza um personagem via ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualiza encontrado"),
            @ApiResponse(responseCode = "404", description = "Atualiza não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonagem(@PathVariable Long id, @RequestBody PersonagemEntity updatePersonagem) {
        try {
            PersonagemEntity personagemAtualizado = servicePersonagem.updatePersonagem(id, updatePersonagem);
            return ResponseEntity.ok(personagemAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar personagem: " + e.getMessage());
        }
    }

    @Operation(description = "Deleta um personagem via ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonagem(@PathVariable Long id) {
        servicePersonagem.deleteByIdPersonagem(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/adicionar-item")
    public ResponseEntity<PersonagemEntity> adicionarItem(
            @PathVariable Long id,
            @RequestBody ItemMagicoEntity item) {
        PersonagemEntity personagemAtualizado = servicePersonagem.adicionarItemAoPersonagem(id, item);
        return ResponseEntity.ok(personagemAtualizado);
    }

}
