package ordercenter.models;

import common.models.utils.EntityClass;
import ordercenter.constants.ArticleState;
import ordercenter.constants.ArticleType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzadmin on 2016/4/12 0012.
 * article表实体类
 */
@Table(name = "article")
@Entity
public class Article implements EntityClass<Integer> {
    /**
     * ID
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 关键字
     */
    private String key;
    /**
     * 文章分类
     */
    private Category category;
    /**
     * 发布管理员
     */
    private Admin admin;
    /**
     * 添加时间
     */
    private DateTime createTime;
    /**
     * 更新时间
     */
    private DateTime updateTime;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 所属专家
     */
    private User user;
    /**
     * 点击次数
     */
    private Integer click;
    /**
     * 图片
     */
    private String image;
    /**
     * 文章类型
     */
    private ArticleType articleType;
    /**
     * 提交状态
     */
    private ArticleState articleState;

    /**
     * 文章评论
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<Comment> comments = new ArrayList<Comment>();

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

    @Column(name = "content")
    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "key")
    @Basic
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="admin_id")
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Column(name = "create_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "sort")
    @Basic
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "click")
    @Basic
    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    @Column(name = "image")
    @Basic
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    @Column(name = "articleState")
    @Enumerated(EnumType.STRING)
    public ArticleState getArticleState() {
        return articleState;
    }

    public void setArticleState(ArticleState articleState) {
        this.articleState = articleState;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
