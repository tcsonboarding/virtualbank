package com.example.demo.Model;

public class ExternalizedEnums {
	public enum AccountType{
		CHECKING, SAVINGS;
	}

    public enum CustomerType {
    	CONSUMER, BUSINESS
	}

	enum IdType{
		DL, //Driving License
		PP, //Passport
		GC  //Green Card
	}
    
    enum StateSymbol{
    	AL ("Alabama"),
    	AK ("Alaska"),
    	AZ ("Arizona"),
    	AR ("Arkansas"),
    	CA ("California"),
    	CO ("Colorado"),
    	CT ("Connecticut"),
    	DE ("Delaware"),
    	FL ("Florida"),
    	GA ("Georgia"),
    	HI ("Hawaii"),
    	ID ("Idaho"),
    	IL ("Illinois"),
    	IN ("Indiana"),
    	IA ("Iowa"),
    	KS ("Kansas"),
    	KY ("Kentucky"),
    	LA ("Louisiana"),
    	ME ("Maine"),
    	MD ("Maryland"),
    	MA ("Massachusetts"),
    	MI ("Michigan"),
    	MN ("Minnesota"),
    	MS ("Mississippi"),
    	MO ("Missouri"),
    	MT ("Montana"),
    	NE ("Nebraska"),
    	NV ("Nevada"),
    	NH ("New Hampshire"),
    	NJ ("New Jersey"),
    	NM ("New Mexico"),
    	NY ("New York"),
    	NC ("North Carolina"),
    	ND ("North Dakota"),
    	OH ("Ohio"),
    	OK ("Oklahoma"),
    	OR ("Oregon"),
    	PA ("Pennsylvania"),
    	RI ("Rhode Island"),
    	SC ("South Carolina"),
    	SD ("South Dakota"),
    	TN ("Tennessee"),
    	TX ("Texas"),
    	UT ("Utah"),
    	VT ("Vermont"),
    	VA ("Virginia"),
    	WA ("Washington"),
    	WV ("West Virginia"),
    	WI ("Wisconsin"),
    	WY ("Wyoming");
    	
    	private final String stateName;
    	
    	StateSymbol(String aStateName){
    		this.stateName = aStateName;
    	}
    	
    	public String getStateName() {
    		return this.stateName;
    	}
    }  
}

