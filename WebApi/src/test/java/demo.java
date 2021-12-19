import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import POJOs.DeleteRequest;
import POJOs.GetMetadataRequest;
import POJOs.UploadRequest;
import utils.Specification;

import java.io.File;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class demo
{
    @Test
    public void test1(){
        /*Response resp = RestAssured
                .given()
                .auth()
                .oauth2("RKYg9Td9usIAAAAAAAAAAQCdzn2Bz8k3DdICt77cfZP_nyCBr_MoqlQYEHVtsUyk")
                .post("https://api.dropboxapi.com/2/files/get_metadata");*/





        //uploadData
        //File file = new File("/Skrypko.jpeg");

        //RequestSpecification uploadRequest = Specification.REQ_SPEC;

        /*UploadRequest upl = UploadRequest.builder().path("/Skrypko.jpeg").autorename(true).build();

        Response resp = RestAssured.given(uploadRequest)
                .when()
                .header("Dropbox-API-Arg", upl)
                .header("Content-Type","application/octet-stream")
                .body(file)
                .post("/upload");*/


        //getMetadata
        /*GetMetaDataRequest getm = GetMetaDataRequest.builder().path("/Skrypko.jpeg").build();
        Response resp = RestAssured.given(uploadRequest)
                .when()
                .header("Content-Type", "application/json")
                .body(getm)
                .post("/get_metadata");*/


        //Delete
        /*RequestSpecification deleteRequest = RestAssured.given();
        DeleteRequest del = DeleteRequest.builder().path("/Skrypko.jpeg").build();
        Response resp = RestAssured.given(uploadRequest)
                .when()
                .header("Content-Type", "application/json")
                .body(del)
                .post("/delete_v2");*/



       /* System.out.println(resp.getStatusCode());
        System.out.println(resp.getBody().asPrettyString());


        RequestSpecification req = RestAssured.given(uploadRequest);
        UploadRequest upl = UploadRequest.builder().path("/Skrypko.jpeg").autorename(true).build();
        uploadRequest.header("Dropbox-API-Arg", upl);
        uploadRequest.header("Content-Type", "application/octet-stream");
        uploadRequest.body(file);*/
    }

}
