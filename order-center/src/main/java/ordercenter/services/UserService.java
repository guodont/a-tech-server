package ordercenter.services;

import common.services.GeneralDao;
import common.utils.IdUtils;
import common.utils.page.Page;
import ordercenter.constants.UserType;
import ordercenter.models.TestObject;
import ordercenter.models.TestObjectItem;
import ordercenter.models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by guodont on 2016/4/12.
 */
@Service
public class UserService {
    @PersistenceContext
    EntityManager em;

    @Autowired
    GeneralDao generalDao;

    /**
     * 根据用户类型查找用户
     * @param page
     * @param userType
     * @return
     */
    @Transactional(readOnly = true)
    public List<User> findUserByType(Optional<Page<User>> page, Optional<UserType> userType) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);

        List<Predicate> predicateList = new ArrayList<>();

        cq.select(userRoot).where(predicateList.toArray(new Predicate[predicateList.size()])).orderBy(cb.desc(userRoot.get("updateTime")));

        TypedQuery<User> query = em.createQuery(cq);

        if(page.isPresent()) {
            CriteriaQuery<Long> countCq = cb.createQuery(Long.class);
            countCq.select(cb.count(countCq.from(User.class))).where(predicateList.toArray(new Predicate[predicateList.size()]));
            Long count = em.createQuery(countCq).getSingleResult();
            page.get().setTotalCount(count.intValue());

            query.setFirstResult(page.get().getStart());
            query.setMaxResults(page.get().getLimit());
        }

        List<User> results = query.getResultList();

        if(page.isPresent()) {
            page.get().setResult(results);
        }

        return results;
    }

    @Transactional
    public void saveUser(User user) {
        if(IdUtils.isEmpty(user.getId())) {
            //ID为空,新增
            user.setUserType(UserType.PUBLIC);
            generalDao.persist(user);

        } else {
            //修改
            generalDao.merge(user);
        }
    }

    @Transactional(readOnly = true)
    public User get(Integer id) {
        return generalDao.get(User.class, id);
    }
}
