package ordercenter.models;

import common.models.utils.EntityClass;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by j on 2016/4/12.
 */
@Table(name = "answer")
@Entity
public class Answer implements EntityClass<Integer> {
    /**
     * id
     */
    private Integer id;
    /**
     * 所属问题
     */
    private Question question;
    /**
     * 问题内容
     */
    private String content;
    /**
     * 创建时间
     */
    private DateTime createTime;
    /**
     * 回答的专家
     */
    private Expert expert;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 回答和问题是多对一的关系
     * @return
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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

    /**
     * 回答和专家是多对一的关系
     * @return
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="expert_id")
    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }
}
