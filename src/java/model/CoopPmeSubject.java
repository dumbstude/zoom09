/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_pme_subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopPmeSubject.findAll", query = "SELECT c FROM CoopPmeSubject c"),
    @NamedQuery(name = "CoopPmeSubject.findBySubjectCode", query = "SELECT c FROM CoopPmeSubject c WHERE c.subjectCode = :subjectCode"),
    @NamedQuery(name = "CoopPmeSubject.findBySubjectTitle", query = "SELECT c FROM CoopPmeSubject c WHERE c.subjectTitle = :subjectTitle"),
    @NamedQuery(name = "CoopPmeSubject.findBySubjectObj", query = "SELECT c FROM CoopPmeSubject c WHERE c.subjectObj = :subjectObj"),
    @NamedQuery(name = "CoopPmeSubject.findBySubjOutline", query = "SELECT c FROM CoopPmeSubject c WHERE c.subjOutline = :subjOutline"),
    @NamedQuery(name = "CoopPmeSubject.findBySubjStat", query = "SELECT c FROM CoopPmeSubject c WHERE c.subjStat = :subjStat")})
public class CoopPmeSubject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "subject_code")
    private String subjectCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "subject_title")
    private String subjectTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "subject_obj")
    private String subjectObj;
    @Size(max = 2147483647)
    @Column(name = "subj_outline")
    private String subjOutline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subj_stat")
    private char subjStat;
    @OneToMany(mappedBy = "subjectCode")
    private Collection<CoopAppSubjRating> coopAppSubjRatingCollection;

    public CoopPmeSubject() {
    }

    public CoopPmeSubject(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public CoopPmeSubject(String subjectCode, String subjectTitle, String subjectObj, char subjStat) {
        this.subjectCode = subjectCode;
        this.subjectTitle = subjectTitle;
        this.subjectObj = subjectObj;
        this.subjStat = subjStat;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getSubjectObj() {
        return subjectObj;
    }

    public void setSubjectObj(String subjectObj) {
        this.subjectObj = subjectObj;
    }

    public String getSubjOutline() {
        return subjOutline;
    }

    public void setSubjOutline(String subjOutline) {
        this.subjOutline = subjOutline;
    }

    public char getSubjStat() {
        return subjStat;
    }

    public void setSubjStat(char subjStat) {
        this.subjStat = subjStat;
    }

    @XmlTransient
    public Collection<CoopAppSubjRating> getCoopAppSubjRatingCollection() {
        return coopAppSubjRatingCollection;
    }

    public void setCoopAppSubjRatingCollection(Collection<CoopAppSubjRating> coopAppSubjRatingCollection) {
        this.coopAppSubjRatingCollection = coopAppSubjRatingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectCode != null ? subjectCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopPmeSubject)) {
            return false;
        }
        CoopPmeSubject other = (CoopPmeSubject) object;
        if ((this.subjectCode == null && other.subjectCode != null) || (this.subjectCode != null && !this.subjectCode.equals(other.subjectCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopPmeSubject[ subjectCode=" + subjectCode + " ]";
    }
    
}
