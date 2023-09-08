package br.com.fiap.checkpoint1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import br.com.fiap.checkpoint1.model.Mensagem;

public class MensagemDAO {

    Connection con;

    public MensagemDAO(Connection con) {
        this.con = con;
    }

    public void insert(Mensagem m) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO tbl_mensagem (id_msg, ds_assunto, nm_dest, nm_reme, dt_date, ds_conteudo, pr_msg) VALUES (?, ?, ?, ?, ?, ?, ?)");

        stmt.setLong(1, m.getId());
        stmt.setString(2, m.getAssunto());
        stmt.setString(3, m.getDestinatario());
        stmt.setString(4, m.getRemetente());
        LocalDate localDate = m.getData();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        stmt.setDate(5, sqlDate);
        stmt.setString(6, m.getConteudo());
        stmt.setInt(7, m.getPrioridade());

        stmt.executeUpdate();
    }

    public void deletar(int Id) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM tbl_mensagem WHERE id_msg = ?");
        stmt.setInt(1, Id);

        int qtd = stmt.executeUpdate();

        if (qtd == 0)
            throw new SQLException("Id não encontrado para remoção");
    }

    public void altera(int Id, String conteudo, String reme, String dest) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE tbl_mensagem SET ds_conteudo = ?, nm_dest = ?, nm_reme = ? WHERE id_msg = ?");
        stmt.setString(1, conteudo);
        stmt.setString(2, dest);
        stmt.setString(3, reme);
        stmt.setInt(4, Id);

        stmt.executeUpdate();
    }
}
