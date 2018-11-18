package com.huigod.link;

public enum ResultEnnum {

  OK(true,"操作成功"),
  ERROR(false, "操作失败");

  private boolean flag;
  private String message;


  ResultEnnum(boolean code, String message) {
    this.flag = code;
    this.message = message;
  }

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
