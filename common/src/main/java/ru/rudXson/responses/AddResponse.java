package ru.rudXson.responses;

public class AddResponse extends Response {

  public AddResponse(String error) {
    super("add", error);
  }
}
