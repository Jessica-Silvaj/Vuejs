package com.jessica.Api.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jessica.Api.models.Categoria;
import com.jessica.Api.models.Produtos;
import com.jessica.Api.models.Status;


public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
	
//	//Buscar um unico produto a partir do id
//	Produtos findById(long id);
	
	//Buscar um unico produto a partir do nome
		Produtos findByNome(String nome);

    List<Categoria>ListarCateg = Arrays.asList(Categoria.values());
    
    List<Status>Listarstatus = Arrays.asList(Status.values());

	
	


}
