package com.mmp.creditbail.view;

import com.mmp.creditbail.beans.Demande;
import com.mmp.creditbail.service.DemandeService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@Named
@ViewScoped
public class SelectionView implements Serializable {

    private List<Demande> products1;
    private Demande selectedProduct;
    private List<Demande> selectedProducts;

    @Inject
    private DemandeService service;

    @PostConstruct
    public void init() {
        products1 = service.getProducts(10);
    }

    public List<Demande> getProducts1() {
        return products1;
    }

    public void setService(DemandeService service) {
        this.service = service;
    }

    public Demande getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Demande selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Demande> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Demande> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public void onRowSelect(SelectEvent<Demande> event) {
        FacesMessage msg = new FacesMessage("Product Selected", String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent<Demande> event) {
        FacesMessage msg = new FacesMessage("Product Unselected", String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
