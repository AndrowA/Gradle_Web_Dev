package ca.mcgill.ecse.btms.application;

import ca.mcgill.ecse.btms.controller.BtmsController;
import ca.mcgill.ecse.btms.model.*;

public class BtmsApplication {

  private static BTMS btms;

  private static int counter = 1;


  /**
   * Main entry point.
   *
   * @param args
   */
  public static void main(String[] args) {
    // Step 1
    // TODO
    printBtmsStatistics();

    // Step 2
    // TODO
    printBtmsStatistics();

    // Step 3
    // TODO
    printBtmsStatistics();

    // Step 4
    // TODO
    printBtmsStatistics();

    // Step 5
    // TODO
    printBtmsStatistics();

    // Step 6
    // TODO
    printBtmsStatistics();

    // Step 7
    // TODO
    printBtmsStatistics();

    // Step 8
    // TODO
    printBtmsStatistics();

    // Step 9
    // TODO
    printBtmsStatistics();

    // Step 10
    // TODO
    printBtmsStatistics();
  }

  public static int increaseCounter() {
    return counter++;
  }

  private static void printBtmsStatistics() {
    System.out.println("===== BTMS: Step " + increaseCounter() +" =====");
    if (btms == null) {
      System.err.println("BTMS is null!");
      return;
    }
    var stats = "Date: " + BtmsController.getTodayDate() + "\n"
        + "Number of buses: " + btms.getVehicles().size() + "\n"
        + "Number of routes: " + btms.getRoutes().size() + "\n"
        + "Number of drivers: " + btms.getDrivers().size() + "\n"
        + "Number of assignments: " + btms.getAssignments().size() + "\n"
        + "Number of schedules: " + btms.getSchedules().size() + "\n";
    for (var bus : btms.getVehicles()) {
      stats += "Bus: " + bus.getLicencePlate() + " (in repair: " + bus.getInRepairShop()
          + ") / #Assignments: " + bus.getRouteAssignments().size() + "\n";
    }
    for (var route : btms.getRoutes()) {
      stats += "Route: " + route.getNumber() + " / #Assignments: " + route.getRouteAssignments().size() + "\n";
    }
    for (var driver : btms.getDrivers()) {
      stats += "Driver: " + driver.getName() + " (sick: " + driver.getOnSickLeave()
          + ") / #Schedules: " + driver.getDriverSchedules().size() + "\n";
    }
    for (var assignment : btms.getAssignments()) {
      stats += "Assignment: " + assignment.getBus().getLicencePlate() + ", " + assignment.getRoute().getNumber()
          + ", Date: " + assignment.getDate() + " / #Schedules: " + assignment.getDriverSchedules().size() + "\n";
    }
    for (var schedule : btms.getSchedules()) {
      var asgn = schedule.getAssignment();
      stats += "Schedule: " + schedule.getDriver().getName() + ", " + asgn.getBus().getLicencePlate() + ", "
          + asgn.getRoute().getNumber() + ", Date: " + asgn.getDate() + " " + schedule.getShift().toString() + "\n";
    }
    var numEquals = 24;
    stats += "=".repeat(numEquals) + "\n";
    System.out.println(stats);
  }

  public static BTMS getBtms() {
    if (btms == null) {
      btms = new BTMS();
    }
    return btms;
  }


}
