package bank.CNI.ssl;

import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import bank.CNI.featureFlag.repo.FeatureFlagRepo;
import bank.CNI.featureFlag.repo.FeatureService;
import lombok.val;

@RestController
@EnableScheduling
public class SSLController {

    private static final String WELCOME_URL = "https://api.github.com/repos/delightiq/gyaan-config/commits";

    private final static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/ssl")
    @Scheduled(fixedRate = 5000)
    public String greetMessage() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github+json");
        headers.set("Authorization", "Bearer ");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                WELCOME_URL, HttpMethod.GET, requestEntity, String.class);

        String featureFlags = response.getBody();

        System.out.println(featureFlags);
        // featureService.save(featureFlags);

        return featureFlags;
    }
}
