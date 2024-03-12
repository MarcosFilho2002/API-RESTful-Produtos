package com.example.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.primeiroexemplo.model.Produto;
import com.example.primeiroexemplo.model.exception.ResourceNotFoundException;

//Simulando banco de dados!!!
@Repository
public class ProdutoRepository_old {
    
    private List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de produtos.
     * @return Lista de Produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }


    /**
     * Método para adicionar produto na lista.
     * @param produto que será adicionado.
     * @return produto adicionado na lista.
     */    
    public Produto adicionar(Produto produto){
        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Método para deletar um produto por Id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        Optional<Produto> produtoEncontrado = obterPorId(id);
        if (produtoEncontrado == null || produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado");
        } else {
            produtos.removeIf(produto -> produto.getId() == id);
        }
       
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return produto que foi atualizado.
     */
    public Produto atualizar(Produto produto){
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        deletar(produto.getId());

        produtos.add(produto);

        return produto;
    }

}
