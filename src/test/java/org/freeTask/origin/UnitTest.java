package org.freeTask.origin;

import lombok.NonNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
  @Test
  void execute(){
    Unit unit = new Unit(1d) {
      @Override
      public @NonNull Result execute() {
        return new NonResult();
      }
    };

    assertEquals(Result.FINISHED, unit.execute().getStatus());
  }
}