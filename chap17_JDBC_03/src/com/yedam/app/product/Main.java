package com.yedam.app.product;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Product> list = ProductDAO.getInstance().selectAll();
		for (Product product : list) {
			System.out.println(product);
		}

	}
}
