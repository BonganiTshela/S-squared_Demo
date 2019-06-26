package co.za.ssquared.cruddemo.cucumber.common;

import co.za.ssquared.cruddemo.CruddemoApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Component;

public class BaseCucumber extends CruddemoApplicationTests {

    @Autowired
    protected TestRestTemplate testRestTemplate;
}
