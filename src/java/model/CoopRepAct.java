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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roland
 */
@Entity
@Table(name = "coop_rep_act")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopRepAct.findAll", query = "SELECT c FROM CoopRepAct c"),
    @NamedQuery(name = "CoopRepAct.findByRepActRecno", query = "SELECT c FROM CoopRepAct c WHERE c.repActRecno = :repActRecno")})
public class CoopRepAct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rep_act_recno")
    private Integer repActRecno;
    @JoinColumn(name = "report_num", referencedColumnName = "report_num")
    @ManyToOne
    private CoopReport reportNum;
    @JoinColumn(name = "act_recno", referencedColumnName = "act_recno")
    @ManyToOne
    private CoopActivity actRecno;

    public CoopRepAct() {
    }

    public CoopRepAct(Integer repActRecno) {
        this.repActRecno = repActRecno;
    }

    public Integer getRepActRecno() {
        return repActRecno;
    }

    public void setRepActRecno(Integer repActRecno) {
        this.repActRecno = repActRecno;
    }

    public CoopReport getReportNum() {
        return reportNum;
    }

    public void setReportNum(CoopReport reportNum) {
        this.reportNum = reportNum;
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
        hash += (repActRecno != null ? repActRecno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopRepAct)) {
            return false;
        }
        CoopRepAct other = (CoopRepAct) object;
        if ((this.repActRecno == null && other.repActRecno != null) || (this.repActRecno != null && !this.repActRecno.equals(other.repActRecno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopRepAct[ repActRecno=" + repActRecno + " ]";
    }
    
}
