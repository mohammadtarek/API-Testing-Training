import ResponseModels.singleUserResponseModel.SingleUserResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import requests.Requests;

public class SingleUserTest {
     String baseUrl="https://reqres.in/api";
      String singleUserEndpoint="/users/2";
    @Test
    public void test_valid_username_and_password(){
        Response singleUserResponse=Requests.singleUser();
        SingleUserResponse singleUserResponseModel =singleUserResponse.as(SingleUserResponse.class);
        Assert.assertNotNull(singleUserResponseModel.data.id);
    }
}
