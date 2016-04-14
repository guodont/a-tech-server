package ordercenter.models;

import common.models.utils.EntityClass;
import ordercenter.constants.Position;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import javax.persistence.*;

/**
 * Created by llz on 2016/4/13.
 */
@Table(name = "advertisement")
@Entity
public class Advertisement implements EntityClass<Integer> {
    /**
     * 广告ID
     */
    private Integer id;
    /**
     *广告名称
     */
    private String name;
    /**
     *广告描述
     */
    private String description;
    /**
     *广告链接
     */
    private String url;
    /**
     *广告图片
     */
    private String image;
    /**
     *更新时间
     */
    private DateTime updateTime;
    /**
     *添加时间
     */
    private DateTime createTime;
    /**
     *点击数
     */
    private Integer click;
    /**
     *位置
     */
    private Position position;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "url")
    @Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "image")
    @Basic
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "update_time")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "create_time")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "click")
    @Basic
    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
