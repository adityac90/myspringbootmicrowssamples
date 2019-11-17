/**
 * 
 */
package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Program;
import com.example.demo.services.ProgramService;

/**
 * @author aditya
 *
 */
@RestController
@RequestMapping("/program")
public class ProgramController {
	@Autowired
	private ProgramService programService;

	@PostMapping
	public ResponseEntity<Program> saveProgram(@RequestBody Program program) {
		final Program saveProgram = programService.saveProgram(program);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveProgram);
	}

}
