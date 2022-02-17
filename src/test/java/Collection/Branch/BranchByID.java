package Collection.Branch;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.*;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class BranchByID extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Branch By ID 200")
    @Story("An Endpoint to get Branch By ID 200")
    public static void BranchByID_200() throws InterruptedException, IOException {
        Response response = GET_200(BranchByID_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Branch By ID 401")
    @Story("An Endpoint to get Branch By ID 401")
    public void BranchByID_401() throws InterruptedException, IOException {
        Response response = GET_401(BranchByID_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Branch By ID 403")
    @Story("An Endpoint to get Branch By ID 403")
    public void BranchByID_403() throws InterruptedException, IOException {
        Response response = GET_403(BranchByID_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
