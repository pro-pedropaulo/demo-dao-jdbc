import java.sql.*;

public class mostrandoDados {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursobd", "root", "123456");

            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM seller");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " - " + rs.getString("Name") +
                        " - " + rs.getString("Email") + " - " + rs.getDate("BirthDate") +
                        " - " + rs.getDouble("BaseSalary") + " - " + rs.getInt("DepartmentId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
