package WhenAndThen;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import POJOs.DeleteRequest;
import POJOs.GetMetadataRequest;
import POJOs.UploadRequest;
import utils.Specification;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;

public class APiTestSteps {
    RequestSpecification uploadRequest = Specification.REQ_SPEC;
    File file = new File("src/test/resources/Skrypko.jpg");
    int statusCode;
    RequestSpecification req;

    @Given("request specification is set")
    public void RequestSpecificationIsSet() {
        req = RestAssured.given(uploadRequest);
    }

    @When("HEADER Dropbox-API-Arg is set")
    public void hEADERDropboxAPIArgIsSet() {
        UploadRequest upload = UploadRequest.builder().path("/Skrypko.jpg").autorename(true).build();
        req.header("Dropbox-API-Arg", upload);
    }

    @And("HEADER parameter request content type is set asa {string}")
    public void hEADERParameterRequestContentTypeIsSetAsa(String contentType) {
        req.header("Content-Type", contentType);
    }

    @And("request body parameters is set for uploading")
    public void requestBodyParametersIsSetForUploading() {
        req.body(file);

    }

    @And("POST HTTP request upload is sent")
    public void pOSTHTTPRequestUploadIsSent() {
        Response response = req.post("/upload");
        statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.println(response.getBody().asPrettyString());
    }

    @Then("valid HTTP response code is received as {int}")
    public void validHTTPResponseCodeIsReceivedAs(int responseCode) {
        Assert.assertEquals(responseCode, statusCode);
    }


    @When("HEADER parameter request content type is set as {string}")
    public void hEADERParameterRequestContentTypeIsSetAs2(String contentType) {
        req.header("Content-Type", contentType);
    }

    @And("request body parameters is set for getting metadata")
    public void requestBodyParametersIsSetForGettingMetadata() {
        GetMetadataRequest getMetadata = GetMetadataRequest.builder().path("/Skrypko.jpg").build();
        req.body(getMetadata);
    }

    @And("POST HTTP request get_metadata is sent")
    public void POSTHTTPRequestGet_metadataIsSent() {
        Response response = req.post("/get_metadata");
        statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.println(response.getBody().asPrettyString());
    }


    @And("request body parameters is set for deleting file")
    public void requestBodyParametersIsSetForDeletingFile() {
        DeleteRequest delete = DeleteRequest.builder().path("/Skrypko.jpg").build();
        req.body(delete);
    }

    @Then("POST HTTP request delete is sent")
    public void pOSTHTTPRequestDeleteIsSent() {
        Response response = req.post("/delete_v2");
        statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.println(response.getBody().asPrettyString());
    }

}
