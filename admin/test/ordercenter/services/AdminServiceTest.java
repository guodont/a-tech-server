package ordercenter.services;

import base.BaseTest;
import ordercenter.constants.UserType;
import ordercenter.models.User;
import org.joda.time.DateTime;
import org.junit.Test;
import utils.Global;

import java.util.List;

/**
 * 测试adminService
 */
public class AdminServiceTest extends BaseTest {

    /**
     * 测试验证管理员用户名密码
     */
    @Test
    public void testAdminServiceFindByEmailAdnPassword() {
        AdminService adminService = Global.ctx.getBean(AdminService.class);
        doInTransactionWithGeneralDao(generalDao -> {
            assert adminService.findByEmailAdnPassword("admin@163.com","123456").size() == 1;
            return null;
        });
    }

}
