package ordercenter.models;

import common.models.utils.EntityClass;
import common.models.utils.OperableData;
import ordercenter.constants.FavoriteType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lzadmin on 2016/4/12 0012.
 * favorite表的实体类
 */
@Table(name = "expert")
@Entity
public class Favorite implements EntityClass<Integer> {
    /**
     * 收藏id
     */
    private Integer id;
    /**
     * 被收藏的id
     */
    private Integer favId;
    /**
     * 收藏时间
     */
    private DateTime createTime;
    /**
     * 收藏的类型
     */
    private FavoriteType favoriteType;
    /**
     * 所属用户
     */
    private User user;

    @Column(name = "fav_id")
    @Basic
    public Integer getFavId() {
        return favId;
    }

    public void setFavId(Integer favId) {
        this.favId = favId;
    }

    @Column(name = "create_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "favoriteType")
    @Enumerated(EnumType.STRING)
    public FavoriteType getFavoriteType() {
        return favoriteType;
    }

    public void setFavoriteType(FavoriteType favoriteType) {
        this.favoriteType = favoriteType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = true, updatable = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
