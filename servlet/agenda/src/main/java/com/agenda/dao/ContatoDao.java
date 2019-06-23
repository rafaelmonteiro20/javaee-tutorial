package com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agenda.model.Contato;

public class ContatoDao {

	private Connection conexao;
	
	public ContatoDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void salva(Contato contato) {
		
		String sql = " INSERT INTO contato (nome, email, endereco, data_nascimento) "
				   + " VALUES (?, ?, ?, ?) ";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco()); 
			stmt.setDate(4, new Date(contato.getDataNascimento().getTime()));
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> buscaTodos() {
		
		String sql = " SELECT * FROM contato ";
		
		List<Contato> contatos = new ArrayList<>();
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()) {
			
			while(rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setDataNascimento(rs.getDate("data_nascimento"));
				contatos.add(contato);
			}

			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
