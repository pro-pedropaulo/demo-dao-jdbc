import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class inserindoDados {
    public static void main(String[] args) {
        try {
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursobd", "root", "123456");

            PreparedStatement ps = conexao.prepareStatement("Insert into seller " +
                    "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                    "values " +
                    "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, "Maria Silva");
            ps.setString(2, "msilva@gmail.com");
            ps.setDate(3, new java.sql.Date(dataFormatada.parse("16/03/1979").getTime()));
            ps.setDouble(4, 2400.50);
            ps.setInt(5, 3);

           int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Pronto! Id = " + id);
                }
            } else {
                System.out.println("Nenhuma linha foi afetada");
            }

            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
