package dao;

import java.sql.SQLException;
import java.util.List;

import model.Endereco;

public interface InEnderecoDAO {

	void inserir(Endereco _objeto) throws SQLException;
	
	Endereco recuperarPeloID(int _id) throws SQLException;
	
	List<Endereco> recuperarTodos() throws SQLException;
	
	boolean atualizar(Endereco _objeto) throws SQLException;
	
	boolean deletar(int _id) throws SQLException;
}
