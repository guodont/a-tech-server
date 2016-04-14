package ordercenter.services;

import base.BaseTest;
import ordercenter.constants.UserType;
import ordercenter.models.User;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.List;

/**
 * 测试 UserService
 * <p>
 * Created by guodont on 16/4/13.
 */
public class UserServiceTest extends BaseTest {

    /**
     * 初始化model数据
     *
     * @return
     */
    User initUser(int i) {
        User user = new User();
        user.setAddress("山西农业大学" + i);
        user.setAvatar("image/avatar.png");
        user.setEmail("test" + i + "@qq.com");
        user.setName("user" + i);
        user.setPassword("123");
        user.setPhone("18900000099");
        user.setRealName("real_name" + i);
        user.setUserType(UserType.PUBLIC);
        user.setLastLoginTime(new DateTime());
        user.setRegisterTime(new DateTime());
        return user;
    }


    void prepareUser(int size) {
        doInTransaction(em -> {
            em.createQuery("delete from User").executeUpdate();
            for (int i = 0; i < size; i++) {
                User user = initUser(i);
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
