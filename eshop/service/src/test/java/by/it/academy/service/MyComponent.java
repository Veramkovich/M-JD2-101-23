package by.it.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:some.properties")

public class MyComponent {

    private final MyComponent2 component2;
    String name;
    String homePath;


    public MyComponent(@Autowired MyComponent2 component2,
                       @Value("${default.component.name}") String name,
                       @Value("${baeldung.presentation}") String homePath
    ) {
        this.component2 = component2;
        this.name = name;
        this.homePath = homePath;
    }

    public void printComponentName() {
        System.out.println("MyComponent");
    }

}

@Component
class MyComponent2 {


    public void printComponentName() {
        System.out.println("MyComponent2");
    }

}