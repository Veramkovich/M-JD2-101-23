package by.it.academy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyComponent.class, MyComponent2.class})
public class MyComponentTest {

    @Autowired
    MyComponent myComponent;

    @Test
    public void printComponentName() {
        assertNotNull(myComponent);
        myComponent.printComponentName();
        assertEquals("test", myComponent.name);
        System.out.println(myComponent.homePath);
    }
}