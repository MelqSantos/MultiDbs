package br.com.digisystem.entities.secondary;

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
@Table(name="livro")
public class Livro {

	@Id
	private int codigo;
	
	private String titulo;
	private String autor;
	private String tema;
}
