package h;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class Search extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String AthrNmS; //author's name for searching…
	
	private String ISt;     //input
	private String Tit;     //input
	private String Aut;     //input
	private String Pst;     //input
	private String Pdt;     //input
	private String Prt;     //input
	
	private String AName;
	private String AAge;
	private String ACountry;

	private ArrayList<Books> srst = new ArrayList<Books>();
	private ArrayList<Books> srst1 = new ArrayList<Books>();
	public String Isb;
	
	public String Dsb;
	
	public String Prompt = null;
	
	public String getPrompt() {
		return Prompt;
	}

	public String getDsb() {
		return Dsb;
	}
	public void setDsb(String Dsb) {
		this.Dsb = Dsb;
	}
	public String getIsb() {
		return Isb;
	}
	public void setIsb(String Isb) {
		this.Isb = Isb;
	}

	public ArrayList<Books> getSrst1() {
		return srst1;
	}
	public void setSrst1(ArrayList<Books> srst1) {
		this.srst1 = srst1;
	}
	public ArrayList<Books> getSrst() {
		return srst;
	}
	public void setSrst(ArrayList<Books> srst) {
		this.srst = srst;
	}
	public String getAName() {
		return AName;
	}
	public void setAName(String AName) {
		this.AName = AName;
	}

	public String getAAge() {
		return AAge;
	}
	public void setAAge(String AAge) {
		this.AAge = AAge;
	}

	public String getACountry() {
		return ACountry;
	}
	public void setACountry(String ACountry) {
		this.ACountry = ACountry;
	}

	public String getISt() {
		return ISt;
	}
	public void setISt(String ISt) {
		this.ISt = ISt;
	}

	public String getTit() {
		return Tit;
	}
	public void setTit(String Tit) {
		this.Tit = Tit;
	}

	public String getAut() {
		return Aut;
	}
	public void setAut(String Aut) {
		this.Aut = Aut;
	}

	public String getPst() {
		return Pst;
	}
	public void setPst(String Pst) {
		this.Pst = Pst;
	}

	public String getPdt() {
		return Pdt;
	}
	public void setPdt(String Pdt) {
		this.Pdt = Pdt;
	}

	public String getPrt() {
		return Prt;
	}
	public void setPrt(String Prt) {
		this.Prt = Prt;
	}
	
	//@RequiredStringValidator(message = "Please input a name",trim = true)
	public String getAthrNms() {
		return AthrNmS;
	}
	public void setAthrNmS(String AthrNmS) {
		this.AthrNmS = AthrNmS;
	}
	public String ADDin()      //新增一本书
	{
		DB db1 = new DB();
		db1.connect();
		int bookex = db1.check_isbn(ISt);
		if(bookex==1)
		{
			Prompt = "You can't add this book! A book which has the same ISBN is alredy existed!";
			return SUCCESS;
		}
		int exist = db1.check_id(Aut);
		if(exist == 0)
		{
			String ins = "insert Author value(" + Aut + ",null,null,null)";
			db1.executeSql(ins);
		}
		
		String sql = "insert Book value(" + "\"" + ISt + "\",\"" + Tit + "\"," + Aut + ",\"" + Pst + "\"," + Pdt +"," + Prt +")"; 
		db1.executeSql(sql);
		db1.close();
		
		if(exist == 0)
		{
			return "input";
		}
		else
		{
			Prompt = "Successful update!";
			return SUCCESS;	
		}
	}
	public String execute()    
	{
		Prompt = "Welcome!";
		return SUCCESS;
	}
	public String SearchA()
	{
		DB db1 = new DB();
		db1.connect();
		String sql="select * from Author a join Book b where a.AuthorID = b.AuthorID and a.Name = '" + AthrNmS + "'";
		srst = db1.findjoin(sql);
		return SUCCESS;
	}
	
	public String Delis()
	{
		DB db1 = new DB();
		db1.connect();
		String temp = "delete from Book where ISBN = " + "\"" + Dsb + "\"";
		db1.executeSql(temp);
		db1.close();
		return SUCCESS;
	}
	
	public String FindBook()
	{
		DB db1 = new DB();
		db1.connect();
		String temp = "select * from Book where ISBN=\""+ Dsb + "\"";
		srst = db1.findbook(temp);
		db1.close();
		return SUCCESS;
	}
	
	public String ADDAu()           //更新作者信息
	{
		DB db1 = new DB();
		db1.connect();
		String temp = "update Author set Name = '" + AName + "' where AuthorID =" + Aut;
		db1.executeSql(temp);
		temp = "update Author set Age = " + AAge + " where AuthorID =" + Aut;
		db1.executeSql(temp);
		temp = "update Author set Country = '" + ACountry + "' where AuthorID =" + Aut;
		db1.executeSql(temp);
		db1.close();
		Prompt = "The author has been added to the database with his book!";
		return SUCCESS;
	}
	
	public String UpBook()           //更新图书信息
	{
		DB db1 = new DB();
		db1.connect();
		
		int exist = db1.check_id(Aut);
		if(exist == 0)
		{
			String ins = "insert Author value(" + Aut + ",null,null,null)";
			db1.executeSql(ins);
		}
		
		String temp = "update Book set AuthorID = " + Aut + " where ISBN ='" + ISt + "'";
		db1.executeSql(temp);
		temp = "update Book set Publisher = '" + Pst + "' where ISBN ='" + ISt + "'";
		db1.executeSql(temp);
		temp = "update Book set PublishDate = " + Pdt + " where ISBN ='" + ISt + "'";
		db1.executeSql(temp);
		temp = "update Book set Price = " + Prt + " where ISBN ='" + ISt + "'";
		db1.executeSql(temp);
		db1.close();
		
		if(exist == 0)
		{
			return "input";
		}
		else
		{
			Prompt = "Updated Successfully!";
			return SUCCESS;	
		}
	}
	
	public String SISBN()
	{
		DB db1 = new DB();
		db1.connect();
		String temp = "select * from Author a JOIN Book b where b.AuthorID = a.AuthorID and b.ISBN = " + "\"" + Isb + "\"";
		srst1 = db1.findjoin(temp);
		db1.close();
		return SUCCESS;
	}


}
