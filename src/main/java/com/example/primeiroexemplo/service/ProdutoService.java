package com.example.primeiroexemplo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.primeiroexemplo.model.Produto;
import com.example.primeiroexemplo.model.exception.ResourceNotFoundException;
import com.example.primeiroexemplo.repository.ProdutoRepository;
import com.example.primeiroexemplo.shared.ProdutoDTO;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método para retornar uma lista de produtos.
     * @return Lista de Produtos.
     */
    public List<ProdutoDTO> obterTodos(){
    	//retorna uma lista de produto model
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
        		.map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
        		.collect(Collectors.toList());
    }

     /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<ProdutoDTO> obterPorId(Integer id){
    	Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()) {
        	throw new ResourceNotFoundException("Produto não com id "+id+" não encontrado!");
        }
        ProdutoDTO produtoDTO =  new ModelMapper().map(produto.get(), ProdutoDTO.class);
        return Optional.of(produtoDTO);
    }

    /**
     * Método para adicionar produto na lista.
     * @param produto que será adicionado.
     * @return produto adicionado na lista.
     */    
    public ProdutoDTO adicionar(ProdutoDTO produtoDTO){
    	produtoDTO.setId(null);
    	//Criar um objeto de mapeamento
    	ModelMapper mapper = new ModelMapper();
    	//Converter o produtoDTO em um Produto
    	Produto produto =  mapper.map(produtoDTO, Produto.class);
    	//Salvar no banco
    	produto = produtoRepository.save(produto);
    	//Retornar o produtoDTO atualizado
    	produtoDTO.setId(produto.getId());
        return produtoDTO;
    }

    /**
     * Método para deletar um produto por Id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
    	Optional<Produto> produto = produtoRepository.findById(id);
    	if(produto.isEmpty()) {
    		throw new ResourceNotFoundException("Não foi possível deletar o produto com o id: "+id+" - Produto não existe!");
    	}
    	
        produtoRepository.deleteById(id);
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return produto que foi atualizado.
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDTO){
    	produtoDTO.setId(id);
    	
    	ModelMapper mapper = new ModelMapper();
    	
    	Produto produto = mapper.map(produtoDTO, Produto.class);
    	
    	produtoRepository.save(produto);
    	
    	return produtoDTO;
    }

}
