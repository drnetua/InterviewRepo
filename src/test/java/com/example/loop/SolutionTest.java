package com.example.loop;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    final Solution solution = new JavaSolution();

    @Test
    public void shouldDetectLoop() {
        Node head = new Node();
        Node fork = new Node();
        Node loop = new Node(new Node(new Node(fork)));
        head.setNext(fork);
        fork.setNext(loop);
        assertEquals(4, solution.detectAndCountLoop(head));
    }

    @Test
    public void shouldReturnZeroIfNoLoopDetected() {
        Node head = new Node(new Node(new Node(new Node())));
        assertEquals(0, solution.detectAndCountLoop(head));
    }
}