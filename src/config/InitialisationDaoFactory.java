package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.DAOFactory;

public class InitialisationDaoFactory implements ServletContextListener {
	
	private DAOFactory daoFactory;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		
		this.daoFactory = DAOFactory.getInstance();
		
		servletContext.setAttribute("daofactory", this.daoFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//
	}


	
	
	
	
	
}
