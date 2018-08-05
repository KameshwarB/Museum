package com.batman.registrationapplication.service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.batman.registrationapplication.bean.RegistrationBean;
import com.batman.registrationapplication.dao.IRegistrationDAO;
import com.batman.registrationapplication.dao.RegistrationDaoImpl;
import com.batman.registrationapplication.exception.RegistrationException;



public class RegistrationServiceImpl implements IRegistrationService
{
	IRegistrationDAO registrationDao;
	
	
	public RegistrationBean addRegistrationDetails(RegistrationBean registrationobject) throws RegistrationException {
		registrationDao= new RegistrationDaoImpl();	
		RegistrationBean registrationSeq;
		registrationSeq= registrationDao.addRegistrationDetails(registrationobject);
		return registrationSeq; 
	}


	
	
public RegistrationBean viewRegistrationDetails(int studentId)
			throws RegistrationException {
		
		registrationDao=new RegistrationDaoImpl();
		RegistrationBean registrationobject=null;
		registrationobject=registrationDao.viewRegistrationDetails(studentId);
		return registrationobject;
	}



public boolean updateRegistrationDetails(String status, int studentId)
		throws RegistrationException {
	registrationDao=new RegistrationDaoImpl();
	boolean registrationobject;
	registrationobject=registrationDao.updateRegistrationDetails(status,studentId);
	return registrationobject;
	
}





public ArrayList<RegistrationBean> viewstatusDetails(String status)
		throws RegistrationException {
	registrationDao=new RegistrationDaoImpl();
	ArrayList<RegistrationBean> bean=null;
	bean=registrationDao.viewstatusDetails(status);
	return bean;
	
}





	}
	
