package training.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import training.WebUtilities.WebActions;
import training.webPageObjects.*;

import java.io.*;
import java.sql.ResultSet;
import java.time.Duration;

public class WebFunctions extends WebActions {

    public void Login(WebDriver driver, ResultSet rs)  {
        loginAdactin log = new loginAdactin(driver);
        // String filename = repo.CaptureScreenShot(driver);

        try {
            //  String username = PropertiesManager.prop.username);
            // String password = PropertiesManager.getProperty(prop.username);
            passData(log.txtUsernme, driver ,rs.getString("username"));

            passData(log.txtPassword, driver ,rs.getString("password") );

            clickObject(log.btnLogin,driver);

            if(!driver.getCurrentUrl().contains("SearchHotel")){
                System.out.println("Invalid Login details or Your Password might have expired.");
            }
            else {
                System.out.println("Logged In Successfully.");
            }

        }catch (Exception e) {
            System.out.println("Login unsuccessful,Errors"+e.getMessage());
            Assert.fail();
        }
    }

    public  void search (WebDriver driver, ResultSet rs2){
        searchHotel search = new searchHotel(driver);

        // filename = repo.CaptureScreenShot(driver);


        try {

            Thread.sleep(2000);
            selectObject(search.location,driver ,"selectByVisibleText",rs2.getString("Location"));// rs2.getString("RoomType"), rs2.getString("NumberOfRooms"), rs2.getString("CheckInDate"),rs2.getString("CheckOutDate") ,rs2.getString("AdultsPerRoom"),rs2.getString("AdultsPerRoom"));location);
            selectObject(search.hotels, driver,"selectByVisibleText",rs2.getString("Hotels"));
            selectObject(search.room_type,driver, "selectByVisibleText",rs2.getString("RoomType"));
            selectObject(search.room_no, driver,"selectByVisibleText", rs2.getString("NumberOfRooms"));
            passData(search.check_in_date, driver ,rs2.getString("CheckInDate"));
            passData(search.check_out_date, driver , rs2.getString("CheckOutDate"));
            selectObject(search.adults, driver, "selectByVisibleText",rs2.getString("AdultsPerRoom"));
            selectObject(search.children, driver, "selectByVisibleText",rs2.getString("ChildrenPerRoom"));
            clickObject(search.submit,driver);
            Thread.sleep(2000);
            if(driver.getCurrentUrl().contains("SelectHotel")){
                System.out.println("Searched Successfully.");
            }
            else {
                System.out.println("invalid search details.");
            }

        } catch (Exception e) {
            // test.fail("search was unsuccessful");
            System.out.println("search was unsuccessful,Errors" + e.getMessage());
            //  Assert.fail();
        }
    }


    public  void sel_Hotel(WebDriver driver) {
        selectHotel selectObj = new selectHotel(driver);
        try{
            Thread.sleep(2000);
            clickObject(selectObj.radioButton,driver);
            clickObject(selectObj.contin,driver);
            if(driver.getCurrentUrl().contains("BookHotel")){
                System.out.println("successful hotel search details.");
            }
            else {
                System.out.println("Selected Successfully.");
            }
        } catch (Exception e) {
            System.out.println("select hotel was unsuccessful,Errors" + e.getMessage());
            // Assert.fail();
        }
    }

    public  void Book_hotel (WebDriver driver,ResultSet rs) throws IOException {
        bookHotel bookHotel = new bookHotel(driver);
        bookingConfirmation bookcon = new bookingConfirmation(driver);

        //filename = repo.CaptureScreenShot(driver);
        try {


            passData(bookHotel.firstname, driver, rs.getString("FirstName"));
            passData(bookHotel.surname, driver,rs.getString("LastName"));
            passData(bookHotel.billing, driver,rs.getString( "BillingAddress"));

            passData(bookHotel.account, driver,rs.getString("CreditCardNumber"));
            selectObject(bookHotel.account_type, driver, "selectByVisibleText",rs.getString("CreditCardType"));
            selectObject(bookHotel.month, driver, "selectByVisibleText",rs.getString( "ExpiryDateMonth"));
            selectObject(bookHotel.year, driver, "selectByVisibleText",rs.getString("ExpiryDateYear"));


            passData(bookHotel.cvv, driver,rs.getString("CVVNumber"));

            clickObject(bookHotel.bookNowButton, driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(bookcon.OrderNumber));


            String order = bookcon.OrderNumber.getAttribute("value");
            //WebElement search =bookHotel.search;
            if (bookcon.OrderNumber.isDisplayed()) {
                System.out.println("Booking successful..Order number : "+order);// + order, MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            } else
                System.out.println("Booking unsuccessful");// MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());


        } catch (Exception e) {
            System.out.println(" book unsuccessfully booked,Errors" + e.getMessage());
        }
    }

    public void orderNumGenerated(WebDriver driver) throws IOException {
        bookingConfirmation book = new bookingConfirmation(driver);
        String OrderNum = book.OrderNumber.getAttribute("value");
        if(book.OrderNumber.isDisplayed()){
            System.out.println("Hotel was booked successful,OrderNumber:\" "+ OrderNum);
        }else {
            System.out.println("Order NUmber was not generated");
            Assert.fail("Order NUmber was not generated");
        }

        String order = OrderNum;
        FileOutputStream fos = new FileOutputStream("src/main/resources/orderNumber.txt");
        DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
        outStream.writeUTF(order);
        outStream.close();

    }

    public void BookedItinerary(WebDriver driver){
        itinerary item = new itinerary(driver);

        item.bookedItinerary.click();
    }

    public void SearchOrderNumber(WebDriver driver) throws IOException {
        searchOrder search = new searchOrder(driver);
        String result;
        FileInputStream fis = new FileInputStream("src/main/resources/orderNumber.txt");
        DataInputStream reader = new DataInputStream(fis);
        result = reader.readUTF();
        // System.out.println(result);
        reader.close();
        //assertEquals(OrderNum, result);
        String arg1=result;

        passData(search.txtOrderID,driver, arg1);
        clickObject(search.btnSearchOrder,driver);
    }

    public void deleteSearched(WebDriver driver){

        searchOrder cancel = new searchOrder(driver);

        try{

            clickObject(cancel.btnRadio,driver);
            clickObject(cancel.btnDelete,driver);

            Thread.sleep(3000);
            driver.switchTo().alert().accept();

        }catch (Exception e){
            e.printStackTrace();
        }


    }






    public void confirmDelete(WebDriver driver) {

        deleteConfirm delete= new deleteConfirm(driver);

        try {
            if (delete.DeleteConfirmation.isDisplayed()) {
                System.out.println(" successfully deleted the booking");
            } else {
                System.out.println("booking was not successfully deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void logout (WebDriver driver)  {
        logOut logout = new logOut(driver);
        //filename = repo.CaptureScreenShot(driver);

        try {
            clickObject(logout.logout,driver);

//



        } catch (Exception e) {
            System.out.println("unsuccessfully logged out,Errors" + e.getMessage());
            Assert.fail();
        }
        clickObject(logout.click,driver);
    }

    public void logoutSuccessful(WebDriver driver){
        logOut logout = new logOut(driver);
        if(logout.click.isDisplayed()){
            System.out.println("Logout was Successful");
        }else{
            System.out.println("Logout was Unsuccessful");
            Assert.fail("Logout was Unsuccessful");
        }
    }



}
