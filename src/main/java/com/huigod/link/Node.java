package com.huigod.link;

public class Node {

  private String data;

  private Node next;

  private Node prev;

  Node() {

  }

  Node(String data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }
}
