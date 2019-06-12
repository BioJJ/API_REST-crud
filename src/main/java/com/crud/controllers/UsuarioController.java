package com.crud.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.models.*;

import com.crud.repository.UsuarioRepository;

@RestController
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	//Listar todos
	@GetMapping("/users")
	public List<Usuario> ListarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	//Cadastrar usuario
	@PostMapping("/users")
	public  @ResponseBody ResponseModel salvar( @Valid @RequestBody Usuario usuario) {
		
		try {
			usuarioRepository.save(usuario);
			return new ResponseModel(1,"Registro salvo com sucesso!");
			
		}catch (Exception e) {
			
			return new ResponseModel(0,e.getMessage());	
		}
		
	}
	
	//Atualizar usuario
		@PutMapping("/users/{id}")
		public @ResponseBody ResponseModel atualizar(@Valid @RequestBody Usuario usuario,@PathVariable("id") int codigo){
	 
				
			try {
	 
					this.usuarioRepository.save(usuario);		
				
				return new ResponseModel(1,"Registro atualizado com sucesso!");
				
	 
			}catch(Exception e) {
	 
				return new ResponseModel(0,e.getMessage());
			}
		}
	
	//Buscar por codigo
	@GetMapping("/users/{id}")
	public @ResponseBody Usuario buscar(@PathVariable("id") Integer codigo){
 
		return this.usuarioRepository.findById(codigo);
	}
	
	//Deletar usuario
	@DeleteMapping("/users/{id}")
	public @ResponseBody ResponseModel excluir(@PathVariable("id")  int codigo){
 
		Usuario user = usuarioRepository.findById(codigo);
 
		try {
 
			usuarioRepository.delete(user);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}


}//
