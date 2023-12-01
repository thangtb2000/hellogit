//package com.example.webbanhang.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.webbanhang.dao.UsserDao;
//import com.example.webbanhang.entity.Usser;
//
//@Service
//@Transactional
//public class UserLoginServiceImpl implements UserDetailsService{
//
//	@Autowired
//	UsserDao userDao;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usser u = userDao.getByUsername(username);
//		
//		if(u == null) {
//			throw new UsernameNotFoundException("no user");
//		}
//		
//		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//		
//		authorities.add(new SimpleGrantedAuthority(u.getRole()));
//		
//		
//		UserDetails details = new User(u.getUsername(), u.getPassword(), true, true, true, true, authorities);
//		
//		return details;
//	}
//
//}
