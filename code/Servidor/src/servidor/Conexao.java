package servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    String serverName = "localhost";
    String mydatabase = "softwork";
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    String password = "";
    String username = "root";
    Connection conexao;
    

    Conexao() throws SQLException {
        conexao = DriverManager.getConnection(url, username, password);
    }

}
