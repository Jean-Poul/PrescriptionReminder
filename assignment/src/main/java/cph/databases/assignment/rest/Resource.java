package cph.databases.assignment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/demo")
public class Resource {


        @GetMapping("geturl")
        public String get() {
            return "That was a get request";
        }

        @PostMapping("posturl")
        public String post( @RequestBody String msg) {
            return "That was a post request with body: " + msg;
        }


}
