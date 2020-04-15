package com.spring.info.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.info.beans.User;

@Component
public class UserService {
	
	private static List<User> userList = new ArrayList<>();
	private static int userCount =4;
	static {
		userList.add(new User(1,"ramaiah", new Date()));
		userList.add(new User(2,"somaiah", new Date()));
		userList.add(new User(3,"chaitanya", new Date()));
		userList.add(new User(4,"gomathi", new Date()));
	}
	
    public List<User> findAll(){
    	
    	return userList;
    }
    
    public User save( User user) {
    	if(user.getId()== null) {
    		user.setId(++userCount);
    	}
    	userList.add(user);
    	return user;
    }
    
    public User findOne(int id) {
    	for(User user : userList) {
    		if(user.getId() == id) {
    			return user;
    		}
    	}
    	return null;
    }

	public User deleteById(int id) {
		// TODO Auto-generated method stub
		Iterator<User> iterator = userList.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				
			return user;
			}
		}
		return null;
	}
}
