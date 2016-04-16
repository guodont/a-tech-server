package ordercenter.services;

import base.BaseTest;
import common.services.GeneralDao;
import ordercenter.constants.CategoryType;
import ordercenter.models.Category;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Administrator on 2016/4/15.
 */
@Service
public class CategoryServiceTest extends BaseTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    GeneralDao generalDao;

    Category initCategory(int i) {
        Category category = new Category();
        category.setPid(i);
        category.setName("image/avatar.png");
        category.setType(CategoryType.ARTICLE);
        category.setName("LLZ");
        category.setImage("image/avatar.png");
        category.setCreateTime(new DateTime());
        category.setUpdateTime(new DateTime());
        return category;
    }

    void prepareCategory(int size) {
        doInTransaction(em -> {
            em.createQuery("delete from Category").executeUpdate();
            for (int i = 0; i < size; i++) {
                Category category = initCategory(i);
                em.persist(category);
            }
            return null;
        });
    }


    /**
     * 测试查询全部数据
     */
    @Test
    public void testCategoryServiceFindAll() {

        prepareCategory(10);

        doInTransactionWithGeneralDao(generalDao -> {

            List<Category> categories = generalDao.findAll(Category.class);
            assert categories.size() == 10;
            return null;
        });
    }

    /**
     * 测试查找一条数据
     */
    @Test
    public void findOne(){
        final Integer[] id = new Integer[1];
        doInTransaction(em -> {
            Category category = initCategory(1);
            em.persist(category);
            id[0] = category.getId();
            return null;
        });

        doInTransactionWithGeneralDao(generalDao ->{
            Category category2 = generalDao.get(Category.class, id[0]);
            assert category2 != null;
            return null;
        });

    }


}
