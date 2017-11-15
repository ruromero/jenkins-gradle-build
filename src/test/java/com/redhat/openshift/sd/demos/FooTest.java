package com.redhat.openshift.sd.demos;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FooTest {

    @Test
    public void testHello() {
        assertEquals("Hello Kermit", new Foo().sayHello("Kermit"));
    }
}
