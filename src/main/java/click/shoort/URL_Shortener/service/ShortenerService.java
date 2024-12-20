package click.shoort.URL_Shortener.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import click.shoort.URL_Shortener.model.ClickShortenerLink;
import click.shoort.URL_Shortener.repository.ClickShortenerLinkRepository;

@Service
public class ShortenerService {

    @Autowired
    private ClickShortenerLinkRepository clickShortenerLinkRepository;

    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("EveryThing is working fine!");
    }

    public ModelAndView getLandingPage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    public ResponseEntity<Void> getOriginalURI(String uri) {
         ClickShortenerLink link = clickShortenerLinkRepository.findByTinyUrl(uri);
        if (link == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY) 
                .location(URI.create(link.getLongUrl()))
                .build();
    }

    @Transactional
    public ResponseEntity<String> shortenUrl(String originalUrl) {
        //first check if the url is already in the database
        ClickShortenerLink link = clickShortenerLinkRepository.findByLongUrl(originalUrl);
        if (link != null) {
            return ResponseEntity.ok("shoort.click/" + link.getTinyUrl());
        }

        ClickShortenerLink newlink = new ClickShortenerLink();
        newlink.setLongUrl(originalUrl);
        ClickShortenerLink link1 = clickShortenerLinkRepository.save(newlink);

        long insertionorderid =  link1.getId();
        String tinyUrl = Long.toString(insertionorderid, 62);

        link1.setTinyUrl(tinyUrl);
        clickShortenerLinkRepository.save(link1);

        String shortenedUrl = "shoort.click/" + tinyUrl;
        return ResponseEntity.ok(shortenedUrl);
    }

}
