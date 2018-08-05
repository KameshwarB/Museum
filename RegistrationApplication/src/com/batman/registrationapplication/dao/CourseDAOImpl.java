package com.batman.registrationapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.batman.registrationapplication.bean.RegistrationBean;
import com.batman.registrationapplication.exception.RegistrationException;
import com.batman.registrationapplication.util.DBConnection;

public class CourseDAOImpl {

	
	public int isCourseIdValid(int courseID)throws Exception
	{
		//String registerId=null;

		
			RegistrationBean robj=new RegistrationBean();
		
			Connection connection = DBConnection.getInstance().getConnection();	
			
			PreparedStatement preparedStatement=null;		
			ResultSet resultSet = null;
			int queryResult=0;
			int count=0;
			
			try
			{		
				preparedStatement=connection.prepareStatement(QueryMapper.SELECT_QUERY_COURSEDAO);
				preparedStatement.setInt(1,courseID);
				ResultSet rs=preparedStatement.executeQuery();
				while(rs.next())
				{
					count=rs.getInt(1);
				    	
				}
				return count;
				
			}
			catch(Exception e)
			{
				
			}
			return count;
		}
	}

