import io.restassured.builder.RequestSpecBuilder;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runners.MethodSorters;
import pojo.DeleteRequest;
import pojo.GetMetaDataRequest;
import pojo.UploadRequest;

import java.io.File;

import static io.restassured.config.EncoderConfig.encoderConfig;


@FixMethodOrder(MethodSorters.JVM)
public class TestApi
{
    File file = new File("src/test/resources/redon2.txt");
    RequestSpecification uploadRequest = new RequestSpecBuilder()
                                        .setConfig(RestAssured.config()
                                                .encoderConfig(encoderConfig()
                                                        .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                                        .setBaseUri("https://api.dropboxapi.com/2/files")
                                        .setAuth(RestAssured.oauth2("yt-_495Us0UAAAAAAAAAAZPb-R2W6dAy-ni_e-o-eVfi5i0IFHynEhVlMeJqXMGL"))
                                        .build();

    @Test
    public void uploadFileTest() {
        UploadRequest upl = UploadRequest.builder().path("/redon2.txt").autorename(true).build();
        Response UploadResp = RestAssured.given(uploadRequest)
                .when()
                .header("Dropbox-API-Arg", upl)
                .header("Content-Type", "application/octet-stream")
                .body(file)
                .post("/upload");

        System.out.println(UploadResp.getStatusCode());
        Assert.assertEquals(UploadResp.getStatusCode(), 200);
        System.out.println(UploadResp.getBody().prettyPrint());
    }
    @Test
    public void getMetaDataTest() {
        GetMetaDataRequest getm = GetMetaDataRequest.builder().path("/redon2.txt").build();
        Response GetMetaDataResp = RestAssured.given(uploadRequest)
                .when()
                .header("Content-Type", "application/json")
                .body(getm)
                .post("/get_metadata");

        System.out.println(GetMetaDataResp.getStatusCode());
        Assert.assertEquals(GetMetaDataResp.getStatusCode(), 200);
        System.out.println(GetMetaDataResp.getBody().prettyPrint());
    }
    @Test
    public void DeleteRequestTest(){
        RequestSpecification deleteRequest = RestAssured.given();
        DeleteRequest del = DeleteRequest.builder().path("/redon2.txt").build();
        Response DeleteResp = RestAssured.given(uploadRequest)
                .when()
                .header("Content-Type", "application/json")
                .body(del)
                .post("/delete_v2");

        System.out.println(DeleteResp.getStatusCode());
        Assert.assertEquals(DeleteResp.getStatusCode(), 200);
        System.out.println(DeleteResp.getBody().prettyPrint());

    }

}