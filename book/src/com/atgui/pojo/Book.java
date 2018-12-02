package com.atgui.pojo;

public class Book {
	private Integer id;
	private String name;
	private double price;
	private String author;
	private int sales;
	private int stock;
	private String imgPath="static/img/default.jpg";
	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param author
	 * @param sales
	 * @param stock
	 * @param imgPath
	 */
	public Book(Integer id, String name, double price, String author, int sales, int stock, String imgPath) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.sales = sales;
		this.stock = stock;
		if(null!=imgPath&&"".equals(imgPath)) {
			this.imgPath = imgPath;
		}
	}
	
	public Book() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		if(null!=imgPath&&"".equals(imgPath)) {
			this.imgPath = imgPath;
		}
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", sales=" + sales
				+ ", stock=" + stock + ", imgPath=" + imgPath + "]";
	}
	

}
