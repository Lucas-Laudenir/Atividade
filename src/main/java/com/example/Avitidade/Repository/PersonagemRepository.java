package com.example.Avitidade.Repository;

import com.example.Avitidade.Model.PersonagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<PersonagemEntity, Long> {
}
