package utils;

import io.restassured.RestAssured;

public class APIConstants {
    public static final String BaseURI = RestAssured.baseURI = "https://petstore.swagger.io/#/pet/addPet";
    public static final String GENERATE_TOKEN_URI = BaseURI+"/generateToken.php";
    public static final String kdjfk_URI = BaseURI+"/";

    public static final String Header_Key_Content_Type = "Content-Type";
    public static final String Header_Value_Content_Type = "application/json";
    public static final String Header_Key_Authorization = "Authorization";
}
