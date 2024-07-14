package com.rr.globaldata;

import java.util.ArrayList;
import java.util.List;

import com.rr.model.Product;

public class GlobalData {
	public static List<Product> cart;
	static {
		cart= new ArrayList<Product>();
	}
}
