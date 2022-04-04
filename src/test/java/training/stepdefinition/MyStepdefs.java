package training.stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import training.PageObjects.WebFunctions;
import training.WebUtilities.webUtilities;
import training.data.data;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyStepdefs {

    webUtilities web = new webUtilities();
    WebFunctions adactin = new WebFunctions();
    public training.data.data data =new data();
    ResultSet rs;
    ResultSet rs2;

    @Before
    public void settingUp() throws InterruptedException {



        web.setWebDriver(web.initializeWebDriver("chrome"));
        web.navigate("http://adactinhotelapp.com");
    }

    @Given("^a user is on the login page$")
    public void a_user_is_on_the_login_page() {

        System.out.println("A user is on the login page");
    }


    @When("^a user enters the username and password and clicks login$")
    public void a_user_enters_the_and_and_clicks_login() throws Exception {
        try {
            rs = data.ConnectAndQuerySQL("jdbc:mysql://localhost:3306/adactinLog",
                    "root", "201618509", "Select * from userD");
            int iRow = data.rowCount(rs);
            for (int i = 1; i <= iRow; i++) {
                if (rs.next()) {

                    adactin.Login(web.getWebDriver(), rs);
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("^a user populates fields in the search page and clicks continue$")
    public void a_user_populates_fields_in_the_search_page_and_clicks_continue() throws Exception {
        try {
            rs2 = data.ConnectAndQuerySQL("jdbc:mysql://localhost:3306/hotel",
                    "root", "201618509", "Select * from booking");
            int iRow = data.rowCount(rs2);
            for (int i = 1; i <= iRow; i++) {
                if (rs2.next()) {
                    adactin.search(web.getWebDriver(), rs2);
                }
            }
        }catch(Exception e){
        }
    }






    @And("^a user selects a hotel from the selection page and click continue$")
    public void a_user_selects_a_hotel_from_the_selection_page_and_click_continue() {
        adactin.sel_Hotel(web.getWebDriver());

    }

    @When("^a user populates the book with valid data and clicks confirm$")
    public void a_user_populates_the_book_with_valid_data_and_clicks_confirm() throws IOException, SQLException {
        try{
            adactin.Book_hotel(web.getWebDriver(), rs2);

        }
        catch (Exception e) {
        }
    }


    @Then("^a order is generated and the booking is successful$")

    public void a_order_is_generated_and_the_booking_is_successful() throws IOException {
        adactin.orderNumGenerated(web.getWebDriver());

    }


    @And("^Clicks on Booked Itinerary$")
    public void clicks_on_Booked_Itinerary()  {
        adactin.BookedItinerary(web.getWebDriver());

    }

    @When("^enters order number   for a recently booked existing order and clicks on search$")
    public void entersOrderNumberForARecentlyBookedExistingOrderAndClicksOnSearch() throws IOException {
        adactin.SearchOrderNumber(web.getWebDriver());
    }

    @And("^a user clicks on cancel selected$")
    public void aUserClicksOnCancelSelected() {

        adactin.deleteSearched(web.getWebDriver());
    }

    @And("^a user search the recently deleted order$")
    public void aUserSearchTheRecentlyDeletedOrder() throws IOException {
        adactin.SearchOrderNumber(web.getWebDriver());
    }

    @Then("^the orderNumber is not displayed$")
    public void theOrderNumberIsNotDisplayed() {
        adactin.confirmDelete(web.getWebDriver());
    }


    @After
    public void teardown() throws InterruptedException {

        try {

            adactin.logout(web.getWebDriver());
            rs.close();
            rs2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Thread.sleep(2000);
            web.getWebDriver().quit();

        }

    }




}
