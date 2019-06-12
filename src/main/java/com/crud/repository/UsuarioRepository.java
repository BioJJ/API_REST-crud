package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(Integer id);
}
