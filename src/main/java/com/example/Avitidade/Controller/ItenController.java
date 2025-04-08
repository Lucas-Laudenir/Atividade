package com.example.Avitidade.Controller;

import com.example.Avitidade.Model.ItemMagicoEntity;
import com.example.Avitidade.Model.PersonagemEntity;
import com.example.Avitidade.Service.ServiceMagicIten;
import com.example.Avitidade.Service.ServicePersonagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Iten")
public class ItenController {

    @Autowired
    private ServiceMagicIten serviceMagicIten;

    @PostMapping
    public ResponseEntity<List<ItemMagicoEntity>> createPersonagem(@RequestBody ItemMagicoEntity Item) {
        ItemMagicoEntity createdItem = serviceMagicIten.craeteItem(Item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public Map<String, List<ItemMagicoEntity>> getAllPersonagens() {
        List<ItemMagicoEntity> Item = serviceMagicIten.;
        return Item.stream()
                .collect(Collectors.groupingBy(ItemMagicoEntity::getNameItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemMagicoEntity> updateItem(@PathVariable() long id, @RequestBody ItemMagicoEntity updateItem) {
        ItemMagicoEntity Item = serviceMagicIten.updateItem(id, updateItem);
        return new ResponseEntity<>(Item, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        serviceMagicIten.deleteByIdItem(id);
        return ResponseEntity.noContent().build();
    }

}
