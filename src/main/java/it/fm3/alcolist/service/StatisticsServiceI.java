package it.fm3.alcolist.service;

import java.util.List;

import it.fm3.alcolist.entity.Cocktail;
import it.fm3.alcolist.utils.RoleEnum;

public interface StatisticsServiceI {
	Integer getByNumbersOfUsers (String role);
	Integer getNumbersOfCreatedByUser(String UserUuid) throws Exception;
	Integer getNumbersOfDeliveredByUser(String UserUuid) throws Exception;
	Integer getNumbersOfExecutedByUser(String UserUuid) throws Exception;
	//List<Cocktail> getBestSellingCocktails(Integer limit) throws Exception;
	List<Cocktail> getBestSellingCocktails(Integer limit) throws Exception;
	List<Cocktail> getBestSellingCocktailsByFlavour() throws Exception;
	//cocktail più venduti divisi
		// categoria
		// cocktail
		// numero totale di cocktail
	//prodotti che stanno per finire
}