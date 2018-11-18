package com.huigod.link;

/**
 * 单链表操作
 */
public class SingleLinkOperator {

  /**
   * 单链表查询第i个元素
   */
  public String getElementByIndex(LinkDataStruct linkDataStruct, int i) {
    if (i < 1 || i > linkDataStruct.getLength()) {
      throw new RuntimeException();
    }
    Node head = linkDataStruct.getHead().getNext();
    int index = 1;
    while (head != null && index < i) {
      head = head.getNext();
      index++;
    }
    return head.getData();
  }

  /**
   * 查询所有的元素
   */
  public String[] getAllElements(LinkDataStruct linkDataStruct) {
    String[] result = new String[linkDataStruct.getLength()];
    Node head = linkDataStruct.getHead();
    for (int index = 0; head.getNext() != null; index++) {
      head = head.getNext();
      result[index] = head.getData();
    }
    return result;
  }

  /**
   * 在第i个元素插入元素
   */
  public boolean insertElementByIndex(LinkDataStruct linkDataStruct, int i, String data) {
    if (i < 1 || i > (linkDataStruct.getLength() + 1)) {
      return ResultEnnum.ERROR.isFlag();
    }
    Node insertNode = new Node(data);
    Node head = linkDataStruct.getHead();
    int index = 1;
    //index<i也排除了i=1的情况
    while (head.getNext() != null && index < i) {
      head = head.getNext();
      index++;
    }
    insertNode.setNext(head.getNext());
    head.setNext(insertNode);

    linkDataStruct.setLength(linkDataStruct.getLength() + 1);

    return ResultEnnum.OK.isFlag();
  }

  /**
   * 删除第i个元素
   */
  public boolean removeElementByIndex(LinkDataStruct linkDataStruct, int i) {
    if (i < 1 || i > linkDataStruct.getLength()) {
      return ResultEnnum.ERROR.isFlag();
    }
    Node head = linkDataStruct.getHead().getNext();
    int index = 1;
    while (head != null && index < i - 1) {
      head = head.getNext();
      index++;
    }
    Node removeNode = head.getNext();
    head.setNext(removeNode.getNext());
    removeNode = null;

    linkDataStruct.setLength(linkDataStruct.getLength() - 1);
    return ResultEnnum.OK.isFlag();
  }

  /**
   * 头插法，插入多个元素
   */
  public boolean headInsertElements(LinkDataStruct linkDataStruct, String... datas) {
    if (datas.length < 1) {
      return ResultEnnum.ERROR.isFlag();
    }
    Node head = linkDataStruct.getHead();
    for (int i = 0; i < datas.length; i++) {
      Node insertNode = new Node(datas[i]);
      insertNode.setNext(head.getNext());
      head.setNext(insertNode);
    }
    linkDataStruct.setLength(linkDataStruct.getLength() + datas.length);
    return ResultEnnum.OK.isFlag();
  }

  /**
   * 尾插入，插入多个元素
   */
  public boolean tailInsertElements(LinkDataStruct linkDataStruct, String... datas) {
    if (datas.length < 1) {
      return ResultEnnum.ERROR.isFlag();
    }
    Node head = linkDataStruct.getHead();
    while (head.getNext() != null) {
      head = head.getNext();
    }

    for (int i = 0; i < datas.length; i++) {
      Node insertNode = new Node(datas[i]);
      head.setNext(insertNode);
      head = insertNode;
    }
    linkDataStruct.setLength(linkDataStruct.getLength() + datas.length);
    return ResultEnnum.OK.isFlag();
  }

  /**
   * 清空链表
   */
  public boolean clearElements(LinkDataStruct linkDataStruct) {
    //获取第一个元素
    Node head = linkDataStruct.getHead().getNext();
    while (head != null) {
      Node flagNode = head.getNext();
      head.setNext(null);
      head.setData(null);
      head = flagNode;
    }
    linkDataStruct.setLength(0);
    return ResultEnnum.OK.isFlag();
  }
}
