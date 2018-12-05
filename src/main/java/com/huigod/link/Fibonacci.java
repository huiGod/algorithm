package com.huigod.link;

/**
 * 斐波那契递归求和
 */
public class Fibonacci {

  public int getFibonacciNumber(int n) {
    if (n < 3) {
      return 1;
    } else {
      return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }
  }

}