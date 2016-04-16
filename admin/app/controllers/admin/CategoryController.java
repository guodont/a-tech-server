package controllers.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Joiner;
import common.utils.IdUtils;
import common.utils.JsonUtils;
import common.utils.page.PageFactory;
import common.utils.play.PlayForm;
import controllers.Secured;
import ordercenter.constants.CategoryType;
import ordercenter.models.Category;
import ordercenter.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.mvc.Result;
import play.mvc.Security;
import views.html.admin.category.*;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

/**
 * Created by llz on 2016/4/15.
 */

@Security.Authenticated(Secured.class)
@org.springframework.stereotype.Controller
public class CategoryController extends BaseAdminController {
    @Autowired
    private CategoryService categoryService;

    public Result list(String type) {

        List<Category> categoryList = categoryService.findCategoryByType(of(PageFactory.getPage(request())),
                ofNullable(type).map(CategoryType::valueOf));
        return ok(list.render(categoryList));
    }

    public Result addPage() {
        return ok(add.render(Form.form(Category.class)));
    }

    public Result updatePage(Integer id) {
        return ok(update.render(Form.form(Category.class).fill(categoryService.get(id))));
    }

    public Result saveCategory() {

        Form<Category> form = PlayForm.form(Category.class).bindFromRequest();
        Category category = form.get();
        if(form.hasErrors()) {
            if(form.globalError() != null) {
                System.out.println("global error: " + form.globalError().message());
            }

            form.errors().forEach((k, v) -> System.out.println(
                    String.format("error key: %s, error value: %s", k,
                    Joiner.on("").join(v.stream().map(x -> x.toString()).collect(Collectors.toList())))));

            System.out.println(category == null);
            System.out.println(category.getName());

            return ok(add.render(form));
        } else {
            System.out.println(category.getPid());
            System.out.println(category.getName());
            System.out.println(category.getType());
            System.out.println(category.getImage());

            if(IdUtils.isEmpty(category.getId())) {
                categoryService.saveCategory(category);
            } else {
                //拷贝修改的数据
                Category testcategory = categoryService.get(category.getId());
                testcategory.setPid(category.getPid());
                testcategory.setName(category.getName());
                testcategory.setType(category.getType());
                testcategory.setImage(category.getImage());
                categoryService.saveCategory(testcategory);
            }
            return redirect(routes.CategoryController.list(null));
        }
    }

    public Result deleteCategory(Integer id){
        if(categoryService.deleteCategory(id))
            return redirect(routes.CategoryController.list(null));
        else
            return redirect(routes.CategoryController.list(null));
    }

    public Result viewByJson(Integer categoryId) throws JsonProcessingException {
        Category category = categoryService.get(categoryId);
        return ok(JsonUtils.object2Node(category));

    }

}