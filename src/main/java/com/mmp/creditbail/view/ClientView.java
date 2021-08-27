
package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Client;
import com.mmp.creditbail.service.ContratService;
import com.mmp.creditbail.service.ClientService;
import org.primefaces.PrimeFaces;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Named
@ViewScoped
public class ClientView implements Serializable {
    
    private List<Client> clients;

    private Client selectedClient;

    private List<Client> selectedClients;

    @Inject
    private ClientService clientService;

    @Inject
    private ContratService contratService;

    @PostConstruct
    public void init() {
        this.clients = this.clientService.getClients();
    }
    
    public List<Client> getClients() {
        return clients;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public List<Client> getSelectedClients() {
        return selectedClients;
    }

    public void setSelectedClients(List<Client> selectedClients) {
        this.selectedClients = selectedClients;
    }

    public void openNew() {
        this.selectedClient = new Client();
    }

    public void saveClient() {
        if (this.selectedClient.getCode() == null) {
            this.selectedClient.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.clients.add(this.selectedClient);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Client Ajouté"));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Client Mis à Jour"));
        }
        
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteClient() {
        this.clients.remove(this.selectedClient);
        this.selectedClient = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Client Supprimé"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedClients.size();
            return size > 1 ? size + " clients sélectionnés" : "1 client sélectionné";
        }

        return "Supprimer";
    }

    public boolean hasSelectedProducts() {
        return this.selectedClients != null && !this.selectedClients.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.clients.removeAll(this.selectedClients);
        this.selectedClients = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void onRowToggle(ToggleEvent event) {
        if (event.getVisibility() == Visibility.VISIBLE) {
            Client product = (Client) event.getData();
            if (product.getContrats() == null) {
                product.setContrats(contratService.getContrats((int) (Math.random() * 7)));
            }
        }
    }
}
