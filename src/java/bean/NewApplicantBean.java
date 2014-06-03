/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import model.CoopApplicant;
import service.CoopApplicantFacadeREST;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author roland
 */
@ManagedBean
@SessionScoped
public class NewApplicantBean implements Serializable {

    @EJB
    private CoopApplicantFacadeREST coopApplicantFacadeREST;
    private CoopApplicant applicant;
    private CoopApplicant selectedApplicant;

   
    public void init() {
        applicant = new CoopApplicant();
    }

    public void beanclear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("applicantBean", null);
    }
    @ManagedProperty(value = "#{prospectBean}")
    private ProspectBean prospectBean;

    public ProspectBean getProspectBean() {
        return prospectBean;
    }

    public void setProspectBean(ProspectBean prospectBean) {
        this.prospectBean = prospectBean;
    }
    @ManagedProperty(value = "#{applicantBean}")
    private ApplicantBean applicantBean;

    public ApplicantBean getApplicantBean() {
        return this.applicantBean;
    }

    public void setApplicantBean(ApplicantBean applicantBean) {
        this.applicantBean = applicantBean;
    }

    public NewApplicantBean() {
        applicant = new CoopApplicant();
    }

    public CoopApplicant getApplicant() {
        return applicant;
    }

    public void setApplicant(CoopApplicant applicant) {
        this.applicant = selectedApplicant;
    }

       public Integer getApplicantNo() {
        return applicant.getApplicantNo();
    }

    public String save() {
        coopApplicantFacadeREST.create(applicant);
        applicant = new CoopApplicant();
        return "addApplicant";
    }

    public String saveEdit() {
        coopApplicantFacadeREST.edit(applicant);
        applicant = new CoopApplicant();
        beanclear();
        return "viewApplicant";
    }
    
}
