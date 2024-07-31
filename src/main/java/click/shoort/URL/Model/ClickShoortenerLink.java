package click.shoort.URL.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "CLICK_SHOORTENER_LINKS")
public class ClickShoortenerLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longUrl;

    private String tinyUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    @Override
    public String toString() {
        return "ClickShoortenerLink{" +
                "id=" + id +
                ", longUrl='" + longUrl + '\'' +
                ", tinyUrl='" + tinyUrl + '\'' +
                '}';
    }
}
