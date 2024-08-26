package click.shoort.URL_Shortener.repository;

import click.shoort.URL_Shortener.model.ClickShortenerLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickShortenerLinkRepository extends JpaRepository<ClickShortenerLink, Long> {
    ClickShortenerLink findByTinyUrl(String tinyUrl);
    ClickShortenerLink findByLongUrl(String longUrl);
}
