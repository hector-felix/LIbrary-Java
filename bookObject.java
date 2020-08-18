
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class bookObject<E> {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
 /*
 * @author: Hector Felix
 * @Date: 2/21/19
 */

    private int year;
    private int pages;
    private String subject;
    private String name;
    private double rating;
    DecimalFormat df = new DecimalFormat("#.##");
    
    public bookObject() {
        this.name = "";
        this.year = 0;
        this.pages = 0;
        this.rating = 0.0;
        this.subject = "";
    }
    
    public bookObject(String name, int year, int pages, double rating, String subject) {
        this.name = name;
        this.year = year;
        this.pages = pages;
        this.rating = rating;
        this.subject = subject;
    }
    
    public void setName(String name) {
        this.name = name;  
    }

    public String getName() {
        return name;        
    }
    
    public int randomYear() {        
        return (int) (Math.random() * ((2019 - 1980) + 0)) + 1980;
    }

    public int getYear() {        
        return year;
    }
    
    public void setYear(int year) {        
        this.year = year;
    }
    
    public int randomPages() {
        return (int) (Math.random() * ((1000 - 50) + 0)) + 50;
    }

    public void setPages(int pages) {        
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setSubject(String subject) {        
        this.subject = subject;
    }

    public String getSubject() {        
        return subject;
    }
    
    public double randomRating() {
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format(((Math.random() * ((10.0 - 0.1) + 0)) + .1)));
    }

    public void setRating(double rating) {        
        this.rating = rating;
    }

    public double getRating() {        
        return rating;
    }
    

//    //We will override toString
//    @Override
    public String toString() {
        
        String s = "";
        
        s = ("Name: " + this.name + " | Year: " + this.year
                + " | Subject: " + this.subject + " | Rating: " + this.rating
                + " | Pages: " + this.pages);

        return s;
    }
}
