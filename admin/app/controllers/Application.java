package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.index;

@org.springframework.stereotype.Controller
public class Application extends Controller {

    @Security.Authenticated(Secured.class)  //需要登录权限
    public Result index() {
        return ok(index.render());
    }

    public Result hello() {
        return ok(Json.toJson("hello"));
    }

//    public Result addBar() {
//        Form<Bar> form = Form.form(Bar.class).bindFromRequest();
//        Bar bar = form.get();
//        barService.addBar(bar);
//        return redirect(controllers.routes.Application.index());
//    }
//
//    public Result listBars() {
//        return ok(Json.toJson(barService.getAllBars()));
//    }

}