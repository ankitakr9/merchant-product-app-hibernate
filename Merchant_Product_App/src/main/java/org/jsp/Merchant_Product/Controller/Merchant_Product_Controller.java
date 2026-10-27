package org.jsp.Merchant_Product.Controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.Merchant_Product.DAO.MerchantDao;
import org.jsp.Merchant_Product.DAO.ProductDao;
import org.jsp.Merchant_Product.DTO.Merchant;
import org.jsp.Merchant_Product.DTO.Product;

public class Merchant_Product_Controller {

	static Scanner sc = new Scanner(System.in);

	static MerchantDao mdao = new MerchantDao();
	static ProductDao pdao = new ProductDao();

	public static void main(String[] args) {

		while (true) {

			System.out.println("1.Save Merchant");
			System.out.println("2.Update Merchant");
			System.out.println("3.Find Merchant by Id");
			System.out.println("4.Find Merchant by Name and Password");
			System.out.println("5.Find Merchant by Product Id");

			System.out.println("6.Add Product");
			System.out.println("7.Update Product");
			System.out.println("8.Find All Product");
			System.out.println("9.Find Product by Merchant name");
			System.out.println("10.Find Product by Merchant gst_num and password");

			System.out.println("11.Exit");
			System.out.println("Enter the Choice.....");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				saveMerchant();
				break;

			case 2:
				updateMerchant();
				break;

			case 3:
				findMerchantById();
				break;

			case 4:
				findMerchantByNameAndPassword();
				break;

			case 5:
				findMerchantByproductId();
				break;

			case 6:
				addProduct();
				break;

			case 7:
				updateProduct();
				break;

			case 8:
				findAllProduct();
				break;

			case 9:
				findProductByMerchantName();
				break;

			case 10:
				findProductByMerchantGstNumAndPassword();
				break;

			case 11:
				System.out.println("Thank youuuu!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice");
			}
		}
	}

	private static void findProductByMerchantGstNumAndPassword() {

		System.out.println("Enter the Merchant gst_num:");
		String gst_num = sc.next();
		System.out.println("Enter the Merchant password:");
		String password = sc.next();
		List<Product> products = pdao.findProductByMerchantGstNumAndPassword(gst_num, password);
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println(p);
			}
		} else {
			System.err.println("No product found");
		}
	}

	private static void findProductByMerchantName() {

		System.out.println("Enter Merchant name:");
		String name = sc.next();
		List<Product> products = pdao.findProductByMerchantName(name);
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println(p);
			}
		} else {
			System.err.println("No product found for this merchant");
		}
	}

	private static void findAllProduct() {

		List<Product> products = pdao.findAllProduct();
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println(p);
			}
		} else {

			System.err.println("No product found");
		}
	}

	private static void updateProduct() {

		System.out.println("Enter the product info...id,name,brand,category,price");

		Product p = new Product();

		p.setId(sc.nextInt());
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setPrice(sc.nextDouble());

		Product pdb = pdao.updateProduct(p);
		if (pdb != null) {
			System.out.println("Product record updated with id: " + pdb.getId());
		} else {
			System.err.println("No record update since id is invalid");
		}
	}

	private static void addProduct() {

		System.out.println("Enter the Merchant id:");
		int mid = sc.nextInt();
		System.out.println("Enter the product info..name,brand,category,price");
		Product p = new Product();

		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setPrice(sc.nextDouble());

		Product pdb = pdao.addProduct(mid, p);

		if (pdb != null) {
			System.out.println("Product with id " + pdb.getId() + " has been added to the Merchant with id " + mid);

		} else {

			System.err.println("No product is added since merchant id is invalid");
		}
	}

	private static void findMerchantByproductId() {

		System.out.println("Enter the Product id:");
		int pid = sc.nextInt();
		Merchant m = mdao.findMerchantByProductId(pid);
		if (m != null) {
			System.out.println(m);
		} else {
			System.err.println("No merchant found since product id is invalid");
		}
	}

	private static void findMerchantByNameAndPassword() {

		System.out.println("Enter Merchant name:");
		String name = sc.next();
		System.out.println("Enter Merchant password:");
		String password = sc.next();
		Merchant m = mdao.findMerchantByNameAndPassword(name, password);

		if (m != null) {
			System.out.println(m);
		} else {
			System.err.println("No merchant found since name/password is invalid");
		}
	}

	private static void findMerchantById() {

		System.out.println("Enter the id...");
		int mid = sc.nextInt();
		Merchant mdb = mdao.findMerchantById(mid);
		if (mdb != null) {
			System.out.println(mdb);
		} else {
			System.err.println("No record found since id is invalid");
		}
	}

	private static void updateMerchant() {

		System.out.println("Enter the merchant info...id,name,gst_num,email,phone,password");

		Merchant m = new Merchant();

		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setGst_num(sc.next());
		m.setEmail(sc.next());
		m.setPhone(sc.nextLong());
		m.setPassword(sc.next());

		Merchant mdb = mdao.updateMerchant(m);
		if (mdb != null) {
			System.out.println("Merchant record updated with id: " + mdb.getId());

		} else {
			System.err.println("No record update since id is invalid");
		}
	}

	private static void saveMerchant() {
		System.out.println("Enter the Merchant info...name,gst_num,email,phone,password");

		Merchant m = new Merchant();
		m.setName(sc.next());
		m.setGst_num(sc.next());
		m.setEmail(sc.next());
		m.setPhone(sc.nextLong());
		m.setPassword(sc.next());
		Merchant mdb = mdao.saveMerchant(m);

		System.out.println("Merchant has been inserted with id : " + mdb.getId());
	}
}