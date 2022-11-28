package groupB_quiz_minproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class Quiz {
	
		public static void quiz()
		{
			System.out.println("Wellcome to Quiz");
			String y = "yes";
			String q = "quit";
			int score = 0;
				try {
					Scanner sc1 = new Scanner(System.in);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhay", "root", "Abhay@123");
					String query = "SELECT * FROM test ORDER BY RAND()";
					Statement st = con1.createStatement();
					ResultSet set = st.executeQuery(query);
					int loop = 0;
					
					while(set.next() && loop<10) {
						Scanner sc4 = new Scanner(System.in);
						/*System.out.println("Do you want to solve next question ?(YES/QUIT)");
						String s = sc1.next();*/
						System.out.println("for continue 1 for quit 2");
						int qu = sc4.nextInt();
						if(qu == 1)
						{
							String question = set.getString(2);
							String ans = set.getString(7);
							String op4 = set.getString(6);
							String op3 = set.getString(5);
							String op2 = set.getString(4);
							String op1 = set.getString(3);
							System.out.println(question);
							System.out.println(" 1 } "+op1);
							System.out.println(" 2 } "+op2);
							System.out.println(" 3 } "+op3);
							System.out.println(" 4 } "+op4);
							System.out.println("Enter your answar number : ");
							int output = sc1.nextInt();
							String ans2 = set.getString(output+2);
							if(ans.equals(ans2)) {
								score++;
						  }
						}
						loop++;
					}
					PreparedStatement st3 = con1.prepareStatement("Update studentdetails set score = ? where sr = ? ");
					st3.setInt(1, score);
					st3.setInt(2, id);
					int v2 = st3.executeUpdate();
					con1.close();
					if(score >= 8 && score <= 10)
					{
						System.out.println("Your Score is "+score+" And grade is *A Class*");
					}
					if(score >= 6 && score < 8)
					{
						System.out.println("Your Score is "+score+" And grade is *B Class*");
					}
					if(score == 5 )
					{
						System.out.println("Your Score is "+score+" And grade is *C Class*");
					}
					else {
						System.out.println("Your Score is "+score+" And grade is *Fail*");
					}
					}catch(Exception e) {
						System.out.println(e);
					}
		}
		public static void rank()
		{
			try {
				Scanner sc = new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhay", "root", "Abhay@123");
				String dec = "select * from studentdetails order by score desc";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(dec);
				int i = 1;
				System.out.println("Enter your ID: ");
				int id = sc.nextInt();
				while(rs.next())
				{
					int id2 = rs.getInt(1);
					if(id == id2)
					{
						System.out.println("your score is "+rs.getInt(3)+" And Rank is : "+i);
					}
					i++;
				}
				
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		public static void Score()
		{
			try {
				Scanner sc = new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhay", "root", "Abhay@123");
				String dec = "select * from studentdetails order by score desc";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(dec);
				int i = 1;
				int id = sc.nextInt();
				while(rs.next())
				{
					int id2 = rs.getInt(1);
					System.out.println("Your ID is: "+id2+" And score is "+rs.getInt(3)+" And Rank is : "+i);
					i++;
				}
				
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		public static void ques()
		{
			try {
				Scanner sc = new Scanner(System.in);
				Scanner sc1 = new Scanner(System.in);
				Scanner sc2 = new Scanner(System.in);
				Scanner sc3 = new Scanner(System.in);
				Scanner sc4 = new Scanner(System.in);
				Scanner sc5 = new Scanner(System.in);
				Scanner sc6 = new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhay", "root", "Abhay@123");

				// create the sql statement
				PreparedStatement ps =  con.prepareStatement("Insert into test(qno,question,A,B,C,D,answer) values(?,?,?,?,?,?,?)");
				
				System.out.print("Enter the sr no: ");
				int sr = sc.nextInt();
				System.out.println("Enter Question: ");
				String s1 = sc1.nextLine();
				System.out.println("option A: ");
				String s2 = sc2.nextLine();
				System.out.println("option B: ");
				String s3 = sc3.next();
				System.out.println("option C: ");
				String s4 = sc4.nextLine();
				System.out.println("option D: ");
				String s5 = sc5.nextLine();
				System.out.println("Answer: ");
				String s6 = sc6.nextLine();
				ps.setInt(1, sr);
				ps.setString(2, s1);
				ps.setString(3, s2);
				ps.setString(4, s3);
				ps.setString(5, s4);
				ps.setString(6, s5);
				ps.setString(7, s6);
				int i = ps.executeUpdate();
				System.out.println("Insertion successfully...");

				// close the resources.
				con.close();
				ps.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		public static void Yscore()
		{
			try {
				Scanner sc = new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhay", "root", "Abhay@123");
				System.out.println("For check the score Enter the following Details: ");
				System.out.println("Enter Youer ID: ");
				int id = sc.nextInt();
				System.out.println("Enter youer Name");
				String name = sc.next();
				String qurii = "select * from studentdetails where sr=? and name=?";
				PreparedStatement ps = con.prepareStatement(qurii);
				ps.setInt(1, id);
				ps.setString(2, name);
				ResultSet rs = ps.executeQuery();
				rs.next();
				System.out.println("Your Score is : "+rs.getInt(3));
				con.close();
				ps.close();
				rs.close();
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		static int id;
		public static void main(String[] args) {
			Quiz s = new Quiz();
			Scanner sc = new Scanner(System.in);
			int	in = 1;
			 while(in == 1 || in == 2)
			 {
				 System.out.println("you want to login press 1 and for signup press 2 and 3 for EXIT");
				 int ni = sc.nextInt();
				 in = ni;
				 if(in==1)
				 {
				 Scanner sc2 = new Scanner(System.in);
				 System.out.println("Enter name: ");
				 String name = sc.next();
				 System.out.println("Enter ID: ");
				 id = sc.nextInt();
				 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhay", "root", "Abhay@123");
					String qri = "select * from studentdetails where sr = ?";
					PreparedStatement ps = con.prepareStatement(qri);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					rs.next();
					int id2 = rs.getInt(1);
					String name2 = rs.getString(2);
					if(id==id2 && name.equalsIgnoreCase(name2))
					{
						int ch;
						Scanner sc3 = new Scanner(System.in); 
						System.out.println("You have log in successfully.....");
						
						System.out.println(" 1 } for start test ");
						System.out.println(" 2 } for see rank ");
						System.out.println(" 3 } for see your score");
						System.out.println(" 4 } for see all scores");
						System.out.println(" 5 } for Entring question");
						System.out.println("Enter the choice as follows:  ");
						ch = sc3.nextInt();
						switch(ch)
						{
							case 1:
									s.quiz();
									break;
							case 2:
									s.rank();
									break;
							case 3:
									s.Yscore();
									break;
							case 4:
									s.Score();
									break;
							case 5:
									s.ques();
									break;
								
						}
						
					}
					else
					{
						System.out.println("ID is invalid");
					}
					con.close();
					ps.close();
					
				 }catch(Exception e)
				 {
					 System.out.println(e);
				 }
			 }else if(in==2)
			 {
				 Scanner sc2 = new Scanner(System.in);
				 System.out.println("Enter your name: ");
				 String name = sc2.nextLine();
				 System.out.println("Enter your id: ");
				 int id = sc.nextInt();
				 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhay", "root", "Abhay@123");
					String str = "insert into studentdetails(sr,name)values(?,?)";
					PreparedStatement ps = con.prepareStatement(str);
					ps.setInt(1, id);
					ps.setString(2, name.toLowerCase());
					int i = ps.executeUpdate();
					System.out.println(" ID and NAME inserted ");
					con.close();
					ps.close();
					
				 }
				 catch(Exception e)
				 {
					 System.out.println(e);
				 }
				 
			 }
		
			 }

		}

	}




