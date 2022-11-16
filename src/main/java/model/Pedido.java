package model;

import java.util.ArrayList;

public class Pedido {
	private int id;
	public ArrayList<ProdutoGenerico> produtoGenerico = new ArrayList<>();
	
	public int getID() {
		return id;
	}
	
	public void setPedido(int id) {
		this.id = id;
	}
}
