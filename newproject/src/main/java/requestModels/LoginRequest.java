package requestModels;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.testng.annotations.Ignore;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email",
        "password",

})
@JsonIgnoreProperties(ignoreUnknown = true)//ely matla2ho4 matb3ato4
public class LoginRequest {

    @JsonProperty("email")
    public String email;
    @JsonProperty("password")
    public String password;

}