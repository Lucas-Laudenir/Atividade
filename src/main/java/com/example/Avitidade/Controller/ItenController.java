package com.example.Avitidade.Controller;

import com.example.Avitidade.Model.ItemMagicoEntity;
import com.example.Avitidade.Service.ServiceMagicIten;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Itens")
public class ItenController {

    @Autowired
    private ServiceMagicIten serviceMagicIten;

    @Operation(description = "Cria item mágico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<ItemMagicoEntity> createItem(@RequestBody ItemMagicoEntity item) {
        ItemMagicoEntity createdItem = serviceMagicIten.createItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @Operation(description = "Retorna todos os itens mágicos por nome")
    @GetMapping
    public ResponseEntity<Map<String, List<ItemMagicoEntity>>> getAllItens() {
        List<ItemMagicoEntity> itens = serviceMagicIten.getAllItem();
        Map<String, List<ItemMagicoEntity>> grouped = itens.stream()
                .collect(Collectors.groupingBy(ItemMagicoEntity::getNameItem));
        return ResponseEntity.ok(grouped);
    }

    @Operation(description = "PUT item mágico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "PUT feito com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ItemMagicoEntity> updateItem(@PathVariable() long id,
                                                       @RequestBody ItemMagicoEntity updateItem) {
        ItemMagicoEntity Item = serviceMagicIten.updateItem(id, updateItem);
        return new ResponseEntity<>(Item, HttpStatus.OK);
    }

    @Operation(description = "Deleta um item mágico pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        serviceMagicIten.deleteByIdItem(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Busca um item mágico pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<ItemMagicoEntity> getItemById(@PathVariable Long id) {
        ItemMagicoEntity item = serviceMagicIten.getByIditen(id);
        return ResponseEntity.ok(item);
    }

}
