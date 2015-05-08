/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.web.controller;

import com.ssl.sipt.api.model.Item;
import com.ssl.sipt.api.model.Lista;
import com.ssl.sipt.api.service.LPServiceInterface;
import com.ssl.sipt.api.service.exception.ServiceException;
import com.ssl.sipt.web.util.NavEnum;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
@Named
@ViewScoped
public class LpController extends AbstractController {

    private static final Logger LOG = LoggerFactory.getLogger(LpController.class);

    @EJB
    private LPServiceInterface listasService;
    private List<Lista> listLP;
    private Lista selectedLP;
    private Item selectedItem;
    private List<Item> listItems;
    private boolean editable;
    private NavEnum optionNavEnum;

    @PostConstruct
    public void initialize() {
        LOG.trace("method: initialize()");
        optionNavEnum = NavEnum.LIST;
        setSelectedItem(null);
        setEditable(false);
        setSelectedItem(null);
        setSelectedLP(null);
        loadListLP();
    }

    public void loadListLP() {
        LOG.trace("method: loadListLP()");
        try {
            setListLP(listasService.findAll());
        } catch (ServiceException ex) {
            LOG.error("Error in method: loadListLP()", ex);
        }
    }

    public void loadListItems() {
        LOG.trace("method: loadList()");
        try {
            setListItems(listasService.findByParent(getSelectedLP().getId()));
        } catch (ServiceException ex) {
            LOG.error("Error in method: loadList()", ex);
        }
    }

    private void initializeEdit() {
        LOG.trace("method: initializeEdit()");
        setEditable(true);
    }

    public void onCreate() {
        LOG.trace("method: onCreate()");
        optionNavEnum = NavEnum.DETAILS;
        setSelectedItem(new Item());
        initializeEdit();
    }

    public void onRowSelect(SelectEvent event) {
        LOG.trace("method: onRowSelect()");
        setSelectedItem((Item) event.getObject());
        setEditable(false);
        optionNavEnum = NavEnum.DETAILS;
    }

    public void onEdit() {
        LOG.trace("method: onEdit()");
        initializeEdit();
    }

    public void onDelete() {
        LOG.trace("method: onDelete()");
        try {
            listasService.delete(getSelectedItem());
            initialize();
        } catch (ServiceException ex) {
            LOG.error("Error in method: onDelete()", ex);
        }
    }

    public void onSave() {
        LOG.trace("method: onSave()");
        try {
            if (getSelectedItem().getId() == null) {
                listasService.create(getSelectedItem());
            } else {
                listasService.update(getSelectedItem());
            }
            setEditable(false);
        } catch (ServiceException ex) {
            LOG.error("Error en <<onSave>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
        }
    }

    public void onCancel() {
        LOG.trace("method: onCancel()");
        if (getSelectedItem() != null && getSelectedItem().getId() != null) {
            setEditable(false);
        } else {
            optionNavEnum = NavEnum.LIST;
        }
    }

    public void onBack() {
        LOG.trace("method: onBack()");
        initialize();
    }

    public boolean isShowList() {
        boolean showList = (optionNavEnum == NavEnum.LIST);
        return showList;
    }

    public boolean isShowDetails() {
        boolean showDetails = (optionNavEnum == NavEnum.DETAILS);
        return showDetails;
    }

    public boolean isNewRecord() {
        boolean newRecord = (getSelectedItem() != null && getSelectedItem().getId() == null);
        return newRecord;
    }

    /**
     * @return the listLP
     */
    public List<Lista> getListLP() {
        return listLP;
    }

    /**
     * @param listLP the listLP to set
     */
    public void setListLP(List<Lista> listLP) {
        this.listLP = listLP;
    }

    /**
     * @return the selectedLP
     */
    public Lista getSelectedLP() {
        return selectedLP;
    }

    /**
     * @param selectedLP the selectedLP to set
     */
    public void setSelectedLP(Lista selectedLP) {
        this.selectedLP = selectedLP;
    }

    /**
     * @return the selectedItem
     */
    public Item getSelectedItem() {
        return selectedItem;
    }

    /**
     * @param selectedItem the selectedItem to set
     */
    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    /**
     * @return the listItems
     */
    public List<Item> getListItems() {
        return listItems;
    }

    /**
     * @param listItems the listItems to set
     */
    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
