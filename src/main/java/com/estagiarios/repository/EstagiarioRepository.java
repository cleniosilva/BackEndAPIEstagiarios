package com.estagiarios.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.estagiarios.models.Estagiario;

public interface EstagiarioRepository extends JpaRepository<Estagiario, Integer>{

}
