package click.shoort.URL.Controlller;

import click.shoort.URL.DAO.ClickShoortenerDao;
import click.shoort.URL.Model.ClickShoortenerLink;
import click.shoort.URL.Service.ShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ShortenerController {

    @Autowired
    private ShortenerService shortenerService;

    @Autowired
    private ClickShoortenerDao clickShoortenerDao;

    @GetMapping("/")
    private ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("Everything under control");
    }

    @GetMapping("/{id}")
    private String getLongURL(@PathVariable String id){
        return shortenerService.getLongURL(id);
    }
}
