package org.freeTask.origin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Collection;

@AllArgsConstructor
@Data
public abstract class AbstractTask {
  public Collection<Unit> units;

  @SneakyThrows(InterruptedException.class)
  public void execute(){

    order(units);

    for(Unit unit : units) {
      Result result = unit.execute();

      result = result == null ? new NonResult() : result;

      unit.setResult(result);

      System.out.println(result.toString());

      String status = result.getStatus();

      while(status == Result.SUSPEND){
        Thread.sleep(10000);
      }

      if (status == Result.ERROR ||status == Result.FINISHED ) break;
    }

  }

  public abstract void order(Collection<Unit> units);
}
