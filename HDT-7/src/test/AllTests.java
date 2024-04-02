package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class AllTests {

    @Test
    public void testAssociation() {
        Association<String, Integer> association = new Association<>("key", 10);
        assertEquals("key", association.getKey());
        assertEquals(10, association.getValue());
    }

    @Test
    public void testBinaryTree() {
        BinaryTree<Integer, String> tree = new BinaryTree<>(10, "value");
        tree.insert(5, "left");
        tree.insert(15, "right");

        assertEquals("left", tree.search(5));
        assertEquals("right", tree.search(15));

        assertEquals("value", tree.search(10));
        assertNull(tree.search(20));

        assertDoesNotThrow(() -> tree.inorderTraversal());
    }

    @Test
    public void testMain() throws IOException {
  
}


