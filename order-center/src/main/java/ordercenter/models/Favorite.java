package ordercenter.models;

import common.models.utils.EntityClass;
import common.models.utils.OperableData;
import ordercenter.constants.FavoriteType;
import org.hibernate.annotations.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lzadmin on 2016/4/12 0012.
 * favorite表的实体类
 */

@Entity
public class Favorite implements EntityClass<Integer> {
    private Integer id;
    //    被收藏的id
    private Integer fav_id;

    private DateTime create_time;
    //    收藏的类型
    private FavoriteType favoriteType;
    //    用户id
    private Integer user_id;

    //    get/set方法
    @Column(name = "fav_id")
    @Basic
    public Integer getFav_id() {
        return fav_id;
    }

    public void setFav_id(Integer fav_id) {
        this.fav_id = fav_id;
    }

    @Column(name = "create_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(DateTime create_time) {
        this.create_time = create_time;
    }

    @Column(name = "favoriteType")
    @Enumerated(EnumType.STRING)
    public FavoriteType getFavoriteType() {
        return favoriteType;
    }

    public void setFavoriteType(FavoriteType favoriteType) {
        this.favoriteType = favoriteType;
    }

    @Column(name = "user_id")
    @Basic
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
