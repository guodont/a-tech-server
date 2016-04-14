package ordercenter.models;

import common.models.utils.EntityClass;
import scala.Int;

import javax.persistence.*;

/**
 * Created by j on 2016/4/13.
 */
@Table(name = "expert")
@Entity
public class Expert implements EntityClass<Integer> {
    /**
     * 专家id
     */
    private Integer id;
    /**
     * 用户信息
     */
    private User user;
    /**
     * 所属分类
     */
    private Category category;
    /**
     * 职称
     */
    private String professional;
    /**
     * 职务
     */
    private String duty;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 服务项目
     */
    private String service;
    /**
     * 所在单位
     */
    private String company;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 一个专家对应一个用户
     * @return
     */
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 专家和分类是多对一的关系
     * @return
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "professional")
    @Basic
    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    @Column(name = "duty")
    @Basic
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Column(name = "introduction")
    @Basic
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Column(name = "service")
    @Basic
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Column(name = "company")
    @Basic
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
