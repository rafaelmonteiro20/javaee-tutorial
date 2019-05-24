package com.estoque.dao;

import java.util.ArrayList;
import java.util.List;

import com.estoque.model.Item;

public class ItemDao {

	private static final List<Item> ITENS = new ArrayList<>(); 
	
	static {
		ITENS.add(new Item("IP001", "IPhone 6", 10, "Smartphone"));
		ITENS.add(new Item("LV002", "Java 8 na prática", 3, "Livro"));
	}
	
	public List<Item> todos() {
		return ITENS;
	}
	
}
