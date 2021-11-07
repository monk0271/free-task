package org.freeTask.origin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
  public static final String SUCCESS = "Success";
  public static final String ERROR = "error";
  public static final String FINISHED = "Finished";
  public static final String SUSPEND = "Suspend";

  private String status;

  private String msg;

}

class NonResult extends Result{
  public NonResult(){ setStatus(FINISHED); }
}