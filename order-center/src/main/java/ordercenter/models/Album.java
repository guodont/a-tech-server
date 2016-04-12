package ordercenter.models;

import common.models.utils.EntityClass;
import common.models.utils.OperableData;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lzadmin on 2016/4/12 0012.
 * album表实体类
 */
public class Album implements EntityClass<Integer> {
    //    专家相册表
    private Integer id;
    //    相册名
    private String name;
    //    照片路径
    private String path;
    //    用户（专家）id
    private Integer user_id;

    private DateTime create_time;
    //    照片描述
    private String description;

//    get、set方法


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="path")
    @Basic
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    @Column(name = "create_time")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(DateTime create_time) {
        this.create_time = create_time;
    }
    @Column(name="description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}