package com.redhat.openshift.sd.demos;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FooTest {

    @Test
    public void testHello() {

        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.
        // Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes. This size will increase
        // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        System.out.format("Heap Size: %dMb | Max Heap: %dMb | Free Heap: %dMb", heapSize / 1024, heapMaxSize / 1024, heapFreeSize / 1024);

        assertEquals("Hello Kermit", new Foo().sayHello("Kermit"));
    }
}
