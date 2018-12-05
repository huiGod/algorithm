package com.huigod.link;

public class LinkDataStruct {

  //头结点可以不用存储实际数据，可以用来存储辅助的数据
  //真正的数据从head后面的节点开始
  private Node head;
  private Node tail;
  private int length;
  private int maxLength;

  LinkDataStruct() {
    head = new Node();
    tail = new Node();
    this.maxLength = 10;
  }

  LinkDataStruct(int maxLength) {
    this();
    this.maxLength = maxLength;
  }

  public Node getHead() {
    return head;
  }

  public void setHead(Node head) {
    this.head = head;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public Node getTail() {
    return tail;
  }

  public void setTail(Node tail) {
    this.tail = tail;
  }

  public int getMaxLength() {
    return maxLength;
  }

  public void setMaxLength(int maxLength) {
    this.maxLength = maxLength;
  }
}
