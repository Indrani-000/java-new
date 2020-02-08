package com.epam.week1;

import java.util.*;

import javax.swing.Spring;
 
 public class App{
    private static final int chocoPrice = 0;
	private static final int chocoWeight = 0;
	static 	Scanner input = new Scanner(System.in);
    static ArrayList<Chocolate> chocolates1=new ArrayList<Chocolate>();  
    static ArrayList<Chocolate> candies =new ArrayList<Chocolate>();
    static ArrayList<Sweet> sweets=new ArrayList<Sweet>();
    static HashMap<String,Integer> nameToWeight =new HashMap<String,Integer>();
    static HashMap<String,Integer> nameToPrice =new HashMap<String,Integer>();
	private static int ChocolateType;
    
    public static void main(String[]args) {
    	inputChocolates1();
    	inputSweets1();
    	
    	System.out.println("Total weight of the gift is:"+ calcTotalWeight1());
    	System.out.println("Choose the way to sort(enter the number):1. By Price 2. By Weight");
    	int sortType=input.nextInt();
    	if (sortType ==1) {
    		Comparator<Chocolate>comparaByPrice=(Chocolate c1, Chocolate c2) -> ((Integer)c1.getprice())
    		.compareTo(c2.getprice());
    		Collections.sort(chocolates1,comparaByPrice);
    		}else {
    			Comparator<Chocolate>comparaByWeight=(Chocolate c1, Chocolate c2) -> ((Integer)c1.getweight())
    			.compareTo(c2.getweight());
        		Collections.sort(chocolates1,comparaByWeight);	
    		}
    	System.out.println("The sorted result:");
    	for (Chocolate chocolate: chocolates1) {
    		System.out.println(chocolate.getprice());
    	}
    	calcRange1(sortType);
    	}
    public static void inputchocolates1(String candyName) {
    	System.out.println("Enter the number of chocolates is gifted:\n");
    	int numberOfchocolates1 = input.nextInt();
    	for ( int chocoCount=1 ; chocoCount <= numberOfchocolates1; chocoCount++)
    	{ 
    		System.out.println("Enter the chocolate type(enter the number):1. Candy 2. Kitkat");
    	int chocolateType=input.nextInt();
    		System.out.println("enter the weight of the chocolate");
    		int chocoWeight= input.nextInt();
    		if (chocolateType==1)
    		{
    			System.out.println("enter the name of candy");
    			String candyName1=input.next();
    			if(nameToWeight.containsKey(candyName1))
    			{
    				nameToWeight.put(candyName1,(int)nameToWeight.get(candyName1)+chocoWeight);
    			}
    			else
    			{
    				nameToWeight.put(candyName,chocoWeight);
    			}
    			if(nameToPrice.containsKey(candyName))
    			{
    				nameToPrice.put(candyName,(int)nameToWeight.get(candyName)+ chocoPrice);
    		    }
    		
    			else
    			{
    				nameToPrice.put(candyName,chocoPrice);
    			}
    		}
    		Chocolate choco = new Chocolate(chocoWeight,chocoPrice);
    		Chocolate.add(choco);
    		
    		if(ChocolateType==1)
    		{
    			candies.add(choco);
    		}
    	}
    }    
    public static void inputSweets1() {
    	System.out.println("enter the number of sweets in gift: \n");
    	int numberOfsweets = input.nextInt();
    	for ( int sweetCount=1 ; sweetCount <= numberOfsweets; sweetCount++)
    	{ 
    		//System.out.println("Enter the chocolate type(enter the number):1. Candy 2. Kitkat");
        	System.out.println("enter the weight of the sweet");
    		int sweetWeight=input.nextInt();
        		System.out.println("enter the price of the sweet");
        		int sweetPrice= input.nextInt();
        		Sweet sweet = new Sweet(sweetWeight,sweetPrice);
        		sweets.add(sweet);
    		}
    }
    public static int calcTotalWeight1() {
    	int totalWeight=0;
    	for(Chocolate choco: chocolates1) {
    		totalWeight +=choco.getweight();
    	}
    	for(Sweet sweet:sweets) {
    		
    	}
    	return totalWeight;
        }
    
    public static void calcRange1(int sortType) {
    	System.out.println("let's find the range:");
    	int lowerLimit, higherLimit;
    	if(sortType==1) {
    		System.out.println("enter the lowerlimit of the price:");
    		lowerLimit= input.nextInt();
    		System.out.println("enter the higherlimit of the price:");
    		higherLimit= input.nextInt();
    		
    		Set<Map.Entry<String,Integer>> candySet = nameToPrice.entrySet();
    		Iterator<Map.Entry<String,Integer>> candyIterator = candySet.iterator();
    		while(candyIterator.hasNext()) {
    			Map.Entry candyElement= (Map.Entry)candyIterator.next();
    			int currentPrice=(int)candyElement.getValue();
    			if (currentPrice >= lowerLimit && currentPrice<=higherLimit)
    				System.out.println(candyElement.getKey());
    			}
    	}else {
    		System.out.println("enter the lowerlimit of the weight:");
    		lowerLimit= input.nextInt();
    		System.out.println("enter the higherlimit of the weight:");
    		higherLimit= input.nextInt();
    		
    		Set<Map.Entry<String,Integer>> candySet = nameToWeight.entrySet();
    		Iterator<Map.Entry<String,Integer>> candyIterator = candySet.iterator();
    		while(candyIterator.hasNext()) {
    			Map.Entry candyElement= (Map.Entry)candyIterator.next();
    			int currentWeight=(int)candyElement.getValue();
    			if (currentWeight>= lowerLimit && currentWeight<=higherLimit)
    				System.out.println(candyElement.getKey());
               }
    
    }
    
    				
    	 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	private static void calcRange(int sortType) {
		// TODO Auto-generated method stub
		
	}

	private static void inputSweets() {
		// TODO Auto-generated method stub
		
	}

	private static void inputChocolates1() {
		// TODO Auto-generated method stub
		
	}

	private static String calcTotalWeight() {
		// TODO Auto-generated method stub
		return null;
	}
}
