package com.huigod.link;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkOperatorTest {

  private LinkDataStruct linkDataStruct = new LinkDataStruct();
  private SingleLinkOperator singleLinkOperator = new SingleLinkOperator();

  @Before
  public void init() {
    singleLinkOperator.tailInsertElements(linkDataStruct, "A", "B", "C", "D");
  }

  @Test(expected = RuntimeException.class)
  public void testGetElementByIndex() {
    Assert.assertEquals("D", singleLinkOperator.getElementByIndex(linkDataStruct, 4));
    singleLinkOperator.getElementByIndex(linkDataStruct, 9);
  }

  @Test
  public void testInsertElementByIndex() {
    Assert.assertTrue(singleLinkOperator.insertElementByIndex(linkDataStruct, 1, "0"));
    Assert.assertEquals("0", linkDataStruct.getHead().getNext().getData());
    Assert.assertEquals("0", singleLinkOperator.getElementByIndex(linkDataStruct, 1));
    Assert.assertEquals("B", singleLinkOperator.getElementByIndex(linkDataStruct, 3));
  }

  @Test
  public void testRemoveElementByIndex() {
    Assert.assertTrue(singleLinkOperator.removeElementByIndex(linkDataStruct, 2));
    Assert.assertEquals("C", singleLinkOperator.getElementByIndex(linkDataStruct, 2));
  }

  @Test
  public void testHeadInsertElements() {
    Assert.assertTrue(singleLinkOperator.headInsertElements(linkDataStruct, "AA", "BB"));
    Assert.assertEquals("BB", singleLinkOperator.getElementByIndex(linkDataStruct, 1));
    Assert.assertEquals("AA", singleLinkOperator.getElementByIndex(linkDataStruct, 2));
  }

  @Test
  public void testGetAllElements() {
    Assert.assertArrayEquals(new String[]{"A", "B", "C", "D"},
        singleLinkOperator.getAllElements(linkDataStruct));
  }

  @Test
  public void testTailInsertElements() {
    Assert.assertTrue(singleLinkOperator.tailInsertElements(linkDataStruct, "AA", "BB"));
    Assert.assertArrayEquals(new String[]{"A", "B", "C", "D", "AA", "BB"},
        singleLinkOperator.getAllElements(linkDataStruct));
  }

  @Test
  public void testClearElements() {
    Assert.assertTrue(singleLinkOperator.clearElements(linkDataStruct));
    Assert.assertNull(linkDataStruct.getHead().getNext().getData());
    Assert.assertNull(linkDataStruct.getHead().getNext().getNext());
  }
}
