package br.com.stos.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.stos.agenda.model.Contato;
import br.com.stos.agenda.util.ConnectionFactory;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvar(Contato contato) {
		String sql = "INSERT INTO contato (nome, telefone, endereco, email, foto) VALUES (?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getTelefone());
			stmt.setString(3, contato.getEndereco());
			stmt.setString(4, contato.getEmail());
			stmt.setString(5, contato.getFoto());

			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> listar() {
		try {
			List<Contato> listarContato = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contato ORDER BY nome");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				listarContato.add(contato);
			}
			stmt.execute();
			connection.close();
			return listarContato;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Contato contato) {
		String sql = "DELETE FROM contato WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, contato.getId());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Contato buscarPorId(int id) {
		try {
			Contato contatoCompleto = new Contato();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contato WHERE id =  ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contatoCompleto.setId(rs.getInt("id"));
				contatoCompleto.setNome(rs.getString("nome"));
				contatoCompleto.setTelefone(rs.getString("telefone"));
				contatoCompleto.setEndereco(rs.getString("endereco"));
				contatoCompleto.setEmail(rs.getString("email"));

			}
			rs.close();
			stmt.close();
			connection.close();
			return contatoCompleto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Contato contato) {
		String sql = "UPDATE contato SET nome = ?, telefone = ?, endereco = ?, email = ? WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getTelefone());
			stmt.setString(3, contato.getEndereco());
			stmt.setString(4, contato.getEmail());
			stmt.setInt(5, contato.getId());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> buscar(Contato c) {

		try {
			List<Contato> buscarContato = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM contato WHERE nome like ? or telefone like ? or email like ?");
			stmt.setString(1, "%" + c.getNome() + "%");
			stmt.setString(2, "%" + c.getTelefone() + "%");
			stmt.setString(3, "%" + c.getEmail() + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Contato cont = new Contato();
				cont.setId(rs.getInt("id"));
				cont.setNome(rs.getString("nome"));
				cont.setTelefone(rs.getString("telefone"));
				cont.setEndereco(rs.getString("endereco"));
				cont.setEmail(rs.getString("email"));

				buscarContato.add(cont);
			}
			rs.close();
			stmt.close();
			connection.close();
			return buscarContato;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
