/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_app_sched")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopAppSched.findAll", query = "SELECT c FROM CoopAppSched c"),
    @NamedQuery(name = "CoopAppSched.findByAppSkedno", query = "SELECT c FROM CoopAppSched c WHERE c.appSkedno = :appSkedno"),
    @NamedQuery(name = "CoopAppSched.findBySkedStatus", query = "SELECT c FROM CoopAppSched c WHERE c.skedStatus = :skedStatus"),
    @NamedQuery(name = "CoopAppSched.findByScheduledTime", query = "SELECT c FROM CoopAppSched c WHERE c.scheduledTime = :scheduledTime"),
    @NamedQuery(name = "CoopAppSched.findByScheduledDate", query = "SELECT c FROM CoopAppSched c WHERE c.scheduledDate = :scheduledDate")})
public class CoopAppSched implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "app_skedno")
    private Integer appSkedno;
    @Column(name = "sked_status")
    private Character skedStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scheduled_time")
    @Temporal(TemporalType.TIME)
    private Date scheduledTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scheduled_date")
    @Temporal(TemporalType.DATE)
    private Date scheduledDate;
    @JoinColumn(name = "applicant_no", referencedColumnName = "applicant_no")
    @ManyToOne
    private CoopApplicant applicantNo;
    @JoinColumn(name = "act_type_code", referencedColumnName = "act_type_code")
    @ManyToOne
    private CoopActivityType actTypeCode;

    public CoopAppSched() {
    }

    public CoopAppSched(Integer appSkedno) {
        this.appSkedno = appSkedno;
    }

    public CoopAppSched(Integer appSkedno, Date scheduledTime, Date scheduledDate) {
        this.appSkedno = appSkedno;
        this.scheduledTime = scheduledTime;
        this.scheduledDate = scheduledDate;
    }

    public Integer getAppSkedno() {
        return appSkedno;
    }

    public void setAppSkedno(Integer appSkedno) {
        this.appSkedno = appSkedno;
    }

    public Character getSkedStatus() {
        return skedStatus;
    }

    public void setSkedStatus(Character skedStatus) {
        this.skedStatus = skedStatus;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public CoopApplicant getApplicantNo() {
        return applicantNo;
    }

    public void setApplicantNo(CoopApplicant applicantNo) {
        this.applicantNo = applicantNo;
    }

    public CoopActivityType getActTypeCode() {
        return actTypeCode;
    }

    public void setActTypeCode(CoopActivityType actTypeCode) {
        this.actTypeCode = actTypeCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appSkedno != null ? appSkedno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopAppSched)) {
            return false;
        }
        CoopAppSched other = (CoopAppSched) object;
        if ((this.appSkedno == null && other.appSkedno != null) || (this.appSkedno != null && !this.appSkedno.equals(other.appSkedno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopAppSched[ appSkedno=" + appSkedno + " ]";
    }
    
}
