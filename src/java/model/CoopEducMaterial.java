/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author mis
 */
@Entity
@Table(name = "coop_educ_material")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopEducMaterial.findAll", query = "SELECT c FROM CoopEducMaterial c"),
	@NamedQuery(name = "CoopEducMaterial.findByInvNo", query = "SELECT c FROM CoopEducMaterial c WHERE c.invNo = :invNo"),
	@NamedQuery(name = "CoopEducMaterial.findByType", query = "SELECT c FROM CoopEducMaterial c WHERE c.type = :type"),
	@NamedQuery(name = "CoopEducMaterial.findByTitle", query = "SELECT c FROM CoopEducMaterial c WHERE c.title = :title"),
	@NamedQuery(name = "CoopEducMaterial.findByCopyNo", query = "SELECT c FROM CoopEducMaterial c WHERE c.copyNo = :copyNo"),
	@NamedQuery(name = "CoopEducMaterial.findByMatStat", query = "SELECT c FROM CoopEducMaterial c WHERE c.matStat = :matStat")})
public class CoopEducMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_no")
	private Integer invNo;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "type")
	private String type;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "title")
	private String title;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "copy_no")
	private String copyNo;
	@Column(name = "mat_stat")
	private Boolean matStat;
	@OneToMany(mappedBy = "invNo")
	private Collection<CoopAppMaterial> coopAppMaterialCollection;

	public CoopEducMaterial() {
	}

	public CoopEducMaterial(Integer invNo) {
		this.invNo = invNo;
	}

	public CoopEducMaterial(Integer invNo, String type, String title, String copyNo) {
		this.invNo = invNo;
		this.type = type;
		this.title = title;
		this.copyNo = copyNo;
	}

	public Integer getInvNo() {
		return invNo;
	}

	public void setInvNo(Integer invNo) {
		this.invNo = invNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCopyNo() {
		return copyNo;
	}

	public void setCopyNo(String copyNo) {
		this.copyNo = copyNo;
	}

	public Boolean getMatStat() {
		return matStat;
	}

	public void setMatStat(Boolean matStat) {
		this.matStat = matStat;
	}

	@XmlTransient
	public Collection<CoopAppMaterial> getCoopAppMaterialCollection() {
		return coopAppMaterialCollection;
	}

	public void setCoopAppMaterialCollection(Collection<CoopAppMaterial> coopAppMaterialCollection) {
		this.coopAppMaterialCollection = coopAppMaterialCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (invNo != null ? invNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopEducMaterial)) {
			return false;
		}
		CoopEducMaterial other = (CoopEducMaterial) object;
		if ((this.invNo == null && other.invNo != null) || (this.invNo != null && !this.invNo.equals(other.invNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopEducMaterial[ invNo=" + invNo + " ]";
	}
	
}
