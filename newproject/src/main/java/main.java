import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class main {
    static String userName="eve.holt@reqres.in";
    static String password ="citys5licka";
    static String baseUrl="https://reqres.in/apiapi/";
    static  String singleUserEndpoint="/users";
    static String loginEndpoint ="/login";



    public static void main(String[] args) {
        Response singleuserresponse= RestAssured.given().log().all().get(baseUrl+singleUserEndpoint+"/2");
        System.out.println(singleuserresponse.statusCode());
        singleuserresponse.prettyPrint();



    }
}
