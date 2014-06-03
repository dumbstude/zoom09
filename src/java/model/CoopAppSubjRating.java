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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_app_subj_rating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopAppSubjRating.findAll", query = "SELECT c FROM CoopAppSubjRating c"),
    @NamedQuery(name = "CoopAppSubjRating.findByAppSubjRatingRecno", query = "SELECT c FROM CoopAppSubjRating c WHERE c.appSubjRatingRecno = :appSubjRatingRecno"),
    @NamedQuery(name = "CoopAppSubjRating.findByEffortRate", query = "SELECT c FROM CoopAppSubjRating c WHERE c.effortRate = :effortRate"),
    @NamedQuery(name = "CoopAppSubjRating.findByUnderstandingRate", query = "SELECT c FROM CoopAppSubjRating c WHERE c.understandingRate = :understandingRate"),
    @NamedQuery(name = "CoopAppSubjRating.findByDelMethod", query = "SELECT c FROM CoopAppSubjRating c WHERE c.delMethod = :delMethod"),
    @NamedQuery(name = "CoopAppSubjRating.findByRemarks", query = "SELECT c FROM CoopAppSubjRating c WHERE c.remarks = :remarks"),
    @NamedQuery(name = "CoopAppSubjRating.findByEvalDate", query = "SELECT c FROM CoopAppSubjRating c WHERE c.evalDate = :evalDate")})
public class CoopAppSubjRating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "app_subj_rating_recno")
    private Integer appSubjRatingRecno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "effort_rate")
    private int effortRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "understanding_rate")
    private int understandingRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "del_method")
    private char delMethod;
    @Size(max = 2147483647)
    @Column(name = "remarks")
    private String remarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eval_date")
    @Temporal(TemporalType.DATE)
    private Date evalDate;
    @JoinColumn(name = "subject_code", referencedColumnName = "subject_code")
    @ManyToOne
    private CoopPmeSubject subjectCode;
    @JoinColumn(name = "applicant_no", referencedColumnName = "applicant_no")
    @ManyToOne
    private CoopApplicant applicantNo;

    public CoopAppSubjRating() {
    }

    public CoopAppSubjRating(Integer appSubjRatingRecno) {
        this.appSubjRatingRecno = appSubjRatingRecno;
    }

    public CoopAppSubjRating(Integer appSubjRatingRecno, int effortRate, int understandingRate, char delMethod, Date evalDate) {
        this.appSubjRatingRecno = appSubjRatingRecno;
        this.effortRate = effortRate;
        this.understandingRate = understandingRate;
        this.delMethod = delMethod;
        this.evalDate = evalDate;
    }

    public Integer getAppSubjRatingRecno() {
        return appSubjRatingRecno;
    }

    public void setAppSubjRatingRecno(Integer appSubjRatingRecno) {
        this.appSubjRatingRecno = appSubjRatingRecno;
    }

    public int getEffortRate() {
        return effortRate;
    }

    public void setEffortRate(int effortRate) {
        this.effortRate = effortRate;
    }

    public int getUnderstandingRate() {
        return understandingRate;
    }

    public void setUnderstandingRate(int understandingRate) {
        this.understandingRate = understandingRate;
    }

    public char getDelMethod() {
        return delMethod;
    }

    public void setDelMethod(char delMethod) {
        this.delMethod = delMethod;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(Date evalDate) {
        this.evalDate = evalDate;
    }

    public CoopPmeSubject getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(CoopPmeSubject subjectCode) {
        this.subjectCode = subjectCode;
    }

    public CoopApplicant getApplicantNo() {
        return applicantNo;
    }

    public void setApplicantNo(CoopApplicant applicantNo) {
        this.applicantNo = applicantNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appSubjRatingRecno != null ? appSubjRatingRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopAppSubjRating)) {
            return false;
        }
        CoopAppSubjRating other = (CoopAppSubjRating) object;
        if ((this.appSubjRatingRecno == null && other.appSubjRatingRecno != null) || (this.appSubjRatingRecno != null && !this.appSubjRatingRecno.equals(other.appSubjRatingRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopAppSubjRating[ appSubjRatingRecno=" + appSubjRatingRecno + " ]";
    }
    
}
