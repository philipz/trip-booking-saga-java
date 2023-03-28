package io.flowing.trip.saga.camunda.adapter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class BookHotelAdapter implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {

    System.out.println("book hotel for '" + execution.getVariable("name") + "'");

    /* if (true) {
       System.out.println("book hotel failed: ''"+ execution.getVariable("name") + "'");
       throw new RuntimeException("Hotel booking did not work");
    } */
  }

}
