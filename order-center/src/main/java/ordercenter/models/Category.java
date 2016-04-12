package ordercenter.models;

import ordercenter.constants.CategoryType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by llz on 2016/4/12.
 */
public class Category {
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
    private DateTime update_time;
    /**
     * 分类表排序
     */
    private Integer sort;

    @Column(name = "id")
    @Basic
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

    @Column(name = "register_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "register_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(DateTime update_time) {
        this.update_time = update_time;
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
