package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Agent;
import com.mmp.creditbail.service.AgentService;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class AgentView implements Serializable {

    private List<Agent> agents;

    private Agent selectedAgent;

    private List<Agent> selectedAgents;

    @Inject
    private AgentService agentService;

    @PostConstruct
    public void init() {
        this.agents = this.agentService.getAgents();
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public Agent getSelectedAgent() {
        return selectedAgent;
    }

    public void setSelectedAgent(Agent selectedAgent) {
        this.selectedAgent = selectedAgent;
    }

    public List<Agent> getSelectedAgents() {
        return selectedAgents;
    }

    public void setSelectedAgents(List<Agent> selectedAgents) {
        this.selectedAgents = selectedAgents;
    }

    public void openNew() {
        this.selectedAgent = new Agent();
    }

    public void saveProduct() {
        if (this.selectedAgent.getCode() == null) {
            this.selectedAgent.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.agents.add(this.selectedAgent);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        this.agents.remove(this.selectedAgent);
        this.selectedAgent = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedAgents.size();
            return size > 1 ? size + " agents sélectionnés" : "1 agent sélectionné";
        }

        return "Supprimer";
    }

    public boolean hasSelectedProducts() {
        return this.selectedAgents != null && !this.selectedAgents.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.agents.removeAll(this.selectedAgents);
        this.selectedAgents = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agents Supprimés"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtAgents').clearFilters()");
    }

}
