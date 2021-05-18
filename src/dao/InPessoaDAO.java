package dao;

import java.sql.SQLException;
import java.util.List;

import model.Pessoa;

public interface InPessoaDAO {

	void inserir(Pessoa _objeto) throws SQLException;
	
	Pessoa recuperarPeloID(int _cpf) throws SQLException;
	
	List<Pessoa> recuperarTodos() throws SQLException;
	
	Boolean atualizar(Pessoa _objeto) throws SQLException;
	
	Boolean deletar(int _cpf) throws SQLException;
}
