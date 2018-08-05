package com.batman.registrationapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.batman.registrationapplication.bean.RegistrationBean;
import com.batman.registrationapplication.exception.RegistrationException;
import com.batman.registrationapplication.util.DBConnection;

public class StudentDAOImpl {
		
	//String registerId=null;

	public boolean isStudentIdValid(int studentID)throws RegistrationException
	{
		RegistrationBean robj=new RegistrationBean();
	
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;

		
		
		try
		{		
			preparedStatement=connection.prepareStatement(QueryMapper.SELECT_QUERY_STUDENTDAO);
			preparedStatement.setInt(1,robj.getSobj().getStudentId());
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				int studentId=rs.getInt(2);
				if(studentId==robj.getSobj().getStudentId())
					return true;
			}
		}
		catch(Exception e)
		{
			
		}
		return false;
	}
}

