/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_activity_attendee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopActivityAttendee.findAll", query = "SELECT c FROM CoopActivityAttendee c"),
    @NamedQuery(name = "CoopActivityAttendee.findByActAttenRecno", query = "SELECT c FROM CoopActivityAttendee c WHERE c.actAttenRecno = :actAttenRecno"),
    @NamedQuery(name = "CoopActivityAttendee.findByAttenIdno", query = "SELECT c FROM CoopActivityAttendee c WHERE c.attenIdno = :attenIdno"),
    @NamedQuery(name = "CoopActivityAttendee.findByCompleted", query = "SELECT c FROM CoopActivityAttendee c WHERE c.completed = :completed")})
public class CoopActivityAttendee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "act_atten_recno")
    private Integer actAttenRecno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "atten_idno")
    private String attenIdno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "completed")
    private boolean completed;
    @JoinColumn(name = "act_recno", referencedColumnName = "act_recno")
    @ManyToOne
    private CoopActivity actRecno;

    public CoopActivityAttendee() {
    }

    public CoopActivityAttendee(Integer actAttenRecno) {
        this.actAttenRecno = actAttenRecno;
    }

    public CoopActivityAttendee(Integer actAttenRecno, String attenIdno, boolean completed) {
        this.actAttenRecno = actAttenRecno;
        this.attenIdno = attenIdno;
        this.completed = completed;
    }

    public Integer getActAttenRecno() {
        return actAttenRecno;
    }

    public void setActAttenRecno(Integer actAttenRecno) {
        this.actAttenRecno = actAttenRecno;
    }

    public String getAttenIdno() {
        return attenIdno;
    }

    public void setAttenIdno(String attenIdno) {
        this.attenIdno = attenIdno;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public CoopActivity getActRecno() {
        return actRecno;
    }

    public void setActRecno(CoopActivity actRecno) {
        this.actRecno = actRecno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actAttenRecno != null ? actAttenRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopActivityAttendee)) {
            return false;
        }
        CoopActivityAttendee other = (CoopActivityAttendee) object;
        if ((this.actAttenRecno == null && other.actAttenRecno != null) || (this.actAttenRecno != null && !this.actAttenRecno.equals(other.actAttenRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopActivityAttendee[ actAttenRecno=" + actAttenRecno + " ]";
    }
    
}
