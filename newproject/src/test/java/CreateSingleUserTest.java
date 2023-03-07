import ResponseModels.CreateUserResponse;
import ResponseModels.LoginErrorResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requests.Requests;

public class CreateSingleUserTest {
     String userName="morpheus";
     String job ="leader";


    @Test(priority = 2)
    public void createSingleUser(){
        userName="morpheus";
        job ="leader";
        SoftAssert softAssert =new SoftAssert();

        Response createuResponse =Requests.createSingleUser(userName,job);
        CreateUserResponse createSingleUserModel= createuResponse.as(CreateUserResponse.class);

        softAssert.assertEquals(createSingleUserModel.name,"morpheus");
        System.out.println(createSingleUserModel.name);
        System.out.println(createSingleUserModel.createdAt);
        System.out.println(createSingleUserModel.id);
        System.out.println(createSingleUserModel.job);
        softAssert.assertAll();
    }
}
