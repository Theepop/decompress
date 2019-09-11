package com.test.decompress.controller;

import com.test.decompress.services.DecompressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/decompress")
public class MainController {
    @Autowired
    DecompressService service;

    @GetMapping(path = "/{input}")
    @ResponseBody
    String decompressWithSearching(@PathVariable String input){
        return service.decompressWithSearching(input);
    }


}
