package com.example.primeiroexemplo.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.example.primeiroexemplo.service.ProdutoService;
import com.example.primeiroexemplo.shared.ProdutoDTO;
import com.example.primeiroexemplo.view.controller.ProdutoController;
import com.example.primeiroexemplo.view.model.ProdutoRequest;

@ExtendWith(MockitoExtension.class)
class ProdutoControllerTest {
	
	@InjectMocks
	ProdutoController produtoController;
	
	@Mock
	ProdutoService produtoService;

	@Test
	void obterTodosTest() {
		List<ProdutoDTO> dto = new ArrayList<>();
		when(produtoService.obterTodos()).thenReturn(dto);
		assertDoesNotThrow(() -> produtoController.obterTodos());
	}
	
	@Test
	void obterPorId() {
		ProdutoDTO dto = new ProdutoDTO();
		Optional<ProdutoDTO> produtoDTO = Optional.of(dto);
		produtoDTO.get().setId(1);
		produtoDTO.get().setNome("");
		produtoDTO.get().setObservacao("");
		produtoDTO.get().setQuantidade(30);
		produtoDTO.get().setValor(1.0);
		when(produtoService.obterPorId(any())).thenReturn(produtoDTO);
		assertDoesNotThrow(() -> produtoController.obterPorId(any()));
	}
	
	@Test
	void adicionarTest() {
		ProdutoRequest produtoRequest = new ProdutoRequest();
		ProdutoDTO dto = new ProdutoDTO();
		dto.setId(1);
		dto.setNome("");
		dto.setQuantidade(30);
		dto.setValor(2.0);
		dto.setObservacao("");
		when(produtoService.adicionar(any())).thenReturn(dto);
		assertDoesNotThrow(() -> produtoController.adicionar(produtoRequest));
	}
	
	@Test
	void deletarTest() {
		assertDoesNotThrow(() -> produtoController.deletar(any()));
	}
	
	@Test
	void atualizarTest() {
		ProdutoRequest produtoRequest = new ProdutoRequest();
		ProdutoDTO dto = new ProdutoDTO();
		when(produtoService.atualizar(any(), any())).thenReturn(dto);
		assertDoesNotThrow(() -> produtoController.atualizar(produtoRequest, eq(any())));
	}
	
}
