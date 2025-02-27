package it.fm3.alcolist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fm3.alcolist.DTO.CocktailDTO;
import it.fm3.alcolist.DTO.IngredientDTO;
import it.fm3.alcolist.service.CocktailServiceI;
import it.fm3.alcolist.service.IngredientServiceI;

@RestController
@CrossOrigin
@RequestMapping("manage-cocktails")
public class CocktailController {
	
	@Autowired
	CocktailServiceI cocktailService;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody CocktailDTO cocktail, HttpServletRequest request){
		try {
			return ResponseEntity.ok(cocktailService.add(cocktail));
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@RequestParam String uuid, HttpServletRequest request) throws Exception{
		return new ResponseEntity<>(cocktailService.delete(uuid),HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody CocktailDTO cocktail, HttpServletRequest request) throws Exception{
		return ResponseEntity.ok(cocktailService.update(cocktail));
	}
	
	@RequestMapping(value = "/get/{uuid}", method = RequestMethod.GET)
	public ResponseEntity<?> getByUuid(@PathVariable(name = "uuid") String uuid) throws Exception {
		try {
		return ResponseEntity.ok(cocktailService.get(uuid));
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
	}
	
	@RequestMapping(value = "/getIngredients/{uuid}", method = RequestMethod.GET)
	public ResponseEntity<?> getIngredients(@PathVariable(name = "uuid") String uuid) throws Exception {
		return ResponseEntity.ok(cocktailService.getIngredients(uuid));
	}
	
	@RequestMapping(value = "/searchByFields", method = RequestMethod.POST)
	public ResponseEntity<?> searchByFields(@RequestBody CocktailDTO cocktail, HttpServletRequest request) throws Exception {
		try {
			return ResponseEntity.ok(cocktailService.searchByFields(cocktail));
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getMenu", method = RequestMethod.POST)
    public ResponseEntity<?> getMenu(@RequestBody CocktailDTO cocktail, HttpServletRequest request) throws Exception {
        return ResponseEntity.ok(cocktailService.getMenu(cocktail));
    }

    @RequestMapping(value = "/getMenuIba", method = RequestMethod.POST)
    public ResponseEntity<?> getByMenuIba(@RequestBody CocktailDTO cocktail, HttpServletRequest request) throws Exception {
        return ResponseEntity.ok(cocktailService.getMenuIba(cocktail));
    }
	
	@RequestMapping(value = "/addIngredient", method = RequestMethod.POST)
	public ResponseEntity<?> addIngredient(@RequestBody IngredientDTO ingredient, HttpServletRequest request) throws Exception{
	
			return ResponseEntity.ok(cocktailService.addIngredient(ingredient));

	}
	
	@RequestMapping(value = "/deleteIngredient", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteIngredient(@RequestBody IngredientDTO ingredient, HttpServletRequest request) throws Exception{
		
			return ResponseEntity.ok(cocktailService.deleteIngredient(ingredient));
		
	}
}