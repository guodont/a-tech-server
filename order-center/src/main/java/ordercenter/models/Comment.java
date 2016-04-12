package ordercenter.models;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

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
    private Integer article_id;
    /**
     * 对应用户编号
     */
    private Integer user_id;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private DateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }
}
