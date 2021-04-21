package com.jessica.Api.models;

public enum Categoria {
	  MERCEARIA(" MERCEARIA"),
	  CARNES("CARNES"),
	  HIGIENE("HIGIENE"),
	  LATICINIOS("LATICINIOS"),
	  LIMPEZA("LIMPEZA"),
	  CAFEDAMANHA("CAFEDAMANHA");
	  
	  private String categ;
	  
	  
	private Categoria(String categ){
		this.categ = categ;
	}
 
	
	public String getCateg() { 
		return categ;
	}
	

	
}
