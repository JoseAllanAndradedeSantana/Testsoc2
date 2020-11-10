package br.com.testsoc.main;

import org.hibernate.Session;
import br.com.testsoc.util.HibernateUtil;



public class HibernateUtilTest {
	
	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
