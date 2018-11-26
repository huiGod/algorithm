package com.huigod.link;

/**
 * 双链表操作
 */
public class DoubleLinkOperator {

  /**
   * 从头到尾遍历双向链表
   */
  public String[] getAllElementHeadToTail(LinkDataStruct linkDataStruct) {
    String[] result = new String[linkDataStruct.getLength()];
    Node head = linkDataStruct.getHead().getNext();
    int index = 0;
    while (head != null && head != linkDataStruct.getTail()) {
      result[index++] = head.getData();
      head = head.getNext();
    }
    return result;
  }

  /**
   * 从尾到到头遍历双向链表
   */
  public String[] getAllElementTailToHead(LinkDataStruct linkDataStruct) {
    String[] result = new String[linkDataStruct.getLength()];
    Node tail = linkDataStruct.getTail().getPrev();
    int index = 0;
    while (tail != null && tail != linkDataStruct.getHead()) {
      result[index++] = tail.getData();
      tail = tail.getPrev();
    }
    return result;
  }

  /**
   * 在i位置插入元素
   */
  public boolean insertNodeByIndex(LinkDataStruct linkDataStruct, int i, String data) {
    if (i < 1 || i > linkDataStruct.getLength() + 1) {
      return ResultEnnum.ERROR.isFlag();
    }

    Node head = linkDataStruct.getHead();
    int index = 1;

    while (head.getNext() != null && index < i) {
      head = head.getNext();
      index++;
    }
    Node insertNode = new Node(data);
    //如果插入的元素不在最后的一个元素，不用处理以下逻辑
    if (i != linkDataStruct.getLength() + 1) {
      head.getNext().setPrev(insertNode);
      insertNode.setNext(head.getNext());
      //维护尾节点元素
      linkDataStruct.getTail().setPrev(head);
    }
    head.setNext(insertNode);
    insertNode.setPrev(head);
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
    //如果删除的是第一个元素或者最后一个元素
    if (i == 1 && length == 1) {
      Node head = linkDataStruct.getHead();
      head.setNext(null);
      linkDataStruct.setTail(head);
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
}
