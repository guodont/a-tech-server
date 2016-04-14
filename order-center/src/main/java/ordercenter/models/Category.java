package ordercenter.models;

import common.models.utils.EntityClass;
import ordercenter.constants.CategoryType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by llz on 2016/4/12.
 */
@Table(name = "category")
@Entity
public class Category implements EntityClass<Integer> {
    /**
     * 分类表ID
     */
    private Integer id;
    /**
     * 分类表父编号
     */
    private Integer pid;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类表类型
     */
    private CategoryType categoryType;
    /**
     * 分类表图片
     */
    private String image;
    /**
     * 分类添加时间
     */
    private DateTime createTime;
    /**
     * 分类更新时间
     */
    private DateTime updateTime;
    /**
     * 分类表排序
     */
    private Integer sort;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "pid")
    @Basic
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    public CategoryType getType() {
        return categoryType;
    }

    public void setType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Column(name = "image")
    @Basic
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "create_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "sort")
    @Basic
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
