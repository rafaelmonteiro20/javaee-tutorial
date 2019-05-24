package com.estoque;

import java.util.List;

import javax.jws.WebService;

import com.estoque.dao.ItemDao;
import com.estoque.model.Item;

@WebService
public class EstoqueWS {

	private ItemDao itemDao = new ItemDao();
	
	public List<Item> getItens() {
		return itemDao.todos();
	}
	
}
