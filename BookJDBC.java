import java.sql.*;
import java.util.Scanner;

public class BookJDBC {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Enter book title:");
            String title = sc.nextLine();

            System.out.println("Enter book author:");
            String author = sc.nextLine();

            System.out.println("Enter book price:");
            double price = sc.nextDouble();

            String insertQuery = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertQuery);

            pst.setString(1, title);
            pst.setString(2, author);
            pst.setDouble(3, price);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Book inserted successfully!");
            }

            String selectQuery = "SELECT * FROM books";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);

            System.out.println("\n--- ALL BOOKS IN DATABASE ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("---------------------------");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
