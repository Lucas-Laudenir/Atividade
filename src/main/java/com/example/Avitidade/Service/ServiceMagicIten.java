package com.example.Avitidade.Service;

import com.example.Avitidade.Model.ItemMagicoEntity;
import com.example.Avitidade.Repository.ItenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class ServiceMagicIten {
    @Autowired
    private ItenRepository repositoryItem;

    public ItemMagicoEntity createItem(ItemMagicoEntity item) {

        item.validarDeforAtak();

        String tipo = item.getTipo().toString().toUpperCase();
        if (!tipo.equals("ARMA") && !tipo.equals("ARMADURA") && !tipo.equals("AMULETO")) {
            throw new IllegalArgumentException("Tipo inválido escolha usar -> ARMA, ARMADURA ou AMULETO.");
        }

        if (tipo.equals("ARMA")) {
            item.setDefIten(0);
        } else if (tipo.equals("ARMADURA")) {
            item.setForcaItem(0);
        }

        if (item.getForcaItem() > 10 || item.getDefIten() > 10) {
            throw new IllegalArgumentException("Força ou Defesa não podem ser maiores que 10.");
        }

        return repositoryItem.save(item);
    }

    @GetMapping
    public Map<String, List<ItemMagicoEntity>> getTasksOrganizedByColumn() {
        List<ItemMagicoEntity> tasks = repositoryItem.findAll();
        return tasks.stream()
                .collect(Collectors.groupingBy(ItemMagicoEntity::getNameItem));
    }
    @PutMapping
    public  ItemMagicoEntity updateItem(Long id, ItemMagicoEntity updateItem) {
        ItemMagicoEntity itemMagicoEntity = repositoryItem.findById(id).orElseThrow(() -> new ServicePersonagem.ResourceNotFoundException("Item Roubado"));
        itemMagicoEntity.setNameItem(updateItem.getNameItem());
        itemMagicoEntity.setDefIten(updateItem.getDefIten());
        itemMagicoEntity.setForcaItem(updateItem.getForcaItem());
        itemMagicoEntity.setTipo(updateItem.getTipo());
        return repositoryItem.save(itemMagicoEntity);
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    public void deleteByIdItem(Long id) {
        repositoryItem.deleteById(id);
    }

    public  List<ItemMagicoEntity> getAllItem() {
        return repositoryItem.findAll();
    }

    public ItemMagicoEntity getByIditen(Long id) {
        return repositoryItem.findById(id)
                .orElseThrow(() -> new RuntimeException("Item mágico não encontrado com o ID: " + id));
    }
}