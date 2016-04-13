package ordercenter.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by j on 2016/4/12.
 */
public class Answer {
    /**
     * id
     */
    private Integer id;
    /**
     * 问题id
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
     * 专家id
     */
    private Expert expertId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
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

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="expert_id")

    public Expert getExpertId() {
        return expertId;
    }

    public void setExpertId(Expert expertId) {
        this.expertId = expertId;
    }
}
