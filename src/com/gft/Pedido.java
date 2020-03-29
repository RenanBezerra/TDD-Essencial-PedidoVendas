package com.gft;

import java.util.ArrayList;
import java.util.List;

import com.gft.desconto.CalculadoraFaixaDesconto;

public class Pedido {

	

	private List<ItemPedido> itens = new ArrayList<>();
	
	private CalculadoraFaixaDesconto calculadoraFaixaDesconto;
	
	public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
		this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
	}

	public void adicionarItem(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}

	public ResumoPedido resumo() {

		double valorTotal = itens.stream().mapToDouble(itens -> itens.getValorUnitario() * itens.getQuantidade()).sum();
		double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
		
		//		double desconto = 0;
//		if (valorTotal > 300.0 && valorTotal < 800.0) {
//			desconto = valorTotal * 0.04;
//		}else if (valorTotal > 800.0 && valorTotal < 1000.0) {
//			desconto = valorTotal * 0.06;
//		}else if (valorTotal > 1000.0) {
//			desconto = valorTotal * 0.08;
//		}

		return new ResumoPedido(valorTotal, desconto);
	}

}
