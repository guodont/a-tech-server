package ordercenter.models;

import common.models.utils.EntityClass;
import common.models.utils.OperableData;
import ordercenter.constants.TradeState;
import ordercenter.constants.TradeType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by lzadmin on 2016/4/12 0012.
 * trade表实体类
 */
public class Trade implements EntityClass<Integer> {

    private Integer id;
    //    交易标题
    private String title;
    //    交易描述
    private String description;
    //    用户id
    private Integer user_id;

    private Integer click;

    private Integer like;
    //    发布时间
    private DateTime create_time;

    private DateTime update_time;
    //    结束时间
    private DateTime end_time;
    //    交易类型
    private TradeType tradeType;
    //分类id
    private Integer category_id;
    //    交易状态
    private TradeState tradeState;

//    get/set方法


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="title")
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name="description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    @Column(name="click")
    @Basic
    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }
    @Column(name="like")
    @Basic
    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }
    @Column(name = "create_time")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(DateTime create_time) {
        this.create_time = create_time;
    }
    @Column(name = "update_time")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(DateTime update_time) {
        this.update_time = update_time;
    }
    @Column(name = "end_time")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(DateTime end_time) {
        this.end_time = end_time;
    }
    @Column(name="tradeType")
    @Enumerated(EnumType.STRING)
    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
    @Column(name="tradeState")
    @Enumerated(EnumType.STRING)
    public TradeState getTradeState() {
        return tradeState;
    }

    public void setTradeState(TradeState tradeState) {
        this.tradeState = tradeState;
    }
}