package org.example;

import org.springframework.stereotype.Component;

@Component // this annotation is not necessary since this only class is passed as parameter when initializing AnnotationConfigApplicationContext
public class NameProvider {

    public String getName() {
        return "Mari";
    }
}
