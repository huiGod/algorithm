package com.huigod.link;

import java.util.regex.Pattern;

/**
 * 栈操作
 */
public class StackOperator {

  /**
   * 入栈操作
   */
  public boolean pushElement(LinkDataStruct linkDataStruct, String data) {
    if (linkDataStruct.getLength() == linkDataStruct.getMaxLength()) {
      return ResultEnnum.ERROR.isFlag();
    }

    Node pushElement = new Node(data);
    Node head = linkDataStruct.getHead();
    if (head.getNext() != null) {
      pushElement.setNext(head.getNext());
    }
    head.setNext(pushElement);
    linkDataStruct.setLength(linkDataStruct.getLength() + 1);
    return ResultEnnum.OK.isFlag();
  }

  /**
   * 出栈操作
   */
  public String popElement(LinkDataStruct linkDataStruct) {
    if (linkDataStruct.getLength() <= 0) {
      throw new RuntimeException();
    }

    Node head = linkDataStruct.getHead();
    Node popElement = head.getNext();
    if (linkDataStruct.getLength() == 1) {
      head.setNext(null);
    } else {
      head.setNext(popElement.getNext());
    }
    linkDataStruct.setLength(linkDataStruct.getLength() - 1);
    return popElement.getData();
  }

  /**
   * 查看栈顶元素
   */
  public String getElement(LinkDataStruct linkDataStruct) {
    if (linkDataStruct.getLength() <= 0) {
      return null;
    }

    Node head = linkDataStruct.getHead();
    Node popElement = head.getNext();
    return popElement.getData();
  }

  /**
   * 弹出所有的元素
   */
  public String[] popAllElement(LinkDataStruct linkDataStruct) {
    String[] result = new String[linkDataStruct.getLength()];
    Node head = linkDataStruct.getHead();
    int index = 0;

    while (head.getNext() != null) {
      Node currentNode = head.getNext();
      result[index++] = currentNode.getData();
      head = null;
      head = currentNode;
    }
    linkDataStruct.setLength(0);
    return result;
  }

  /**
   * 中缀表达式转换成后缀表达式
   * 后缀表达式：指的是不包含括号，运算符放在两个运算对象的后面，所有的计算按运算符出现的顺序，严格从左向右进行（不再考虑运算符的优先规则）
   * a. 若为 '('，入栈；
   * b. 若为 ')'，则依次把栈中的的运算符加入后缀表达式中，直到出现'('，从栈中删除'(' ；
   * c. 若为除括号外的其他运算符， 当其优先级高于除'('以外的栈顶运算符时，直接入栈。
   * 否则从栈顶开始，依次弹出比当前处理的运算符优先级高和优先级相等的运算符，
   * 直到一个比它优先级低的或者遇到了一个左括号为止，然后将其自身压入栈中（先出后入）。
   * @param exp
   */
  public String[] middleToSuffixExpression(String[] exp) {
    DoubleLinkOperator doubleLinkOperator = new DoubleLinkOperator();
    if (exp == null || exp.length == 0) {
      return null;
    }
    LinkDataStruct result = new LinkDataStruct();
    LinkDataStruct linkDataStruct = new LinkDataStruct();
    int index = 0;
    while (index < exp.length) {
      String currentChar = String.valueOf(exp[index]);
      //直接入栈
      if ("*".equals(currentChar) || "/".equals(currentChar) || "(".equals(currentChar)) {
        pushElement(linkDataStruct, currentChar);
      } else if (")".equals(currentChar)) {
        //匹配到前面那的(为止
        while (true) {
          String popElemennt = popElement(linkDataStruct);
          if ("(".equals(popElemennt)) {
            break;
          }
          doubleLinkOperator.insertToTail(result, popElemennt);
        }
      }else if ("+".equals(currentChar) || "-".equals(currentChar)) {
        while (true) {
          //需要比较同栈顶元素比较
          String topElement = getElement(linkDataStruct);
          //因为+或者-是优先级最低的，需要弹出优先级更高的或者相同的元素
          if (topElement == null || "(".equals(topElement)) {
            break;
          }
          doubleLinkOperator.insertToTail(result, popElement(linkDataStruct));
        }
        pushElement(linkDataStruct, currentChar);
      } else {
        //如果不是操作符，直接输出
        doubleLinkOperator.insertToTail(result, currentChar);
      }
      index++;
    }
    if (linkDataStruct.getLength() != 0) {
      for (String topElement : popAllElement(linkDataStruct)) {
        doubleLinkOperator.insertToTail(result, topElement);
      }
    }
    return doubleLinkOperator.getAllElementHeadToTail(result);
  }

  public int computeSuffixExpression(String[] exp) {
    int index = 0;
    LinkDataStruct stack = new LinkDataStruct();
    while (index < exp.length) {
      String current = String.valueOf(exp[index]);
      String regrex = "[+\\-*/]";
      if (Pattern.compile(regrex).matcher(current).matches()) {
        int param1 = Integer.valueOf(popElement(stack));
        int param2 = Integer.valueOf(popElement(stack));
        int result;
        if ("+".equals(current)) {
          result = param1 + param2;
        } else if ("-".equals(current)) {
          result = param2 - param1;
        } else if ("*".equals(current)) {
          result = param1 * param2;
        } else {
          result = param2 / param1;
        }
        pushElement(stack, String.valueOf(result));
      } else {
        pushElement(stack, current);
      }
      index++;
    }
    return Integer.valueOf(popElement(stack));
  }
}
