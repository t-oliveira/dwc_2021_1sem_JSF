package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Pessoa;

public class PessoaDAO implements InPessoaDAO {
	
	private Connection conexao;

	public PessoaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void inserir(Pessoa _objeto) throws SQLException {
		
		String SQL = "INSERT INTO pessoa (cpf, nome, cel, email) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setLong(1, _objeto.getCpf());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getCel());
		ps.setString(4, _objeto.getEmail());
		
		ps.execute();
	}

	@Override
	public Pessoa recuperarPeloID(int _cpf) throws SQLException {
		
		String SQL = "SELECT "
				+ "cpf, nome, cel, email, end_padrao"
				+ " FROM pessoa WHERE cpf = " + _cpf;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Pessoa p = null;
		
		//SE RS CONSEGUIR APONTAR PARA O MEU UNICO REGISTRO FAÇA
		if(rs.next()) {
			Long cpf = rs.getLong(1);
			String nome = rs.getString(2);
			String cel = rs.getString("cel");
			String email = rs.getString("email");
			int endPadrao = rs.getInt("end_padrao");
			
			EnderecoDAO daoEnd = new EnderecoDAO(this.conexao);
			
			p = new Pessoa(cpf, nome, cel, email, daoEnd.recuperarPeloID(endPadrao), daoEnd.recuperarEnderecosPorPessoa(cpf));
		}
		
		return p;
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
			int endPadrao = rs.getInt("end_padrao");
			
			EnderecoDAO daoEnd = new EnderecoDAO(this.conexao);
			
			Pessoa p = new Pessoa(cpf, nome, cel, email, daoEnd.recuperarPeloID(endPadrao), daoEnd.recuperarEnderecosPorPessoa(cpf));
			
			listaPessoas.add(p);
		}
		
		
		//Retorno do Método
		return listaPessoas;
	}

	@Override
	public boolean atualizar(Pessoa _objeto) throws SQLException {
		
		String SQL = "UPDATE pessoa SET "
				+ "nome = ?, cel = ?, email = ?, end_padrao = ?"
				+ " WHERE cpf = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getCel());
		ps.setString(3, _objeto.getEmail());
		//Verificação para ver se EndPadrão foi instanciado
		if (_objeto.getEndPadrao() != null) {
			ps.setInt(4, _objeto.getEndPadrao().getId());
		}
		else {
			ps.setNull(4, java.sql.Types.NULL);
		}
		ps.setLong(5, _objeto.getCpf());
		
		if(ps.executeUpdate() == 1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

	@Override
	public boolean deletar(Long _cpf) throws SQLException {
		
		String SQL = "DELETE FROM pessoa WHERE cpf = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setLong(1, _cpf);
		
		if(ps.executeUpdate() == 1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

}
