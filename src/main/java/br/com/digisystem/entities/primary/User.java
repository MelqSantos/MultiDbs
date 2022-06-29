package br.com.digisystem.entities.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class User {
	
	@Id
	private int codigo;
	
	private String nome;
	private String email;
	private String senha;
}
