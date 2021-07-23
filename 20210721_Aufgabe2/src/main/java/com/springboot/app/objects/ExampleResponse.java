package com.springboot.app.objects;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExampleResponse {

	public String mostExpensiveProduct;
	public String cheapestProduct;
	public String mostPopularProduct;
	public List<String> germanProducts;
	public List<String> chineseProducts;
	boolean containsFragileProducts;
	
	public JsonArray  JArray;
	public ExampleResponse(JsonArray Produktdata){
		JArray = Produktdata;
	}
	
	/*
	 * Analyze the Json and create the response
	 */
	public JsonObject Analyze() {
		
		JsonObject response = new JsonObject();
		response.addProperty("mostExpensiveProduct", getmostExpensiveProduct());
		response.addProperty("cheapestProduct", getmostCheapesProduct());
		response.addProperty("mostPopularProduct", getmostPopularProduct());
		response.add("germanProducts", getGermanProducts());
		response.add("chineseProducts", getchineseProduct());
		response.addProperty("containsFragileProducts", containsFragileProduct());

		return response ;
	}
	
	/*
	 * @result returns if a fragile element is included 
	 */
	private boolean containsFragileProduct() {
		
		boolean Result = false;
		for (int i = 0; i < JArray.size(); ++i) {
			
			JsonObject rec = JArray.get(i).getAsJsonObject();
			boolean products = rec.get("isFragile").getAsBoolean();
			if(products == true) {
				Result = true;
			}
		}
		return Result;
	}

	/*
	 * @result returns the chinese-products
	 */
	private JsonArray getchineseProduct() {
		
		JsonArray chineseProducts = new JsonArray();
		for (int i = 0; i < JArray.size(); ++i) {
			
			JsonObject rec = JArray.get(i).getAsJsonObject();
			String products = rec.get("countryOfOrigin").getAsString();
			if(products.equals("CN")) {
				chineseProducts.add(rec.get("name").getAsString());
			}
		}
		return chineseProducts;
	}

	/*
	 * @result Returns the german products
	 */
	private JsonArray getGermanProducts() {
		
		JsonArray germanProducts = new JsonArray();
		for (int i = 0; i < JArray.size(); ++i) {
			
			JsonObject rec = JArray.get(i).getAsJsonObject();
			String products = rec.get("countryOfOrigin").getAsString();
			if(products.equals("DE")) {
				germanProducts.add( rec.get("name").getAsString());
			}
		}
		return germanProducts;
	}

	/*
	 * @result returns the most popular product
	 */
	private String getmostPopularProduct() {
	
		String MostPopularProduct = "";
		int timesPurchased = 0;
		for (int i = 0; i < JArray.size(); ++i) {
			
			JsonObject rec = JArray.get(i).getAsJsonObject();
			int purchased = rec.get("timesPurchased").getAsInt();
			if(timesPurchased < purchased) {
				MostPopularProduct = rec.get("name").getAsString();
				timesPurchased = purchased;
			}
		}
		
		return MostPopularProduct;
	}

	/*
	 * @result returns the most expensive product
	 */
	public String getmostExpensiveProduct() {
		
		String MostExpensiveProduct = "";
		double currentPrice = 0;
		for (int i = 0; i < JArray.size(); ++i) {
			
			JsonObject rec = JArray.get(i).getAsJsonObject();
			double price = rec.get("price").getAsDouble();
			if(currentPrice < price) {
				MostExpensiveProduct = rec.get("name").getAsString();
				currentPrice = price;
			}
		}
		
		return MostExpensiveProduct;
	}
	
	/*
	 * @result returns the most cheapest product
	 */
	public String getmostCheapesProduct() {
		
		JsonObject firstJobj = JArray.get(0).getAsJsonObject();
		String MostExpensiveProduct = "";
		double currentPrice = firstJobj.get("price").getAsDouble();
		for (int i = 0; i < JArray.size(); ++i) {
			
			JsonObject rec = JArray.get(i).getAsJsonObject();
			double price = rec.get("price").getAsDouble();
			if(currentPrice > price) {
				MostExpensiveProduct = rec.get("name").getAsString();
				currentPrice = price;
			}
		}
		
		return MostExpensiveProduct;
	}
	
}
