Ext.define('Shoppingportal.shoppingportal.web.com.shopping.view.onlineshopping.ItemCatalogue', {
     "xtype": "itemCatalogue",
     "name": "itemcatalogue",
     "items": [{
          "xtype": "listViewBaseView",
          "name": "itemlist",
          "items": [],
          "isListPanel": true,
          "autoScroll": true,
          "border": false,
          "layout": "column",
          "defaults": {
               "columnWidth": "1.0"
          },
          "templateConfig": {
               "uiId": "64946CE8-30DA-45FE-9293-BEBDAD248296",
               "uiClass": "Shoppingportal.shoppingportal.web.com.shopping.view.onlineshopping.ItemTemplate",
               "uiType": 2,
               "url": "secure/Item/findAll",
               "requestMethodType": "GET"
          },
          "title": "Item List",
          "padding": 0,
          "margin": 5,
          "itemId": "ngbgiai",
          "dockedItems": []
     }],
     "border": true,
     "title": "Item Catalogue",
     "margin": 5,
     "itemId": "ekbmhci",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "layout": "fit",
     "requires": ["Shoppingportal.shoppingportal.web.com.shopping.controller.onlineshopping.ItemCatalogueController", "Shoppingportal.shoppingportal.shared.com.shopping.viewmodel.onlineshopping.ItemCatalogueViewModel", "Shoppingportal.shoppingportal.shared.com.shopping.model.onlineshopping.ItemCatalogueModel", "Shoppingportal.view.fw.component.ListViewBaseView"],
     "viewModel": "ItemCatalogueViewModel",
     "controller": "ItemCatalogueController"
});