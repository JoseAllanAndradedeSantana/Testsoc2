package br.com.testsoc.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.testsoc.dao.DadosPacienteDAO;
import br.com.testsoc.domain.DadosPaciente;

@ManagedBean
@ViewScoped
public class DadosPacienteBean {
	
	private DadosPaciente dadosPaciente;
	private List<DadosPaciente> pacientes;
	
	public List<DadosPaciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<DadosPaciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public DadosPaciente getDadosPaciente() {
		return dadosPaciente;
	}
	public void setDadosPaciente(DadosPaciente dadosPaciente) {
		this.dadosPaciente = dadosPaciente;
	}
	@PostConstruct
	public void listar(){
		try{
			
          DadosPacienteDAO dadosPacienteDAO = new DadosPacienteDAO();
          pacientes = dadosPacienteDAO.listar();
			
		}catch(RuntimeException err){
			
		}
	}
	public void novo(){
		dadosPaciente = new DadosPaciente();
		
	}
	
	public void salvar(){
		DadosPacienteDAO dadosPacienteDAO = new DadosPacienteDAO();
		dadosPacienteDAO.salvar(dadosPaciente);
		System.out.println("Consulta Agendada com Sucesso");
	}

}
