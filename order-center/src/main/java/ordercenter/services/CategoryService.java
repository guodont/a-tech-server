package ordercenter.services;

import common.services.GeneralDao;
import common.utils.IdUtils;
import common.utils.page.Page;
import ordercenter.constants.CategoryType;
import ordercenter.models.Category;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by llz on 2016/4/15.
 */
@Service
public class CategoryService {
    @PersistenceContext
    EntityManager em;

    @Autowired
    GeneralDao generalDao;

    /**
     *
     * @param page
     * @param categoryType
     * @return
     */
    @Transactional(readOnly = true)
    public List<Category> findCategoryByType(Optional<Page<Category>> page, Optional<CategoryType> categoryType) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);
        Root<Category> categoryRoot = cq.from(Category.class);

        List<Predicate> predicateList = new ArrayList<>();
        cq.select(categoryRoot).where(predicateList.toArray(new Predicate[predicateList.size()])).orderBy(cb.desc(categoryRoot.get("updateTime")));
        TypedQuery<Category> query = em.createQuery(cq);

        if(page.isPresent()) {
            CriteriaQuery<Long> countCq = cb.createQuery(Long.class);
            countCq.select(cb.count(countCq.from(Category.class))).where(predicateList.toArray(new Predicate[predicateList.size()]));
            Long count = em.createQuery(countCq).getSingleResult();
            page.get().setTotalCount(count.intValue());

            query.setFirstResult(page.get().getStart());
            query.setMaxResults(page.get().getLimit());
        }

        if(categoryType.isPresent()) {
            predicateList.add(cb.equal(categoryRoot.get("type"), categoryType.get()));
        }

        List<Category> results = query.getResultList();
        if(page.isPresent()) {
            page.get().setResult(results);
        }
        return results;
    }

    /**
     * 保存分类
     * @param category
     */
    @Transactional
    public void saveCategory(Category category) {
        if(IdUtils.isEmpty(category.getId())) {
            //ID为空,新增
            category.setType(CategoryType.ARTICLE);
            generalDao.persist(category);
        } else {
            //修改
            generalDao.merge(category);
        }
    }

    /**
     * 删除分类
     * @param categoryId
     */
    @Transactional
    public boolean deleteCategory(Integer categoryId) {
        return (generalDao.removeById(Category.class, categoryId));
    }

    /**
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Category get(Integer id) {
        return generalDao.get(Category.class, id);
    }
}
