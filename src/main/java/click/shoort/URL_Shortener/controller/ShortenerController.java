package click.shoort.URL_Shortener.controller;

import click.shoort.URL_Shortener.service.ShortenerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ShortenerController {
    
    @Autowired
    private ShortenerService shortenerService;

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return shortenerService.healthCheck();
    }

    @GetMapping("/")
    public ModelAndView landingPage() {
        return shortenerService.getLandingPage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getOriginalURI(@PathVariable("id") String uri) {
        return shortenerService.getOriginalURI(uri);
    }

    @PostMapping("/shortUrl")
    public String shortenUrl(@RequestBody String originalUrl) {
        return shortenerService.shortenUrl(originalUrl);
    }
}
