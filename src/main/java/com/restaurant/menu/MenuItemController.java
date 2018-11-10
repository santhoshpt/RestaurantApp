package com.restaurant.menu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/restaurant/menu/item")
public class MenuItemController {
	
    @RequestMapping(method=RequestMethod.GET, 
	                produces="application/json")
    public ResponseEntity<MenuItem> getMenuItem(@RequestParam(value="id") String id, HttpSession httpSession) {
		MenuItem item = getItems(httpSession).get(id);
		if(item != null) {
			return new ResponseEntity(item, HttpStatus.OK);
		} else {
			//Exception as menu item does not exists;
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
    }
	
	@RequestMapping(method=RequestMethod.POST, 
	                produces="application/json", 
					consumes="application/json")
	public ResponseEntity<MenuItem> insertMenuItem(@RequestBody MenuItem menuItem, 
	                                               HttpSession httpSession) {
		System.out.println("Menu Item to to inserted -->" + menuItem.toString());
		addItemToSession(menuItem, httpSession);
		return new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", 
	                method=RequestMethod.PUT, 
					produces="application/json", 
					consumes="application/json")
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable(value="id") String id, 
	                                               @RequestBody MenuItem menuItem, 
												   HttpSession httpSession) {
		System.out.println("Menu Item to be upadated --> " + menuItem.toString());
		if(isItemExists(menuItem, httpSession)) {
		    addItemToSession(menuItem, httpSession);
			return new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", 
	                method=RequestMethod.DELETE, 
					consumes="application/json")
	public ResponseEntity deleteMenuItem(@PathVariable(value="id") String id, 
	                                     HttpSession httpSession) {
		if(isItemExists(id, httpSession)) {
		    removeItemFromSession(id, httpSession);
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	public void addItemToSession(MenuItem item, HttpSession httpSession) {
		Map menuItems = getItems(httpSession);
		menuItems.put(item.getId(), item);
		httpSession.setAttribute("menuItems", menuItems);
	}
	
	public void removeItemFromSession(String id, HttpSession httpSession) {
		Map menuItems = getItems(httpSession);
		menuItems.remove(id);
		httpSession.setAttribute("menuItems", menuItems);
	}

	public boolean isItemExists(MenuItem item, HttpSession httpSession) {
		boolean isExists = false;
		Map items = getItems(httpSession);
		if(items.containsKey(item.getId())) {
			isExists = true;
		}
		return isExists;
	}
	
	public boolean isItemExists(String id, HttpSession httpSession) {
		boolean isExists = false;
		Map items = getItems(httpSession);
		if(items.containsKey(id)) {
			isExists = true;
		}
		return isExists;
	}
	
	public HashMap<String, MenuItem> getItems(HttpSession httpSession) {
		//Sample code... Need to refactor to Database schema.
		System.out.println("Http Session -->"+ httpSession);
		HashMap<String, MenuItem> menuItems = (HashMap<String, MenuItem>)httpSession.getAttribute("menuItems");
		System.out.println("Menu Items  --> " + menuItems);
		if(null == menuItems) {
			System.out.println("Menu items in session is empty");
			menuItems = new HashMap<String, MenuItem>();
			httpSession.setAttribute("menuItems", menuItems);
		}
		System.out.println("Menu Item Count  --> " + menuItems.size());
		return menuItems;
	}
}