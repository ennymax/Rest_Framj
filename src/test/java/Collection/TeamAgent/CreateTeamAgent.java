package Collection.TeamAgent;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

import static pojo.Constant.Constant.CreateTeamAgent_EndPoint;
import static pojo.Constant.Constant.Create_KB_Dialogue_Flow_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class CreateTeamAgent extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Team Agent")
    @Story("An Endpoint to Create Team Agent")
    public void CreateTeamAgent_200() throws InterruptedException, IOException {
        Response response = POST_200(CreateTeamAgent_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateTeamAgent.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Team Agent 401")
    @Story("An Endpoint to Create Team Agent 401")
    public void CreateTeamAgent_401() throws InterruptedException, IOException {
        Response response = POST_401(Create_KB_Dialogue_Flow_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateTeamAgent.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Team Agent 403")
    @Story("An Endpoint to Create TeamA gent 403")
    public void CreateTeamAgent_403() throws InterruptedException, IOException {
        Response response = POST_403(Create_KB_Dialogue_Flow_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateTeamAgent.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
