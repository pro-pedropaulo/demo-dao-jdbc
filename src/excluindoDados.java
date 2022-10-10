import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class excluindoDados {
    public static void main(String[] args) {
        try {

            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursobd", "root", "123456");

            PreparedStatement ps = conexao.prepareStatement("delete from seller " +
                    "where " +
                    "(id = ?)");


            ps.setInt(1, 8);

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
