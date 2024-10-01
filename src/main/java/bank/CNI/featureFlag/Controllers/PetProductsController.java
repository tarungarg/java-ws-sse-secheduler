package bank.CNI.featureFlag.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import io.getunleash.UnleashContext;
import org.unleash.features.annotation.Toggle;
// import bank.CNI.featureFlag.service.PetProductsService;
import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.UnleashContext;
import io.getunleash.util.UnleashConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@RestController
class PetProductsController {

    private final Unleash unleash;

    public PetProductsController(final Unleash unleash) {
        this.unleash = unleash;
    }

    @GetMapping("/products")
    public Unleash getPetProducts(final String name) {
        UnleashConfig config = new UnleashConfig.Builder()
                .appName("production")
                .instanceId("glffct-")
                .unleashAPI("https://gitlab.com/api/v4/feature_flags/unleash//toggle/")
                .build();

        return new DefaultUnleash(config);
    }

    @GetMapping("/v")
    public Boolean c(final String name) {
        return unleash.isEnabled("sss");
    }

    @GetMapping("/v1")
    public List<Object> c1(final String name) {
        ArrayList<Object> dynamicArray = new ArrayList<>();
        List<String> sss = unleash.more().getFeatureToggleNames();

        for (String obj : sss) {

            dynamicArray.add(new Person(obj, unleash.isEnabled(obj)).toString());
        }

        return dynamicArray;
    }

}

class Person {
    String name;
    boolean value;

    public Person(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
