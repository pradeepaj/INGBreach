package com.ing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.dto.LoginReqDto;
import com.ing.dto.LoginResDto;
import com.ing.entity.UserDetails;
import com.ing.repository.UserRepository;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public LoginResDto userLogin(LoginReqDto loginDto) {
		UserDetails details=userRepository.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
		LoginResDto loginResDto=new LoginResDto();
		loginResDto.setUserId(details.getUserId());
		loginResDto.getRole(details.getRole());
		
		return null;
	}

}
