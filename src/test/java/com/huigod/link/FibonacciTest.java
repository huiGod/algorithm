package com.huigod.link;

import org.junit.Test;

public class FibonacciTest {

  private Fibonacci fibonacci = new Fibonacci();

  @Test
  public void testGetFibonacciNumber() {
    for (int i = 1; i <= 10; i++) {
      System.out.println(fibonacci.getFibonacciNumber(i));
    }
  }

}
