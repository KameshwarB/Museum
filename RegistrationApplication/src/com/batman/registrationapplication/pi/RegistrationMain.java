package com.batman.registrationapplication.pi;

import java.awt.List;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.batman.registrationapplication.bean.CourseBean;
import com.batman.registrationapplication.bean.RegistrationBean;
import com.batman.registrationapplication.bean.StudentBean;
import com.batman.registrationapplication.dao.CourseDAOImpl;
import com.batman.registrationapplication.dao.StudentDAOImpl;
import com.batman.registrationapplication.exception.RegistrationException;
import com.batman.registrationapplication.service.IRegistrationService;
import com.batman.registrationapplication.service.RegistrationServiceImpl;

public class RegistrationMain
{
	static Scanner sc = new Scanner(System.in);
	static IRegistrationService regService=null;
	static RegistrationServiceImpl registrationImpl=null;
	static StudentDAOImpl studentdao=null;
	static CourseDAOImpl  coursedao=null;
	static boolean studentIdvalidate;
	static int courseIdvalidate;
	static RegistrationBean registrationobject = null;
	public static void main(String args[]) throws Exception
	{
		PropertyConfigurator.configure("resources//log4j.properties");

		RegistrationBean registerId=null;
		RegistrationBean registrationobject = null;
		int option = 0;
		int studentId = 0;

		//isCourseIdValid()

		while (true) {

			System.out.println("1.Add Registration ");
			System.out.println("2.View VIA Student ID");
			System.out.println("3.Update Status");
			System.out.println("4.View VIA status Enter(active/inactive/quit)");
			System.out.println("5.Exit");
			System.out.println("Select an option:");
			System.out.println("");
			System.out.println("");




			option = sc.nextInt();
			switch (option)
			{

			case 1:

				while (registrationobject == null) 
				{
					//populate registration is called
					registrationobject = populateregistrationBean();


				}

				try 
				{	
					regService = new RegistrationServiceImpl();
					registerId = regService.addRegistrationDetails(registrationobject);

					System.out.println("Details  has been successfully registered ");
					break;
				} 

				catch (RegistrationException registrationException) 
				{

					System.out.println("ERROR : "
							+ registrationException.getMessage());
				} 
				finally
				{
					registerId = null;
					regService = null;
					registrationobject = null;
				}


			case 2:
				regService = new RegistrationServiceImpl();
				System.out.println("Enter StudentId:");
				studentId = sc.nextInt();



				registrationobject = getRegisterationDetails(studentId);

				if (registrationobject != null) {
					System.out.println("StudentID        :"
							+ registrationobject.getSobj().getStudentId());
					System.out.println("CourseId         :"
							+ registrationobject.getCobj().getCourseId());
					System.out.println("Grade            :"
							+ registrationobject.getGrade());
					System.out.println("Status           :"
							+ registrationobject.getStatus());
					System.out.println("Date of joining  :"
							+ registrationobject.getDOJ());
					System.out.println("");
					System.out.println("");
				} else {
					System.err
					.println("There are no student details associated with student id "
							+ studentId);
				}

				break;
			case 3:
				regService = new RegistrationServiceImpl();
				try {
					System.out.println("Enter the Status    :");
					String status=sc.next();
					System.out.println("Enter the StudentId :");
					studentId=sc.nextInt();
					System.out.println("");
					System.out.println("");
					regService.updateRegistrationDetails(status,studentId);


				}

				catch (RegistrationException e) 
				{

					e.printStackTrace();
				}
				finally
				{
					regService=null;
					registrationobject = null;
				}
				break;

			case 4:
				regService = new RegistrationServiceImpl();

				System.out.println("Enter the status(active/inactive/quit):");
				String status=sc.next();

				ArrayList<RegistrationBean> registrationList = new ArrayList<RegistrationBean>();
				registrationList = regService.viewstatusDetails(status);

				for(RegistrationBean object:registrationList)
				{
					System.out.println("CourseID       :"+ object.getCobj().getCourseId());
					System.out.println("StudentID      :"+ object.getSobj().getStudentId());
					System.out.println("Status         :"+ object.getStatus());
					System.out.println("Grade          :"+ object.getGrade());
					System.out.println("Date of joining:"+ object.getDOJ());
					System.out.println("");
					System.out.println("");
				}
				break;
			case 5:

				System.out.print("Exit Trust Application");
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid option[1-5]");
			}

		}
	}








	private static RegistrationBean getRegisterationDetails(int studentId) {
		RegistrationBean registrationobject= null;
		regService = new RegistrationServiceImpl();

		try {
			registrationobject = regService.viewRegistrationDetails(studentId);
		} catch (RegistrationException RegistrationException) {

			System.out.println("ERROR : " + RegistrationException.getMessage());
		}

		regService = null;
		return registrationobject;
	}








	private static RegistrationBean populateregistrationBean() throws Exception 
	{
		RegistrationBean registrationobject = new RegistrationBean();


		System.out.println("\n Enter Details");

		System.out.println("Enter Course Id: ");
		registrationobject.setCobj(new CourseBean());
		registrationobject.getCobj().setCourseId(sc.nextInt());
		coursedao=new CourseDAOImpl();
		try
		{	
			//validation  done for enrolling the student in course of course id the maximun is 5
			courseIdvalidate=coursedao.isCourseIdValid(registrationobject.getCobj().getCourseId());
			System.out.println(courseIdvalidate);
		}
		catch(RegistrationException e)
		{
			System.out.println("Error"+e.getMessage());
		}

		if(courseIdvalidate>5)

			throw new Exception("Course has enrolled maximum no of students");
		else
		{
			System.out.println("Enter Student Id: ");
			registrationobject.setSobj(new StudentBean());
			registrationobject.getSobj().setStudentId(sc.nextInt());
		}

		try
	{

		//validation  done for existence of student id if student id is there it will return true
			studentdao=new StudentDAOImpl();
	studentIdvalidate=studentdao.isStudentIdValid(registrationobject.getSobj().getStudentId());
	if(studentIdvalidate=false)

			throw new Exception("Student Id already exist you cannot enroll into new course!!!");
	}
	catch(RegistrationException e)
	{
		System.out.println("Error"+e.getMessage());
	}

		 



		/*System.out.println("Enter grade: ");
	registrationobject.setGrade(sc.next());

	System.out.println("Enter status: ");
	registrationobject.setStatus(sc.next());

		 */


		return registrationobject;	
	}

}

