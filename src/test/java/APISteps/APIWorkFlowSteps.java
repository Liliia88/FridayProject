package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayloadConstant;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIWorkFlowSteps {
    RequestSpecification request;
    Response response;

}
