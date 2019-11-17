/**
 * 
 */
package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BuyTerm;
import com.example.demo.services.BuyTermService;

/**
 * @author aditya
 *
 */
@RestController
@RequestMapping("/buyterm")
public class BuyTermController {
	@Autowired
	private BuyTermService buyTermService;

	@PostMapping
	public ResponseEntity<BuyTerm> saveBuyTerm(@RequestBody BuyTerm buyTerm) {
		return ResponseEntity.status(HttpStatus.CREATED).body(buyTermService.saveBuyTerm(buyTerm));
	}

	@GetMapping
	public ResponseEntity<List<BuyTerm>> allBuyTerms() {
		return ResponseEntity.ok(buyTermService.allBuyterms());
	}

	@GetMapping("/{buyTermId}")
	public ResponseEntity<BuyTerm> buyTerm(@PathVariable int buyTermId) {
		return ResponseEntity.ok(buyTermService.buyTerm(buyTermId));
	}

	@PutMapping
	public ResponseEntity<BuyTerm> updateBuyTerm(@RequestBody BuyTerm buyTerm) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(buyTermService.saveBuyTerm(buyTerm));
	}

	@DeleteMapping("/{buyTermId}")
	public ResponseEntity<?> deleteABuyTerm(@PathVariable int buyTermId) {
		buyTermService.deleteBuyTerm(buyTermId);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteBuyTerms() {
		buyTermService.deleteAllBuyTerms();
		return ResponseEntity.ok().build();
	}

}
