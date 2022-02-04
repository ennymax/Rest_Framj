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
import static pojo.Constant.Constant.DetectIntent_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class DetectIntent extends TestBase {
/*
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Detect Intent 200")
    @Story("An Endpoint to Detect Intent 200")
    public void DetectIntent_200() throws InterruptedException, IOException {
        Response response = POST_200(DetectIntent_EndPoint, generateStringFromResource("./src/main/java/Payload/DetectIntent.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }


 */
    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Detect Intent 400")
    @Story("An Endpoint to Detect Intent 400")
    public void DetectIntent_400() throws InterruptedException, IOException {
        Response response = POST_200(DetectIntent_EndPoint, generateStringFromResource("./src/main/java/Payload/DetectIntent.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Detect Intent 401")
    @Story("An Endpoint to get Detect Intent 401")
    public void DetectIntent_401() throws InterruptedException, IOException {
        Response response = GET_401(DetectIntent_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Detect Intent 403")
    @Story("An Endpoint to Detect Intent 403")
    public void DetectIntent_403() throws InterruptedException, IOException {
        Response response = GET_403(DetectIntent_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
