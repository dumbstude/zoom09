/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.CoopApplicant;
import model.CoopOrgUnit;
import model.CoopProspect;
import org.primefaces.event.SelectEvent;
import service.CoopApplicantFacade;
import service.CoopOrgUnitFacade;
import service.CoopProspectFacade;

/**
 *
 * @author roland
 */
@ManagedBean
@SessionScoped
public class ProspectBean implements Serializable {

	@EJB
	private CoopProspectFacade coopProspectFacade;
	@EJB
	private CoopOrgUnitFacade coopOrgUnitFacade;
	@EJB
	private CoopApplicantFacade coopApplicantFacade;
	
	private CoopProspect prospect;
	private CoopApplicant applicant;
	private CoopOrgUnit orgUnit;
	private List<CoopOrgUnit> ouList;
	private List<CoopProspect> prospectList;
	private List<CoopApplicant> applicantList;
	private List<CoopProspect> filteredProspects;
	private List<CoopApplicant> filteredApplicants;
	private CoopProspect selectedProspect;
	private CoopApplicant selectedApplicant;
	private DataModel<CoopProspect> prospectModel;
	private DataModel<CoopApplicant> applicantModel;
	private DataModel<CoopOrgUnit> ouModel;
	private Date test;

	@PostConstruct
	public void init() {
		prospect = new CoopProspect();
		applicant = new CoopApplicant();
		prospectList = coopProspectFacade.findAll();
		applicantList = coopApplicantFacade.findAll();
		ouList = coopOrgUnitFacade.findAll();
		prospectModel = new ListDataModel<CoopProspect>(prospectList);
		applicantModel = new ListDataModel<CoopApplicant>(applicantList);
		ouModel = new ListDataModel<CoopOrgUnit>(ouList);
	}

	public void beanclear() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("prospectBean", null);
	}

	/**
	 * Creates a new instance of ProspectBean
	 */
	public ProspectBean() {
		prospect = new CoopProspect();
	}

	public DataModel<CoopProspect> getProspectModel() {
		if (prospectModel == null) {
			prospectModel = new ListDataModel<CoopProspect>(prospectList);
		}
		return prospectModel;
	}

	public DataModel<CoopApplicant> getApplicantModel() {
		if (applicantModel == null) {
			applicantModel = new ListDataModel<CoopApplicant>(applicantList);
		}
		return applicantModel;
	}

	public DataModel<CoopOrgUnit> getOuModel() {
		if (ouModel == null) {
			ouModel = new ListDataModel<CoopOrgUnit>(ouList);
		}
		return ouModel;
	}

	public CoopOrgUnit getOrgUnit() {
		if (orgUnit == null) {
			orgUnit = new CoopOrgUnit();
		}
		return orgUnit;
	}

	public CoopProspect getProspect() {
		return prospect;
	}

	public void setProspect(CoopProspect prospect) {
		this.prospect = selectedProspect;
	}

	public CoopApplicant getApplicant() {
		return applicant;
	}

	public void prospectToApplicant() {
		prospect = selectedProspect;
		applicant.setFirstName(prospect.getFirstName());
		applicant.setLastName(prospect.getLastName());
		applicant.setMiddleName(prospect.getMiddleName());
		applicant.setGender(prospect.getGender());
		applicant.setBirthdate(prospect.getBirthdate());
		applicant.setNationality(prospect.getNationality());
		applicant.setContactNumber(prospect.getContactNumber());
		applicant.setOccupation(prospect.getOccupation());
		applicant.setStreet(prospect.getStreet());
		applicant.setBarangay(prospect.getBarangay());
		applicant.setCityMun(prospect.getCityMun());
		applicant.setOuCode(prospect.getOuCode().getCoopOrgUnit());
	}

	public String saveth() {
		prospectToApplicant();
		coopApplicantFacade.create(applicant);
		applicant = new CoopApplicant();
		prospect = new CoopProspect();
		beanclear();
		return "viewApplicant?faces-redirect=true";
	}

	public List<CoopProspect> getProspectList() {
		if (prospectList == null) {
			prospectList = coopProspectFacade.findAll();
		}
		return prospectList;
	}

	public void setProspectList(List<CoopProspect> prospectList) {
		this.prospectList = prospectList;
	}

	public List<CoopOrgUnit> getOuList() {
		if (ouList == null) {
			ouList = coopOrgUnitFacade.findAll();
		}
		return ouList;
	}

	public void setOuList(List<CoopOrgUnit> ouList) {
		this.ouList = ouList;
	}

	public List<CoopApplicant> getApplicantList() {
		if (applicantList == null) {
			applicantList = coopApplicantFacade.findAll();
		}
		return applicantList;
	}

	public void setApplicantList(List<CoopApplicant> applicantList) {
		this.applicantList = applicantList;
	}

	public List<CoopApplicant> getFilteredApplicants() {
		return filteredApplicants;
	}

	public void setFilteredApplicants(List<CoopApplicant> filteredApplicants) {
		this.filteredApplicants = filteredApplicants;
	}

	public CoopApplicant getSelectedApplicant() {
		if (selectedApplicant == null) {
			selectedApplicant = new CoopApplicant();
		}
		return selectedApplicant;
	}

	public void setSelectedApplicant(CoopApplicant selectedApplicant) {
		this.selectedApplicant = selectedApplicant;
	}

	public List<CoopProspect> getFilteredProspects() {
		return filteredProspects;
	}

	public void setFilteredProspects(List<CoopProspect> filteredProspects) {
		this.filteredProspects = filteredProspects;
	}

	public void setSelectedProspect(CoopProspect selectedProspect) {
		this.selectedProspect = selectedProspect;
	}

	public CoopProspect getSelectedProspect() {
		if (selectedProspect == null) {
			selectedProspect = new CoopProspect();
		}
		return selectedProspect;
	}

	public void onRowSelect(SelectEvent event) {
	}

	public String saveEdit() {
		coopProspectFacade.edit(prospect);
		prospect = new CoopProspect();
		beanclear();
		return "viewProspect";
	}

	public String deleteProspect() {
		coopProspectFacade.remove(prospect);
		prospect = new CoopProspect();
		beanclear();
		return "viewProspect";
	}

}
