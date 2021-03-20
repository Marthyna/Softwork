package servidor;

import classesDominio.Aluno;
import classesDominio.Aplicacao;
import classesDominio.Curriculo;
import classesDominio.Empresa;
import classesDominio.Endereco;
import classesDominio.Mensagem;
import classesDominio.Vaga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static servidor.Servidor.st;

public class Servidor {

    public static Conexao con;
    public static Statement st;

    public static void main(String[] args) {
        try {
            con = new Conexao();
            st = con.conexao.createStatement();

            ServerSocket servidor = new ServerSocket(12345);
            while (true) {
                // thread para clientes
                Socket cliente = servidor.accept();
                TrataCliente trataCliente = new TrataCliente(cliente);
            }
        } catch (IOException | SQLException ioe) {
        }
    }

}

class TrataCliente extends Thread {

    Socket cliente;

    public TrataCliente(Socket cliente) {
        this.cliente = cliente;
        this.start();
    }

    public void run() {

        try {

            ObjectOutputStream out = new ObjectOutputStream(this.cliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(this.cliente.getInputStream());

            LinkedList<Vaga> listaVagas = new LinkedList<>();
            LinkedList<Mensagem> listaMensagens = new LinkedList<>();
            LinkedList<Vaga> listaVagasEmEspera = new LinkedList<>();
            LinkedList<Vaga> listaVagasAceitas = new LinkedList<>();
            LinkedList<Vaga> listaVagasRecusadas = new LinkedList<>();
            LinkedList<Aplicacao> listaAplicacoesHistorico = new LinkedList<>();
            LinkedList<Mensagem> listaMensagensAluno = new LinkedList<>();
            LinkedList<Mensagem> listaMensagensEmpresa = new LinkedList<>();
            LinkedList<Vaga> listaVagasAbertasEmpresa = new LinkedList<>();
            LinkedList<Vaga> listaVagasHistoricoEmpresa = new LinkedList<>();
            LinkedList<Aplicacao> listaAplicacoesRecebidas = new LinkedList<>();
            LinkedList<Aplicacao> listaAplicacoesAceitas = new LinkedList<>();
            LinkedList<Aplicacao> listaAplicacoesRecusadasEmpresa = new LinkedList<>();
            LinkedList<Aplicacao> listaAplicacoesPorVaga = new LinkedList<>();
            LinkedList<Vaga> listaVagasPesquisadas = new LinkedList<>();

            String mensagemRecebida = (String) in.readObject();
            String mensagemEnviar = "";

            while (!mensagemRecebida.equals("fim")) {
                switch (mensagemRecebida) {
                    case "cadastraAluno": {
                        out.writeObject("Ok");

                        Aluno meuAluno = (Aluno) in.readObject();

                        Endereco endereco = meuAluno.getEndereco();
                        String rua = endereco.getRua();
                        int numero = endereco.getNumero();
                        String bairro = endereco.getBairro();
                        String cidade = endereco.getCidade();
                        int cep = endereco.getCep();
                        String complemento = "";
                        if (!endereco.getComplemento().equals("")) {
                            complemento = endereco.getComplemento();
                        }

                        String consulta = "SELECT cod_endereco FROM endereco WHERE rua LIKE '" + rua + "' AND numero = " + numero + " AND bairro LIKE '" + bairro + "' AND complemento LIKE '" + complemento + "' AND cep = " + cep + " AND cidade LIKE '" + cidade + "'";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        boolean enderecoCadastrado = false;
                        int cod_endereco = 0;

                        while (rs.next()) {
                            enderecoCadastrado = true;
                            cod_endereco = Integer.parseInt(rs.getString("cod_endereco"));
                        }

                        if (!enderecoCadastrado) {
                            String insert = "INSERT INTO endereco(rua, numero, bairro, complemento, cep, cidade) VALUES ('" + rua + "', " + numero + ", '" + bairro + "', '" + complemento + "', " + cep + ",  '" + cidade + "')";
                            st.executeUpdate(insert);

                            consulta = "SELECT cod_endereco FROM endereco WHERE rua LIKE '" + rua + "' AND numero = " + numero + " AND bairro LIKE '" + bairro + "' AND complemento LIKE '" + complemento + "' AND cep = " + cep + " AND cidade LIKE '" + cidade + "'";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            while (rs.next()) {
                                cod_endereco = Integer.parseInt(rs.getString("cod_endereco"));
                            }
                        }

                        int telefone = meuAluno.getTelefone();
                        int ddd = meuAluno.getDdd();
                        String email = meuAluno.getEmail();

                        consulta = "SELECT Pessoa_cod_pessoa FROM usuario WHERE email LIKE '" + email + "'";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        boolean pessoaCadastrada = false;

                        while (rs.next()) {
                            pessoaCadastrada = true;
                        }

                        if (!pessoaCadastrada) {
                            String insert = "INSERT INTO pessoa(telefone, ddd, Endereco_cod_endereco) VALUES (" + telefone + "," + ddd + "," + cod_endereco + ")";
                            st.executeUpdate(insert);

                            consulta = "SELECT cod_pessoa FROM pessoa WHERE telefone = " + telefone + " AND ddd = " + ddd + " AND Endereco_cod_endereco = " + cod_endereco + " ";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_pessoa = 0;

                            while (rs.next()) {
                                cod_pessoa = Integer.parseInt(rs.getString("cod_pessoa"));
                            }

                            out.writeObject(cod_pessoa);
                            String senhaCriptografada = (String) in.readObject();

                            insert = "INSERT INTO usuario(email, senha, Pessoa_cod_pessoa) VALUES ('" + email + "','" + senhaCriptografada + "'," + cod_pessoa + ")";
                            st.executeUpdate(insert);

                            long matricula = meuAluno.getMatricula();
                            int ano = meuAluno.getAno();
                            String curso = meuAluno.getCurso();
                            int turno = meuAluno.getTurno();
                            String turnoliteral = meuAluno.getTurnoLiteral();
                            String nomeCompleto = meuAluno.getNomeCompleto();
                            int sexo = meuAluno.getSexo();
                            String sexoLiteral = meuAluno.getSexoLiteral();
                            long cpf = meuAluno.getCpf();
                            long rg = meuAluno.getRg();
                            LocalDate dataNascimento = meuAluno.getDataNascimento();
                            Curriculo curriculo = meuAluno.getCurriculo();

                            consulta = "SELECT cod_aluno FROM aluno WHERE matricula = " + matricula + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            boolean matriculaCadastrada = false;

                            while (rs.next()) {
                                matriculaCadastrada = true;
                            }

                            if (!matriculaCadastrada) {
                                consulta = "SELECT cod_aluno FROM aluno WHERE rg = " + rg + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                boolean rgCadastrado = false;

                                while (rs.next()) {
                                    rgCadastrado = true;
                                }

                                if (!rgCadastrado) {
                                    consulta = "SELECT cod_aluno FROM aluno WHERE cpf = " + cpf + "";
                                    st.executeQuery(consulta);
                                    rs = st.getResultSet();

                                    boolean cpfCadastrado = false;

                                    while (rs.next()) {
                                        cpfCadastrado = true;
                                    }

                                    if (!cpfCadastrado) {
                                        insert = "INSERT INTO aluno(matricula, nomeCompleto, rg, cpf, dataNascimento, sexo, sexoLiteral, ano, turno, turnoLiteral, curso, Pessoa_cod_pessoa) VALUES (" + matricula + ",'" + nomeCompleto + "'," + rg + "," + cpf + ",'" + dataNascimento + "'," + sexo + ",'" + sexoLiteral + "'," + ano + "," + turno + ",'" + turnoliteral + "','" + curso + "'," + cod_pessoa + ")";
                                        st.executeUpdate(insert);

                                        int cod_aluno = 0;

                                        consulta = "SELECT cod_aluno FROM aluno WHERE cpf = " + meuAluno.getCpf() + "";
                                        st.executeQuery(consulta);
                                        rs = st.getResultSet();

                                        while (rs.next()) {
                                            cod_aluno = Integer.parseInt(rs.getString("cod_aluno"));
                                        }

                                        insert = "INSERT INTO curriculo(descricao, idioma1, idioma2, idioma3, formacao1, formacao2, formacao3, curso1, curso2, curso3, emprego1, emprego2, emprego3, Aluno_cod_aluno) VALUES ('" + curriculo.getDescricao() + "','" + curriculo.getIdioma1() + "','" + curriculo.getIdioma2() + "','" + curriculo.getIdioma3() + "','" + curriculo.getFormacao1() + "','" + curriculo.getFormacao2() + "','" + curriculo.getFormacao3() + "','" + curriculo.getCurso1() + "','" + curriculo.getCurso2() + "','" + curriculo.getCurso3() + "','" + curriculo.getEmprego1() + "','" + curriculo.getEmprego2() + "','" + curriculo.getEmprego3() + "'," + cod_aluno + ")";
                                        st.executeUpdate(insert);

                                        consulta = "SELECT cod_curriculo FROM curriculo WHERE Aluno_cod_aluno = " + cod_aluno + " ";
                                        st.executeQuery(consulta);
                                        rs = st.getResultSet();

                                        int cod_curriculo = 0;

                                        while (rs.next()) {
                                            cod_curriculo = Integer.parseInt(rs.getString("cod_curriculo"));
                                        }

                                        meuAluno.getCurriculo().setID(cod_curriculo);

                                        mensagemEnviar = "alunoCadastrado";
                                        out.writeObject(mensagemEnviar);
                                        out.writeObject(cod_aluno);
                                    } else {
                                        out.writeObject("cpfJaCadastrado");
                                    }
                                } else {
                                    out.writeObject("rgJaCadastrado");
                                }
                            } else {
                                out.writeObject("matriculaJaCadastrada");
                            }
                        } else {
                            out.writeObject("emailJaExiste");
                        }
                        break;
                    }
                    case "cadastraEmpresa": {
                        out.writeObject("Ok");

                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        Endereco endereco = minhaEmpresa.getEndereco();
                        String rua = endereco.getRua();
                        int numero = endereco.getNumero();
                        String bairro = endereco.getBairro();
                        String cidade = endereco.getCidade();
                        int cep = endereco.getCep();
                        String complemento = "";
                        if (!endereco.getComplemento().equals("")) {
                            complemento = endereco.getComplemento();
                        }

                        String consulta = "SELECT cod_endereco FROM endereco WHERE rua LIKE '" + rua + "' AND numero = " + numero + " AND bairro LIKE '" + bairro + "' AND complemento LIKE '" + complemento + "' AND cep = " + cep + " AND cidade LIKE '" + cidade + "'";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        boolean enderecoCadastrado = false;
                        int cod_endereco = 0;

                        while (rs.next()) {
                            enderecoCadastrado = true;
                            cod_endereco = Integer.parseInt(rs.getString("cod_endereco"));
                        }

                        if (!enderecoCadastrado) {
                            String insert = "INSERT INTO endereco(rua, numero, bairro, complemento, cep, cidade) VALUES ('" + rua + "', " + numero + ", '" + bairro + "', '" + complemento + "', " + cep + ",  '" + cidade + "')";
                            st.executeUpdate(insert);

                            consulta = "SELECT cod_endereco FROM endereco WHERE rua LIKE '" + rua + "' AND numero = " + numero + " AND bairro LIKE '" + bairro + "' AND complemento LIKE '" + complemento + "' AND cep = " + cep + " AND cidade LIKE '" + cidade + "'";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            while (rs.next()) {
                                cod_endereco = Integer.parseInt(rs.getString("cod_endereco"));
                            }
                        }

                        int telefone = minhaEmpresa.getTelefone();
                        int ddd = minhaEmpresa.getDdd();
                        String email = minhaEmpresa.getEmail();
                        String razaoSocial = minhaEmpresa.getRazaoSocial();

                        consulta = "SELECT cod_empresa FROM empresa WHERE razaoSocial LIKE '" + razaoSocial + "' ";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        boolean razaoSocialEmUso = false;

                        while (rs.next()) {
                            razaoSocialEmUso = true;
                        }

                        if (!razaoSocialEmUso) {
                            out.writeObject("razaoSocialOk");

                            String insert = "INSERT INTO pessoa(telefone, ddd, Endereco_cod_endereco) VALUES (" + telefone + "," + ddd + "," + cod_endereco + ")";
                            st.executeUpdate(insert);

                            consulta = "SELECT cod_pessoa FROM pessoa WHERE telefone = " + telefone + " AND ddd = " + ddd + " AND Endereco_cod_endereco = " + cod_endereco + " ";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_pessoa = 0;

                            while (rs.next()) {
                                cod_pessoa = Integer.parseInt(rs.getString("cod_pessoa"));
                            }

                            out.writeObject(cod_pessoa);
                            String senhaCriptografada = (String) in.readObject();

                            insert = "INSERT INTO usuario(email, senha, Pessoa_cod_pessoa) VALUES ('" + email + "','" + senhaCriptografada + "'," + cod_pessoa + ")";
                            st.executeUpdate(insert);

                            long cnpj = minhaEmpresa.getCnpj();
                            String nomeFantasia = minhaEmpresa.getNomeFantasia();

                            consulta = "SELECT cod_empresa FROM empresa WHERE cnpj = " + cnpj + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            boolean cnpjEmUso = false;

                            while (rs.next()) {
                                cnpjEmUso = true;
                            }

                            if (!cnpjEmUso) {
                                insert = "INSERT INTO empresa(cnpj, razaoSocial, nomeFantasia, Pessoa_cod_pessoa) VALUES (" + cnpj + ",'" + razaoSocial + "','" + nomeFantasia + "', " + cod_pessoa + ")";
                                st.executeUpdate(insert);

                                consulta = "SELECT cod_empresa FROM empresa WHERE cnpj = " + minhaEmpresa.getCnpj() + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                int cod_empresa = 0;

                                while (rs.next()) {
                                    cod_empresa = Integer.parseInt(rs.getString("cod_empresa"));
                                }

                                mensagemEnviar = "empresaCadastrada";
                                out.writeObject(mensagemEnviar);
                                out.writeObject(cod_empresa);

                            } else {
                                out.writeObject("cnpjEmUso");
                            }
                        } else {
                            out.writeObject("razaoSocialEmUso");
                        }

                        break;
                    }
                    case "validaUsuario": {
                        out.writeObject("Ok");
                        String email = (String) in.readObject();
                        int cod_pessoa = 0;

                        String consulta = "SELECT Pessoa_cod_pessoa FROM usuario WHERE email like '" + email + "'";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        while (rs.next()) {
                            cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                        }
                        if (cod_pessoa != 0) {
                            mensagemEnviar = "cod_pessoa";
                            out.writeObject(mensagemEnviar);
                            out.writeObject(cod_pessoa);
                            String senha = (String) in.readObject();
                            consulta = "SELECT Pessoa_cod_pessoa FROM usuario WHERE senha like '" + senha + "'";

                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            if (rs.next()) {
                                out.writeObject("senhaValida");
                                mensagemRecebida = (String) in.readObject();
                                if (mensagemRecebida.equals("Ok")) {

                                    consulta = "SELECT * FROM pessoa WHERE cod_pessoa like '" + cod_pessoa + "'";

                                    st.executeQuery(consulta);
                                    rs = st.getResultSet();

                                    while (rs.next()) {
                                        int telefone = Integer.parseInt(rs.getString("telefone"));
                                        int ddd = Integer.parseInt(rs.getString("ddd"));
                                        int cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                                        consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco;
                                        st.executeQuery(consulta);
                                        rs = st.getResultSet();

                                        while (rs.next()) {
                                            String rua = rs.getString("rua");
                                            int numero = Integer.parseInt(rs.getString("numero"));
                                            String bairro = rs.getString("bairro");
                                            String cidade = rs.getString("cidade");
                                            int cep = Integer.parseInt(rs.getString("cep"));
                                            String complemento = rs.getString("complemento");
                                            Endereco meuEndereco = new Endereco(rua, numero, bairro, cidade, cep);
                                            meuEndereco.setComplemento(complemento);

                                            consulta = "SELECT * FROM aluno WHERE Pessoa_cod_pessoa = " + cod_pessoa;
                                            boolean isAluno = false;
                                            st.executeQuery(consulta);
                                            rs = st.getResultSet();

                                            long matricula = 0;
                                            int ano = 0;
                                            String curso = "";
                                            int turno = 0;
                                            String nomeCompleto = "";
                                            int sexo = 0;
                                            long cpf = 0;
                                            long rg = 0;
                                            LocalDate dataNascimento = null;
                                            int cod_aluno = 0;

                                            while (rs.next()) {
                                                matricula = Long.parseLong(rs.getString("matricula"));
                                                ano = Integer.parseInt(rs.getString("ano"));
                                                curso = rs.getString("curso");
                                                turno = Integer.parseInt(rs.getString("turno"));
                                                nomeCompleto = rs.getString("nomeCompleto");
                                                sexo = Integer.parseInt(rs.getString("sexo"));
                                                cpf = Long.parseLong(rs.getString("cpf"));
                                                rg = Long.parseLong(rs.getString("rg"));
                                                dataNascimento = LocalDate.parse(rs.getString("dataNascimento"));
                                                cod_aluno = Integer.parseInt(rs.getString("cod_aluno"));

                                                isAluno = true;

                                                consulta = "SELECT * FROM curriculo WHERE Aluno_cod_aluno = " + cod_aluno + "";
                                                st.executeQuery(consulta);
                                                rs = st.getResultSet();

                                                int ID = 0;
                                                String descricao = "";
                                                String formacao1 = "";
                                                String formacao2 = "";
                                                String formacao3 = "";
                                                String idioma1 = "";
                                                String idioma2 = "";
                                                String idioma3 = "";
                                                String curso1 = "";
                                                String curso2 = "";
                                                String curso3 = "";
                                                String emprego1 = "";
                                                String emprego2 = "";
                                                String emprego3 = "";

                                                while (rs.next()) {
                                                    descricao = rs.getString("descricao");
                                                    formacao1 = rs.getString("formacao1");
                                                    formacao2 = rs.getString("formacao2");
                                                    formacao3 = rs.getString("formacao3");
                                                    idioma1 = rs.getString("idioma1");
                                                    idioma2 = rs.getString("idioma2");
                                                    idioma3 = rs.getString("idioma3");
                                                    curso1 = rs.getString("curso1");
                                                    curso2 = rs.getString("curso2");
                                                    curso3 = rs.getString("curso3");
                                                    emprego1 = rs.getString("emprego1");
                                                    emprego2 = rs.getString("emprego2");
                                                    emprego3 = rs.getString("emprego3");
                                                    ID = Integer.parseInt(rs.getString("cod_curriculo"));
                                                }

                                                Curriculo meuCurriculo = new Curriculo(descricao, formacao1, formacao2, formacao3, idioma1, idioma2, idioma3, curso1, curso2, curso3, emprego1, emprego2, emprego3);
                                                meuCurriculo.setID(ID);

                                                Aluno meuAluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, meuEndereco, telefone, ddd, email, senha);
                                                meuAluno.setCurriculo(meuCurriculo);
                                                meuAluno.setID(cod_aluno);

                                                mensagemEnviar = "usuarioAluno";
                                                out.writeObject(mensagemEnviar);

                                                mensagemRecebida = (String) in.readObject();

                                                if (mensagemRecebida.equals("Ok")) {
                                                    out.writeObject(meuAluno);
                                                    out.writeObject(cod_aluno);
                                                }
                                            }

                                            if (!isAluno) {
                                                consulta = "SELECT * FROM empresa WHERE Pessoa_cod_pessoa = " + cod_pessoa;

                                                st.executeQuery(consulta);
                                                rs = st.getResultSet();

                                                while (rs.next()) {
                                                    String razaoSocial = rs.getString("razaoSocial");
                                                    String nomeFantasia = rs.getString("nomeFantasia");
                                                    long cnpj = Long.parseLong(rs.getString("cnpj"));
                                                    int cod_empresa = Integer.parseInt(rs.getString("cod_empresa"));

                                                    Empresa minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, meuEndereco, telefone, ddd, email, senha);
                                                    minhaEmpresa.setID(cod_empresa);

                                                    mensagemEnviar = "usuarioEmpresa";
                                                    out.writeObject(mensagemEnviar);

                                                    mensagemRecebida = (String) in.readObject();

                                                    if (mensagemRecebida.equals("Ok")) {
                                                        out.writeObject(minhaEmpresa);
                                                        out.writeObject(cod_empresa);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                out.writeObject("senhaInvalida");
                            }
                        } else {
                            out.writeObject("EmailInvalido");
                        }
                        break;
                    }
                    case "recuperaSenha": {
                        mensagemEnviar = "Ok";
                        out.writeObject(mensagemEnviar);

                        String email = (String) in.readObject();

                        int cod_pessoa = 0;
                        String senha = "";

                        String consulta = "SELECT Pessoa_cod_pessoa, senha FROM usuario WHERE email LIKE '" + email + "'";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        while (rs.next()) {
                            cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                            senha = rs.getString("senha");
                        }

                        if (cod_pessoa != 0 && !senha.equals("")) {
                            mensagemEnviar = "enviaCodPessoaSenha";
                            out.writeObject(mensagemEnviar);

                            mensagemRecebida = (String) in.readObject();

                            if (mensagemRecebida.equals("Ok")) {
                                out.writeObject(cod_pessoa);
                                out.writeObject(senha);
                            }
                        } else {
                            mensagemEnviar = "emailInvalido";
                            out.writeObject(mensagemEnviar);
                        }
                        break;
                    }
                    case "redefineSenha": {
                        out.writeObject("Ok");
                        String tipoUser = (String) in.readObject();
                        String email = "";

                        if (tipoUser.equals("aluno")) {
                            Aluno meuAluno = (Aluno) in.readObject();
                            email = meuAluno.getEmail();
                        } else if (tipoUser.equals("empresa")) {
                            Empresa minhaEmpresa = (Empresa) in.readObject();
                            email = minhaEmpresa.getEmail();
                        }

                        String consulta = "SELECT Pessoa_cod_pessoa FROM usuario WHERE email like '" + email + "'";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();
                        int cod_pessoa = 0;

                        while (rs.next()) {
                            cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                        }

                        if (cod_pessoa != 0) {
                            out.writeObject("emailValido");
                            out.writeObject(cod_pessoa);
                            String senhaAtualCriptografada = (String) in.readObject();

                            consulta = "SELECT * FROM usuario WHERE senha LIKE '" + senhaAtualCriptografada + "'";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            boolean senhaValida = false;

                            while (rs.next()) {
                                senhaValida = true;
                            }

                            if (!senhaValida) {
                                out.writeObject("senhaInvalida");
                            } else {
                                out.writeObject("senhaValida");
                                String senhaNovaCriptografada = (String) in.readObject();
                                String update = "UPDATE usuario SET senha = '" + senhaNovaCriptografada + "' WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                                st.executeUpdate(update);

                                out.writeObject("senhaRedefinida");
                            }

                        } else {
                            out.writeObject("emailInvalido");
                        }
                        break;
                    }
                    case "salvarDadosConta": {
                        out.writeObject("Ok");

                        Aluno meuAluno = (Aluno) in.readObject();
                        Endereco endereco = meuAluno.getEndereco();
                        Curriculo curriculo = meuAluno.getCurriculo();

                        String consulta = "SELECT Pessoa_cod_pessoa FROM aluno WHERE cod_aluno = " + meuAluno.getID() + "";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_pessoa = 0;
                        int cod_aluno = 0;

                        while (rs.next()) {
                            cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                        }

                        consulta = "SELECT Endereco_cod_endereco FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        int cod_endereco = 0;

                        while (rs.next()) {
                            cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                        }
                        if (cod_endereco != 0) {
                            String update = "UPDATE endereco SET rua = '" + endereco.getRua() + "',numero = " + endereco.getNumero() + ",bairro = '" + endereco.getBairro() + "',complemento = '" + endereco.getComplemento() + "',cep = " + endereco.getCep() + ",cidade = '" + endereco.getCidade() + "' WHERE cod_endereco = " + cod_endereco + "";
                            st.executeUpdate(update);

                            update = "UPDATE aluno SET matricula = " + meuAluno.getMatricula() + ",nomeCompleto='" + meuAluno.getNomeCompleto() + "',rg=" + meuAluno.getRg() + ",cpf=" + meuAluno.getCpf() + ",dataNascimento='" + meuAluno.getDataNascimento() + "',sexo=" + meuAluno.getSexo() + ",sexoLiteral='" + meuAluno.getSexoLiteral() + "',ano=" + meuAluno.getAno() + ",turno=" + meuAluno.getTurno() + ",turnoLiteral='" + meuAluno.getTurnoLiteral() + "',curso='" + meuAluno.getCurso() + "' WHERE cod_aluno = " + cod_aluno + "";
                            st.executeUpdate(update);

                            update = "UPDATE usuario SET email = '" + meuAluno.getEmail() + "' WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                            st.executeUpdate(update);

                            consulta = "SELECT cod_curriculo FROM curriculo WHERE Aluno_cod_aluno = " + cod_aluno + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_curriculo = 0;

                            while (rs.next()) {
                                cod_curriculo = Integer.parseInt(rs.getString("cod_curriculo"));
                            }

                            update = "UPDATE curriculo SET descricao='" + curriculo.getDescricao() + "',idioma1='" + curriculo.getIdioma1() + "',idioma2='" + curriculo.getIdioma2() + "',idioma3='" + curriculo.getIdioma3() + "',formacao1='" + curriculo.getFormacao1() + "',formacao2='" + curriculo.getFormacao2() + "',formacao3='" + curriculo.getFormacao3() + "',curso1='" + curriculo.getCurso1() + "',curso2='" + curriculo.getCurso2() + "',curso3='" + curriculo.getCurso3() + "',emprego1='" + curriculo.getEmprego1() + "',emprego2='" + curriculo.getEmprego2() + "',emprego3='" + curriculo.getEmprego3() + "' WHERE cod_curriculo = " + cod_curriculo + "";
                            st.executeUpdate(update);

                            out.writeObject("alunoAtualizado");
                        } else {
                            out.writeObject("erroEndereco");
                        }

                        break;
                    }
                    case "listaVagas": {
                        out.writeObject("Ok");

                        boolean temVagas = false;

                        Aluno meuAluno = (Aluno) in.readObject();

                        String consulta = "SELECT * FROM aplicacao WHERE Aluno_cod_aluno = " + meuAluno.getID() + "";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int[] codigosVagasAplicacoes = new int[MAX_PRIORITY];

                        boolean alunoTemAplicacao = false;
                        int x = 0;

                        while (rs.next()) {
                            alunoTemAplicacao = true;
                            codigosVagasAplicacoes[x] = (Integer.parseInt(rs.getString("Vaga_cod_vaga")));
                            x++;
                        }

                        if (alunoTemAplicacao) {
                            consulta = "SELECT * FROM vaga v, aplicacao ap, aluno a, empresa e, pessoa p, endereco ed, usuario u WHERE preenchida = 0 AND v.Empresa_cod_empresa = e.cod_empresa AND e.Pessoa_cod_pessoa = p.cod_pessoa AND p.Endereco_cod_endereco = ed.cod_endereco AND u.Pessoa_cod_pessoa = p.cod_pessoa  GROUP BY v.cod_vaga";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_vaga = 0;

                            while (rs.next()) {
                                boolean vagaJaAplicada = false;
                                cod_vaga = Integer.parseInt(rs.getString("cod_vaga"));

                                for (x = 0; x < codigosVagasAplicacoes.length; x++) {
                                    int codigo = codigosVagasAplicacoes[x];
                                    if (codigo == cod_vaga) {
                                        vagaJaAplicada = true;
                                        break;
                                    }
                                }

                                if (!vagaJaAplicada) {
                                    String setor = "";
                                    boolean remunerada = false;
                                    int remuneradaInteiro = 0;
                                    String nome = "";
                                    float salario = 0;
                                    String descricao = "";
                                    boolean preenchida = false;
                                    int turno = 0;
                                    LocalDate dataPublicacao = null;

                                    int cod_empresa = 0;
                                    String razaoSocial = "";
                                    String nomeFantasia = "";
                                    long cnpj = 0;

                                    int telefone = 0;
                                    int ddd = 0;

                                    String rua = "";
                                    int numero = 0;
                                    String bairro = "";
                                    String cidade = "";
                                    String complemento = "";
                                    int cep = 0;

                                    String email = "";
                                    String senha = "";

                                    temVagas = true;

                                    cod_vaga = Integer.parseInt(rs.getString("v.cod_vaga"));
                                    setor = rs.getString("v.setor");
                                    nome = rs.getString("v.nome");
                                    remuneradaInteiro = Integer.parseInt(rs.getString("v.remunerada"));
                                    salario = Float.parseFloat(rs.getString("v.salario"));
                                    descricao = rs.getString("v.descricao");
                                    turno = Integer.parseInt(rs.getString("v.turno"));
                                    dataPublicacao = LocalDate.parse(rs.getString("v.dataPublicacao"));

                                    if (remuneradaInteiro == 1) {
                                        remunerada = true;
                                    }

                                    cod_empresa = Integer.parseInt(rs.getString("e.cod_empresa"));
                                    razaoSocial = rs.getString("e.razaoSocial");
                                    nomeFantasia = rs.getString("e.nomeFantasia");
                                    cnpj = Long.parseLong(rs.getString("e.cnpj"));

                                    telefone = Integer.parseInt(rs.getString("p.telefone"));
                                    ddd = Integer.parseInt(rs.getString("p.ddd"));

                                    rua = rs.getString("ed.rua");
                                    numero = Integer.parseInt(rs.getString("ed.numero"));
                                    bairro = rs.getString("ed.bairro");
                                    cidade = rs.getString("ed.cidade");
                                    complemento = rs.getString("ed.complemento");
                                    cep = Integer.parseInt(rs.getString("ed.cep"));

                                    email = rs.getString("u.email");
                                    senha = rs.getString("u.senha");

                                    Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                                    endereco.setComplemento(complemento);

                                    Empresa empresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);
                                    empresa.setID(cod_empresa);

                                    Vaga vaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, empresa);
                                    vaga.setSalario(salario);
                                    vaga.setTurnoLiteral();
                                    vaga.setID(cod_vaga);

                                    listaVagas.add(vaga);
                                }
                            }
                        } else {
                            consulta = "SELECT * FROM vaga v, aluno a, empresa e, pessoa p, endereco ed, usuario u WHERE preenchida = 0 AND v.Empresa_cod_empresa = e.cod_empresa AND e.Pessoa_cod_pessoa = p.cod_pessoa AND p.Endereco_cod_endereco = ed.cod_endereco AND u.Pessoa_cod_pessoa = p.cod_pessoa GROUP BY v.cod_vaga";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_vaga = 0;
                            String setor = "";
                            boolean remunerada = false;
                            int remuneradaInteiro = 0;
                            String nome = "";
                            float salario = 0;
                            String descricao = "";
                            boolean preenchida = false;
                            int preenchidaInteiro = 0;
                            int turno = 0;
                            LocalDate dataPublicacao = null;

                            int cod_empresa = 0;
                            String razaoSocial = "";
                            String nomeFantasia = "";
                            long cnpj = 0;

                            int telefone = 0;
                            int ddd = 0;

                            String rua = "";
                            int numero = 0;
                            String bairro = "";
                            String cidade = "";
                            String complemento = "";
                            int cep = 0;

                            String email = "";
                            String senha = "";

                            while (rs.next()) {
                                temVagas = true;

                                cod_vaga = Integer.parseInt(rs.getString("v.cod_vaga"));
                                setor = rs.getString("v.setor");
                                nome = rs.getString("v.nome");
                                remuneradaInteiro = Integer.parseInt(rs.getString("v.remunerada"));
                                salario = Float.parseFloat(rs.getString("v.salario"));
                                descricao = rs.getString("v.descricao");
                                preenchidaInteiro = Integer.parseInt(rs.getString("v.preenchida"));
                                turno = Integer.parseInt(rs.getString("v.turno"));
                                dataPublicacao = LocalDate.parse(rs.getString("v.dataPublicacao"));

                                if (remuneradaInteiro == 1) {
                                    remunerada = true;
                                }

                                if (preenchidaInteiro == 1) {
                                    preenchida = true;
                                }

                                cod_empresa = Integer.parseInt(rs.getString("e.cod_empresa"));
                                razaoSocial = rs.getString("e.razaoSocial");
                                nomeFantasia = rs.getString("e.nomeFantasia");
                                cnpj = Long.parseLong(rs.getString("e.cnpj"));

                                telefone = Integer.parseInt(rs.getString("p.telefone"));
                                ddd = Integer.parseInt(rs.getString("p.ddd"));

                                rua = rs.getString("ed.rua");
                                numero = Integer.parseInt(rs.getString("ed.numero"));
                                bairro = rs.getString("ed.bairro");
                                cidade = rs.getString("ed.cidade");
                                complemento = rs.getString("ed.complemento");
                                cep = Integer.parseInt(rs.getString("ed.cep"));

                                email = rs.getString("u.email");
                                senha = rs.getString("u.senha");

                                Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                                endereco.setComplemento(complemento);

                                Empresa empresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);
                                empresa.setID(cod_empresa);

                                Vaga vaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, empresa);
                                vaga.setSalario(salario);
                                vaga.setTurnoLiteral();
                                vaga.setID(cod_vaga);

                                if (!preenchida) {
                                    listaVagas.add(vaga);
                                }
                            }
                        }

                        if (temVagas) {
                            out.writeObject("temVagas");
                            out.writeObject(listaVagas);
                            listaVagas.clear();
                        } else {
                            out.writeObject("nenhumaVagaCadastrada");
                        }
                        break;
                    }
                    case "pesquisaVagas": {
                        out.writeObject("Ok");

                        String termoPesquisado = (String) in.readObject();

                        String consulta = "SELECT * FROM vaga v, empresa e, pessoa p,"
                                + " endereco ed, usuario u WHERE (v.nome LIKE '%"
                                + termoPesquisado + "%' OR e.razaoSocial LIKE '%"
                                + termoPesquisado + "%') AND v.Empresa_cod_empresa"
                                + " = e.cod_empresa AND e.Pessoa_cod_pessoa ="
                                + " p.cod_pessoa AND p.Endereco_cod_endereco ="
                                + " ed.cod_endereco AND u.Pessoa_cod_pessoa ="
                                + " p.cod_pessoa";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_vaga = 0;
                        String setor = "";
                        boolean remunerada = false;
                        String nome = "";
                        float salario = 0;
                        String descricao = "";
                        boolean preenchida = false;
                        int turno = 0;
                        LocalDate dataPublicacao = null;

                        int cod_empresa = 0;
                        String razaoSocial = "";
                        String nomeFantasia = "";
                        long cnpj = 0;

                        int telefone = 0;
                        int ddd = 0;

                        String rua = "";
                        int numero = 0;
                        String bairro = "";
                        String cidade = "";
                        String complemento = "";
                        int cep = 0;

                        String email = "";
                        String senha = "";

                        boolean temVagas = false;

                        while (rs.next()) {
                            temVagas = true;

                            setor = rs.getString("v.setor");
                            nome = rs.getString("v.nome");
                            remunerada = Boolean.valueOf(rs.getString("v.remunerada"));
                            salario = Float.parseFloat(rs.getString("v.salario"));
                            descricao = rs.getString("v.descricao");
                            preenchida = Boolean.valueOf(rs.getString("v.preenchida"));
                            turno = Integer.parseInt(rs.getString("v.turno"));
                            dataPublicacao = LocalDate.parse(rs.getString("v.dataPublicacao"));

                            cod_empresa = Integer.parseInt(rs.getString("e.cod_empresa"));

                            razaoSocial = rs.getString("e.razaoSocial");
                            nomeFantasia = rs.getString("e.nomeFantasia");
                            cnpj = Long.parseLong(rs.getString("e.cnpj"));

                            telefone = Integer.parseInt(rs.getString("p.telefone"));
                            ddd = Integer.parseInt(rs.getString("p.ddd"));

                            email = rs.getString("u.email");

                            rua = rs.getString("ed.rua");
                            numero = Integer.parseInt(rs.getString("ed.numero"));
                            bairro = rs.getString("ed.bairro");
                            cidade = rs.getString("ed.cidade");
                            complemento = rs.getString("ed.complemento");
                            cep = Integer.parseInt(rs.getString("ed.cep"));

                            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                            endereco.setComplemento(complemento);

                            Empresa empresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);
                            empresa.setID(cod_empresa);

                            Vaga vaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, empresa);
                            vaga.setSalario(salario);
                            vaga.setTurnoLiteral();
                            vaga.setID(cod_vaga);

                            if (!preenchida) {
                                listaVagasPesquisadas.add(vaga);
                            }
                        }
                        if (temVagas) {
                            out.writeObject("temVagas");
                            out.writeObject(listaVagasPesquisadas);
                        } else {
                            out.writeObject("nenhumaVagaCadastrada");
                        }
                        break;
                    }
                    case "detalhaVaga": {
                        out.writeObject("Ok");

                        String selecionadaNome = (String) in.readObject();

                        String consulta = "SELECT * FROM vaga WHERE nome LIKE '" + selecionadaNome + "'";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        String setor = "";
                        boolean remunerada = false;
                        String nome = "";
                        float salario = 0;
                        String descricao = "";
                        boolean preenchida = false;
                        int turno = 0;
                        Empresa empresa = null;
                        int cod_empresa = 0;
                        int cod_vaga = 0;
                        LocalDate dataPublicacao = null;

                        while (rs.next()) {
                            setor = rs.getString("setor");
                            nome = rs.getString("nome");
                            remunerada = Boolean.valueOf(rs.getString("remunerada"));
                            salario = Float.parseFloat(rs.getString("salario"));
                            descricao = rs.getString("descricao");
                            preenchida = Boolean.valueOf(rs.getString("preenchida"));
                            turno = Integer.parseInt(rs.getString("turno"));
                            cod_empresa = Integer.parseInt(rs.getString("Empresa_cod_empresa"));
                            cod_vaga = Integer.parseInt(rs.getString("cod_vaga"));
                            dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));
                        }

                        consulta = "SELECT * FROM empresa WHERE cod_empresa = " + cod_empresa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String razaoSocial = "";
                        String nomeFantasia = "";
                        long cnpj = 0;
                        int cod_pessoa = 0;

                        while (rs.next()) {
                            razaoSocial = rs.getString("razaoSocial");
                            nomeFantasia = rs.getString("nomeFantasia");
                            cnpj = Long.parseLong(rs.getString("cnpj"));
                            cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                        }

                        consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        int cod_endereco = 0;
                        int telefone = 0;
                        int ddd = 0;
                        String email = "";
                        String senha = "";

                        while (rs.next()) {
                            cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                            telefone = Integer.parseInt(rs.getString("telefone"));
                            ddd = Integer.parseInt(rs.getString("ddd"));

                        }

                        consulta = "SELECT email FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        while (rs.next()) {
                            email = rs.getString("email");
                        }

                        consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String rua = "";
                        int numero = 0;
                        String bairro = "";
                        String cidade = "";
                        String complemento = "";
                        int cep = 0;

                        while (rs.next()) {
                            rua = rs.getString("rua");
                            numero = Integer.parseInt(rs.getString("numero"));
                            bairro = rs.getString("bairro");
                            cidade = rs.getString("cidade");
                            complemento = rs.getString("complemento");
                            cep = Integer.parseInt(rs.getString("cep"));
                        }

                        Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                        endereco.setComplemento(complemento);
                        empresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);
                        empresa.setID(cod_empresa);

