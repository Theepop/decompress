package com.test.decompress.controller;

import com.test.decompress.dao.InputDAO;
import com.test.decompress.dao.ResultDAO;
import com.test.decompress.services.DecompressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/decompress")
public class MainController {
    @Autowired
    DecompressService service;

    @PostMapping(path = "/")
    @ResponseBody
    public ResultDAO decompressWithSearching(@RequestBody InputDAO input){
        ResultDAO result = new ResultDAO();
        result.setResult(service.decompressWithSearching(input.getInput()));
        return result;
    }


}
