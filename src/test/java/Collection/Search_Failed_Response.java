package Collection;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

import static pojo.Constant.Constant.SearchFailedResponse_EndPoint;
import static pojo.Constant.Constant.SearchServices_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class Search_Failed_Response extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search_Failed_Response 200")
    @Story("An Endpoint to Search_Failed_Response 200")
    public void Search_Failed_Response_200() throws InterruptedException, IOException {
        Response response = GET_200(SearchFailedResponse_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search_Failed_Response 401")
    @Story("An Endpoint to Search_Failed_Response 401")
    public void Search_Failed_Response_401() throws InterruptedException, IOException {
        Response response = GET_401(SearchFailedResponse_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search_Failed_Response 403")
    @Story("An Endpoint to Search_Failed_Response 403")
    public void Search_Failed_Response_403() throws InterruptedException, IOException {
        Response response = GET_403(SearchFailedResponse_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
