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
@Table(name = "trade")
@Entity
public class Trade implements EntityClass<Integer> {

    private Integer id;
    /**
     * 交易标题
     */
    private String title;
    /**
     * 交易描述
     */
    private String description;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 点击数
     */
    private Integer click;
    /**
     * 收藏数
     */
    private Integer like;
    /**
     * 发布时间
     */
    private DateTime createTime;
    /**
     * 交易标题
     */
    private DateTime updateTime;
    /**
     * 结束时间
     */
    private DateTime endTime;
    /**
     * 交易类型
     */
    private TradeType tradeType;
    /**
     * 分类id
     */
    private Integer categoryId;
    /**
     * 交易状态
     */
    private TradeState tradeState;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title")
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer user_id) {
        this.userId = userId;
    }

    @Column(name = "click")
    @Basic
    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    @Column(name = "like")
    @Basic
    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    @Column(name = "create_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreateIime() {
        return createTime;
    }

    public void setCreateIime(DateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getUpdateIime() {
        return updateTime;
    }

    public void setUpdateIime(DateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "end_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getEndIime() {
        return endTime;
    }

    public void setEndIime(DateTime endTime) {
        this.endTime = endTime;
    }

    @Column(name = "tradeType")
    @Enumerated(EnumType.STRING)
    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "tradeState")
    @Enumerated(EnumType.STRING)
    public TradeState getTradeState() {
        return tradeState;
    }

    public void setTradeState(TradeState tradeState) {
        this.tradeState = tradeState;
    }
}