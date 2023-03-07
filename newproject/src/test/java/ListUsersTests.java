import ResponseModels.ListUsersResponse.ListUsersResponse;
import ResponseModels.ListUsersResponse.UserData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requests.Requests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUsersTests {

     String userName = "eve.holt@reqres.in";
     String password = "citys5licka";
     String baseUrl = "https://reqres.in/api";
     String singleUserEndpoint = "/users";
     String loginEndpoint = "/login";
     String listusers = "/users";
    String token;
    public  Requests req = new Requests();

    @BeforeClass
    public void loginsucess() {
        Response loginResponse = Requests.login(userName, password);
    }

    @Test
    public void listusersSuccess() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        Map<String, String> queryParam = new HashMap<>();
        queryParam.put("page", "2");


        Response listUsersResponse = RestAssured.given().log().all().headers(headers).queryParams(queryParam).contentType("application/json").get(baseUrl + listusers);

        ListUsersResponse listUsersResponse1 = listUsersResponse.as(ListUsersResponse.class);
        //JsonPath listUserPath =ListUsersResponse.jsonPath();

        String page = listUsersResponse1.page.toString();
        String perpage = listUsersResponse1.perPage.toString();
        String actual_total = listUsersResponse1.total.toString();
        int expected_total = Integer.parseInt(page) * Integer.parseInt(perpage);
        String expected_totals = Integer.toString(expected_total);
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actual_total, expected_totals, "incorrect total");
        softassert.assertAll();
    }

    @Test
    public void listsersCheckId() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        Map<String, String> queryParam = new HashMap<>();
        queryParam.put("page", "2");
        Response ListUsersResponse = RestAssured.given().log().all().headers(headers).queryParams(queryParam).get(baseUrl + listusers);

        Response listUsersResponse = RestAssured.given().log().all().headers(headers).queryParams(queryParam).contentType("application/json").get(baseUrl + listusers);
        ListUsersResponse listUsersResponse1 = listUsersResponse.as(ListUsersResponse.class);

        String page = listUsersResponse1.page.toString();
        String perpage = listUsersResponse1.perPage.toString();
        String actual_total = listUsersResponse1.total.toString();
    }
//        List<Object> data_list =listUserPath.getList("data");
//        Object first_id = data_list.get(0);
//    List<Map<String,String>> userData=listUserPath.getList("data");
//        System.out.println(userData.get(0).get("email")+" -----hellllllllllllo");


    @Test
    public void checkUserData() {

        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        Map<String, String> queryParam = new HashMap<>();
        queryParam.put("page", "2");
        Response listUsersResponse = Requests.listUsers();
        ListUsersResponse listUsersResponseModel = listUsersResponse.as(ListUsersResponse.class);
        System.out.println(listUsersResponseModel.data.get(0).id+"hiiiiiiiiiiiiiiiiiii");
        for (int i = 0; i < listUsersResponseModel.data.size(); i++) {

            Assert.assertNotNull(listUsersResponseModel.data.get(i).id);
        }
    }
}