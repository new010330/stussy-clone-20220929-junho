package com.stussy.stussclone20220929junho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopPageController {

    @GetMapping("/collections/{category}")
    public String loadCollections(@PathVariable String category) {
        return  "shop/collections";
    }

}
