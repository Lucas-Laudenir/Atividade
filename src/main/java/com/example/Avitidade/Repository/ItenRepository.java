package com.example.Avitidade.Repository;

import com.example.Avitidade.Model.ItemMagicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ItenRepository extends JpaRepository<ItemMagicoEntity, Long> {
}
