package h;

import java.sql.Date;

public class Books {
	
	public String ISBN;
	public String Title;
	public int AuthorID;
	public String Publisher;
	public Date PDate;
	public double Price;

	public String Name;
	public int Age;
	public String Country;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}


	
	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return Title;
	}

	public int getAuthorID() {
		return AuthorID;
	}

	public String getPublisher() {
		return Publisher;
	}

	public Date getPDate() {
		return PDate;
	}

	public double getPrice() {
		return Price;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public void setPDate(Date pDate) {
		PDate = pDate;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
	

}
