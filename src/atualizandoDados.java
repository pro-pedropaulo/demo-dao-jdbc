import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class atualizandoDados {
    public static void main(String[] args) {
        try {

            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursobd", "root", "123456");

            PreparedStatement ps = conexao.prepareStatement("update seller " +
                    "set BaseSalary = BaseSalary + ? " +
                    "where " +
                    "(name = ?)");


            ps.setDouble(1, 200.0);
            ps.setString(2, "Pedro Paulo");

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Pronto! Linhas afetadas: " + linhasAfetadas);
            } else {
                System.out.println("Nenhuma linha foi afetada");
            }

            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
