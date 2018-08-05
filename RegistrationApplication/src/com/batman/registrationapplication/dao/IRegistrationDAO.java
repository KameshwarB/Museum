package com.batman.registrationapplication.dao;

import java.util.ArrayList;
import java.util.List;

import com.batman.registrationapplication.bean.RegistrationBean;
import com.batman.registrationapplication.exception.RegistrationException;

public interface IRegistrationDAO {

	public RegistrationBean addRegistrationDetails(RegistrationBean registrationobj) throws RegistrationException;
	public RegistrationBean viewRegistrationDetails(int studentId) throws RegistrationException;
	public boolean updateRegistrationDetails(String status,int studentId)throws RegistrationException;
	public ArrayList<RegistrationBean> viewstatusDetails(String status)throws RegistrationException;
}
