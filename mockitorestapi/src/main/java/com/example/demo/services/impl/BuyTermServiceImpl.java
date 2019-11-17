/**
 * 
 */
package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BuyTerm;
import com.example.demo.repositories.BuyTermRepository;
import com.example.demo.services.BuyTermService;

/**
 * @author aditya
 *
 */
@Service
public class BuyTermServiceImpl implements BuyTermService {
	@Autowired
	private BuyTermRepository buyTermRepository;

	@Override
	public BuyTerm saveBuyTerm(BuyTerm buyTerm) {
		return buyTermRepository.save(buyTerm);
	}

	@Override
	public List<BuyTerm> allBuyterms() {
		return buyTermRepository.findAll();
	}

	@Override
	public BuyTerm buyTerm(int buyTermId) {
		// TODO Auto-generated method stub
		return buyTermRepository.findById(buyTermId).get();
	}

	@Override
	public void deleteBuyTerm(int buyTermId) {
		buyTermRepository.deleteById(buyTermId);

	}

	@Override
	public void deleteAllBuyTerms() {
		buyTermRepository.deleteAll();
	}

}
