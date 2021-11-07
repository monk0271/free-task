package org.freeTask.origin;

import lombok.Data;

@Data
public abstract class Unit {
  private Double index;
  private Result result;

  public abstract Result execute();

  public Unit(Double index){
    this.index=index;
  };
}
