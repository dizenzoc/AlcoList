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

import it.fm3.alcolist.DTO.TablesDTO;
import it.fm3.alcolist.service.TablesServiceI;


@RestController
@CrossOrigin
@RequestMapping("manage-tables")
public class TablesController {
	@Autowired
	TablesServiceI tablesService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody TablesDTO tables, HttpServletRequest request){
		try {
			return ResponseEntity.ok(tablesService.add(tables));
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@RequestParam String name, HttpServletRequest request) throws Exception{
		return new ResponseEntity<>(tablesService.delete(name),HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody TablesDTO tables, HttpServletRequest request) throws Exception{
		return ResponseEntity.ok(tablesService.update(tables));
	}
	
	@RequestMapping(value = "/get/{uuid}", method = RequestMethod.GET)
	public ResponseEntity<?> getByUuid(@PathVariable(name = "uuid") String uuid) throws Exception {
		return ResponseEntity.ok(tablesService.get(uuid));
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() throws Exception {
		return ResponseEntity.ok(tablesService.getAll());
	}
	/*
	@RequestMapping(value = "/searchByFields", method = RequestMethod.POST)
	public ResponseEntity<?> searchByFields(@RequestBody TablesDTO t, HttpServletRequest request) throws Exception {
		return ResponseEntity.ok(tablesService.searchByFields(t));
	}*/
	
	@RequestMapping(value = "/getTableByOrderUuid/{uuid}", method = RequestMethod.GET)
	public ResponseEntity<?> getTableByOrderUuid(@PathVariable(name = "uuid") String uuid) throws Exception {
		return ResponseEntity.ok(tablesService.getTableByOrderUuid(uuid));
	}
	
}
