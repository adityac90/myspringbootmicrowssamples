/**
 * 
 */
package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.BuyTerm;

/**
 * @author aditya
 *
 */
public interface BuyTermService {
	BuyTerm saveBuyTerm(BuyTerm buyTerm);

	List<BuyTerm> allBuyterms();

	BuyTerm buyTerm(int buyTermId);

	void deleteBuyTerm(int buyTermId);

	void deleteAllBuyTerms();

}
