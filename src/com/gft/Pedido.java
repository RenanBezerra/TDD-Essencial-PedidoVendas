package com.gft;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private double valorTotal = 0.0;
	private double desconto = 0.0;

	private List<ItemPedido> itens = new ArrayList<>();

	public void adicionarItem(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}

	public double valorTotal() {

		 valorTotal = itens.stream()
				 .mapToDouble(itens -> itens.getValorUnitario()*itens.getQuantidade()).sum();
		
		return valorTotal;
	}

	public double desconto() {
		return desconto;
	}

}
