package ordercenter.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by llz on 2016/4/12.
 */
@Table(name = "comment")
@Entity
public class Comment {
    /**
     * 评价编号
     */
    private Integer id;
    /**
     * 对应文章
     */
    private Integer articleId;
    /**
     * 对应用户编号
     */
    private Integer userId;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private DateTime createTime;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", insertable = false, updatable = false)
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUser_id(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "content")
    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "create_time")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }
}
