package com.ing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.dto.LoginReqDto;
import com.ing.dto.LoginResDto;
import com.ing.entity.UserDetails;
import com.ing.exception.EnterValidCredentials;
import com.ing.exception.UserNotFound;
import com.ing.repository.UserRepository;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public LoginResDto userLogin(LoginReqDto loginDto) {
		
		
		UserDetails details=userRepository.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
		
		if(null!=details) {
			if (details.getEmail().equals(loginDto.getEmail()) && details.getPassword().equals(loginDto.getPassword())) {
				LoginResDto loginResDto=new LoginResDto();
				loginResDto.setUserId(details.getUserId());
				loginResDto.setRole(details.getRole());
				loginResDto.setUserName(details.getUserName());
				loginResDto.setMessage("Login Success");
				return loginResDto;
			}else {
				throw new EnterValidCredentials("Please enter correct username or password");
			}
			
		}
		else {
			throw new UserNotFound("User does not exists");
		}
		
		
		
	}

}
