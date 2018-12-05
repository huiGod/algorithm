package com.huigod.link;

import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackOperatorTest {

  private LinkDataStruct stack = new LinkDataStruct();
  private StackOperator stackOperator = new StackOperator();

  @Before
  public void init() {
    Node node1 = new Node("A");
    stack.getHead().setNext(node1);
    Node node2 = new Node("B");
    stack.getHead().setNext(node2);
    node2.setNext(node1);
    Node node3 = new Node("C");
    stack.getHead().setNext(node3);
    node3.setNext(node2);
    Node node4 = new Node("D");
    stack.getHead().setNext(node4);
    node4.setNext(node3);
    stack.setLength(4);
  }

  @Test
  public void testPushElement() {
    Assert.assertTrue(stackOperator.pushElement(stack, "E"));
    Assert.assertArrayEquals(new String[]{"E", "D", "C", "B", "A"},
        stackOperator.popAllElement(stack));
  }

  @Test
  public void testPopElement() {
    Assert.assertEquals("D", stackOperator.popElement(stack));
    Assert.assertArrayEquals(new String[]{"C", "B", "A"}, stackOperator.popAllElement(stack));
  }

  @Test
  public void testPopAllElement() {
    Assert.assertArrayEquals(new String[]{"D", "C", "B", "A"}, stackOperator.popAllElement(stack));
  }

  @Test
  public void testGetElement() {
    Assert.assertEquals("D", stackOperator.getElement(stack));
  }

  @Test
  public void testMiddleToSuffixExpression() {
    Assert.assertArrayEquals(
        new String[]{"9", "3", "1", "-", "3", "*", "+", "10", "2", "/", "+"},
        stackOperator.middleToSuffixExpression(
            new String[]{"9", "+", "(", "3", "-", "1", ")", "*", "3", "+", "10", "/", "2"}));
  }

  @Test
  public void testComputeSuffixExpression() {
    String[] exp = stackOperator.middleToSuffixExpression(
        new String[]{"9", "+", "(", "3", "-", "1", ")", "*", "3", "+", "10", "/", "2"});
    Assert.assertEquals(20, stackOperator.computeSuffixExpression(exp));
  }

  @Test
  public void testRegrex() {
    System.out.println(Pattern.compile("[+\\-*/]").matcher("/").matches());
  }

}
