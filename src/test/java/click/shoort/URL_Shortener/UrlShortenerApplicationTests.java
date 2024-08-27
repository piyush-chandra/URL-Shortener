package click.shoort.URL_Shortener;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlShortenerApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void healthCheckEndpointShouldReturnOk() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/healthCheck", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("OK");
    }

    @Test
    void shortenUrlEndpointShouldReturnShortUrl() {
        String longUrl = "https://www.example.com";
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/shortUrl", longUrl, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).startsWith("http://localhost:" + port + "/");
    }

    @Test
    void redirectionShouldWorkForShortenedUrl() {
        // First, create a shortened URL
        String longUrl = "https://www.example.com";
        ResponseEntity<String> shortenResponse = restTemplate.postForEntity("http://localhost:" + port + "/shortUrl", longUrl, String.class);
        String shortUrl = shortenResponse.getBody();

        // Now, try to access the shortened URL
        ResponseEntity<Void> redirectResponse = restTemplate.getForEntity(shortUrl, Void.class);
        assertThat(redirectResponse.getStatusCode()).isEqualTo(HttpStatus.FOUND);
        assertThat(redirectResponse.getHeaders().getLocation()).isEqualTo(java.net.URI.create(longUrl));
    }
}
