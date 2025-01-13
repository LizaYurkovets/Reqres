package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.*;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserAPI {

    public static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static RequestSpecification spec =
            given()
                    .log().all()
                    .contentType(ContentType.JSON);

    public static CreateUserRs createUser(CreateUserRq createUserRq) {
        return
                given()
                        .spec(spec)
                        .body(gson.toJson(createUserRq))
                        .when()
                        .post("https://reqres.in/api/users")
                        .then()
                        .log().all()
                        .statusCode(201)
                        .extract()
                        .as(CreateUserRs.class);
    }

    public static void deleteUser(long id) {
        given()
                .spec(spec)
                .when()
                .delete("https://reqres.in/api/users/" + id)
                .then()
                .log().all()
                .statusCode(204);
    }

    public static UpdateUserRs updateUser(UpdateUserRq updateUserRq) {
        return
        given()
                .spec(spec)
                .body(gson.toJson(updateUserRq))
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(UpdateUserRs.class);
    }

    public static UpdateUserRs updateUserViaPatch(UpdateUserRq updateUserRq) {
        return
                given()
                        .spec(spec)
                        .body(gson.toJson(updateUserRq))
                        .when()
                        .patch("https://reqres.in/api/users/2")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(UpdateUserRs.class);

    }

    public static GetSingleUserRs getSingleUser(long id) {
        return
                given()
                        .spec(spec)
                        .when()
                        .get("https://reqres.in/api/users/" + id)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(GetSingleUserRs.class);
    }

}
