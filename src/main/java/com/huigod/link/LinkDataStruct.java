package com.huigod.link;

public class LinkDataStruct {

  //头结点可以不用存储实际数据，可以用来存储辅助的数据
  //真正的数据从tail后面的节点开始
  private Node head;
  private int length;

  LinkDataStruct() {
    head = new Node();
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
}
