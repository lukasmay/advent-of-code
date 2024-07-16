package org.y2023.day8;

public class Node {
    public  String leftId;
    public String rightId;
    public String id;

    public Node(String id, String left, String right) {
        this.id = id;
        this.leftId = left;
        this.rightId = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "leftId='" + leftId + '\'' +
                ", rightId='" + rightId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
