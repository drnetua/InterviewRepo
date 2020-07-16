package com.example.loop;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    final Solution solution = new JavaSolution();

    @Test
    public void shouldHandleNull() {
        assertEquals(0, solution.detectAndCountLoop(null));
    }

    @Test
    public void shouldReturnZeroIfNoLoopDetected() {
        Node head = new Node(new Node(new Node(new Node())));
        assertEquals(0, solution.detectAndCountLoop(head));
    }

    @Test
    public void shouldDetectSelfLoop() {
        Node head = new Node();
        head.setNext(head);
        assertEquals(1, solution.detectAndCountLoop(head));
    }

    @Test
    public void shouldDetectShortLoop() {
        Node head = new Node(); //1
        Node fork = new Node(); //2
        Node loop = new Node(new Node(new Node(fork))); //3->4->5->2
        head.setNext(fork); //1->2
        fork.setNext(loop); //2->3
        assertEquals(4, solution.detectAndCountLoop(head));
    }

    @Test
    public void shouldHandleBigLoop() {
        Node head = new Node();
        Node tail = head;
        for (int i = 0; i < 5000; i++) {
            Node next = new Node();
            tail.setNext(next);
            tail = next;
        }
        tail.setNext(head);

        assertEquals(5001, solution.detectAndCountLoop(head));
    }
}