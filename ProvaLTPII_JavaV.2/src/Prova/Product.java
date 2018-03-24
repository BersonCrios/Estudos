package Prova;

/*
 * Guilherme Berson
 * SI - UNITINS
 * 4ºPERÍODO
 * */

public class Product {
	
		/*Atributos da classe Produto*/
		   private int ProductCode;
		   private String ProductName;
		   private float ProductValue;
		   private String DescribeProduct;
		   private int QtdProduct;
	    
		   
		   

	    

	    
	    /*Getters*/
	    public int getCode(){
	    	return ProductCode;
	    }
	    
	    public String getName(){
	    	return ProductName;
	    }
	    
	    public float getValue(){
	    	return ProductValue;
	    }
	    
	    public String getDescribe(){
	    	return DescribeProduct;
	    }
	    
	    public int getQtd(){
	    	return QtdProduct;
	    }
	    
	    
	    
	    /*Setters*/	   	    
	    public void setCode(int codeNew){
	    	this.ProductCode = codeNew;
	    }
	    
	    public void setName(String nameNew){
	    	this.ProductName = nameNew;
	    }
	    
	    public void setValue(float valueNew){
	    	this.ProductValue  = valueNew;
	    } 
	    
	    public void setDescribe(String describeNew){
	    	this.DescribeProduct = describeNew;
	    }
	    public void setQtd(int QtdNew){
	    	this.QtdProduct = QtdNew;
	    }
}
