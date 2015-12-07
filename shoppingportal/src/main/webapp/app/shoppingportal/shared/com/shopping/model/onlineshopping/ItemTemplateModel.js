Ext.define('Shoppingportal.shoppingportal.shared.com.shopping.model.onlineshopping.ItemTemplateModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "itemId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemIcon",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemPrice",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemQuantity",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "addtocart",
          "type": "auto",
          "defaultValue": ""
     }]
});