                        Vaga vaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, empresa);
                        vaga.setSalario(salario);
                        vaga.setTurnoLiteral();
                        vaga.setID(cod_vaga);

                        out.writeObject(vaga);

                        break;
                    }
                    case "detalhaAplicacao": {
                        out.writeObject("Ok");

                        String nomeVaga = (String) in.readObject();
                        Aluno meuaAluno = (Aluno) in.readObject();

                        String consulta = "SELECT * FROM aplicacao a, vaga v, empresa e, pessoa p, usuario u, endereco ed WHERE v.nome LIKE '" + nomeVaga + "' AND a.Vaga_cod_vaga = v.cod_vaga AND a.Aluno_cod_aluno = " + meuaAluno.getID() + " AND v.Empresa_cod_empresa = e.cod_empresa AND p.cod_pessoa = e.Pessoa_cod_pessoa AND u.Pessoa_cod_pessoa = p.cod_pessoa AND ed.cod_endereco = p.Endereco_cod_endereco";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_app = 0;
                        boolean aceita = false;
                        boolean movimentada = false;
                        int aceitaint = 0, movimentadaint = 0;

                        int cod_vaga = 0;
                        String setor = "";
                        boolean remunerada = false;
                        int remuneradaint = 0, preenchidaint = 0;
                        String nome = "";
                        float salario = 0;
                        String descricao = "";
                        boolean preenchida = false;
                        int turno = 0;
                        LocalDate dataPublicacao = null;

                        Empresa empresa = null;
                        int cod_empresa = 0;
                        String razaoSocial = "";
                        String nomeFantasia = "";
                        long cnpj = 0;

                        int telefone = 0;
                        int ddd = 0;

                        String email = "";
                        String senha = "";

                        String rua = "";
                        int numero = 0;
                        String bairro = "";
                        String cidade = "";
                        String complemento = "";
                        int cep = 0;

                        while (rs.next()) {
                            cod_app = Integer.parseInt(rs.getString("a.cod_aplicacao"));
                            aceitaint = Integer.parseInt(rs.getString("a.aceita"));
                            movimentadaint = Integer.parseInt(rs.getString("a.movimentada"));

                            cod_vaga = Integer.parseInt(rs.getString("v.cod_vaga"));
                            setor = rs.getString("v.setor");
                            nome = rs.getString("v.nome");
                            remuneradaint = Integer.parseInt(rs.getString("v.remunerada"));
                            salario = Float.parseFloat(rs.getString("v.salario"));
                            descricao = rs.getString("v.descricao");
                            preenchidaint = Integer.parseInt(rs.getString("v.preenchida"));
                            turno = Integer.parseInt(rs.getString("v.turno"));
                            dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));

                            cod_empresa = Integer.parseInt(rs.getString("e.cod_empresa"));
                            razaoSocial = rs.getString("e.razaoSocial");
                            nomeFantasia = rs.getString("e.nomeFantasia");
                            cnpj = Long.parseLong(rs.getString("e.cnpj"));

                            telefone = Integer.parseInt(rs.getString("p.telefone"));
                            ddd = Integer.parseInt(rs.getString("p.ddd"));

                            email = rs.getString("u.email");

                            rua = rs.getString("ed.rua");
                            numero = Integer.parseInt(rs.getString("ed.numero"));
                            bairro = rs.getString("ed.bairro");
                            cidade = rs.getString("ed.cidade");
                            complemento = rs.getString("ed.complemento");
                            cep = Integer.parseInt(rs.getString("ed.cep"));

                            Endereco meuEndereco = new Endereco(rua, numero, bairro, cidade, cep);
                            meuEndereco.setComplemento(complemento);

                            empresa = new Empresa(razaoSocial, nomeFantasia, cnpj, meuEndereco, telefone, ddd, email, senha);
                            empresa.setID(cod_empresa);

                            if (preenchidaint == 1) {
                                preenchida = true;
                            } else if (preenchidaint == 0) {
                                preenchida = false;
                            }

                            if (remuneradaint == 1) {
                                remunerada = true;
                            } else if (remuneradaint == 0) {
                                remunerada = false;
                            }

                            Vaga minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, empresa);
                            minhaVaga.setID(cod_vaga);
                            minhaVaga.setSalario(salario);

                            if (aceitaint == 1) {
                                aceita = true;
                            } else if (aceitaint == 0) {
                                aceita = false;
                            }

                            if (movimentadaint == 1) {
                                movimentada = true;
                            } else if (movimentadaint == 0) {
                                movimentada = false;
                            }

                            Aplicacao minhaApp = new Aplicacao(meuaAluno, minhaVaga, movimentada);
                            minhaApp.setID(cod_app);
                            minhaApp.setAceita(aceita);

                            out.writeObject(minhaApp);
                        }

                        break;
                    }
                    case "enviaCurriculo": {
                        out.writeObject("Ok");

                        int cod_aluno = (int) in.readObject();
                        Vaga minhaVaga = (Vaga) in.readObject();

                        int cod_vaga = minhaVaga.getID();

                        String consulta = "SELECT * FROM curriculo c, vaga v WHERE c.Aluno_cod_aluno = " + cod_aluno + " AND v.cod_vaga = " + cod_vaga + "";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        boolean temCurriculo = false;
                        int totalAplicacoes = 0;

                        while (rs.next()) {
                            temCurriculo = true;
                            totalAplicacoes = Integer.parseInt(rs.getString("v.totalAplicacoes"));
                        }

                        if (temCurriculo) {
                            out.writeObject("temCurriculo");

                            String insert = "INSERT INTO aplicacao(Aluno_cod_aluno, aceita, movimentada, Vaga_cod_vaga) VALUES (" + cod_aluno + ", 0, 0, " + cod_vaga + ")";
                            st.executeUpdate(insert);

                            totalAplicacoes++;

                            String update = "UPDATE vaga SET totalAplicacoes = " + totalAplicacoes + " WHERE cod_vaga = " + cod_vaga + "";
                            st.executeUpdate(update);

                            out.writeObject("cadastreiAplicacao");

                        }
                        break;
                    }
                    case "listaVagasAceitas": {
                        out.writeObject("Ok");

                        Aluno meuAluno = (Aluno) in.readObject();

                        String consulta = "SELECT Vaga_cod_vaga FROM aplicacao WHERE Aluno_cod_aluno = " + meuAluno.getID() + " AND aceita = 1";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();
                        int cod_vaga = 0;

                        while (rs.next()) {
                            cod_vaga = Integer.parseInt(rs.getString("Vaga_cod_vaga"));
                        }

                        consulta = "SELECT * FROM vaga WHERE cod_vaga = " + cod_vaga + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String setor = "";
                        boolean remunerada = false;
                        String nome = "";
                        float salario = 0;
                        String descricao = "";
                        boolean preenchida = false;
                        int turno = 0;
                        int cod_empresa = 0;
                        LocalDate dataPublicacao = null;

                        boolean temVagas = false;

                        while (rs.next()) {
                            setor = rs.getString("setor");
                            nome = rs.getString("nome");
                            remunerada = Boolean.valueOf(rs.getString("remunerada"));
                            salario = Float.parseFloat(rs.getString("salario"));
                            descricao = rs.getString("descricao");
                            preenchida = Boolean.valueOf(rs.getString("preenchida"));
                            turno = Integer.parseInt(rs.getString("turno"));
                            cod_empresa = Integer.parseInt(rs.getString("Empresa_cod_empresa"));
                            dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));

                            temVagas = true;

                            if (temVagas) {
                                consulta = "SELECT * FROM empresa WHERE cod_empresa = " + cod_empresa + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String razaoSocial = "";
                                String nomeFantasia = "";
                                long cnpj = 0;
                                int cod_pessoa = 0;

                                while (rs.next()) {
                                    razaoSocial = rs.getString("razaoSocial");
                                    nomeFantasia = rs.getString("nomeFantasia");
                                    cnpj = Long.parseLong(rs.getString("cnpj"));
                                    cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                                }

                                consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                int cod_endereco = 0;
                                int telefone = 0;
                                int ddd = 0;

                                while (rs.next()) {
                                    cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                                    telefone = Integer.parseInt(rs.getString("telefone"));
                                    ddd = Integer.parseInt(rs.getString("ddd"));
                                }

                                consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String rua = "";
                                int numero = 0;
                                String bairro = "";
                                String cidade = "";
                                String complemento = "";
                                int cep = 0;

                                while (rs.next()) {
                                    rua = rs.getString("rua");
                                    numero = Integer.parseInt(rs.getString("numero"));
                                    bairro = rs.getString("bairro");
                                    cidade = rs.getString("cidade");
                                    complemento = rs.getString("complemento");
                                    cep = Integer.parseInt(rs.getString("cep"));
                                }

                                Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                                endereco.setComplemento(complemento);

                                consulta = "SELECT email FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String email = "";
                                String senha = "";

                                while (rs.next()) {
                                    email = rs.getString("email");
                                }

                                Empresa minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);

                                Vaga vaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                                vaga.setSalario(salario);
                                vaga.setTurnoLiteral();

                                if (!preenchida) {
                                    listaVagasAceitas.add(vaga);
                                }
                            }
                        }
                        if (temVagas) {
                            out.writeObject("temVagas");
                            out.writeObject(listaVagasAceitas);
                            listaVagasAceitas.clear();
                        } else {
                            out.writeObject("nenhumaVagaCadastrada");
                        }
                        break;
                    }
                    case "listaVagasRecusadas": {
                        out.writeObject("Ok");

                        Aluno meuAluno = (Aluno) in.readObject();

                        String consulta = "SELECT Vaga_cod_vaga FROM aplicacao WHERE Aluno_cod_aluno = " + meuAluno.getID() + " AND aceita = 0 AND movimentada = 1";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();
                        int cod_vaga = 0;

                        while (rs.next()) {
                            cod_vaga = Integer.parseInt(rs.getString("Vaga_cod_vaga"));
                        }

                        consulta = "SELECT * FROM vaga WHERE cod_vaga = " + cod_vaga + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String setor = "";
                        boolean remunerada = false;
                        String nome = "";
                        float salario = 0;
                        String descricao = "";
                        boolean preenchida = false;
                        int turno = 0;
                        int cod_empresa = 0;
                        LocalDate dataPublicacao = null;

                        boolean temVagas = false;

                        while (rs.next()) {
                            setor = rs.getString("setor");
                            nome = rs.getString("nome");
                            remunerada = Boolean.valueOf(rs.getString("remunerada"));
                            salario = Float.parseFloat(rs.getString("salario"));
                            descricao = rs.getString("descricao");
                            preenchida = Boolean.valueOf(rs.getString("preenchida"));
                            turno = Integer.parseInt(rs.getString("turno"));
                            cod_empresa = Integer.parseInt(rs.getString("Empresa_cod_empresa"));
                            dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));

                            temVagas = true;

                            if (temVagas) {
                                consulta = "SELECT * FROM empresa WHERE cod_empresa = " + cod_empresa + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String razaoSocial = "";
                                String nomeFantasia = "";
                                long cnpj = 0;
                                int cod_pessoa = 0;

                                while (rs.next()) {
                                    razaoSocial = rs.getString("razaoSocial");
                                    nomeFantasia = rs.getString("nomeFantasia");
                                    cnpj = Long.parseLong(rs.getString("cnpj"));
                                    cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                                }

                                consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                int cod_endereco = 0;
                                int telefone = 0;
                                int ddd = 0;

                                while (rs.next()) {
                                    cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                                    telefone = Integer.parseInt(rs.getString("telefone"));
                                    ddd = Integer.parseInt(rs.getString("ddd"));
                                }

                                consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String rua = "";
                                int numero = 0;
                                String bairro = "";
                                String cidade = "";
                                String complemento = "";
                                int cep = 0;

                                while (rs.next()) {
                                    rua = rs.getString("rua");
                                    numero = Integer.parseInt(rs.getString("numero"));
                                    bairro = rs.getString("bairro");
                                    cidade = rs.getString("cidade");
                                    complemento = rs.getString("complemento");
                                    cep = Integer.parseInt(rs.getString("cep"));
                                }

                                Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                                endereco.setComplemento(complemento);

                                consulta = "SELECT email FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String email = "";
                                String senha = "";

                                while (rs.next()) {
                                    email = rs.getString("email");
                                }

                                Empresa minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);
                                minhaEmpresa.setID(cod_empresa);

                                Vaga vaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                                vaga.setSalario(salario);
                                vaga.setTurnoLiteral();
                                vaga.setID(cod_vaga);

                                if (!preenchida) {
                                    listaVagasRecusadas.add(vaga);
                                }
                            }
                        }
                        if (temVagas) {
                            out.writeObject("temVagas");
                            out.writeObject(listaVagasRecusadas);
                            listaVagasRecusadas.clear();
                        } else {
                            out.writeObject("nenhumaVagaCadastrada");
                        }
                        break;
                    }
                    case "listaVagasHistorico": {
                        out.writeObject("Ok");

                        Aluno meuAluno = (Aluno) in.readObject();

                        String consulta = "SELECT * FROM aplicacao ap, vaga v, empresa e, pessoa p, endereco ed, usuario u "
                                + "WHERE u.Pessoa_cod_pessoa = p.cod_pessoa AND ed.cod_endereco = p.Endereco_cod_endereco AND p.cod_pessoa = e.Pessoa_cod_pessoa"
                                + " AND e.cod_empresa = v.Empresa_cod_empresa AND v.cod_vaga = ap.Vaga_cod_vaga AND "
                                + "ap.Aluno_cod_aluno = " + meuAluno.getID() + " ";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_vaga = 0;
                        int aceita = 0;
                        int movimentada = 0;
                        int cod_app = 0;

                        boolean temAplicacoes = false;

                        while (rs.next()) {
                            temAplicacoes = true;

                            cod_vaga = Integer.parseInt(rs.getString("v.cod_vaga"));
                            aceita = Integer.parseInt(rs.getString("ap.aceita"));
                            movimentada = Integer.parseInt(rs.getString("ap.movimentada"));
                            cod_app = Integer.parseInt(rs.getString("ap.cod_aplicacao"));

                            String setor = "";
                            boolean remunerada = false;
                            String nome = "";
                            float salario = 0;
                            String descricao = "";
                            boolean preenchida = false;
                            int turno = 0;
                            int cod_empresa = 0;
                            LocalDate dataPublicacao = null;

                            setor = rs.getString("v.setor");
                            nome = rs.getString("v.nome");
                            remunerada = Boolean.valueOf(rs.getString("v.remunerada"));
                            salario = Float.parseFloat(rs.getString("v.salario"));
                            descricao = rs.getString("v.descricao");
                            preenchida = Boolean.valueOf(rs.getString("v.preenchida"));
                            turno = Integer.parseInt(rs.getString("v.turno"));
                            cod_empresa = Integer.parseInt(rs.getString("v.Empresa_cod_empresa"));
                            dataPublicacao = LocalDate.parse(rs.getString("v.dataPublicacao"));

                            String razaoSocial = "";
                            String nomeFantasia = "";
                            long cnpj = 0;
                            int cod_pessoa = 0;

                            razaoSocial = rs.getString("e.razaoSocial");
                            nomeFantasia = rs.getString("e.nomeFantasia");
                            cnpj = Long.parseLong(rs.getString("e.cnpj"));
                            cod_pessoa = Integer.parseInt(rs.getString("e.Pessoa_cod_pessoa"));

                            int cod_endereco = 0;
                            int telefone = 0;
                            int ddd = 0;

                            cod_endereco = Integer.parseInt(rs.getString("p.Endereco_cod_endereco"));
                            telefone = Integer.parseInt(rs.getString("p.telefone"));
                            ddd = Integer.parseInt(rs.getString("p.ddd"));

                            String rua = "";
                            int numero = 0;
                            String bairro = "";
                            String cidade = "";
                            String complemento = "";
                            int cep = 0;

                            rua = rs.getString("ed.rua");
                            numero = Integer.parseInt(rs.getString("ed.numero"));
                            bairro = rs.getString("ed.bairro");
                            cidade = rs.getString("ed.cidade");
                            complemento = rs.getString("ed.complemento");
                            cep = Integer.parseInt(rs.getString("ed.cep"));

                            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                            endereco.setComplemento(complemento);

                            String email = "";
                            String senha = "";

                            email = rs.getString("u.email");

                            Empresa minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);
                            minhaEmpresa.setID(cod_empresa);

                            Vaga vaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                            vaga.setSalario(salario);
                            vaga.setTurnoLiteral();
                            vaga.setID(cod_vaga);

                            boolean aceita2 = false;

                            if (aceita == 1) {
                                aceita2 = true;
                            }

                            boolean movimentada2 = false;

                            if (movimentada == 1) {
                                movimentada2 = true;
                            }

                            Aplicacao minhaApp = new Aplicacao(meuAluno, vaga, remunerada);
                            minhaApp.setAceita(aceita2);
                            minhaApp.setMovimentada(movimentada2);
                            minhaApp.setID(cod_app);

                            listaAplicacoesHistorico.add(minhaApp);

                        }

                        if (temAplicacoes) {
                            out.writeObject("temAplicacoes");
                            out.writeObject(listaAplicacoesHistorico);
                            listaAplicacoesHistorico.clear();
                        } else {
                            out.writeObject("nenhumaAplicacao");
                        }
                        break;
                    }
                    case "enviaMensagemAluno": {
                        out.writeObject("Ok");

                        Mensagem minhaMsg = (Mensagem) in.readObject();
                        String insert = "INSERT INTO mensagem(Aluno_cod_aluno, Empresa_cod_empresa, conteudo, assunto, dataHoraEnvio, alunoRemetente) VALUES (" + minhaMsg.getAluno().getID() + "," + minhaMsg.getEmpresa().getID() + ",'" + minhaMsg.getMensagem() + "','" + minhaMsg.getAssunto() + "','" + minhaMsg.getDataHoraEnvio() + "',1)";
                        st.executeUpdate(insert);

                        String consulta = "SELECT cod_mensagem FROM mensagem WHERE Aluno_cod_aluno = " + minhaMsg.getAluno().getID() + " AND Empresa_cod_empresa = " + minhaMsg.getEmpresa().getID() + " AND conteudo LIKE '" + minhaMsg.getMensagem() + "' AND assunto LIKE '" + minhaMsg.getAssunto() + "' AND dataHoraEnvio LIKE '" + minhaMsg.getDataHoraEnvio() + "' ";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_mensagem = 0;

                        while (rs.next()) {
                            cod_mensagem = Integer.parseInt(rs.getString("cod_mensagem"));
                        }

                        minhaMsg.setID(cod_mensagem);

                        out.writeObject("mensagemEnviada");
                        break;
                    }
                    case "listaMensagensAluno": {
                        out.writeObject("Ok");

                        Aluno meuAluno = (Aluno) in.readObject();

                        String consulta = "SELECT * FROM mensagem WHERE Aluno_cod_aluno = " + meuAluno.getID() + " AND alunoRemetente = 0";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_empresa = 0;
                        int cod_mensagem = 0;
                        String mensagem = "";
                        String assunto = "";
                        LocalDateTime dataHoraEnvio = null;
                        boolean alunoRemetente = true;
                        boolean temMensagens = false;

                        while (rs.next()) {
                            cod_empresa = Integer.parseInt(rs.getString("Empresa_cod_empresa"));
                            mensagem = rs.getString("conteudo");
                            assunto = rs.getString("assunto");
                            dataHoraEnvio = LocalDateTime.parse(rs.getString("dataHoraEnvio"));
                            cod_mensagem = Integer.parseInt(rs.getString("cod_mensagem"));

                            consulta = "SELECT * FROM empresa WHERE cod_empresa = " + cod_empresa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String razaoSocial = "";
                            String nomeFantasia = "";
                            long cnpj = 0;
                            int cod_pessoa = 0;

                            while (rs.next()) {
                                razaoSocial = rs.getString("razaoSocial");
                                nomeFantasia = rs.getString("nomeFantasia");
                                cnpj = Long.parseLong(rs.getString("cnpj"));
                                cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                            }

                            consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_endereco = 0;
                            int telefone = 0;
                            int ddd = 0;

                            while (rs.next()) {
                                cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                                telefone = Integer.parseInt(rs.getString("telefone"));
                                ddd = Integer.parseInt(rs.getString("ddd"));
                            }

                            consulta = "SELECT email FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String email = "";
                            String senha = "";

                            while (rs.next()) {
                                email = rs.getString("email");
                            }

                            consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String rua = "";
                            int numero = 0;
                            String bairro = "";
                            String cidade = "";
                            String complemento = "";
                            int cep = 0;

                            while (rs.next()) {
                                rua = rs.getString("rua");
                                numero = Integer.parseInt(rs.getString("numero"));
                                bairro = rs.getString("bairro");
                                cidade = rs.getString("cidade");
                                complemento = rs.getString("complemento");
                                cep = Integer.parseInt(rs.getString("cep"));
                            }

                            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                            endereco.setComplemento(complemento);

                            Empresa minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);
                            minhaEmpresa.setID(cod_empresa);

                            Mensagem minhaMsg = new Mensagem(meuAluno, minhaEmpresa, mensagem, assunto, alunoRemetente, dataHoraEnvio);
                            minhaMsg.setID(cod_mensagem);
                            listaMensagensAluno.add(minhaMsg);

                            temMensagens = true;
                        }

                        if (temMensagens) {
                            out.writeObject("temMensagens");
                            out.writeObject(listaMensagensAluno);
                            listaMensagensAluno.clear();
                        } else {
                            out.writeObject("naoTemMensagens");
                        }

                        break;
                    }
                    case "listaMensagensEmpresa": {
                        out.writeObject("Ok");

                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT * FROM mensagem WHERE Empresa_cod_empresa = " + minhaEmpresa.getID() + " AND alunoRemetente = 1";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_aluno = 0;
                        int cod_mensagem = 0;
                        String mensagem = "";
                        String assunto = "";
                        LocalDateTime dataHoraEnvio = null;
                        boolean alunoRemetente = false;
                        boolean temMensagens = false;

                        while (rs.next()) {
                            cod_aluno = Integer.parseInt(rs.getString("Aluno_cod_aluno"));
                            mensagem = rs.getString("conteudo");
                            assunto = rs.getString("assunto");
                            dataHoraEnvio = LocalDateTime.parse(rs.getString("dataHoraEnvio"));
                            cod_mensagem = Integer.parseInt(rs.getString("cod_mensagem"));

                            consulta = "SELECT * FROM aluno WHERE cod_aluno = " + cod_aluno + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            long matricula = 0;
                            int ano = 0;
                            String curso = "";
                            int turno = 0;
                            String nomeCompleto = "";
                            int sexo = 0;
                            long cpf = 0;
                            long rg = 0;
                            LocalDate dataNascimento = null;
                            int cod_pessoa = 0;

                            while (rs.next()) {
                                matricula = Long.parseLong(rs.getString("matricula"));
                                ano = Integer.parseInt(rs.getString("ano"));
                                curso = rs.getString("curso");
                                turno = Integer.parseInt(rs.getString("turno"));
                                nomeCompleto = rs.getString("nomeCompleto");
                                sexo = Integer.parseInt(rs.getString("sexo"));
                                cpf = Long.parseLong(rs.getString("cpf"));
                                rg = Long.parseLong(rs.getString("rg"));

                                dataNascimento = LocalDate.parse(rs.getString("dataNascimento"));
                                cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                            }

                            consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_endereco = 0;
                            int telefone = 0;
                            int ddd = 0;

                            while (rs.next()) {
                                cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                                telefone = Integer.parseInt(rs.getString("telefone"));
                                ddd = Integer.parseInt(rs.getString("ddd"));
                            }

                            consulta = "SELECT email FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String email = "";
                            String senha = "";

                            while (rs.next()) {
                                email = rs.getString("email");
                            }

                            consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String rua = "";
                            int numero = 0;
                            String bairro = "";
                            String cidade = "";
                            String complemento = "";
                            int cep = 0;

                            while (rs.next()) {
                                rua = rs.getString("rua");
                                numero = Integer.parseInt(rs.getString("numero"));
                                bairro = rs.getString("bairro");
                                cidade = rs.getString("cidade");
                                complemento = rs.getString("complemento");
                                cep = Integer.parseInt(rs.getString("cep"));
                            }

                            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                            endereco.setComplemento(complemento);
                            Aluno meuAluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, endereco, telefone, ddd, email, senha);
                            meuAluno.setTurnoLiteral();
                            meuAluno.setSexoLiteral();
                            meuAluno.setID(cod_aluno);

                            Mensagem minhaMsg = new Mensagem(meuAluno, minhaEmpresa, mensagem, assunto, alunoRemetente, dataHoraEnvio);
                            minhaMsg.setID(cod_mensagem);
                            listaMensagensEmpresa.add(minhaMsg);

                            temMensagens = true;
                        }

                        if (temMensagens) {
                            out.writeObject("temMensagens");
                            out.writeObject(listaMensagensEmpresa);
                            listaMensagensEmpresa.clear();
                        } else {
                            out.writeObject("naoTemMensagens");
                        }
                        break;
                    }
                    case "listaVagasEmEspera": {
                        out.writeObject("Ok");

                        Aluno meuAluno = (Aluno) in.readObject();

                        String consulta = "SELECT * FROM aplicacao WHERE aplicacao.Aluno_cod_aluno = " + meuAluno.getID() + " AND aplicacao.movimentada = 0";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_vaga = 0;

                        while (rs.next()) {
                            cod_vaga = Integer.parseInt(rs.getString("Vaga_cod_vaga"));
                        }

                        consulta = "SELECT * FROM vaga WHERE cod_vaga = " + cod_vaga + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String setor = "";
                        boolean remunerada = false;
                        String nome = "";
                        float salario = 0;
                        String descricao = "";
                        boolean preenchida = false;
                        int turno = 0;
                        int cod_empresa = 0;
                        LocalDate dataPublicacao = null;

                        boolean temVagas = false;

                        while (rs.next()) {
                            setor = rs.getString("setor");
                            nome = rs.getString("nome");
                            remunerada = Boolean.valueOf(rs.getString("remunerada"));
                            salario = Float.parseFloat(rs.getString("salario"));
                            descricao = rs.getString("descricao");
                            preenchida = Boolean.valueOf(rs.getString("preenchida"));
                            turno = Integer.parseInt(rs.getString("turno"));
                            cod_empresa = Integer.parseInt(rs.getString("Empresa_cod_empresa"));
                            dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));

                            temVagas = true;

                            if (temVagas) {
                                consulta = "SELECT * FROM empresa WHERE cod_empresa = " + cod_empresa + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String razaoSocial = "";
                                String nomeFantasia = "";
                                long cnpj = 0;
                                int cod_pessoa = 0;

                                while (rs.next()) {
                                    razaoSocial = rs.getString("razaoSocial");
                                    nomeFantasia = rs.getString("nomeFantasia");
                                    cnpj = Long.parseLong(rs.getString("cnpj"));
                                    cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                                }

                                consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                int cod_endereco = 0;
                                int telefone = 0;
                                int ddd = 0;

                                while (rs.next()) {
                                    cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                                    telefone = Integer.parseInt(rs.getString("telefone"));
                                    ddd = Integer.parseInt(rs.getString("ddd"));
                                }

                                consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String rua = "";
                                int numero = 0;
                                String bairro = "";
                                String cidade = "";
                                String complemento = "";
                                int cep = 0;

                                while (rs.next()) {
                                    rua = rs.getString("rua");
                                    numero = Integer.parseInt(rs.getString("numero"));
                                    bairro = rs.getString("bairro");
                                    cidade = rs.getString("cidade");
                                    complemento = rs.getString("complemento");
                                    cep = Integer.parseInt(rs.getString("cep"));
                                }

                                Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                                endereco.setComplemento(complemento);

                                consulta = "SELECT email FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String email = "";
                                String senha = "";

                                while (rs.next()) {
                                    email = rs.getString("email");
                                }

                                Empresa minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);
                                minhaEmpresa.setID(cod_empresa);

                                Vaga vaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                                vaga.setSalario(salario);
                                vaga.setTurnoLiteral();
                                vaga.setID(cod_vaga);

                                if (!preenchida) {
                                    listaVagasEmEspera.add(vaga);
                                }
                            }
                        }
                        if (temVagas) {
                            out.writeObject("temVagas");
                            out.writeObject(listaVagasEmEspera);
                            listaVagasEmEspera.clear();
                        } else {
                            out.writeObject("nenhumaVagaCadastrada");
                        }
                        break;
                    }
                    case "salvarDadosContaEmpresa": {
                        out.writeObject("Ok");

                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT Pessoa_cod_pessoa FROM empresa WHERE cod_empresa = " + minhaEmpresa.getID() + "";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();
                        int cod_pessoa = 0;

                        while (rs.next()) {
                            cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                        }

                        consulta = "SELECT Endereco_cod_endereco FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();
                        int cod_endereco = 0;

                        while (rs.next()) {
                            cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                        }

                        String update = "UPDATE endereco SET rua = '" + minhaEmpresa.getEndereco().getRua() + "',numero = " + minhaEmpresa.getEndereco().getNumero() + ",bairro = '" + minhaEmpresa.getEndereco().getBairro() + "',complemento = '" + minhaEmpresa.getEndereco().getComplemento() + "',cep = " + minhaEmpresa.getEndereco().getCep() + ",cidade = '" + minhaEmpresa.getEndereco().getCidade() + "' WHERE cod_endereco = " + cod_endereco + "";
                        st.executeUpdate(update);
                        out.writeObject("empresaAtualizada");

                        break;
                    }
                    case "listaVagasAbertasEmpresa": {
                        out.writeObject("Ok");

                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT * FROM vaga WHERE Empresa_cod_empresa = " + minhaEmpresa.getID() + " AND preenchida = 0";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        String nome = "";
                        String setor = "";
                        boolean remunerada = false;
                        int remuneradaInteiro = 0;
                        float salario = 0;
                        String descricao = "";
                        boolean preenchida = false;
                        int turno = 0;
                        LocalDate dataPublicacao = null;
                        int totalAplicacoes = 0;

                        boolean temVagas = false;

                        while (rs.next()) {
                            temVagas = true;

                            nome = rs.getString("nome");
                            setor = rs.getString("setor");
                            remuneradaInteiro = Integer.parseInt(rs.getString("remunerada"));
                            salario = Float.parseFloat(rs.getString("salario"));
                            descricao = rs.getString("descricao");
                            turno = Integer.parseInt(rs.getString("turno"));
                            dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));
                            totalAplicacoes = Integer.parseInt(rs.getString("totalAplicacoes"));

                            if (remuneradaInteiro == 1) {
                                remunerada = true;
                            }

                            Vaga minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, totalAplicacoes, minhaEmpresa);
                            minhaVaga.setTurnoLiteral();
                            minhaVaga.setSalario(salario);

                            listaVagasAbertasEmpresa.add(minhaVaga);
                        }

                        if (temVagas) {
                            out.writeObject("temVagas");
                            out.writeObject(listaVagasAbertasEmpresa);
                            listaVagasAbertasEmpresa.clear();

                        } else {
                            out.writeObject("nenhumaVagaCadastrada");
                        }
                        break;
                    }
                    case "listaVagasEmpresa": {
                        out.writeObject("Ok");

                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT * FROM vaga WHERE Empresa_cod_empresa = " + minhaEmpresa.getID() + " ";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        String nome = "";
                        String setor = "";
                        boolean remunerada = false;
                        int remuneradaInteiro = 0;
                        float salario = 0;
                        String descricao = "";
                        int preenchidaInt = 0;
                        int turno = 0;
                        LocalDate dataPublicacao = null;
                        int totalAplicacoes = 0;

                        boolean temVagas = false;

                        while (rs.next()) {
                            temVagas = true;
                            boolean preenchida = false;

                            nome = rs.getString("nome");
                            setor = rs.getString("setor");
                            remuneradaInteiro = Integer.parseInt(rs.getString("remunerada"));
                            salario = Float.parseFloat(rs.getString("salario"));
                            descricao = rs.getString("descricao");
                            turno = Integer.parseInt(rs.getString("turno"));
                            dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));
                            totalAplicacoes = Integer.parseInt(rs.getString("totalAplicacoes"));
                            preenchidaInt = Integer.parseInt(rs.getString("preenchida"));

                            if (preenchidaInt == 1) {
                                preenchida = true;
                            }

                            if (remuneradaInteiro == 1) {
                                remunerada = true;
                            }

                            Vaga minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, totalAplicacoes, minhaEmpresa);
                            minhaVaga.setTurnoLiteral();
                            minhaVaga.setSalario(salario);
                            minhaVaga.setPreenchida(preenchida);

                            listaVagasHistoricoEmpresa.add(minhaVaga);
                        }

                        if (temVagas) {
                            out.writeObject("temVagas");
                            out.writeObject(listaVagasHistoricoEmpresa);
                            listaVagasHistoricoEmpresa.clear();

                        } else {
                            out.writeObject("nenhumaVagaCadastrada");
                        }
                        break;
                    }
                    case "detalhaVagaEmpresa": {
                        out.writeObject("Ok");

                        String nomeSelecionada = (String) in.readObject();
                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT * FROM vaga WHERE nome LIKE '" + nomeSelecionada + "' ";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        String nome = "";
                        String setor = "";
                        boolean remunerada = false;
                        int remuneradaInteiro = 0;
                        float salario = 0;
                        String descricao = "";
                        boolean preenchida = false;
                        int turno = 0;
                        int cod_vaga = 0;
                        LocalDate dataPublicacao = null;

                        while (rs.next()) {
                            nome = rs.getString("nome");
                            setor = rs.getString("setor");
                            remuneradaInteiro = Integer.parseInt(rs.getString("remunerada"));
                            salario = Float.parseFloat(rs.getString("salario"));
                            descricao = rs.getString("descricao");
                            turno = Integer.parseInt(rs.getString("turno"));
                            cod_vaga = Integer.parseInt(rs.getString("cod_vaga"));
                            dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));

                            if (remuneradaInteiro == 1) {
                                remunerada = true;
                            }
                        }

                        Vaga minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                        minhaVaga.setTurnoLiteral();
                        minhaVaga.setSalario(salario);
                        minhaVaga.setID(cod_vaga);

                        out.writeObject(minhaVaga);
                        break;
                    }
                    case "editarVaga": {
                        out.writeObject("Ok");

                        Vaga minhaVaga = (Vaga) in.readObject();
                        int remunerada = 0;
                        if (minhaVaga.isRemunerada()) {
                            remunerada = 1;
                        }

                        String update = "UPDATE vaga SET nome = '" + minhaVaga.getNome() + "', descricao = '" + minhaVaga.getDescricao() + "', remunerada = " + remunerada + ", salario = " + minhaVaga.getSalario() + ", preenchida = 0, turno = " + minhaVaga.getTurno() + ", turnoLiteral = '" + minhaVaga.getTurnoLiteral() + "', setor = '" + minhaVaga.getSetor() + "' WHERE cod_vaga = " + minhaVaga.getID() + "";
                        st.executeUpdate(update);

                        out.writeObject("vagaEditada");
                        break;
                    }
                    case "cadastraVaga": {
                        out.writeObject("Ok");

                        Vaga minhaVaga = (Vaga) in.readObject();
                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        int remunerada = 0;
                        if (minhaVaga.isRemunerada()) {
                            remunerada = 1;
                        }

                        String consulta = "SELECT cod_vaga FROM vaga WHERE nome LIKE '" + minhaVaga.getNome() + "' AND descricao LIKE '" + minhaVaga.getDescricao() + "' AND remunerada = " + remunerada + " AND salario = " + minhaVaga.getSalario() + " AND turno = " + minhaVaga.getTurno() + " AND turnoLiteral LIKE '" + minhaVaga.getTurnoLiteral() + "' AND setor LIKE '" + minhaVaga.getSetor() + "' ";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        boolean vagaCadastrada = false;

                        while (rs.next()) {
                            vagaCadastrada = true;
                        }

                        if (!vagaCadastrada) {
                            consulta = "SELECT cod_empresa FROM empresa WHERE cnpj = " + minhaEmpresa.getCnpj() + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_empresa = 0;

                            while (rs.next()) {
                                cod_empresa = Integer.parseInt(rs.getString("cod_empresa"));
                            }

                            String insert = "INSERT INTO vaga(nome, descricao, remunerada, salario, preenchida, turno, turnoLiteral, setor, Empresa_cod_empresa,dataPublicacao,totalAplicacoes) VALUES ('" + minhaVaga.getNome() + "','" + minhaVaga.getDescricao() + "'," + remunerada + "," + minhaVaga.getSalario() + ",0," + minhaVaga.getTurno() + ",'" + minhaVaga.getTurnoLiteral() + "','" + minhaVaga.getSetor() + "'," + cod_empresa + ", '" + minhaVaga.getDataPublicacao() + "', 0)";
                            st.executeUpdate(insert);

                            consulta = "SELECT cod_vaga FROM vaga WHERE nome LIKE '" + minhaVaga.getNome() + "' AND descricao LIKE '" + minhaVaga.getDescricao() + "' AND remunerada = " + remunerada + " AND salario = " + minhaVaga.getSalario() + " AND turno = " + minhaVaga.getTurno() + " AND turnoLiteral LIKE '" + minhaVaga.getTurnoLiteral() + "' AND setor LIKE '" + minhaVaga.getSetor() + "' ";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_vaga = 0;

                            while (rs.next()) {
                                cod_vaga = Integer.parseInt(rs.getString("cod_vaga"));
                            }

                            out.writeObject("vagaCadastrada");
                            out.writeObject(cod_vaga);
                        } else {
                            out.writeObject("vagaJaCadastrada");
                        }
                        break;
                    }
                    case "listaRecebidosEmpresa": {
                        out.writeObject("Ok");

                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT * FROM aplicacao a, vaga v, aluno al, pessoa p, endereco ed WHERE p.Endereco_cod_endereco = ed.cod_endereco AND al.Pessoa_cod_pessoa = p.cod_pessoa AND a.Aluno_cod_aluno = al.cod_aluno AND a.Vaga_cod_vaga = v.cod_vaga AND v.Empresa_cod_empresa = " + minhaEmpresa.getID() + " AND a.movimentada = 0";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        boolean movimentada = false;
                        boolean aceita = false;

                        boolean temAplicacoes = false;

                        while (rs.next()) {
                            temAplicacoes = true;

                            int cod_aluno = Integer.parseInt(rs.getString("a.Aluno_cod_aluno"));
                            int cod_vaga = Integer.parseInt(rs.getString("a.Vaga_cod_vaga"));

                            long matricula = Long.parseLong(rs.getString("al.matricula"));
                            int ano = Integer.parseInt(rs.getString("al.ano"));
                            String curso = rs.getString("al.curso");
                            int turno = Integer.parseInt(rs.getString("al.turno"));
                            String nomeCompleto = rs.getString("al.nomeCompleto");
                            int sexo = Integer.parseInt(rs.getString("al.sexo"));
                            long cpf = Long.parseLong(rs.getString("al.cpf"));
                            long rg = Long.parseLong(rs.getString("al.rg"));
                            LocalDate dataNascimento = LocalDate.parse(rs.getString("al.dataNascimento"));

                            String email = "";
                            String senha = "";

                            int telefone = Integer.parseInt(rs.getString("p.telefone"));
                            int ddd = Integer.parseInt(rs.getString("p.ddd"));

                            String rua = rs.getString("ed.rua");
                            int numero = Integer.parseInt(rs.getString("ed.numero"));
                            String bairro = rs.getString("ed.bairro");
                            String cidade = rs.getString("ed.cidade");
                            int cep = Integer.parseInt(rs.getString("ed.cep"));
                            String complemento = rs.getString("ed.complemento");

                            Endereco meuEndereco = new Endereco(rua, numero, bairro, cidade, cep);
                            meuEndereco.setComplemento(complemento);

                            Aluno meuAluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, meuEndereco, telefone, ddd, email, senha);
                            meuAluno.setTurnoLiteral();
                            meuAluno.setSexoLiteral();
                            meuAluno.setID(cod_aluno);
                            meuAluno.setIdade(dataNascimento);

                            boolean remunerada = false;
                            float salario = 0;
                            boolean preenchida = false;

                            String nome = rs.getString("v.nome");
                            String setor = rs.getString("v.setor");
                            int remuneradaInteiro = Integer.parseInt(rs.getString("v.remunerada"));
                            salario = Float.parseFloat(rs.getString("v.salario"));
                            String descricao = rs.getString("v.descricao");
                            int turnoVaga = Integer.parseInt(rs.getString("v.turno"));
                            LocalDate dataPublicacao = LocalDate.parse(rs.getString("v.dataPublicacao"));

                            Vaga minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turnoVaga, dataPublicacao, 0, minhaEmpresa);
                            if (remuneradaInteiro == 1) {
                                minhaVaga.setRemunerada(true);
                                minhaVaga.setSalario(salario);
                            }
                            minhaVaga.setTurnoLiteral();
                            minhaVaga.setID(cod_vaga);

                            Aplicacao minhaApp = new Aplicacao(meuAluno, minhaVaga, movimentada);
                            minhaApp.setAceita(aceita);

                            listaAplicacoesRecebidas.add(minhaApp);
                        }

                        if (temAplicacoes) {
                            out.writeObject("temAplicacoes");
                            out.writeObject(listaAplicacoesRecebidas);
                            listaAplicacoesRecebidas.clear();
                        } else {
                            out.writeObject("naoTemAplicacoesRecebidas");
                        }
                        break;
                    }
                    case "listaAceitosEmpresa": {
                        out.writeObject("Ok");

                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT * FROM aplicacao a, vaga v WHERE v.cod_vaga = a.Vaga_cod_vaga AND v.Empresa_cod_empresa = " + minhaEmpresa.getID() + " AND a.movimentada = 1 AND a.aceita = 1";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_aluno = 0;
                        int cod_vaga = 0;
                        boolean movimentada = true;
                        boolean aceita = true;

                        boolean temAplicacoes = false;

                        while (rs.next()) {
                            temAplicacoes = true;

                            cod_aluno = Integer.parseInt(rs.getString("Aluno_cod_aluno"));
                            cod_vaga = Integer.parseInt(rs.getString("Vaga_cod_vaga"));

                            consulta = "SELECT * FROM aluno WHERE cod_aluno = " + cod_aluno;
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            long matricula = 0;
                            int ano = 0;
                            String curso = "";
                            int turno = 0;
                            String nomeCompleto = "";
                            int sexo = 0;
                            long cpf = 0;
                            long rg = 0;
                            LocalDate dataNascimento = null;
                            String caminhoCurriculo = "";
                            int ID = 0;
                            int IDpessoa = 0;

                            while (rs.next()) {
                                matricula = Long.parseLong(rs.getString("matricula"));
                                ano = Integer.parseInt(rs.getString("ano"));
                                curso = rs.getString("curso");
                                turno = Integer.parseInt(rs.getString("turno"));
                                nomeCompleto = rs.getString("nomeCompleto");
                                sexo = Integer.parseInt(rs.getString("sexo"));
                                cpf = Long.parseLong(rs.getString("cpf"));
                                rg = Long.parseLong(rs.getString("rg"));

                                dataNascimento = LocalDate.parse(rs.getString("dataNascimento"));
                                ID = Integer.parseInt(rs.getString("cod_aluno"));
                                IDpessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                            }

                            consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + IDpessoa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            Endereco meuEndereco = null;
                            int cod_endereco = 0;
                            int telefone = 0;
                            int ddd = 0;
                            String email = "";
                            String senha = "";

                            while (rs.next()) {
                                telefone = Integer.parseInt(rs.getString("telefone"));
                                ddd = Integer.parseInt(rs.getString("ddd"));
                                cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));

                                consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco;
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String rua = "";
                                int numero = 0;
                                String bairro = "";
                                String cidade = "";
                                int cep = 0;

                                while (rs.next()) {
                                    rua = rs.getString("rua");
                                    numero = Integer.parseInt(rs.getString("numero"));
                                    bairro = rs.getString("bairro");
                                    cidade = rs.getString("cidade");
                                    cep = Integer.parseInt(rs.getString("cep"));

                                    meuEndereco = new Endereco(rua, numero, bairro, cidade, cep);
                                }
                            }

                            consulta = "SELECT * FROM curriculo WHERE Aluno_cod_aluno = " + cod_aluno + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int cod_curriculo = 0;
                            String descricaoCurriculo = "";
                            String formacao1 = "";
                            String formacao2 = "";
                            String formacao3 = "";
                            String idioma1 = "";
                            String idioma2 = "";
                            String idioma3 = "";
                            String curso1 = "";
                            String curso2 = "";
                            String curso3 = "";
                            String emprego1 = "";
                            String emprego2 = "";
                            String emprego3 = "";

                            while (rs.next()) {
                                descricaoCurriculo = rs.getString("descricao");
                                formacao1 = rs.getString("formacao1");
                                formacao2 = rs.getString("formacao2");
                                formacao3 = rs.getString("formacao3");
                                idioma1 = rs.getString("idioma1");
                                idioma2 = rs.getString("idioma2");
                                idioma3 = rs.getString("idioma3");
                                curso1 = rs.getString("curso1");
                                curso2 = rs.getString("curso2");
                                curso3 = rs.getString("curso3");
                                emprego1 = rs.getString("emprego1");
                                emprego2 = rs.getString("emprego2");
                                emprego3 = rs.getString("emprego3");
                                ID = Integer.parseInt(rs.getString("cod_curriculo"));
                            }

                            Curriculo meuCurriculo = new Curriculo(descricaoCurriculo, formacao1, formacao2, formacao3, idioma1, idioma2, idioma3, curso1, curso2, curso3, emprego1, emprego2, emprego3);
                            meuCurriculo.setID(cod_curriculo);

                            Aluno meuAluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, meuEndereco, telefone, ddd, email, senha);
                            meuAluno.setTurnoLiteral();
                            meuAluno.setSexoLiteral();
                            meuAluno.setID(ID);
                            meuAluno.setIdade(dataNascimento);
                            meuAluno.setCurriculo(meuCurriculo);

                            consulta = "SELECT * FROM vaga WHERE cod_vaga = " + cod_vaga;
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String nome = "";
                            String setor = "";
                            boolean remunerada = false;
                            int remuneradaInteiro = 0;
                            float salario = 0;
                            String descricao = "";
                            boolean preenchida = false;
                            int turnoVaga = 0;
                            int IDvaga = 0;
                            LocalDate dataPublicacao = null;

                            while (rs.next()) {
                                nome = rs.getString("nome");
                                setor = rs.getString("setor");
                                remuneradaInteiro = Integer.parseInt(rs.getString("remunerada"));
                                salario = Float.parseFloat(rs.getString("salario"));
                                descricao = rs.getString("descricao");
                                turnoVaga = Integer.parseInt(rs.getString("turno"));
                                IDvaga = Integer.parseInt(rs.getString("cod_vaga"));
                                dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));
                            }

                            Vaga minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turnoVaga, dataPublicacao, 0, minhaEmpresa);
                            if (remuneradaInteiro == 1) {
                                minhaVaga.setRemunerada(true);
                                minhaVaga.setSalario(salario);
                            }
                            minhaVaga.setTurnoLiteral();
                            minhaVaga.setID(IDvaga);

                            Aplicacao minhaApp = new Aplicacao(meuAluno, minhaVaga, movimentada);
                            minhaApp.setAceita(aceita);

                            listaAplicacoesAceitas.add(minhaApp);
                        }

                        if (temAplicacoes) {
                            out.writeObject("temAplicacoes");
                            out.writeObject(listaAplicacoesAceitas);
                            listaAplicacoesAceitas.clear();
                        } else {
                            out.writeObject("naoTemAplicacoesAceitas");
                        }
                        break;
                    }
                    case "detalhaAplicacaoEmpresa": {
                        out.writeObject("Ok");

                        String selecionadaNome = (String) in.readObject();
                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT cod_aluno FROM aluno WHERE nomeCompleto LIKE '" + selecionadaNome + "'";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_aluno = 0;

                        while (rs.next()) {
                            cod_aluno = Integer.parseInt(rs.getString("cod_aluno"));
                        }

                        consulta = "SELECT * FROM aplicacao WHERE Aluno_cod_aluno = " + cod_aluno;
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        int cod_vaga = 0;
                        boolean movimentada = false;
                        int movimentadaInt = 0;
                        boolean aceita = false;
                        int aceitaInt = 0;
                        int cod_app = 0;

                        while (rs.next()) {
                            cod_vaga = Integer.parseInt(rs.getString("Vaga_cod_vaga"));
                            movimentadaInt = Integer.parseInt(rs.getString("movimentada"));
                            aceitaInt = Integer.parseInt(rs.getString("aceita"));
                            cod_app = Integer.parseInt(rs.getString("cod_aplicacao"));
                        }

                        if (movimentadaInt == 1) {
                            movimentada = true;
                        }

                        if (aceitaInt == 1) {
                            aceita = true;
                        }

                        consulta = "SELECT * FROM vaga WHERE cod_vaga = " + cod_vaga;
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String nome = "";
                        String setor = "";
                        boolean remunerada = false;
                        int remuneradaInteiro = 0;
                        float salario = 0;
                        String descricao = "";
                        boolean preenchida = false;
                        int turno = 0;
                        LocalDate dataPublicacao = null;

                        while (rs.next()) {
                            nome = rs.getString("nome");
                            setor = rs.getString("setor");
                            remuneradaInteiro = Integer.parseInt(rs.getString("remunerada"));
                            salario = Float.parseFloat(rs.getString("salario"));
                            descricao = rs.getString("descricao");
                            turno = Integer.parseInt(rs.getString("turno"));
                            cod_vaga = Integer.parseInt(rs.getString("cod_vaga"));
                            dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));

                            if (remuneradaInteiro == 1) {
                                remunerada = true;
                            }
                        }

                        Vaga minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                        minhaVaga.setTurnoLiteral();
                        minhaVaga.setSalario(salario);
                        minhaVaga.setID(cod_vaga);

                        consulta = "SELECT * FROM aluno WHERE cod_aluno = " + cod_aluno;
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        long matricula = 0;
                        int ano = 0;
                        String curso = "";
                        int turnoAluno = 0;
                        String nomeCompleto = "";
                        int sexo = 0;
                        long cpf = 0;
                        long rg = 0;
                        LocalDate dataNascimento = null;
                        int ID = 0;
                        int IDpessoa = 0;

                        while (rs.next()) {
                            matricula = Long.parseLong(rs.getString("matricula"));
                            ano = Integer.parseInt(rs.getString("ano"));
                            curso = rs.getString("curso");
                            turnoAluno = Integer.parseInt(rs.getString("turno"));
                            nomeCompleto = rs.getString("nomeCompleto");
                            sexo = Integer.parseInt(rs.getString("sexo"));
                            cpf = Long.parseLong(rs.getString("cpf"));
                            rg = Long.parseLong(rs.getString("rg"));

                            dataNascimento = LocalDate.parse(rs.getString("dataNascimento"));
                            ID = Integer.parseInt(rs.getString("cod_aluno"));
                            IDpessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                        }

                        consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + IDpessoa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        Endereco meuEndereco = null;
                        int cod_endereco = 0;
                        int telefone = 0;
                        int ddd = 0;
                        String email = "";
                        String senha = "";
                        int cod_pessoa = 0;

                        while (rs.next()) {
                            telefone = Integer.parseInt(rs.getString("telefone"));
                            ddd = Integer.parseInt(rs.getString("ddd"));
                            cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                            cod_pessoa = Integer.parseInt(rs.getString("cod_pessoa"));

                            consulta = "SELECT email FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            while (rs.next()) {
                                email = rs.getString("email");
                            }

                            consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco;
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String rua = "";
                            int numero = 0;
                            String bairro = "";
                            String cidade = "";
                            int cep = 0;

                            while (rs.next()) {
                                rua = rs.getString("rua");
                                numero = Integer.parseInt(rs.getString("numero"));
                                bairro = rs.getString("bairro");
                                cidade = rs.getString("cidade");
                                cep = Integer.parseInt(rs.getString("cep"));

                                meuEndereco = new Endereco(rua, numero, bairro, cidade, cep);
                            }
                        }

                        consulta = "SELECT * FROM curriculo WHERE Aluno_cod_aluno = " + cod_aluno + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        int cod_curriculo = 0;
                        String descricaoCurriculo = "";
                        String formacao1 = "";
                        String formacao2 = "";
                        String formacao3 = "";
                        String idioma1 = "";
                        String idioma2 = "";
                        String idioma3 = "";
                        String curso1 = "";
                        String curso2 = "";
                        String curso3 = "";
                        String emprego1 = "";
                        String emprego2 = "";
                        String emprego3 = "";

                        while (rs.next()) {
                            descricao = rs.getString("descricao");
                            formacao1 = rs.getString("formacao1");
                            formacao2 = rs.getString("formacao2");
                            formacao3 = rs.getString("formacao3");
                            idioma1 = rs.getString("idioma1");
                            idioma2 = rs.getString("idioma2");
                            idioma3 = rs.getString("idioma3");
                            curso1 = rs.getString("curso1");
                            curso2 = rs.getString("curso2");
                            curso3 = rs.getString("curso3");
                            emprego1 = rs.getString("emprego1");
                            emprego2 = rs.getString("emprego2");
                            emprego3 = rs.getString("emprego3");
                            ID = Integer.parseInt(rs.getString("cod_curriculo"));
                        }

                        Curriculo meuCurriculo = new Curriculo(descricaoCurriculo, formacao1, formacao2, formacao3, idioma1, idioma2, idioma3, curso1, curso2, curso3, emprego1, emprego2, emprego3);
                        meuCurriculo.setID(cod_curriculo);

                        Aluno meuAluno = new Aluno(matricula, ano, curso, turnoAluno, nomeCompleto, sexo, cpf, rg, dataNascimento, meuEndereco, telefone, ddd, email, senha);
                        meuAluno.setTurnoLiteral();
                        meuAluno.setSexoLiteral();
                        meuAluno.setID(ID);
                        meuAluno.setCurriculo(meuCurriculo);

                        Aplicacao minhaApp = new Aplicacao(meuAluno, minhaVaga, movimentada);
                        minhaApp.setID(cod_app);
                        minhaApp.setAceita(aceita);

                        out.writeObject(minhaApp);

                        break;
                    }

                    case "verificaEmail": {
                        out.writeObject("Ok");
                        String email = (String) in.readObject();
                        boolean emailEmUso = false;
                        String consulta = "SELECT cod_usuario FROM usuario WHERE email LIKE '" + email + "'";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();
                        while (rs.next()) {
                            emailEmUso = true;
                        }

                        if (emailEmUso) {
                            out.writeObject("emailEmUso");
                        } else {
                            out.writeObject("emailDisponivel");
                        }
                        break;
                    }
                    case "listaRecusadosEmpresa": {
                        out.writeObject("Ok");

                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT * FROM aplicacao a, vaga v WHERE v.cod_vaga = a.Vaga_cod_vaga AND v.Empresa_cod_empresa = " + minhaEmpresa.getID() + " AND a.movimentada = 1 AND a.aceita = 0";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_aluno = 0;
                        int cod_vaga = 0;
                        boolean movimentada = true;
                        boolean aceita = false;

                        boolean temAplicacoes = false;

                        while (rs.next()) {
                            temAplicacoes = true;

                            cod_aluno = Integer.parseInt(rs.getString("Aluno_cod_aluno"));
                            cod_vaga = Integer.parseInt(rs.getString("Vaga_cod_vaga"));

                            consulta = "SELECT * FROM aluno WHERE cod_aluno = " + cod_aluno;
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            long matricula = 0;
                            int ano = 0;
                            String curso = "";
                            int turno = 0;
                            String nomeCompleto = "";
                            int sexo = 0;
                            long cpf = 0;
                            long rg = 0;
                            LocalDate dataNascimento = null;
                            int ID = 0;
                            int IDpessoa = 0;

                            while (rs.next()) {
                                matricula = Long.parseLong(rs.getString("matricula"));
                                ano = Integer.parseInt(rs.getString("ano"));
                                curso = rs.getString("curso");
                                turno = Integer.parseInt(rs.getString("turno"));
                                nomeCompleto = rs.getString("nomeCompleto");
                                sexo = Integer.parseInt(rs.getString("sexo"));
                                cpf = Long.parseLong(rs.getString("cpf"));
                                rg = Long.parseLong(rs.getString("rg"));

                                dataNascimento = LocalDate.parse(rs.getString("dataNascimento"));
                                ID = Integer.parseInt(rs.getString("cod_aluno"));
                                IDpessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                            }

                            consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + IDpessoa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            Endereco meuEndereco = null;
                            int cod_endereco = 0;
                            int telefone = 0;
                            int ddd = 0;
                            String email = "";
                            String senha = "";

                            while (rs.next()) {
                                telefone = Integer.parseInt(rs.getString("telefone"));
                                ddd = Integer.parseInt(rs.getString("ddd"));
                                cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));

                                consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco;
                                st.executeQuery(consulta);
                                rs = st.getResultSet();

                                String rua = "";
                                int numero = 0;
                                String bairro = "";
                                String cidade = "";
                                int cep = 0;

                                while (rs.next()) {
                                    rua = rs.getString("rua");
                                    numero = Integer.parseInt(rs.getString("numero"));
                                    bairro = rs.getString("bairro");
                                    cidade = rs.getString("cidade");
                                    cep = Integer.parseInt(rs.getString("cep"));

                                    meuEndereco = new Endereco(rua, numero, bairro, cidade, cep);
                                }
                            }
                            
                            consulta = "SELECT * FROM curriculo WHERE Aluno_cod_aluno = " + cod_aluno + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int IDcurriculo = 0;
                            String descricao = "";
                            String formacao1 = "";
                            String formacao2 = "";
                            String formacao3 = "";
                            String idioma1 = "";
                            String idioma2 = "";
                            String idioma3 = "";
                            String curso1 = "";
                            String curso2 = "";
                            String curso3 = "";
                            String emprego1 = "";
                            String emprego2 = "";
                            String emprego3 = "";

                            while (rs.next()) {
                                descricao = rs.getString("descricao");
                                formacao1 = rs.getString("formacao1");
                                formacao2 = rs.getString("formacao2");
                                formacao3 = rs.getString("formacao3");
                                idioma1 = rs.getString("idioma1");
                                idioma2 = rs.getString("idioma2");
                                idioma3 = rs.getString("idioma3");
                                curso1 = rs.getString("curso1");
                                curso2 = rs.getString("curso2");
                                curso3 = rs.getString("curso3");
                                emprego1 = rs.getString("emprego1");
                                emprego2 = rs.getString("emprego2");
                                emprego3 = rs.getString("emprego3");
                                ID = Integer.parseInt(rs.getString("cod_curriculo"));
                            }

                            Curriculo meuCurriculo = new Curriculo(descricao, formacao1, formacao2, formacao3, idioma1, idioma2, idioma3, curso1, curso2, curso3, emprego1, emprego2, emprego3);
                            meuCurriculo.setID(IDcurriculo);

                            Aluno meuAluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, meuEndereco, telefone, ddd, email, senha);
                            meuAluno.setTurnoLiteral();
                            meuAluno.setSexoLiteral();
                            meuAluno.setID(ID);
                            meuAluno.setIdade(dataNascimento);
                            meuAluno.setCurriculo(meuCurriculo);

                            consulta = "SELECT * FROM vaga WHERE cod_vaga = " + cod_vaga;
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String nome = "";
                            String setor = "";
                            boolean remunerada = false;
                            int remuneradaInteiro = 0;
                            float salario = 0;
                            String descricaoVaga = "";
                            boolean preenchida = false;
                            int turnoVaga = 0;
                            int IDvaga = 0;
                            LocalDate dataPublicacao = null;

                            while (rs.next()) {
                                nome = rs.getString("nome");
                                setor = rs.getString("setor");
                                remuneradaInteiro = Integer.parseInt(rs.getString("remunerada"));
                                salario = Float.parseFloat(rs.getString("salario"));
                                descricao = rs.getString("descricao");
                                turnoVaga = Integer.parseInt(rs.getString("turno"));
                                IDvaga = Integer.parseInt(rs.getString("cod_vaga"));
                                dataPublicacao = LocalDate.parse(rs.getString("dataPublicacao"));

                            }

                            Vaga minhaVaga = new Vaga(nome, setor, remunerada, descricaoVaga, preenchida, turnoVaga, dataPublicacao, 0, minhaEmpresa);
                            if (remuneradaInteiro == 1) {
                                minhaVaga.setRemunerada(true);
                                minhaVaga.setSalario(salario);
                            }
                            minhaVaga.setTurnoLiteral();
                            minhaVaga.setID(IDvaga);

                            Aplicacao minhaApp = new Aplicacao(meuAluno, minhaVaga, movimentada);
                            minhaApp.setAceita(aceita);

                            listaAplicacoesRecusadasEmpresa.add(minhaApp);
                        }

                        if (temAplicacoes) {
                            out.writeObject("temAplicacoes");
                            out.writeObject(listaAplicacoesRecusadasEmpresa);
                            listaAplicacoesRecusadasEmpresa.clear();
                        } else {
                            out.writeObject("naoTemAplicacoesRecusadas");
                        }
                        break;
                    }
                    case "aceitarAplicacao": {
                        out.writeObject("Ok");

                        Aplicacao minhaApp = (Aplicacao) in.readObject();

                        String update = "UPDATE aplicacao SET aceita = 1, movimentada = 1 WHERE cod_aplicacao = " + minhaApp.getID() + "";
                        st.executeUpdate(update);

                        update = "UPDATE vaga SET preenchida = 1 WHERE cod_vaga = " + minhaApp.getVaga().getID() + "";
                        st.executeUpdate(update);

                        out.writeObject("aplicacaoAceita");
                        break;
                    }
                    case "recusarAplicacao": {
                        out.writeObject("Ok");

                        Aplicacao minhaApp = (Aplicacao) in.readObject();

                        String update = "UPDATE aplicacao SET aceita = 0, movimentada = 1 WHERE cod_aplicacao = " + minhaApp.getID() + "";
                        st.executeUpdate(update);

                        out.writeObject("aplicacaoRecusada");

                        break;
                    }
                    case "enviaMensagemEmpresa": {
                        out.writeObject("Ok");

                        Mensagem minhaMsg = (Mensagem) in.readObject();

                        String insert = "INSERT INTO mensagem(Aluno_cod_aluno, Empresa_cod_empresa, conteudo, assunto, dataHoraEnvio, alunoRemetente) VALUES (" + minhaMsg.getAluno().getID() + "," + minhaMsg.getEmpresa().getID() + ",'" + minhaMsg.getMensagem() + "','" + minhaMsg.getAssunto() + "','" + minhaMsg.getDataHoraEnvio() + "',0)";
                        st.executeUpdate(insert);

                        String consulta = "SELECT cod_mensagem FROM mensagem WHERE Aluno_cod_aluno = " + minhaMsg.getAluno().getID() + " AND Empresa_cod_empresa = " + minhaMsg.getEmpresa().getID() + " AND conteudo LIKE '" + minhaMsg.getMensagem() + "' AND assunto LIKE '" + minhaMsg.getAssunto() + "' AND dataHoraEnvio LIKE '" + minhaMsg.getDataHoraEnvio() + "' ";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_mensagem = 0;

                        while (rs.next()) {
                            cod_mensagem = Integer.parseInt(rs.getString("cod_mensagem"));
                        }

                        minhaMsg.setID(cod_mensagem);

                        out.writeObject("mensagemEnviada");
                        break;
                    }
                    case "detalhaMensagemAluno": {
                        out.writeObject("Ok");

                        String selecionadaAssunto = (String) in.readObject();
                        Aluno meuAluno = (Aluno) in.readObject();

                        String consulta = "SELECT * FROM mensagem WHERE assunto LIKE '" + selecionadaAssunto + "' AND Aluno_cod_aluno = " + meuAluno.getID() + " AND alunoRemetente = 0";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        String assunto = selecionadaAssunto;
                        String conteudo = "";
                        int cod_empresa = 0;
                        boolean alunoRemetente = false;
                        LocalDateTime dataHoraEnvio = null;

                        while (rs.next()) {
                            conteudo = rs.getString("conteudo");
                            cod_empresa = Integer.parseInt(rs.getString("Empresa_cod_empresa"));
                            dataHoraEnvio = LocalDateTime.parse(rs.getString("dataHoraEnvio"));
                        }

                        consulta = "SELECT * FROM empresa WHERE cod_empresa = " + cod_empresa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String razaoSocial = "";
                        String nomeFantasia = "";
                        long cnpj = 0;
                        int cod_pessoa = 0;

                        while (rs.next()) {
                            razaoSocial = rs.getString("razaoSocial");
                            nomeFantasia = rs.getString("nomeFantasia");
                            cnpj = Long.parseLong(rs.getString("cnpj"));
                            cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                        }

                        consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        int cod_endereco = 0;
                        int telefone = 0;
                        int ddd = 0;

                        while (rs.next()) {
                            cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                            telefone = Integer.parseInt(rs.getString("telefone"));
                            ddd = Integer.parseInt(rs.getString("ddd"));
                        }

                        consulta = "SELECT email FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String email = "";
                        String senha = "";

                        while (rs.next()) {
                            email = rs.getString("email");
                        }

                        consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String rua = "";
                        int numero = 0;
                        String bairro = "";
                        String cidade = "";
                        String complemento = "";
                        int cep = 0;

                        while (rs.next()) {
                            rua = rs.getString("rua");
                            numero = Integer.parseInt(rs.getString("numero"));
                            bairro = rs.getString("bairro");
                            cidade = rs.getString("cidade");
                            complemento = rs.getString("complemento");
                            cep = Integer.parseInt(rs.getString("cep"));
                        }

                        Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                        endereco.setComplemento(complemento);
                        Empresa minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);
                        minhaEmpresa.setID(cod_empresa);

                        Mensagem minhaMsg = new Mensagem(meuAluno, minhaEmpresa, conteudo, assunto, alunoRemetente, dataHoraEnvio);

                        out.writeObject(minhaMsg);

                        break;
                    }
                    case "detalhaMensagemEmpresa": {
                        out.writeObject("Ok");

                        String assunto = (String) in.readObject();
                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT * FROM mensagem WHERE assunto LIKE '" + assunto + "' AND Empresa_cod_empresa = " + minhaEmpresa.getID() + " AND alunoRemetente = 1";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        String conteudo = "";
                        int cod_aluno = 0;
                        boolean alunoRemetente = false;
                        LocalDateTime dataHoraEnvio = null;
                        int cod_mensagem = 0;

                        while (rs.next()) {
                            conteudo = rs.getString("conteudo");
                            cod_aluno = Integer.parseInt(rs.getString("Aluno_cod_aluno"));
                            dataHoraEnvio = LocalDateTime.parse(rs.getString("dataHoraEnvio"));
                            cod_mensagem = Integer.parseInt(rs.getString("cod_mensagem"));
                        }

                        consulta = "SELECT * FROM aluno WHERE cod_aluno = " + cod_aluno + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        long matricula = 0;
                        int ano = 0;
                        String curso = "";
                        int turno = 0;
                        String nomeCompleto = "";
                        int sexo = 0;
                        long cpf = 0;
                        long rg = 0;
                        LocalDate dataNascimento = null;
                        int cod_pessoa = 0;

                        while (rs.next()) {
                            matricula = Long.parseLong(rs.getString("matricula"));
                            ano = Integer.parseInt(rs.getString("ano"));
                            curso = rs.getString("curso");
                            turno = Integer.parseInt(rs.getString("turno"));
                            nomeCompleto = rs.getString("nomeCompleto");
                            sexo = Integer.parseInt(rs.getString("sexo"));
                            cpf = Long.parseLong(rs.getString("cpf"));
                            rg = Long.parseLong(rs.getString("rg"));

                            dataNascimento = LocalDate.parse(rs.getString("dataNascimento"));
                            cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                        }

                        consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        int cod_endereco = 0;
                        int telefone = 0;
                        int ddd = 0;

                        while (rs.next()) {
                            cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                            telefone = Integer.parseInt(rs.getString("telefone"));
                            ddd = Integer.parseInt(rs.getString("ddd"));
                        }

                        consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String rua = "";
                        int numero = 0;
                        String bairro = "";
                        String cidade = "";
                        String complemento = "";
                        int cep = 0;

                        while (rs.next()) {
                            rua = rs.getString("rua");
                            numero = Integer.parseInt(rs.getString("numero"));
                            bairro = rs.getString("bairro");
                            cidade = rs.getString("cidade");
                            complemento = rs.getString("complemento");
                            cep = Integer.parseInt(rs.getString("cep"));
                        }

                        Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                        endereco.setComplemento(complemento);

                        consulta = "SELECT * FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        String email = "";

                        while (rs.next()) {
                            email = rs.getString("email");
                        }

                        Aluno meuAluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, endereco, telefone, ddd, email, rua);
                        meuAluno.setTurnoLiteral();
                        meuAluno.setSexoLiteral();
                        meuAluno.setID(cod_aluno);

                        Mensagem minhaMsg = new Mensagem(meuAluno, minhaEmpresa, conteudo, assunto, alunoRemetente, dataHoraEnvio);
                        minhaMsg.setID(cod_mensagem);

                        out.writeObject(minhaMsg);

                        break;
                    }
                    case "listaRecebidosPorVaga": {
                        out.writeObject("Ok");

                        Vaga vaga = (Vaga) in.readObject();
                        int remunerada = 0;
                        if (vaga.isRemunerada()) {
                            remunerada = 1;
                        }
                        int preenchida = 0;
                        if (vaga.isPreenchida()) {
                            preenchida = 1;
                        }
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String dataPublicacao = vaga.getDataPublicacao().format(formato);

                        boolean temAplicacoes = false;

                        String consulta = "SELECT * FROM vaga v WHERE v.nome LIKE '" + vaga.getNome() + "'"
                                + " AND v.descricao LIKE '" + vaga.getDescricao() + "'"
                                + " AND v.remunerada = " + remunerada + ""
                                + " AND v.salario = " + vaga.getSalario() + ""
                                + " AND v.preenchida = " + preenchida + ""
                                + " AND v.turno = " + vaga.getTurno() + ""
                                + " AND v.turnoLiteral LIKE '" + vaga.getTurnoLiteral() + "'"
                                + " AND v.setor LIKE '" + vaga.getSetor() + "'"
                                + " AND v.dataPublicacao LIKE '" + dataPublicacao + "'"
                                + " AND v.totalAplicacoes = " + vaga.getTotalAplicacoes() + ""
                                + " AND v.Empresa_cod_empresa = " + vaga.getEmpresa().getID() + "";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_vaga = 0;

                        while (rs.next()) {
                            cod_vaga = Integer.parseInt(rs.getString("v.cod_vaga"));
                        }

                        consulta = "SELECT * FROM aplicacao WHERE Vaga_cod_vaga = " + cod_vaga + " AND movimentada = 0";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        int cod_aluno = 0;
                        int cod_app = 0;

                        while (rs.next()) {
                            temAplicacoes = true;

                            cod_aluno = Integer.parseInt(rs.getString("Aluno_cod_aluno"));
                            cod_app = Integer.parseInt(rs.getString("cod_aplicacao"));

                            consulta = "SELECT * FROM aluno WHERE cod_aluno = " + cod_aluno + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            long matricula = 0;
                            int ano = 0;
                            String curso = "";
                            int turno = 0;
                            String nomeCompleto = "";
                            int sexo = 0;
                            long cpf = 0;
                            long rg = 0;
                            LocalDate dataNascimento = null;
                            int cod_pessoa = 0;

                            while (rs.next()) {
                                matricula = Long.parseLong(rs.getString("matricula"));
                                ano = Integer.parseInt(rs.getString("ano"));
                                curso = rs.getString("curso");
                                turno = Integer.parseInt(rs.getString("turno"));
                                nomeCompleto = rs.getString("nomeCompleto");
                                sexo = Integer.parseInt(rs.getString("sexo"));
                                cpf = Long.parseLong(rs.getString("cpf"));
                                rg = Long.parseLong(rs.getString("rg"));
                                dataNascimento = LocalDate.parse(rs.getString("dataNascimento"));
                                cod_pessoa = Integer.parseInt(rs.getString("Pessoa_cod_pessoa"));
                            }

                            consulta = "SELECT * FROM pessoa WHERE cod_pessoa = " + cod_pessoa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int telefone = 0;
                            int ddd = 0;
                            int cod_endereco = 0;

                            while (rs.next()) {
                                telefone = Integer.parseInt(rs.getString("telefone"));
                                ddd = Integer.parseInt(rs.getString("ddd"));
                                cod_endereco = Integer.parseInt(rs.getString("Endereco_cod_endereco"));
                            }

                            consulta = "SELECT * FROM endereco WHERE cod_endereco = " + cod_endereco + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String rua = "";
                            int numero = 0;
                            String bairro = "";
                            String cidade = "";
                            int cep = 0;
                            String complemento = "";

                            while (rs.next()) {
                                rua = rs.getString("rua");
                                numero = Integer.parseInt(rs.getString("numero"));
                                bairro = rs.getString("bairro");
                                cidade = rs.getString("cidade");
                                cep = Integer.parseInt(rs.getString("cep"));
                                complemento = rs.getString("complemento");
                            }

                            Endereco meuEndereco = new Endereco(rua, numero, bairro, cidade, cep);
                            meuEndereco.setComplemento(complemento);

                            consulta = "SELECT email FROM usuario WHERE Pessoa_cod_pessoa = " + cod_pessoa + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            String email = "";

                            while (rs.next()) {
                                email = rs.getString("email");
                            }

                            consulta = "SELECT * FROM curriculo WHERE Aluno_cod_aluno = " + cod_aluno + "";
                            st.executeQuery(consulta);
                            rs = st.getResultSet();

                            int ID = 0;
                            String descricao = "";
                            String formacao1 = "";
                            String formacao2 = "";
                            String formacao3 = "";
                            String idioma1 = "";
                            String idioma2 = "";
                            String idioma3 = "";
                            String curso1 = "";
                            String curso2 = "";
                            String curso3 = "";
                            String emprego1 = "";
                            String emprego2 = "";
                            String emprego3 = "";

                            while (rs.next()) {
                                descricao = rs.getString("descricao");
                                formacao1 = rs.getString("formacao1");
                                formacao2 = rs.getString("formacao2");
                                formacao3 = rs.getString("formacao3");
                                idioma1 = rs.getString("idioma1");
                                idioma2 = rs.getString("idioma2");
                                idioma3 = rs.getString("idioma3");
                                curso1 = rs.getString("curso1");
                                curso2 = rs.getString("curso2");
                                curso3 = rs.getString("curso3");
                                emprego1 = rs.getString("emprego1");
                                emprego2 = rs.getString("emprego2");
                                emprego3 = rs.getString("emprego3");
                                ID = Integer.parseInt(rs.getString("cod_curriculo"));
                            }

                            Curriculo meuCurriculo = new Curriculo(descricao, formacao1, formacao2, formacao3, idioma1, idioma2, idioma3, curso1, curso2, curso3, emprego1, emprego2, emprego3);
                            meuCurriculo.setID(ID);

                            Aluno meuAluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, meuEndereco, telefone, ddd, email, "");
                            meuAluno.setTurnoLiteral();
                            meuAluno.setSexoLiteral();
                            meuAluno.setID(cod_aluno);
                            meuAluno.setCurriculo(meuCurriculo);

                            Aplicacao minhaApp = new Aplicacao(meuAluno, vaga, false);
                            minhaApp.setID(cod_app);

                            listaAplicacoesPorVaga.add(minhaApp);
                        }

                        if (temAplicacoes) {
                            out.writeObject("temAplicacoes");
                            out.writeObject(listaAplicacoesPorVaga);
                            listaAplicacoesPorVaga.clear();
                        } else {
                            out.writeObject("naotemAplicacoes");
                        }
                        break;
                    }
                    case "excluiVaga": {
                        out.writeObject("Ok");

                        String selecionadaNome = (String) in.readObject();
                        Empresa minhaEmpresa = (Empresa) in.readObject();

                        String consulta = "SELECT cod_vaga FROM vaga WHERE nome LIKE '" + selecionadaNome + "' AND Empresa_cod_empresa = " + minhaEmpresa.getID() + "";
                        st.executeQuery(consulta);
                        ResultSet rs = st.getResultSet();

                        int cod_vaga = 0;

                        while (rs.next()) {
                            cod_vaga = Integer.parseInt(rs.getString("cod_vaga"));
                        }

                        consulta = "SELECT * FROM aplicacao WHERE Vaga_cod_vaga = " + cod_vaga + "";
                        st.executeQuery(consulta);
                        rs = st.getResultSet();

                        boolean temAplicacao = false;

                        while (rs.next()) {
                            temAplicacao = true;
                        }

                        if (temAplicacao) {
                            out.writeObject("temAplicacao");

                            mensagemRecebida = (String) in.readObject();
                            if (mensagemRecebida.equals("confirmaExclusao")) {
                                String delete = "DELETE FROM vaga WHERE Empresa_cod_empresa = " + minhaEmpresa.getID() + " AND nome LIKE '" + selecionadaNome + "'";
                                st.executeUpdate(delete);

                                out.writeObject("vagaExcluida");
                            } else if (mensagemRecebida.equals("cancelaExclusao")) {
                                break;
                            }
                            break;
                        } else {
                            out.writeObject("naoTemAplicacao");

                            mensagemRecebida = (String) in.readObject();
                            if (mensagemRecebida.equals("ok")) {
                                String delete = "DELETE FROM vaga WHERE Empresa_cod_empresa = " + minhaEmpresa.getID() + " AND nome LIKE '" + selecionadaNome + "'";
                                st.executeUpdate(delete);

                                out.writeObject("vagaExcluida");

                            }
                        }
                    }
                }

                mensagemRecebida = (String) in.readObject();
            }

            in.close();

            out.close();

            this.cliente.close();

        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TrataCliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
