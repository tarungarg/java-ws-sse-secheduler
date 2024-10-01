package bank.CNI.featureFlag.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FeatureFlagController {
    private static final String WELCOME_URL = "https://gitlab.com/api/v4/feature_flags/unleash/";

    @GetMapping("/featureFlag")
    public String featureFlag() {
        return "Feature Flag";
    }

    @GetMapping("/welcomeclient")
    public String greetMessage() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(WELCOME_URL, String.class);
        return result;
    }
}
