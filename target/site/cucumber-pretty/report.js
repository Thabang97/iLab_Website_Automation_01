$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/training/features/BookHotel.feature");
formatter.feature({
  "line": 2,
  "name": "Book hotel Feature",
  "description": "",
  "id": "book-hotel-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@run1"
    }
  ]
});
formatter.before({
  "duration": 20043661000,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "user logs in",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "a user is on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a user enters the username and password and clicks login",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.a_user_is_on_the_login_page()"
});
formatter.result({
  "duration": 79697600,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_user_enters_the_and_and_clicks_login()"
});
formatter.result({
  "duration": 5309243600,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Successful booking of a hotel",
  "description": "",
  "id": "book-hotel-feature;successful-booking-of-a-hotel",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@BOOKING"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "a user populates fields in the search page and clicks continue",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "a user selects a hotel from the selection page and click continue",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "a user populates the book with valid data and clicks confirm",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "a order is generated and the booking is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.a_user_populates_fields_in_the_search_page_and_clicks_continue()"
});
formatter.result({
  "duration": 42274483400,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_user_selects_a_hotel_from_the_selection_page_and_click_continue()"
});
formatter.result({
  "duration": 3779993700,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_user_populates_the_book_with_valid_data_and_clicks_confirm()"
});
formatter.result({
  "duration": 6430278100,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_order_is_generated_and_the_booking_is_successful()"
});
formatter.result({
  "duration": 22479800,
  "status": "passed"
});
formatter.after({
  "duration": 3825255400,
  "status": "passed"
});
formatter.before({
  "duration": 9127938500,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "user logs in",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "a user is on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a user enters the username and password and clicks login",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.a_user_is_on_the_login_page()"
});
formatter.result({
  "duration": 44100,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_user_enters_the_and_and_clicks_login()"
});
formatter.result({
  "duration": 5236190700,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Delete an existing booking",
  "description": "",
  "id": "book-hotel-feature;delete-an-existing-booking",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@DELETE"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "Clicks on Booked Itinerary",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "enters order number   for a recently booked existing order and clicks on search",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "a user clicks on cancel selected",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "a user search the recently deleted order",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "the orderNumber is not displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.clicks_on_Booked_Itinerary()"
});
formatter.result({
  "duration": 3559833900,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.entersOrderNumberForARecentlyBookedExistingOrderAndClicksOnSearch()"
});
formatter.result({
  "duration": 1432617100,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.aUserClicksOnCancelSelected()"
});
formatter.result({
  "duration": 3178210600,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.aUserSearchTheRecentlyDeletedOrder()"
});
formatter.result({
  "duration": 5677410500,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.theOrderNumberIsNotDisplayed()"
});
formatter.result({
  "duration": 18394200,
  "status": "passed"
});
formatter.after({
  "duration": 3859616200,
  "status": "passed"
});
});