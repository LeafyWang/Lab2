package h;

import java.sql.Connection;        //数据库连接实例
import java.sql.DriverManager;     //数据库驱动管理类，调用其静态方法getConnection并传入数据库的URL获得数据库连接实例
import java.sql.Statement;         //操作数据库要用到的类，主要用于执行SQL语句
import java.util.ArrayList;
import java.sql.ResultSet;         //数据库查询结果集
import java.sql.SQLException;

public class DB{
	private static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";    //MySQL JDBC驱动字符串
    private static String URL = "jdbc:mysql://fgpzxmboisat.rds.sae.sina.com.cn:10597/bookdb";
    private static Statement stmt;
    private Connection connection = null;
    //数据库Url,用来标识要连接的数据库
	public static void main()
	{
		//connect();
	}

	public void connect()                           //链接数据库
	{
		 try
	        {
	            Class.forName(DRIVER_MYSQL);     //加载JDBC驱动
	            //System.out.println("Driver Load Success.");

	            connection = DriverManager.getConnection(URL,"root","123456");   //创建数据库连接对象
	            stmt = connection.createStatement();       //创建Statement对象
	        } 
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}
	
    public ResultSet query(String sql)                     //sql query
    {
        ResultSet result = null;
        try
        {
            result = stmt.executeQuery(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    
    public ArrayList<Books> findbook(String sql)                     //sql query
    {
        ResultSet result = null;
        ArrayList<Books> bklist = new ArrayList<Books>();
        
        try
        {
            result = stmt.executeQuery(sql);
            while(result.next())
            {
            	Books bk = new Books();
            	bk.setISBN(result.getString(1));
            	bk.setTitle(result.getString(2));
            	bk.setAuthorID(result.getInt(3));
            	bk.setPublisher(result.getString(4));
            	bk.setPDate(result.getDate(5));
            	bk.setPrice(result.getDouble(6));
            	bklist.add(bk);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bklist;
    }
    
    
    public void executeSql(String sql) {
    	try
        {
            stmt.execute(sql);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public ArrayList<Books> findjoin(String sql)
	{
		ResultSet result = null;
		ArrayList<Books> bklist = new ArrayList<Books>();
		
		try
        {
            result = stmt.executeQuery(sql);
            while(result.next())
            {
            	Books bk = new Books();
            	//bk.setAuthorID(result.getInt(1));
            	bk.setName(result.getString(2));
            	bk.setAge(result.getInt(3));
            	bk.setCountry(result.getString(4));
            	bk.setISBN(result.getString(5));
            	bk.setTitle(result.getString(6));
            	bk.setAuthorID(result.getInt(7));
            	bk.setPublisher(result.getString(8));
            	bk.setPDate(result.getDate(9));
            	bk.setPrice(result.getDouble(10));
            	bklist.add(bk);
            }
        } 
		catch (SQLException e)
        {
            e.printStackTrace();
        }
		return bklist;
	}
	
	public void Update(String up)
	{
		try {
			stmt.executeUpdate(up);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int check_id(String id)     //检查新加入图书对应的作者是否存在
	{
		try
        {
            ResultSet result = stmt.executeQuery("select count(*) exist from Author where AuthorID = " + id);
            
            int mes = 0;
            while(result.next())
            {
            	mes = result.getInt(1);
            }
            
            if(mes == 1 )
            {
            	return 1;
            }
            else 
            {
            	return 0;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
		return 0;
	}
	
	public int check_isbn(String isbn)    //检查新加入的书籍的ISBN码是否已经出现过
	{
		try
        {
            ResultSet result = stmt.executeQuery("select count(*) exist from Book where ISBN = \"" + isbn + "\"");
            int mes = 0;
            while(result.next())
            {
            	mes = result.getInt(1);
            }
            
            if(mes == 1 )
            {
            	return 1;
            }
            else 
            {
            	return 0;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
		return 0;
	}
	
	public void close()
	{
		try {
			connection.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ;
	}
}
