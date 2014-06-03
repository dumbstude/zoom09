/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.CoopProspect;
import org.primefaces.event.SelectEvent;
import service.CoopProspectFacadeREST;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author roland
 */
@ManagedBean
@SessionScoped
public class ProspectBean implements Serializable {

    @EJB
    private CoopProspectFacadeREST coopProspectFacadeREST;
    private CoopProspect prospect;
    private List<CoopProspect> prospectList;
    private List<CoopProspect> filteredProspects;
    private CoopProspect selectedProspect;
    private DataModel<CoopProspect> prospectModel;

    public void init() {
        prospect = new CoopProspect();
        prospectList = coopProspectFacadeREST.findAll();
        prospectModel = new ListDataModel<>(prospectList);
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
            prospectModel = new ListDataModel<>(prospectList);
        }
        return prospectModel;
    }

    public CoopProspect getProspect() {
        return prospect;
    }

    public void setProspect(CoopProspect prospect) {
        this.prospect = selectedProspect;
    }

    public String save() {
        coopProspectFacadeREST.create(prospect);
        prospect = new CoopProspect();
        return "addProspect";
    }

    public List<CoopProspect> getProspectList() {
        prospectList = coopProspectFacadeREST.findAll();
        return prospectList;
    }

    public void setProspectList(List<CoopProspect> prospectList) {
        this.prospectList = prospectList;
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
        coopProspectFacadeREST.edit(prospect);
        prospect = new CoopProspect();
        beanclear();
        return "viewProspect";
    }
     public String deleteProspect() {
        coopProspectFacadeREST.remove(prospect);
        prospect = new CoopProspect();
        beanclear();
        return "viewProspect";
    }

}