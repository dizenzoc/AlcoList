package it.fm3.alcolist.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.fm3.alcolist.entity.Cocktail;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
	Cocktail findByUuid(String uuid);
	
	List<Cocktail> findByNameContainsIgnoreCase(String name);
	List<Cocktail> findByNameContainsIgnoreCase(Pageable pageable, String name);
	int countByNameContainingIgnoreCase(String name);
	
	List<Cocktail> findByFlavourContainsIgnoreCase(String flavour);
	List<Cocktail> findByFlavourContainsIgnoreCase(Pageable pageable, String flavour);
	int countByFlavourContainsIgnoreCase(String flavour);
	
	List<Cocktail> findByIsAlcoholic(boolean alcoholic);
	List<Cocktail> findByIsAlcoholic(Pageable pageable, boolean alcoholic);
	int countByIsAlcoholic(boolean alcoholic);
	
	@Query("SELECT c FROM Cocktail c WHERE UPPER(c.name) LIKE %:name% AND c.flavour = :flavour")
	List<Cocktail> findByNameAndFlavourContainsIgnoreCase(@Param("name") String name, @Param("flavour") String flavour);
	List<Cocktail> findByNameAndFlavourContainsIgnoreCase(Pageable pageable, @Param("name") String name, @Param("flavour") String flavour);
	@Query("SELECT COUNT(c) FROM Cocktail c WHERE UPPER(c.name) LIKE %:name% AND c.flavour = :flavour")
	int countByNameAndFlavourContainingIgnoreCase(@Param("name") String name, @Param("flavour") String flavour);
	
	
	@Query("SELECT c FROM Cocktail c WHERE UPPER(c.name) LIKE %:name% AND c.isAlcoholic = :alcoholic")
	List<Cocktail> findByNameAndIsAlcoholic(@Param("name") String name, @Param("alcoholic") boolean alcoholic);
	List<Cocktail> findByNameAndIsAlcoholic(Pageable pageable, @Param("name") String name, @Param("alcoholic") boolean alcoholic);
	@Query("SELECT COUNT(c) FROM Cocktail c WHERE UPPER(c.name) LIKE %:name% AND c.isAlcoholic = :alcoholic")
	int countByNameAndIsAlcoholic(@Param("name") String name, @Param("alcoholic") boolean alcoholic);
	
	List<Cocktail> findByFlavourAndIsAlcoholic(String flavour, boolean alcoholic);
	List<Cocktail> findByFlavourAndIsAlcoholic(Pageable pageable, String flavour, boolean alcoholic);
	int countByFlavourAndIsAlcoholic(String flavour, boolean alcoholic);
	
	@Query("SELECT c FROM Cocktail c WHERE UPPER(c.name) LIKE %:name% AND c.flavour = :flavour AND c.isAlcoholic = :alcoholic")
	List<Cocktail> findByNameAndFlavourAndIsAlcoholic(@Param("name") String name, @Param("flavour") String flavour, @Param("alcoholic") boolean alcoholic);
	List<Cocktail> findByNameAndFlavourAndIsAlcoholic(Pageable pageable, @Param("name") String name, @Param("flavour") String flavour, @Param("alcoholic") boolean alcoholic);
	@Query("SELECT COUNT(c) FROM Cocktail c WHERE UPPER(c.name) LIKE %:name% AND c.flavour = :flavour AND c.isAlcoholic = :alcoholic")
	int countByNameAndFlavourAndIsAlcoholic(@Param("name") String name, @Param("flavour") String flavour, @Param("alcoholic") boolean alcoholic);

	//@Query("SELECT c FROM Cocktail c WHERE c.inmenu=true");
	//List<Cocktail> findByInMenu(Pageable pageable, boolean inMenu);
	List<Cocktail> findByInMenu(Pageable pageable, boolean inMenu);
	int countByInMenu(boolean inMenu);
	
	List<Cocktail> findByIsIBA(Pageable pageable, boolean isIba);
	int countByIsIBA(boolean isIba);
}
