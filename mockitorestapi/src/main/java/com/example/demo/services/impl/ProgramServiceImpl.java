/**
 * 
 */
package com.example.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Program;
import com.example.demo.repositories.ProgramRepository;
import com.example.demo.services.ProgramService;

/**
 * @author aditya
 *
 */
@Service
public class ProgramServiceImpl implements ProgramService {
	@Autowired
	private ProgramRepository programRepository;

	@Override
	public Program saveProgram(Program program) {
		return programRepository.save(program);
	}

}
