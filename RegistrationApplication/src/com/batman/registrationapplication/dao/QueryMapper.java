package com.batman.registrationapplication.dao;



	public interface QueryMapper {
		
		public static final String Update_QUERY="update registration set status=? where studentid=?";
		public static final String VIEW_REGISTERATION_DETAILS_QUERY="select courseId,studentId,grade,status,DOJ FROM Registration WHERE studentId=?";
		public static final String INSERT_QUERY="INSERT INTO Registration VALUES(?,?,null,'active',SYSDATE)";
		public static final String SELECT_QUERY_STUDENTDAO = "select courseId,studentId,grade,status,DOJ from Student where studentId=?";
		public static final String SELECT_QUERY_COURSEDAO ="select count(*) from Registration where courseid=? group by courseid";
		public static final String Select_QUERY_STATUS="select * from Registration where status=?";
		
	}

