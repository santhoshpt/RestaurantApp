package com.restaurant.menu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/restaurant/menu/item")
public class MenuItemController {
	
	
    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<MenuItem> getMenuItem(@RequestParam(value="id") String id, HttpSession httpSession) {
		MenuItem item = getItems(httpSession).get(id);
		if(item != null) {
			return new ResponseEntity(item, HttpStatus.OK);
		} else {
			//Exception as menu item does not exists;
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
    }
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public ResponseEntity<MenuItem> insertMenuItem(MenuItem menuItem, HttpSession httpSession) {
		getItems(httpSession).put(menuItem.getId(), menuItem);
		//return new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
		return new ResponseEntity<MenuItem>(new MenuItem("10","10","10","10"), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable(value="id") String id, MenuItem menuItem, HttpSession httpSession) {
		MenuItem item = getItems(httpSession).get(id);
		if(item != null) {
			getItems(httpSession).put(id, menuItem);
			return new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, consumes="application/json")
	public void deleteMenuItem(@PathVariable(value="id") String id, HttpSession httpSession) {
		MenuItem item = getItems(httpSession).remove(id);
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
		return menuItems;
	}
}