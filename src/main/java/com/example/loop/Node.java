package com.example.loop;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Node {

    private static final AtomicInteger instanceCount = new AtomicInteger();

    private final int value;

    private Node next;

    public Node() {
        this(null);
    }

    public Node(Node next) {
        this.value = instanceCount.incrementAndGet();
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + (next == null ? "None" : Integer.toString(next.value)) +
                '}';
    }
}

