package org.youri.tutorial.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.youri.tutorial.domain.DbUser;

public class UserDao {
		protected static Logger  logger  = Logger.getLogger("dao");
		
		public DbUser getDatabase(String username){
			List<DbUser> users = internalDatabase();
			for(DbUser user : users){
				if(user.getUsername().equals(username)){
					logger.debug("User found");
					return user;
				}
			}
			logger.error("User does not exist!");
			throw new RuntimeException("User does't exist!");
			
		}
		
		
		
		private List<DbUser> internalDatabase(){
			ArrayList<DbUser> users = new ArrayList<DbUser>();
			DbUser user = null;
			user = new DbUser();
			
			user.setUsername("admin");
			 // "admin"经过MD5加密后  
			//pass admin
	        user.setPassword("21232f297a57a5a743894a0e4a801fc3");  
	        user.setAccess(1);  
	  
	        users.add(user);  
	  
	        user = new DbUser();  
	        user.setUsername("user");  
	  
	        // "user"经过MD5加密后  
	        //user
	        user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");  
	        user.setAccess(2);  
	  
	        users.add(user);  
	  
	        return users;  
		}
}
