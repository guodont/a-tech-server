package ordercenter.models;

import common.models.utils.EntityClass;
import ordercenter.constants.ArticleState;
import ordercenter.constants.ArticleType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import javax.persistence.*;

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
     * 文章类型id
     */
    private Integer category_id;
    /**
     * 管理员id
     */
    private Integer admin_id;
    /**
     * 添加时间
     */
    private DateTime create_time;
    /**
     * 更新时间
     */
    private DateTime update_time;
    /**
     * 排序
     */
    private String sortType;
    /**
     * 专家id
     */
    private Integer user_id;
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

    @Column(name = "category_id")
    @Basic
    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Column(name = "admin_id")
    @Basic
    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    @Column(name = "create_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(DateTime create_time) {
        this.create_time = create_time;
    }

    @Column(name = "update_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(DateTime update_time) {
        this.update_time = update_time;
    }

    @Column(name = "sortType")
    @Basic
    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    @Column(name = "user_id")
    @Basic
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    @Column(name = "articleType")
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

}
