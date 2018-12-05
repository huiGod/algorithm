package com.huigod.link;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkOperatorTest {

  private DoubleLinkOperator doubleLinkOperator = new DoubleLinkOperator();
  private LinkDataStruct linkDataStruct = new LinkDataStruct();

  @Before
  public void init() {
    Node node1 = new Node("A");
    node1.setPrev(linkDataStruct.getHead());
    linkDataStruct.getHead().setNext(node1);
    Node node2 = new Node(node1, "B");
    node1.setNext(node2);
    Node node3 = new Node(node2, "C");
    node2.setNext(node3);
    Node node4 = new Node(node3, "D");
    node3.setNext(node4);
    node4.setNext(linkDataStruct.getTail());
    linkDataStruct.getTail().setPrev(node4);
    linkDataStruct.setLength(4);
  }

  @Test
  public void testInsertNodeByIndex() {
    Assert.assertTrue(doubleLinkOperator.insertNodeByIndex(linkDataStruct, 1, "AA"));
    Assert.assertArrayEquals(new String[]{"AA", "A", "B", "C", "D"},
        doubleLinkOperator.getAllElementHeadToTail(linkDataStruct));
    Assert.assertTrue(doubleLinkOperator.insertNodeByIndex(linkDataStruct, 6, "E"));
    Assert.assertArrayEquals(new String[]{"AA", "A", "B", "C", "D", "E"},
        doubleLinkOperator.getAllElementHeadToTail(linkDataStruct));
  }

  @Test
  public void testGetAllElementHeadToTail() {
    Assert.assertArrayEquals(new String[]{"A", "B", "C", "D"},
        doubleLinkOperator.getAllElementHeadToTail(linkDataStruct));
  }

  @Test
  public void testGetAllElementTailToHead() {
    Assert.assertArrayEquals(new String[]{"D", "C", "B", "A"},
        doubleLinkOperator.getAllElementTailToHead(linkDataStruct));
  }

  @Test
  public void testRemoveElementByIndex() {
    Assert.assertFalse(doubleLinkOperator.removeElementByIndex(linkDataStruct, 0));
    Assert.assertTrue(doubleLinkOperator.removeElementByIndex(linkDataStruct, 1));
    Assert.assertArrayEquals(new String[]{"B", "C", "D"},
        doubleLinkOperator.getAllElementHeadToTail(linkDataStruct));
    Assert.assertFalse(doubleLinkOperator.removeElementByIndex(linkDataStruct, 4));
    Assert.assertTrue(doubleLinkOperator.removeElementByIndex(linkDataStruct, 3));
    Assert.assertArrayEquals(new String[]{"B", "C"},
        doubleLinkOperator.getAllElementHeadToTail(linkDataStruct));
    Assert.assertTrue(doubleLinkOperator.removeElementByIndex(linkDataStruct, 2));
    Assert.assertTrue(doubleLinkOperator.removeElementByIndex(linkDataStruct, 1));
    Assert.assertEquals(0, linkDataStruct.getLength());
  }

  @Test
  public void testInsertToTail() {
    Assert.assertTrue(doubleLinkOperator.insertToTail(linkDataStruct, "E"));
    Assert.assertArrayEquals(new String[]{"A", "B", "C", "D", "E"},
        doubleLinkOperator.getAllElementHeadToTail(linkDataStruct));
    LinkDataStruct empty = new LinkDataStruct();
    Assert.assertTrue(doubleLinkOperator.insertToTail(empty, "A"));
    Assert.assertArrayEquals(new String[]{"A"}, doubleLinkOperator.getAllElementHeadToTail(empty));

  }

}
