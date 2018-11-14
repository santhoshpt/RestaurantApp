package com.restaurant.menu;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.MenuItem;
import com.restaurant.entity.MenuItemRepository;

@RestController
@RequestMapping("/restaurant/menu/item")
public class MenuItemController {
	
	@Autowired
	private MenuItemRepository repository;
	
    @RequestMapping(value="/{id}",
    		        method=RequestMethod.GET, 
	                produces="application/json")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable(value="id") String id, HttpSession httpSession) {
    	
    	Optional<MenuItem> optional = repository.findById(Long.parseLong(id));
    	if(optional.isPresent()) {
    		MenuItem entity = optional.get();
    		return new ResponseEntity<MenuItem>(entity, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<MenuItem>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @RequestMapping(method=RequestMethod.GET,
    				produces="application/json")
    public List<MenuItem> getMenuItems() {
    	return repository.findAll();
    }
	
	@RequestMapping(method=RequestMethod.POST, 
	                produces="application/json", 
					consumes="application/json")
	public ResponseEntity<MenuItem> insertMenuItem(@RequestBody MenuItem item, 
	                                               HttpSession httpSession) {
		System.out.println("Menu Item to to inserted -->" + item.toString());
		repository.save(item);
		return new ResponseEntity<MenuItem>(item, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", 
	                method=RequestMethod.PUT, 
					produces="application/json", 
					consumes="application/json")
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable(value="id") String id, 
	                                               @RequestBody MenuItem menuItem, 
												   HttpSession httpSession) {
		System.out.println("Menu Item to be upadated --> " + menuItem.toString());
		Optional<MenuItem> value = repository.findById(Long.parseLong(id));
		if(value.isPresent()) {
			MenuItem entity = value.get();
			menuItem.setId(entity.getId());
			repository.save(menuItem);
			return new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
		} else {
			return new ResponseEntity<MenuItem>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", 
	                method=RequestMethod.DELETE, 
					consumes="application/json")
	public ResponseEntity deleteMenuItem(@PathVariable(value="id") String id) {
		
    	Optional<MenuItem> optional = repository.findById(Long.parseLong(id));
    	if(optional.isPresent()) {
    		MenuItem entity = optional.get();
    		repository.delete(entity);
    		return new ResponseEntity<MenuItem>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<MenuItem>(HttpStatus.NOT_FOUND);
    	}
	}
}