package org.freeTask.origin;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTaskTest {

  @Test
  void execute() {
    Collection<Unit> units = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      int finalI = i;
      units.add(new Unit(Double.valueOf(finalI)) {
        @Override
        public Result execute() {
          String msg = "execute "+ finalI;
          System.out.println(msg);
          return new Result(Result.SUCCESS,msg);
        }
      });
    }

    val task = new AbstractTask(units) {
      @Override
      public void order(Collection<Unit> units) {
        ((ArrayList<Unit>)units).sort((o1, o2) -> o1.getIndex()<o2.getIndex()? 0 : -1);
      }
    };

    task.execute();
    System.out.println("Units' Results"+task.getUnits());
  }
}