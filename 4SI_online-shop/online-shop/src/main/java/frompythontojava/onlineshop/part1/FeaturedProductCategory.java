package frompythontojava.onlineshop.part1;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class FeaturedProductCategory extends ProductCategory{
    Date expirationDate;

    public FeaturedProductCategory(String name, String expdate) throws ParseException {
        super(name);
        this.expirationDate = changeStringToDate(expdate);
    }

    private Date changeStringToDate(String date) throws ParseException {
        
        Date expdate = new SimpleDateFormat("yyyy.MM.dd").parse(date);
        
        return expdate;
        
    }

    public String toString() {
        return this.getName() + ": " + "ExpirationDate: " +  new SimpleDateFormat("yyyy.MM.dd").format(this.expirationDate) + " ";
    }

}