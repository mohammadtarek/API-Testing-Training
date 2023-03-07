import ResponseModels.LoginErrorResponse;
import ResponseModels.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requests.Requests;
import helper.PropertiesLoader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginTest {
     String userName="eve.holt@reqres.in";
     String password ="citys5licka";
     String baseUrl="https://reqres.in/api";
      String singleUserEndpoint="/users";
     String token;

    @Test (priority = 2)
    public void loginRequest(){
         userName="eve.holt@reqres.in";
         password ="citys5licka";
        SoftAssert softAssert =new SoftAssert();
        Response loginResponse =Requests.login(userName,password);
        //LoginResponse loginResponsemodel =loginResponse.as(LoginResponse.class);
        softAssert.assertEquals(loginResponse.statusCode(),200,"status code is not as expected");
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public  void checkEmptyEmail(){
        SoftAssert softAssert =new SoftAssert();
        userName="";
        String password ="citys5licka";
        Response loginResponse =Requests.login(userName,password);
        LoginErrorResponse loginResponse1 =loginResponse.as(LoginErrorResponse.class);
        softAssert.assertEquals(loginResponse1.error,"Missing email or username","empty mail");
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public  void checkEmptymailandpassword(){
        SoftAssert softassert =new SoftAssert();
        userName="eve.holt@reqres.in";
        password="";
        Response loginErrorResponse =Requests.login(userName,password);
        //JsonPath loginJsonPath =loginResponse.jsonPath();
        LoginErrorResponse loginerrorResponseModel =loginErrorResponse.as(LoginErrorResponse.class);
        softassert.assertEquals(loginerrorResponseModel.error,"Missing password","check on password valid mail & empty password falied");
        softassert.assertAll();
    }

    @Test
    public void wrongemail(){
        userName="eve.holt@reqres.in";
        password ="citys5licka";

        Response loginResponse =Requests.login(userName,password);
        LoginResponse loginErrorResponse =loginResponse.as(LoginResponse.class);
        SoftAssert softassert =new SoftAssert();
        softassert.assertNotNull(loginErrorResponse.token);
        softassert.assertAll();


    }
}
