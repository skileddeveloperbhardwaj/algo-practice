package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Car implements Vehicle {

    @Override
    public void drive() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return 0;
            }
        });
    }
}

class Node{
    int timeStamp;
    int key;
}
