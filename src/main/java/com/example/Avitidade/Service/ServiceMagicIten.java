package com.example.Avitidade.Service;

import com.example.Avitidade.Model.ItemMagicoEntity;
import com.example.Avitidade.Repository.ItenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class ServiceMagicIten {
    @Autowired
    private ItenRepository repositoryItem;

    public ItemMagicoEntity craeteItem (ItemMagicoEntity itemMagicoEntity){
        itemMagicoEntity.setForcaItem(56);
        itemMagicoEntity.setNameItem("espada");
        itemMagicoEntity.setDefIten(56);
        itemMagicoEntity.setItenTipo("Machado");
        ItemMagicoEntity saveItem =  repositoryItem.save(itemMagicoEntity);
        System.out.println("Item salvo: " + saveItem);
        return saveItem;
    }

    @GetMapping
    public Map<String, List<ItemMagicoEntity>> getTasksOrganizedByColumn() {
        List<ItemMagicoEntity> tasks = repositoryItem.findAll();
        return tasks.stream()
                .collect(Collectors.groupingBy(ItemMagicoEntity::getNameItem));
    }

    public  ItemMagicoEntity updateItem(Long id, ItemMagicoEntity updateItem) {
        ItemMagicoEntity itemMagicoEntity = repositoryItem.findById(id).orElseThrow(() -> new ServicePersonagem.ResourceNotFoundException(""));
        itemMagicoEntity.setNameItem(itemMagicoEntity.getNameItem());
        //personagem.setLIstaitemMagico(updatePersonagem.getLIstaitemMagico());
        itemMagicoEntity.setDefIten(itemMagicoEntity.getDefIten());
        itemMagicoEntity.setForcaItem(itemMagicoEntity.getForcaItem());
        itemMagicoEntity.setItenTipo(itemMagicoEntity.getItenTipo());
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

}
