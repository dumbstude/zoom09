/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author mis
 */
@Entity
@Table(name = "coop_rep_act")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopRepAct.findAll", query = "SELECT c FROM CoopRepAct c"),
	@NamedQuery(name = "CoopRepAct.findByRepActNum", query = "SELECT c FROM CoopRepAct c WHERE c.repActNum = :repActNum")})
public class CoopRepAct implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rep_act_num")
	private Integer repActNum;
	@JoinColumn(name = "report_num", referencedColumnName = "report_num")
    @ManyToOne
	private CoopReport reportNum;
	@JoinColumn(name = "act_num", referencedColumnName = "act_num")
    @ManyToOne
	private CoopActivity actNum;

	public CoopRepAct() {
	}

	public CoopRepAct(Integer repActNum) {
		this.repActNum = repActNum;
	}

	public Integer getRepActNum() {
		return repActNum;
	}

	public void setRepActNum(Integer repActNum) {
		this.repActNum = repActNum;
	}

	public CoopReport getReportNum() {
		return reportNum;
	}

	public void setReportNum(CoopReport reportNum) {
		this.reportNum = reportNum;
	}

	public CoopActivity getActNum() {
		return actNum;
	}

	public void setActNum(CoopActivity actNum) {
		this.actNum = actNum;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (repActNum != null ? repActNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopRepAct)) {
			return false;
		}
		CoopRepAct other = (CoopRepAct) object;
		if ((this.repActNum == null && other.repActNum != null) || (this.repActNum != null && !this.repActNum.equals(other.repActNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopRepAct[ repActNum=" + repActNum + " ]";
	}
	
}
