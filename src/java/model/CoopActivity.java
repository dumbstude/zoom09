/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopActivity.findAll", query = "SELECT c FROM CoopActivity c"),
    @NamedQuery(name = "CoopActivity.findByActRecno", query = "SELECT c FROM CoopActivity c WHERE c.actRecno = :actRecno"),
    @NamedQuery(name = "CoopActivity.findByActName", query = "SELECT c FROM CoopActivity c WHERE c.actName = :actName"),
    @NamedQuery(name = "CoopActivity.findByActObj", query = "SELECT c FROM CoopActivity c WHERE c.actObj = :actObj"),
    @NamedQuery(name = "CoopActivity.findByActDateFrom", query = "SELECT c FROM CoopActivity c WHERE c.actDateFrom = :actDateFrom"),
    @NamedQuery(name = "CoopActivity.findByActDateTo", query = "SELECT c FROM CoopActivity c WHERE c.actDateTo = :actDateTo"),
    @NamedQuery(name = "CoopActivity.findByActDetails", query = "SELECT c FROM CoopActivity c WHERE c.actDetails = :actDetails"),
    @NamedQuery(name = "CoopActivity.findByActLocation", query = "SELECT c FROM CoopActivity c WHERE c.actLocation = :actLocation")})
public class CoopActivity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "act_recno")
    private Integer actRecno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "act_name")
    private String actName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "act_obj")
    private String actObj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "act_date_from")
    @Temporal(TemporalType.DATE)
    private Date actDateFrom;
    @Column(name = "act_date_to")
    @Temporal(TemporalType.DATE)
    private Date actDateTo;
    @Size(max = 2147483647)
    @Column(name = "act_details")
    private String actDetails;
    @Size(max = 30)
    @Column(name = "act_location")
    private String actLocation;
    @OneToMany(mappedBy = "actRecno")
    private Collection<CoopRepAct> coopRepActCollection;
    @JoinColumn(name = "act_type_code", referencedColumnName = "act_type_code")
    @ManyToOne
    private CoopActivityType actTypeCode;
    @OneToMany(mappedBy = "actRecno")
    private Collection<CoopActivityAttendee> coopActivityAttendeeCollection;

    public CoopActivity() {
    }

    public CoopActivity(Integer actRecno) {
        this.actRecno = actRecno;
    }

    public CoopActivity(Integer actRecno, String actName, String actObj, Date actDateFrom) {
        this.actRecno = actRecno;
        this.actName = actName;
        this.actObj = actObj;
        this.actDateFrom = actDateFrom;
    }

    public Integer getActRecno() {
        return actRecno;
    }

    public void setActRecno(Integer actRecno) {
        this.actRecno = actRecno;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActObj() {
        return actObj;
    }

    public void setActObj(String actObj) {
        this.actObj = actObj;
    }

    public Date getActDateFrom() {
        return actDateFrom;
    }

    public void setActDateFrom(Date actDateFrom) {
        this.actDateFrom = actDateFrom;
    }

    public Date getActDateTo() {
        return actDateTo;
    }

    public void setActDateTo(Date actDateTo) {
        this.actDateTo = actDateTo;
    }

    public String getActDetails() {
        return actDetails;
    }

    public void setActDetails(String actDetails) {
        this.actDetails = actDetails;
    }

    public String getActLocation() {
        return actLocation;
    }

    public void setActLocation(String actLocation) {
        this.actLocation = actLocation;
    }

    @XmlTransient
    public Collection<CoopRepAct> getCoopRepActCollection() {
        return coopRepActCollection;
    }

    public void setCoopRepActCollection(Collection<CoopRepAct> coopRepActCollection) {
        this.coopRepActCollection = coopRepActCollection;
    }

    public CoopActivityType getActTypeCode() {
        return actTypeCode;
    }

    public void setActTypeCode(CoopActivityType actTypeCode) {
        this.actTypeCode = actTypeCode;
    }

    @XmlTransient
    public Collection<CoopActivityAttendee> getCoopActivityAttendeeCollection() {
        return coopActivityAttendeeCollection;
    }

    public void setCoopActivityAttendeeCollection(Collection<CoopActivityAttendee> coopActivityAttendeeCollection) {
        this.coopActivityAttendeeCollection = coopActivityAttendeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actRecno != null ? actRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopActivity)) {
            return false;
        }
        CoopActivity other = (CoopActivity) object;
        if ((this.actRecno == null && other.actRecno != null) || (this.actRecno != null && !this.actRecno.equals(other.actRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopActivity[ actRecno=" + actRecno + " ]";
    }
    
}
