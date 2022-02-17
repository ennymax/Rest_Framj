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
import static pojo.Constant.Constant.GetIntent_EndPoint;
import static pojo.Constant.Constant.RefreshBranch_EndPoint;
import static utility.RestCalls.*;

public class Refresh extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to refresh 200")
    @Story("An Endpoint to refresh 200")
    public static void refresh_200() throws InterruptedException, IOException {
        Response response = GET_200(RefreshBranch_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to refresh 401")
    @Story("An Endpoint to refresh 401")
    public void refresh_401() throws InterruptedException, IOException {
        Response response = GET_401(GetIntent_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to refresh 403")
    @Story("An Endpoint to refresh 403")
    public void refresh_403() throws InterruptedException, IOException {
        Response response = GET_403(GetIntent_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
