package controllers.admin;

import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.test.*;
import controllers.test.routes;
import ordercenter.models.Admin;
import ordercenter.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.data.validation.Constraints;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.admin.login;

import java.util.List;

/**
 * 认证控制器
 * Created by guodont on 16/4/15.
 */
@org.springframework.stereotype.Controller
public class AuthenticationController extends Controller {

    @Autowired
    private AdminService adminService;

    /**
     * 登录页面
     * @return
     */
    public Result login() {
        return ok(login.render());
    }
    /**
     * 处理管理员登录
     * @return
     */
    public Result doLogin() {

        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(loginForm.errorsAsJson());
        }

        Login loggingInUser = loginForm.get();
        List<Admin> admins = adminService.findByEmailAdnPassword(loggingInUser.email, loggingInUser.password);
        if(admins.size()==0) {
            return badRequest(buildJsonResponse("error", "Incorrect email or password"));
        } else {
            session().clear();
            session("username", loggingInUser.email);

            ObjectNode wrapper = Json.newObject();
            ObjectNode msg = Json.newObject();
            msg.put("message", "Logged in successfully");
            msg.put("user", loggingInUser.email);
            wrapper.put("success", msg);
//            return ok(wrapper);

            return redirect(
                    routes.TestObjectController.list(null, null)
            );
        }
    }

    /**
     * 退出操作
     * @return
     */
    public Result logout() {
        session().clear();
        return ok(buildJsonResponse("success", "Logged out successfully"));
    }

    public static class Login {
        @Constraints.Required
        private String email;
        @Constraints.Required
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

    public static ObjectNode buildJsonResponse(String type, String message) {
        ObjectNode wrapper = Json.newObject();
        ObjectNode msg = Json.newObject();
        msg.put("message", message);
        wrapper.put(type, msg);
        return wrapper;
    }
}
