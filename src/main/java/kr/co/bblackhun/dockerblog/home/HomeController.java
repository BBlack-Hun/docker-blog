package kr.co.bblackhun.dockerblog.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@CrossOrigin()
public class HomeController {

    @CrossOrigin()
    @GetMapping()
    public String Home() {
        return "home.html";
    }
}
