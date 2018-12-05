package com.huigod.link;

/**
 * 双链表操作
 */
public class DoubleLinkOperator {

  /**
   * 从头到尾遍历双向链表
   */
  public String[] getAllElementHeadToTail(LinkDataStruct linkDataStruct) {
    if (linkDataStruct.getLength() < 1) {
      return new String[0];
    }
    String[] result = new String[linkDataStruct.getLength()];
    Node head = linkDataStruct.getHead();
    int index = 0;
    while (head.getNext() != linkDataStruct.getTail()) {
      head = head.getNext();
      result[index++] = head.getData();
    }
    return result;
  }

  /**
   * 从尾到到头遍历双向链表
   */
  public String[] getAllElementTailToHead(LinkDataStruct linkDataStruct) {
    if (linkDataStruct.getLength() < 1) {
      return new String[0];
    }
    String[] result = new String[linkDataStruct.getLength()];
    Node tail = linkDataStruct.getTail();
    int index = 0;
    while (tail.getPrev() != linkDataStruct.getHead()) {
      tail = tail.getPrev();
      result[index++] = tail.getData();
    }
    return result;
  }

  /**
   * 在i位置插入元素 首先处理后面元素与插入元素之间的关系，因为如果先处理插入元素与前面元素的关系，那么将无法找到后续元素
   */
  public boolean insertNodeByIndex(LinkDataStruct linkDataStruct, int i, String data) {
    if (i < 1 || i > linkDataStruct.getLength() + 1) {
      return ResultEnnum.ERROR.isFlag();
    }

    Node head = linkDataStruct.getHead();
    int index = 1;

    while (head.getNext() != linkDataStruct.getTail() && index < i) {
      head = head.getNext();
      index++;
    }
    Node insertNode = new Node(data);
    //如果插入的元素是最后一个元素
    if (i == linkDataStruct.getLength() + 1) {
      head.setNext(insertNode);
      insertNode.setPrev(head);
      insertNode.setNext(linkDataStruct.getTail());
      linkDataStruct.getTail().setPrev(insertNode);
    } else {
      head.getNext().setPrev(insertNode);
      insertNode.setNext(head.getNext());
      head.setNext(insertNode);
      insertNode.setPrev(head);
    }
    linkDataStruct.setLength(linkDataStruct.getLength() + 1);
    return ResultEnnum.OK.isFlag();
  }

  /**
   * 删除第i个位置的元素
   */
  public boolean removeElementByIndex(LinkDataStruct linkDataStruct, int i) {
    int length = linkDataStruct.getLength();
    if (i <= 0 || i > length) {
      return ResultEnnum.ERROR.isFlag();
    }
    //只有一个元素被删除
    if (i == 1 && length == 1) {
      Node head = linkDataStruct.getHead();
      head.setNext(null);
      linkDataStruct.getTail().setPrev(null);
      linkDataStruct.setLength(length - 1);
      return ResultEnnum.OK.isFlag();
    }
    Node deleteNode;
    //从后往前遍历
    if (i > length / 2) {
      Node tail = linkDataStruct.getTail();
      for (int index = length; index >= i; index--) {
        tail = tail.getPrev();
      }
      deleteNode = tail;
    } else {
      //从前往后遍历
      Node head = linkDataStruct.getHead();
      for (int index = 1; index <= i; index++) {
        head = head.getNext();
      }
      deleteNode = head;
    }
    deleteNode.getPrev().setNext(deleteNode.getNext());
    deleteNode.getNext().setPrev(deleteNode.getPrev());
    deleteNode = null;
    linkDataStruct.setLength(length - 1);
    return ResultEnnum.OK.isFlag();
  }

  /**
   * 插入元素到尾部
   */
  public boolean insertToTail(LinkDataStruct linkDataStruct, String data) {
    Node tailNode = linkDataStruct.getTail();
    Node headNode = linkDataStruct.getHead();
    Node insertNode = new Node(data);
    Node lastNode;
    if (linkDataStruct.getLength() >= 1) {
      lastNode = tailNode.getPrev();
    } else {
      lastNode = headNode;
    }
    lastNode.setNext(insertNode);
    insertNode.setPrev(lastNode);
    insertNode.setNext(tailNode);
    tailNode.setPrev(insertNode);
    linkDataStruct.setLength(linkDataStruct.getLength() + 1);
    return ResultEnnum.OK.isFlag();
  }
}
