package com.batman.registrationapplication.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.batman.registrationapplication.bean.CourseBean;
import com.batman.registrationapplication.bean.RegistrationBean;
import com.batman.registrationapplication.bean.StudentBean;
import com.batman.registrationapplication.exception.RegistrationException;
import com.batman.registrationapplication.util.DBConnection;

public class RegistrationDaoImpl implements IRegistrationDAO
{

	
	//////******************************************ADD REGISTRATION**************************************************////////
	
	public RegistrationBean addRegistrationDetails(RegistrationBean registrationobject)
			throws RegistrationException {
		
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		RegistrationBean registerId=null;
		
		int queryResult=0;
		try
		{		
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);
			preparedStatement.setInt(1,registrationobject.getCobj().getCourseId());
			preparedStatement.setInt(2,registrationobject.getSobj().getStudentId());			
			//preparedStatement.setString(3,registrationobject.getGrade());
			//preparedStatement.setString(4,registrationobject.getStatus());
			
			
			
			queryResult=preparedStatement.executeUpdate();
		
			if(queryResult==0)
			{
				
				throw new RegistrationException("Inserting of data details failed ");

			}
			else
			{
				
				return registerId;
			}

		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			
			throw new RegistrationException("Tehnical problem occured refer log");
		}
		finally
		{
			try 
			{
			
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				
				throw new RegistrationException("Error in closing db connection");

			}
		}
	}

	
	
	/////////****************************************VIEW REGISTRATION**********************///////////////////////////
	public RegistrationBean viewRegistrationDetails(int studentId)
			throws RegistrationException {
		Connection connection=DBConnection.getInstance().getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		RegistrationBean registrationobject=null;
		try
		{
			preparedStatement=connection.prepareStatement(QueryMapper.VIEW_REGISTERATION_DETAILS_QUERY);
			preparedStatement.setInt(1,studentId);
			resultset=preparedStatement.executeQuery();
			
			if(resultset.next())
			{
				registrationobject=new RegistrationBean();
				StudentBean s=new StudentBean();
				CourseBean c=new CourseBean();
				registrationobject.setCobj(c);
				registrationobject.getCobj().setCourseId(resultset.getInt(1));
				registrationobject.setSobj(s);
				registrationobject.getSobj().setStudentId(resultset.getInt(2));
				registrationobject.setGrade(resultset.getString(3));
				registrationobject.setStatus(resultset.getString(4));
				registrationobject.setDOJ(resultset.getDate(5));
			}
			return registrationobject;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//e.printStackTrace();
		}
		finally
		{
			try 
			{
				resultset.close();
				preparedStatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				throw new RegistrationException("Error in closing db connection");

			}
		}
		
		return registrationobject;
	}
	
	
	////////////*****************************STATUS UPDATE REEGISTRATION******************************************/////////
	
	public boolean updateRegistrationDetails(String status,int studentId)throws RegistrationException
	{
		Connection con=DBConnection.getInstance().getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultset = null ;
		int registerCount = 0;
		RegistrationBean registerobject;
		RegistrationBean registrationobject=new RegistrationBean();
		PreparedStatement ps=null;
		int queryResult=0;
		
		
		try
		{
			preparedStatement=con.prepareStatement(QueryMapper.Update_QUERY);
			preparedStatement.setString(1, status);
			//StudentBean sobj=new StudentBean();
			//registrationobject.setSobj(sobj);
			preparedStatement.setInt(2,studentId);
			 queryResult = preparedStatement.executeUpdate();
			
		
		if(queryResult!= 0){
		System.out.println("Updated Successfuly status");
			return true;
		}
		else
		
			return false;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			/*try 
			{
				
				ps.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				
				throw new RegistrationException("Error in closing db connection");

			}*/
		}
		return false;
		
		
	}


////////////////////************************View Via Status Details****************************//////////////////////////
	
	public ArrayList<RegistrationBean> viewstatusDetails(String status)
			throws RegistrationException {
		Connection connection=DBConnection.getInstance().getConnection();
		int registercount=0;
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		ArrayList<RegistrationBean> registrationList=new ArrayList<RegistrationBean>();
		
		try
		{
			preparedStatement=connection.prepareStatement(QueryMapper.Select_QUERY_STATUS);
			System.out.println("Enter the status(active/inactive/quit):");
			preparedStatement.setString(1,status);
			resultset=preparedStatement.executeQuery();
			
			while(resultset.next())
			{
				RegistrationBean registrationobject=new RegistrationBean();
				StudentBean s=new StudentBean();
				CourseBean c=new CourseBean();
				registrationobject.setCobj(c);
				registrationobject.getCobj().setCourseId(resultset.getInt(1));
				registrationobject.setSobj(s);
				registrationobject.getSobj().setStudentId(resultset.getInt(2));
				registrationobject.setGrade(resultset.getString(3));
				registrationobject.setStatus(resultset.getString(4));
				registrationobject.setDOJ(resultset.getDate(5));
				registrationList.add(registrationobject);
				registercount++;
			}
			return registrationList;
		}
			catch (SQLException sqlException) {
				
				throw new RegistrationException("Tehnical problem occured. Refer log");
			}
		finally
		{
			try 
			{
				
				preparedStatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				
				throw new RegistrationException("Error in closing db connection");
				
			}
		}
		
	}
	
}



