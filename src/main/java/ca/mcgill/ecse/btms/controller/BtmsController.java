package ca.mcgill.ecse.btms.controller;

import java.sql.Date;
import java.time.LocalDate;

import ca.mcgill.ecse.btms.application.BtmsApplication;
import ca.mcgill.ecse.btms.model.BTMS;

public class BtmsController {

  private static BTMS btms = BtmsApplication.getBtms();

  private BtmsController() {}

  public static String createDriver(String name) {
    try {
      btms.addDriver(name, false);
    } catch (RuntimeException e) {
      return e.getMessage();
    }
    return "";
  }


  public static String createRoute(int number) {
    var error = "";
    if (number <= 0) {
      error = "The number of a route must be greater than zero. ";
    }
    if (number > 9999) {
      error = "The number of a route cannot be greater than 9999. ";
    }
    if (!error.isEmpty()) {
      return error.trim();
    }

    try {
      btms.addRoute(number);
    } catch (RuntimeException e) {
      error = e.getMessage();
      if (error.startsWith("Cannot create due to duplicate number.")) {
        error = "A route with this number already exists. Please use a different number.";
      }
    }
    return error;
  }

  // returns the java.sql.Date for an input string in the form "yyyy-MM-dd".
  public static Date getDateFromString(String yyyyMMdd) {
    return Date.valueOf(yyyyMMdd);
  }

  public static Date getTodayDate() {
    return Date.valueOf(LocalDate.now());
  }

}
