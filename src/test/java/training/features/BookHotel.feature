@run1
Feature: Book hotel Feature

  Background: user logs in
    Given a user is on the login page
    When a user enters the username and password and clicks login


  @BOOKING
  Scenario: Successful booking of a hotel
    And a user populates fields in the search page and clicks continue
    And a user selects a hotel from the selection page and click continue
    And a user populates the book with valid data and clicks confirm
    Then a order is generated and the booking is successful




  @DELETE
  Scenario: Delete an existing booking
    And Clicks on Booked Itinerary
    When enters order number   for a recently booked existing order and clicks on search
    And a user clicks on cancel selected
    And a user search the recently deleted order
    Then the orderNumber is not displayed









