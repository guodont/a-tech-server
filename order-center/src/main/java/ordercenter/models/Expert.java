package ordercenter.models;

import scala.Int;

import javax.persistence.*;

/**
 * Created by j on 2016/4/13.
 */
public class Expert {
    private Integer id;
    private User user;
    private Integer categoryId;
    private String  professional;
    private String  duty;
    private String  instruction;
    private String  service;
    private String  company;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    @ManyToMany(mappedBy="User",cascade=CascadeType.REFRESH)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Column(name ="category_id")
    @Basic
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name ="professional")
    @Basic
    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    @Column(name ="duty")
    @Basic
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
    @Column(name ="instruction")
    @Basic
    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    @Column(name ="service")
    @Basic
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
    @Column(name ="company")
    @Basic
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
