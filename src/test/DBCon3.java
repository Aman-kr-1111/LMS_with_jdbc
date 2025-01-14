package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBCon3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try (sc;) {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADVJAVA", "ADVJAVA");
			PreparedStatement ps1 = con.prepareStatement("INSERT INTO BOOKDETAILS52 VALUES(?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("SELECT * FROM BOOKDETAILS52");
			PreparedStatement ps3 = con.prepareStatement("SELECT * FROM BOOKDETAILS52 WHERE BCODE = ?");
			PreparedStatement ps4 = con.prepareStatement("UPDATE BOOKDETAILS52 SET BPRICE=?,BQTY=BQTY+? WHERE BCODE=?");
			PreparedStatement ps5 = con.prepareStatement("DELETE FROM BOOKDETAILS52 WHERE BCODE=?");

			while (true) {
				System.out.println("***** Choice *****");
				System.out.println("\t1.AddBookDetails" + "\n\t2.ViewAllBookDetails" + "\n\t3.ViewBookByCode"
						+ "\n\t4.UpdateBookByBookCode(Price/Qty)" + "\n\t5.DeleteBookByCode" + "\n\t6.Exit");
				System.out.print("Enter choice: ");
				int ch = Integer.parseInt(sc.nextLine());
				switch (ch) {
				case 1:
					System.out.print("Enter the BookCode: ");
					String bCode = sc.nextLine();
					System.out.print("Enter the BookName: ");
					String bName = sc.nextLine();
					System.out.print("Enter the BookAuthor: ");
					String bAuthor = sc.nextLine();
					System.out.print("Enter the BookPrice: ");
					float bPrice = Float.parseFloat(sc.nextLine());
					System.out.print("Enter the BookQty: ");
					int bQty = Integer.parseInt(sc.nextLine());

					// Setting data to ps1-object
					ps1.setString(1, bCode);
					ps1.setString(2, bName);
					ps1.setString(3, bAuthor);
					ps1.setFloat(4, bPrice);
					ps1.setInt(5, bQty);

					int k1 = ps1.executeUpdate();
					if (k1 > 0) {
						System.out.println("BookDetails inserted Successfully...");
					}
					break;
				case 2:
					ResultSet rs1 = ps2.executeQuery();
					System.out.println("\n***** Book-Details *****");
					while (rs1.next()) {
						System.out.println(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
								+ rs1.getFloat(4) + "\t" + rs1.getInt(5));
					}
					System.out.println();
					break;
				case 3:
					System.out.print("Enter the BookCode: ");
					String code1 = sc.nextLine();
					ps3.setString(1, code1);

					ResultSet rs2 = ps3.executeQuery();
					if (rs2.next()) {
						System.out.println("\n***** Book-Details *****");
						System.out.println(rs2.getString(1) + "\t" + rs2.getString(2) + "\t" + rs2.getString(3) + "\t"
								+ rs2.getFloat(4) + "\t" + rs2.getInt(5) + "\n");
					} else {
						System.out.println("Invalid BookCode...");
					}
					break;
				case 4:
					System.out.print("Enter the BookCode: ");
					String code2 = sc.nextLine();
					ps3.setString(1, code2);

					ResultSet rs3 = ps3.executeQuery();
					if (rs3.next()) {
						System.out.println("Old Book Price: " + rs3.getFloat(4));
						System.out.print("Enter new Book Price: ");
						float nPrice = Float.parseFloat(sc.nextLine());

						System.out.println("Old Book Qty: " + rs3.getInt(5));
						System.out.print("Enter new Book Qty: ");
						int nQty = Integer.parseInt(sc.nextLine());

						ps4.setFloat(1, nPrice);
						ps4.setInt(2, nQty);
						ps4.setString(3, code2);

						int k2 = ps4.executeUpdate();
						if (k2 > 0) {
							System.out.println("Book price and qty updated...");
						}
					} else {
						System.out.println("Invalid BookCode...");
					}
					break;
				case 5:
					System.out.print("Enter the BookCode: ");
					String code3 = sc.nextLine();
					ps3.setString(1, code3);

					ResultSet rs4 = ps3.executeQuery();
					if (rs4.next()) {
						ps5.setString(1, code3);
						int k3 = ps5.executeUpdate();

						if (k3 > 0) {
							System.out.println("BookDetails deleted successfully...");
						}
					} else {
						System.out.println("Invalid BookCode...");
					}
					break;
				case 6:
					System.out.println("Operation on DB Stopped...");
					System.exit(0);
				default:
					System.out.println("Invalid choice...");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
