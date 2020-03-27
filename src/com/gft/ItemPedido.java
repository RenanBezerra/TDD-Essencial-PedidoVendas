package com.gft;

public class ItemPedido {
	private String string;
	private double valorUnitario;
	private int quantidade;

	public ItemPedido(String string, double valorUnitario, int quantidade) {
		this.string = string;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}