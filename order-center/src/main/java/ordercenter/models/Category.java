package ordercenter.models;

import common.models.utils.EntityClass;
import common.models.utils.OperableData;
import org.joda.time.DateTime;

/**
 * Created by lzadmin on 2016/4/12 0012.
 * category(分类表)表实体类
 */
public class Category implements EntityClass<Integer> ,OperableData {
    private  Integer id;
//    父编号，父编号与id相关联
    private  Integer pid;

    private  String name;
//    分类类型
    private CategoryType categoryType;
//    图片url地址
    private  String image;
//    创建时间
    private  DateTime create_time;
//    更新时间
    private  DateTime update_time;
//    排序0~255
    private  String sort;
//    get/set方法

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(DateTime create_time) {
        this.create_time = create_time;
    }

    public DateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(DateTime update_time) {
        this.update_time = update_time;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
//    构造函数

    public Category(Integer id, Integer pid, String name, CategoryType categoryType, String image, DateTime create_time, DateTime update_time, String sort) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.categoryType = categoryType;
        this.image = image;
        this.create_time = create_time;
        this.update_time = update_time;
        this.sort = sort;
    }

    public Category() {
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public void setCreateTime(DateTime createTime) {

    }

    @Override
    public DateTime getCreateTime() {
        return null;
    }

    @Override
    public void setUpdateTime(DateTime updateTime) {

    }

    @Override
    public DateTime getUpdateTime() {
        return null;
    }

    @Override
    public void setOperatorId(Integer operatorId) {

    }

    @Override
    public Integer getOperatorId() {
        return null;
    }
}
