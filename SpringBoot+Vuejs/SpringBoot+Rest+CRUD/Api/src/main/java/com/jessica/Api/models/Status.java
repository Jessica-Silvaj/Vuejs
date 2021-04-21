package com.jessica.Api.models;

public enum Status {
	   PENDENTE("PEDENTE"),
	   EMESTOQUE("EMESTOQUE"),
	   SEMESTOQUE("SEMESTOQUE"),
	   BAIXOESTOQUE("BAIXOESTOQUE");
	   
	  private String statu;
	  
	  
		private Status(String statu){
			this.statu = statu;
		}
	 
		
		public String getStatu() {
			return statu;
		}
		
		
	   

}
