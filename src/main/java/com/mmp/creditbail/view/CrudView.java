package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Materiel;
import com.mmp.creditbail.service.MaterielService;
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
public class CrudView implements Serializable {

    private List<Materiel> products;

    private Materiel selectedMateriel;

    private List<Materiel> selectedMateriels;

    @Inject
    private MaterielService materielService;

    @PostConstruct
    public void init() {
        this.products = this.materielService.getClonedProducts(100);
    }

    public List<Materiel> getProducts() {
        return products;
    }

    public Materiel getSelectedMateriel() {
        return selectedMateriel;
    }

    public void setSelectedMateriel(Materiel selectedMateriel) {
        this.selectedMateriel = selectedMateriel;
    }

    public List<Materiel> getSelectedMateriels() {
        return selectedMateriels;
    }

    public void setSelectedMateriels(List<Materiel> selectedMateriels) {
        this.selectedMateriels = selectedMateriels;
    }

    public void openNew() {
        this.selectedMateriel = new Materiel();
    }

    public void saveProduct() {
        if (this.selectedMateriel.getCode() == null) {
            this.selectedMateriel.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.products.add(this.selectedMateriel);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        this.products.remove(this.selectedMateriel);
        this.selectedMateriel = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedMateriels.size();
            return size > 1 ? size + " matériels sélectionnés" : "1 matériel sélectionné";
        }

        return "Supprimer";
    }

    public boolean hasSelectedProducts() {
        return this.selectedMateriels != null && !this.selectedMateriels.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.products.removeAll(this.selectedMateriels);
        this.selectedMateriels = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtMateriels').clearFilters()");
    }

}
