Ext.define('Shoppingportal.shoppingportal.web.com.shopping.view.onlineshopping.ItemTemplate', {
     "xtype": "itemTemplate",
     "items": [{
          "xtype": "hiddenfield",
          "fieldLabel": "itemId",
          "bindable": "itemId",
          "margin": 5,
          "name": "itemId",
          "itemId": "efhhhai",
          "bind": "{itemId}"
     }, {
          "xtype": "displayfield",
          "fieldLabel": "Name",
          "margin": 5,
          "bindable": "itemName",
          "name": "itemName",
          "itemId": "cdjbbmi",
          "bind": "{itemName}"
     }, {
          "xtype": "image",
          "name": "itemIcon",
          "height": 100,
          "width": 100,
          "border": true,
          "margin": 5,
          "bindable": "itemIcon",
          "itemId": "adonkhi",
          "bind": {
               "src": "{itemIcon}"
          }
     }, {
          "xtype": "displayfield",
          "fieldLabel": "Price",
          "margin": 5,
          "bindable": "itemPrice",
          "name": "itemPrice",
          "itemId": "jkagjli",
          "bind": "{itemPrice}"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Quantity",
          "name": "itemQuantity",
          "margin": 5,
          "bindable": "itemQuantity",
          "itemId": "lbjhcfi",
          "bind": "{itemQuantity}"
     }, {
          "xtype": "button",
          "text": "Add To Cart",
          "isSubmitBtn": true,
          "margin": 5,
          "name": "addtocart",
          "itemId": "lmekdfi",
          "listeners": {
               "click": "onaddtocartclick"
          }
     }],
     "margin": 5,
     "border": true,
     "autoScroll": true,
     "title": "Panel",
     "itemId": "hnmhbmi",
     "dockedItems": [],
     "extend": "Ext.panel.Panel",
     "requires": ["Shoppingportal.shoppingportal.web.com.shopping.controller.onlineshopping.ItemTemplateController", "Shoppingportal.shoppingportal.shared.com.shopping.viewmodel.onlineshopping.ItemTemplateViewModel", "Shoppingportal.shoppingportal.shared.com.shopping.model.onlineshopping.ItemTemplateModel"],
     "viewModel": "ItemTemplateViewModel",
     "controller": "ItemTemplateController"
});