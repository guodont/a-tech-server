package ordercenter.services;

import common.services.GeneralDao;
import common.utils.Md5EncryptUtils;
import ordercenter.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guodont on 16/4/15.
 */
@Service
public class AdminService {
    @PersistenceContext
    EntityManager em;

    @Autowired
    GeneralDao generalDao;

    @Transactional(readOnly = true)
    public List<Admin> findByEmailAdnPassword(String email, String password) {
        String jpql = "select o from Admin o where 1=1 ";
        Map<String, Object> queryParams = new HashMap<>();
        jpql += " and o.email = :email ";
        queryParams.put("email",email);
        jpql += " and o.password = :password ";
        queryParams.put("password",Md5EncryptUtils.md5(password));
        return generalDao.queryByJPQl(jpql , queryParams);
    }
}
