package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaDAO implements InPessoaDAO {
	
	private Connection conexao;

	public PessoaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void inserir(Pessoa _objeto) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Pessoa recuperarPeloID(int _cpf) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> recuperarTodos() throws SQLException {
		
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		
		String SQL = "SELECT "
				+ "cpf, nome, cel, email, end_padrao"
				+ " FROM pessoa";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			Long cpf = rs.getLong(1);
			String nome = rs.getString(2);
			String cel = rs.getString("cel");
			String email = rs.getString("email");
			//int endPadrao = rs.getInt("end_padrao");
			
			Pessoa p = new Pessoa(cpf, nome, cel, email, null, null);
			
			listaPessoas.add(p);
		}
		
		
		//Retorno do Método
		return listaPessoas;
	}

	@Override
	public Boolean atualizar(Pessoa _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deletar(int _cpf) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
