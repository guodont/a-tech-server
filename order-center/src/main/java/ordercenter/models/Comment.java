package ordercenter.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by j on 2016/4/12.
 */
public class Comment {
    /**
     * id
     */
    private Integer id;
    /**
     * 文章id
     */
    private Article article;
    /**
     * 用户id
     */
    private User user;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 创建时间
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", insertable = false, updatable = false)
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    @Column(name = "user_id")
    @Basic
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
