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
import static pojo.Constant.Constant.AcceptUserChat_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class Accept_User_Chat_Support extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Accept User Chat Support 200")
    @Story("An Endpoint to Accept User Chat Support 200")
    public void Accept_User_Chat_Support_200() throws InterruptedException, IOException {
        Response response = PUT_200(AcceptUserChat_EndPoint, generateStringFromResource("./src/main/java/Payload/AcceptUserChatPayload.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Service Updated Successfully");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Accept User Chat Support 401")
    @Story("An Endpoint to Accept User Chat Support 401")
    public void Accept_User_Chat_Support_401() throws InterruptedException, IOException {
        Response response = POST_401(AcceptUserChat_EndPoint, generateStringFromResource("./src/main/java/Payload/AcceptUserChatPayload.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Accept User Chat Support 403")
    @Story("An Endpoint to Accept User Chat Support 403")
    public void Accept_User_Chat_Support_403() throws InterruptedException, IOException {
        Response response = POST_403(AcceptUserChat_EndPoint, generateStringFromResource("./src/main/java/Payload/AcceptUserChatPayload.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Accept User Chat Support 404")
    @Story("An Endpoint to Accept User Chat Support 404")
    public void Accept_User_Chat_Support_404() throws InterruptedException, IOException {
        Response response = PUT_200(AcceptUserChat_EndPoint, generateStringFromResource("./src/main/java/Payload/AcceptUserChatPayload.json"));
        response.prettyPeek().then().spec(responseSpec_404);
    }
}
