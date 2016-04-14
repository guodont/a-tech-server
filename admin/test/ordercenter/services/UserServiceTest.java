package ordercenter.services;

import base.BaseTest;
import ordercenter.constants.UserType;
import ordercenter.models.User;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.List;

/**
 *
 * 测试 UserService
 *
 * Created by guodont on 16/4/13.
 */
public class UserServiceTest extends BaseTest {

    User initUser() {
        User user = new User();
        user.setAddress("山西农业大学");
        user.setAvatar("image/avatar.png");
        user.setEmail("test@qq.com");
        user.setName("user01");
        user.setPassword("123");
        user.setPhone("18900009999");
        user.setRealName("real");
        user.setUserType(UserType.PUBLIC);
        user.setLastLoginTime(new DateTime());
        user.setRegisterTime(new DateTime());
        return user;
    }

    void prepareUser(int size) {
        doInTransaction(em -> {
            em.createQuery("delete from User").executeUpdate();
            //创建订单
            for (int i = 0; i < size; i++) {
                User user = initUser();
                em.persist(user);
            }
            return null;
        });
    }

    @Test
    public void testUserServiceFindAll() {

        prepareUser(10);

        doInTransactionWithGeneralDao(generalDao -> {

            List<User> testObjects = generalDao.findAll(User.class);
            assert testObjects.size() == 10;
            return null;

        });
    }

}
