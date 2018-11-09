package com.restaurant.menu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuItemController {

    @RequestMapping("/restaurant/menu/item")
    public MenuItem greeting(@RequestParam(value="id") long id) {
        return new MenuItem(id, "test", "test", 10.00);
    }
	
}