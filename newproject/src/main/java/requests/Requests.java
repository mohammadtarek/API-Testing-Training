package requests;

import helper.EndPoints;
import helper.Helper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import requestModels.CreateUserRequest;
import requestModels.LoginRequest;
import helper.PropertiesLoader;
import java.util.HashMap;
import java.util.Map;

public class Requests {
    static String userName="eve.holt@reqres.in";
    static String password ="citys5licka";
    static String baseUrl="https://reqres.in/api";
    static  String singleUserEndpoint="/users/2";
    static String loginEndpoint ="/login";
    static  String listusers="/users/2";
    static String createSingleUserEndpoint="/users/2";
   static String token ;
    public static Response login(String userNames, String passwords){

        LoginRequest loginRequest=new LoginRequest();
        loginRequest.email=userNames;
        loginRequest.password=passwords;
        //System.out.println(Helper.getObjectAsString(loginRequest)+"hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        Response loginresponse= RestAssured.given().log().all().contentType("application/json").body(Helper.getObjectAsString(loginRequest)).post( PropertiesLoader.readProperties("baseURL")+ EndPoints.loginEndPoint);
        return  loginresponse;

    }
    public static Response createSingleUser(String UserName,String job){
        CreateUserRequest createUserRequest=new CreateUserRequest();
        createUserRequest.job=job;
        createUserRequest.name=UserName;
        Response createSingleUserResponse=RestAssured.given().log().all().contentType("application/json").body(Helper.getObjectAsString(createUserRequest)).post(baseUrl+createSingleUserEndpoint);
        return  createSingleUserResponse;
    }
  public static Response listUsers() {
      Map<String, String> headers = new HashMap<>();
      headers.put("Authorization", token);
      Map<String, String> queryParam = new HashMap<>();
      queryParam.put("page", "2");
      Response usersResponse = RestAssured.given().log().all().headers(headers).queryParams(queryParam).
              contentType("application/json").get(baseUrl + listusers);

    return  usersResponse;

  }
  public static Response singleUser() {
      Response singleUser = RestAssured.given().log().all().contentType("application/json").get(baseUrl + singleUserEndpoint);
        return singleUser;
  }
}
