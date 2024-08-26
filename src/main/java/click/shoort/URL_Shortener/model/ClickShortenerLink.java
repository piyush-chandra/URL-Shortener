package click.shoort.URL_Shortener.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CLICK_SHOORTENER_LINKS")
public class ClickShortenerLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "long_url", nullable = true)
    private String longUrl;

    @Column(name = "tiny_url", length = 30)
    private String tinyUrl;

    //constructor
    public ClickShortenerLink() {
    }

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
}
