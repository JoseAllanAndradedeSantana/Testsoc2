package br.com.testsoc.dao;

//import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.testsoc.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDAO <En> {
	private Class<En> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<En>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	//nome do objeto
	public void salvar(En en){
		//capturando sessão aberta
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		//controlar transação
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(en);
			//confirmando transação
			transacao.commit();
		}catch (RuntimeException err){
			
			if(transacao != null){
				transacao.rollback();
			}
			throw err;
		} finally {
			//finalizando sessão
			sessao.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<En> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			CriteriaBuilder builder = sessao.getCriteriaBuilder();
			CriteriaQuery<En> consulta = builder.createQuery(classe);
			consulta.from(classe);
			List<En> resultado = sessao.createQuery(consulta).getResultList();
			return resultado;
			
		}catch (RuntimeException err){
			throw err;
		}finally{
			sessao.close();
		}
	}
	 public En buscar(Long codigo){
		  Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		  En resultado = null;
		  try {          
		   resultado = sessao.find(classe, codigo);
		          return resultado;
		  } catch (RuntimeException err) {
		   throw err;
		  } finally{
		   sessao.close();   
		  }
		 }
	 public void excluir(En en){
			//capturando sessão aberta
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			//controlar transação
			Transaction transacao = null;
			
			try{
				transacao = sessao.beginTransaction();
				sessao.delete(en);
				//confirmando transação
				transacao.commit();
			}catch (RuntimeException err){
				
				if(transacao != null){
					transacao.rollback();
				}
				throw err;
			} finally {
				//finalizando sessão
				sessao.close();
			}
			
		}
	 
	 public void editar(En en){
			//capturando sessão aberta
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			//controlar transação
			Transaction transacao = null;
			
			try{
				transacao = sessao.beginTransaction();
				sessao.update(en);
				//confirmando transação
				transacao.commit();
			}catch (RuntimeException err){
				
				if(transacao != null){
					transacao.rollback();
				}
				throw err;
			} finally {
				//finalizando sessão
				sessao.close();
			}
			
		}

	
	 public void merge(En en){
			//capturando sessão aberta
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			//controlar transação
			Transaction transacao = null;
			
			try{
				transacao = sessao.beginTransaction();
				sessao.merge(en);
				//confirmando transação
				transacao.commit();
			}catch (RuntimeException err){
				
				if(transacao != null){
					transacao.rollback();
				}
				throw err;
			} finally {
				//finalizando sessão
				sessao.close();
			}
			
		}
		

}
