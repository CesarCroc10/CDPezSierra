package com.example.cdpezsierra.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cdpezsierra.modelos.clases.InscripcionClub;

@Repository
public interface IInscripcionClubRepository extends JpaRepository<InscripcionClub,Integer> {

}