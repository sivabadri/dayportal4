package com.day4_portal.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day4_portal.model.Student;
import com.day4_portal.repository.StudentRepo;
import com.day4_portal.service.ApiService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApiServiceImpl implements ApiService {
    @Autowired
	private StudentRepo studentRepo;
    
    @Override
    public boolean adduser(Student student) {
    	boolean userExists = studentRepo.existsByMailid(student.getMailid());
		if(!userExists)
		{
			studentRepo.save(student);
			return true;
		}else {
			
			return false;
		}
    }

    
	@Override
	public boolean updateuser(Long id,Student student) {
		// TODO Auto-generated method stub
		//tourRepository.saveAndFlush(tour);
		Optional<Student>existingUserOptional =studentRepo.findById(id);
		
		if(existingUserOptional.isPresent()) {
		Student userExists=existingUserOptional.get();
		userExists.setStudentName(student.getStudentName());
		userExists.setDepartmentName(student.getDepartmentName());
		userExists.setMailid(student.getMailid());;
		studentRepo.save(userExists);
		return true;
	}else {
		return false;
	}

}
	@Override
	public boolean deleteUser(Long id) {
		Optional<Student>existingUserOptional=studentRepo.findById(id);
		if(existingUserOptional.isPresent()) {
			studentRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

	
}