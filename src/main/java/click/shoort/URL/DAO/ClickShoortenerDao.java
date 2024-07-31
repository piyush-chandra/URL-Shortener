package click.shoort.URL.DAO;

import click.shoort.URL.Model.ClickShoortenerLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClickShoortenerDao extends JpaRepository<ClickShoortenerLink, Long> {
//    private Object findByTinyUrl(String tinyURL);


//    private List<ClickShoortenerLink> findById(int id);
}
