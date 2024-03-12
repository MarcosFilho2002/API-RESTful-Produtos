package com.example.primeiroexemplo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.primeiroexemplo.model.Produto;
import com.example.primeiroexemplo.model.exception.ResourceNotFoundException;
import com.example.primeiroexemplo.repository.ProdutoRepository;
import com.example.primeiroexemplo.shared.ProdutoDTO;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

	@InjectMocks
	ProdutoService produtoService;
	
	@Mock
	ProdutoRepository produtoRepository;
	
	@Test
	void obterTodosTest() {
		List<Produto> produtos = new ArrayList<>();
		when(produtoRepository.findAll()).thenReturn(produtos);
		assertDoesNotThrow(() -> produtoService.obterTodos());
	}
	
	@Test
	void obterPorIdTest() {
		Produto produto = new Produto();
		Optional<Produto> produtoOptional = Optional.of(produto); 
		when(produtoRepository.findById(any())).thenReturn(produtoOptional);
		assertDoesNotThrow(() -> produtoService.obterPorId(any()));
	}
	
	@Test
	void obterPorIdExceptionTest() {
		Optional<Produto> produtoOptional = Optional.empty(); 
		when(produtoRepository.findById(any())).thenReturn(produtoOptional);
		assertThrows(ResourceNotFoundException.class, () -> produtoService.obterPorId(any()));
	}
	
	@Test
	void adicionatTest() {
		ProdutoDTO produtoDTO =  new ProdutoDTO();
		Produto produto = new Produto();
		when(produtoRepository.save(any())).thenReturn(produto);
		assertDoesNotThrow(() -> produtoService.adicionar(produtoDTO));
	}
	
	@Test
	void deletarTest() {
		Produto produto = new Produto();
		Optional<Produto> produtoOptional = Optional.of(produto);
		when(produtoRepository.findById(any())).thenReturn(produtoOptional);
		assertDoesNotThrow(() -> produtoService.deletar(any()));
	}
	
	@Test
	void deletarExceptionTest() {
		assertThrows(ResourceNotFoundException.class,() -> produtoService.deletar(0));
	}
	
	@Test
	void atualizarTest() {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		assertDoesNotThrow(() -> produtoService.atualizar(any(),produtoDTO));
	}
	
}
