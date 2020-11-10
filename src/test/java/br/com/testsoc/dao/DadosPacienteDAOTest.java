package br.com.testsoc.dao;
import org.junit.Ignore;
import org.junit.Test;

import br.com.testsoc.domain.DadosPaciente;
public class DadosPacienteDAOTest {
	@Test
	//@Ignore
	public void salvar(){
		DadosPaciente dadospaciente = new DadosPaciente();
		dadospaciente.setName("Allan");
		//dadospaciente.setDate();
		dadospaciente.setName_exam("Allan");
		dadospaciente.setObservation("Allan");
		dadospaciente.setResult("Allan");
		
		DadosPacienteDAO dadospacienteDAO = new DadosPacienteDAO();
		dadospacienteDAO.salvar(dadospaciente);
	}
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 1L;
		DadosPacienteDAO dadospacienteDAO = new DadosPacienteDAO();
		
		DadosPaciente dadosPaciente = dadospacienteDAO.buscar(codigo);
		
		System.out.println(dadosPaciente.getName());
		
		
	}
	@Test
	@Ignore
	public void excluir(){
		
		Long codigo = 1L;
		DadosPacienteDAO dadospacienteDAO = new DadosPacienteDAO();
		
		DadosPaciente dadosPaciente = dadospacienteDAO.buscar(codigo);
		
		if(dadosPaciente == null){
			System.out.println("Nenhuma consulta encontrada");
		}else{
			
		
		dadospacienteDAO.excluir(dadosPaciente);
		System.out.println("Consulta excluida");
		}
		
		
	}
	@Test
	@Ignore
	public void editar(){
		Long codigo = 2L;
		DadosPacienteDAO dadospacienteDAO = new DadosPacienteDAO();
		
		DadosPaciente dadosPaciente = dadospacienteDAO.buscar(codigo);
		
		dadosPaciente.setName("Jose");
		dadospacienteDAO.editar(dadosPaciente);
		
	}

}
