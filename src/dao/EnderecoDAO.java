package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;

public class EnderecoDAO implements InEnderecoDAO {

	private Connection conexao;

	public EnderecoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void inserir(Endereco _objeto) throws SQLException {

		String SQL = "INSERT INTO pessoa (descricao, bairro, cidade, estado, cep, pessoa_cpf) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getDescricao());
		ps.setString(2, _objeto.getBairro());
		ps.setString(3, _objeto.getCidade());
		ps.setString(4, _objeto.getEstado());
		ps.setString(5, _objeto.getCep());
		ps.setLong(6, _objeto.getPessoa().getCpf());
		
		ps.execute();

	}

	@Override
	public Endereco recuperarPeloID(int _id) throws SQLException {
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM endereco WHERE id = " + _id;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Endereco endereco = null;
		
		//SE RS CONSEGUIR APONTAR PARA O MEU UNICO REGISTRO FAÇA
		if(rs.next()) {
			
			endereco = new Endereco();
			endereco.setId(rs.getInt(1));
			endereco.setDescricao(rs.getString(2));
			endereco.setBairro(rs.getString(3));
			endereco.setCidade(rs.getString(4));
			endereco.setEstado(rs.getString(5));
			endereco.setCep(rs.getString(6));
		}
		
		return endereco;
	}

	@Override
	public List<Endereco> recuperarTodos() throws SQLException {

		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM endereco";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			
			Endereco endereco = new Endereco();
			
			endereco = new Endereco();
			endereco.setId(rs.getInt(1));
			endereco.setDescricao(rs.getString(2));
			endereco.setBairro(rs.getString(3));
			endereco.setCidade(rs.getString(4));
			endereco.setEstado(rs.getString(5));
			endereco.setCep(rs.getString(6));
		
			
			listaEnderecos.add(endereco);
		}
		
		
		//Retorno do Método
		return listaEnderecos;
	}

	@Override
	public boolean atualizar(Endereco _objeto) throws SQLException {
		
		String SQL = "UPDATE endereco SET "
				+ "descricao = ?, bairro = ?, cidade = ?, estado = ?, cep = ?"
				+ " WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getDescricao());
		ps.setString(2, _objeto.getBairro());
		ps.setString(3, _objeto.getCidade());
		ps.setString(4, _objeto.getEstado());
		ps.setString(5, _objeto.getCep());
		
		ps.setInt(6, _objeto.getId());
		
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
	public boolean deletar(int _id) throws SQLException {

		String SQL = "DELETE FROM endereco WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setLong(1, _id);
		
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
