package com.gft;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gft.desconto.CalculadoraDescontoPrimeiraFaixa;
import com.gft.desconto.CalculadoraDescontoSegundaFaixa;
import com.gft.desconto.CalculadoraDescontoTerceiraFaixa;
import com.gft.desconto.CalculadoraFaixaDesconto;
import com.gft.desconto.CalculadoraSemDesconto;


public class PedidoTest {

	private Pedido pedido;

	@Before
	public void setup() {
		CalculadoraFaixaDesconto calculadoraFaixaDesconto =
					new CalculadoraDescontoTerceiraFaixa(
							new CalculadoraDescontoSegundaFaixa(
									new CalculadoraDescontoPrimeiraFaixa( 
											new CalculadoraSemDesconto(null))));
		pedido = new Pedido(calculadoraFaixaDesconto);
	}

	protected void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.resumo();
		assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.001);
		assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
	}

	@Test
	public void devePermitirAdicionarUmItemNoPedido() throws Exception {
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
	}

	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	public void deveCalcularResumoParaItemSemDesconto() throws Exception {
		pedido.adicionarItem(new ItemPedido("sabonete", 5.0, 5));
		assertResumoPedido(25.0, 0.0);
	}

	@Test
	public void deveCalcularResumoParaDoisItensSemDesconto() throws Exception {
		pedido.adicionarItem(new ItemPedido("sabonete", 3.0, 3));
		pedido.adicionarItem(new ItemPedido("Pasta dental", 7.0, 3));

		assertResumoPedido(30.0, 0);
	}

	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));

		assertResumoPedido(400.0, 16.0);
	}

	
	@Test
	public void deveAplicarDesconto2aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Oleo", 15.0, 30));
		
		assertResumoPedido(900.0, 54.0);
	}
	
	@Test
	public void deveAplicarDesconto3aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Oleo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Creme", 10.0, 30));
		
		assertResumoPedido(1200.0, 96.0);
	}
	
	
	
	
}
