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

  Node(Node prev, String data) {
    this.data = data;
    this.prev = prev;
  }

  Node(Node prev, String data, Node next) {
    this.prev = prev;
    this.data = data;
    this.next = next;
  }

  Node(String data, Node next) {
    this.data = data;
    this.next = next;
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
