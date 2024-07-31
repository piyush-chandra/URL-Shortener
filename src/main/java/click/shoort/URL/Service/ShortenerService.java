package click.shoort.URL.Service;

import click.shoort.URL.DAO.ClickShoortenerDao;
import click.shoort.URL.Model.ClickShoortenerLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShortenerService {

    @Autowired
    private ClickShoortenerDao clickShoortenerDao;

    public String getLongURL(String id) {
        Optional<ClickShoortenerLink> ls = clickShoortenerDao.findById(Long.parseLong(id));
        String longURL = ls.get().getLongUrl();
        return longURL;
    }
}
