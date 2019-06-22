package com.loja.ejb;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ConfigBean {

	@EJB
	private PedidoService pedidoService;
	
	@EJB
	private FabricanteService fabricanteService;
	
	@EJB
	private PecaService pecaService;

	@PostConstruct
	public void criaDados() {

		pecaService.criaPeca("1234-5678-01", 1, "ABC PART", "PECAQWERTYUIOPASXDCFVGBHNJMKL", new Date());
		pecaService.criaPeca("9876-4321-02", 2, "DEF PART", "PECAQWERTYUIOPASXDCFVGBHNJMKL", new Date());
		pecaService.criaPeca("5456-6789-03", 3, "GHI PART", "PECAQWERTYUIOPASXDCFVGBHNJMKL", new Date());
		pecaService.criaPeca("ABCD-XYZW-FF", 5, "XYZ PART", "PECAQWERTYUIOPASXDCFVGBHNJMKL", new Date());
		pecaService.criaPeca("SDFG-ERTY-BN", 7, "BOM PART", "PECAQWERTYUIOPASXDCFVGBHNJMKL", new Date());

		pecaService.addPecaAPecaPai("SDFG-ERTY-BN", 7, "9876-4321-02", 2);
		pecaService.addPecaAPecaPai("SDFG-ERTY-BN", 7, "5456-6789-03", 3);
		pecaService.addPecaAPecaPai("SDFG-ERTY-BN", 7, "ABCD-XYZW-FF", 5);

		fabricanteService.criaFabricante(100, "WidgetCorp", "111 Main St., Anytown, KY 99999", "Mr. Jones", "888-777-9999");
		fabricanteService.criaFabricante(200, "Gadget, Inc.", "123 State St., Sometown, MI 88888", "Mrs. Smith",
				"866-345-6789");

		pecaService.criaPecaFabricante("1234-5678-01", 1, "PECA1", 100.00, 100);
		pecaService.criaPecaFabricante("9876-4321-02", 2, "PECA2", 10.44, 200);
		pecaService.criaPecaFabricante("5456-6789-03", 3, "PECA3", 76.23, 200);
		pecaService.criaPecaFabricante("ABCD-XYZW-FF", 5, "PECA4", 55.19, 100);
		pecaService.criaPecaFabricante("SDFG-ERTY-BN", 7, "PECA5", 345.87, 100);

		Integer pedido = new Integer(1111);
		pedidoService.criaPedido(pedido, 'P', 10, "333 New Court, New City, CA 90000");
		pedidoService.addItem(pedido, "1234-5678-01", 1, 3);
		pedidoService.addItem(pedido, "9876-4321-02", 2, 5);
		pedidoService.addItem(pedido, "ABCD-XYZW-FF", 5, 7);

		pedido = new Integer(4312);
		pedidoService.criaPedido(pedido, 'P', 0, "333 New Court, New City, CA 90000");
		pedidoService.addItem(pedido, "SDFG-ERTY-BN", 7, 1);
		pedidoService.addItem(pedido, "ABCD-XYZW-FF", 5, 3);
		pedidoService.addItem(pedido, "1234-5678-01", 1, 15);

	}

	@PreDestroy
	public void deleteDados() {

	}

}
