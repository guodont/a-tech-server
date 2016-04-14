package ordercenter.models;

import common.models.utils.EntityClass;
import ordercenter.constants.QuestionAuditState;
import ordercenter.constants.QuestionResolveState;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 2016/4/13.
 * 问题model
 */
@Table(name = "question")
@Entity
public class Question implements EntityClass<Integer> {
    /**
     * id
     */
    private Integer id;
    /**
     * 所属分类
     */
    private Category category;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private DateTime createTime;
    /**
     * 浏览数
     */
    private Integer click;
    /**
     * 收藏数
     */
    private Integer like;
    /**
     * 指定专家
     */
    private Expert expert;
    /**
     * 提问用户
     */
    private User user;
    /**
     * 问题审核状态
     */
    private QuestionAuditState questionAuditState;
    /**
     * 问题解决状态
     */
    private QuestionResolveState questionResolveState;
    /**
     * 回答
     */
    private List<Answer> answers = new ArrayList<Answer>();

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    @Column(name = "create_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
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

    @Column(name = "like")
    @Basic
    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="expert_id")
    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "audit_state")
    @Enumerated(EnumType.STRING)
    public QuestionAuditState getQuestionAuditState() {
        return questionAuditState;
    }

    public void setQuestionAuditState(QuestionAuditState questionAuditState) {
        this.questionAuditState = questionAuditState;
    }

    @Column(name = "resolve_state")
    @Enumerated(EnumType.STRING)
    public QuestionResolveState getQuestionResolveState() {
        return questionResolveState;
    }

    public void setQuestionResolveState(QuestionResolveState questionResolveState) {
        this.questionResolveState = questionResolveState;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
