package com.jessica.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.jessica.Api.models.*;
import com.jessica.Api.repository.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value= "API REST produtos")
@CrossOrigin(origins="*")
public class ProdutoController {

	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produtos> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/Categorias")
	public List<Categoria> listaCategorias(){
		return produtoRepository.ListarCateg;
	}
	
	
	@GetMapping("/Status")
	public List<Status> listaStatus(){
		return produtoRepository.Listarstatus;
	}
	
	// Buscar um produto por nome
	@GetMapping("/produtos/{nome}")
	@ApiOperation(value="Buscar uma produtor pelo nome")
	public Produtos listaProdutosUnico(@PathVariable(value="nome")String nome){
	    return produtoRepository.findByNome(nome);
        }
		
		
	//Criar um dados do produto e salva
	@PostMapping("/produto")
	@ApiOperation(value="Criar um novo produto")
	public Produtos salvaProdutos(@RequestBody Produtos produto){
		return  produtoRepository.save(produto);
	}
	
		
		// Deleta varios Produtos 
	    @DeleteMapping("/produto")
		@ApiOperation(value="Deleta varios produtos")
	   public void deletaProdutos(@RequestBody Produtos produtos){
	   produtoRepository.delete(produtos);
       }
			
	   // Deleta um produto pelo Id 
	   @DeleteMapping("/produto/{id}")
	   @ApiOperation(value="Deleta produtos atraves do Id")
	   public void deletaProdutosId(@PathVariable("id") long id){
	  produtoRepository.deleteById(id);
	  }
	  
	 //Atualizar/ALterar pelo Id
	   @PutMapping("/produto/{id}")
	   @ApiOperation(value="Altera produtos pelo Id")
	   public Produtos atualizarProdutosId(@RequestBody Produtos produtos){
	   return produtoRepository.save(produtos);
	   }
	   
	   
}
