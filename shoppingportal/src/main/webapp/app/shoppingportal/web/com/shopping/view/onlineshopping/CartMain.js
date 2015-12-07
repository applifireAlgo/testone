Ext.define('Shoppingportal.shoppingportal.web.com.shopping.view.onlineshopping.CartMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CartMainController",
     "restURL": "/Cart",
     "defaults": {
          "split": true
     },
     "requires": ["Shoppingportal.shoppingportal.shared.com.shopping.model.onlineshopping.CartModel", "Shoppingportal.shoppingportal.web.com.shopping.controller.onlineshopping.CartMainController", "Shoppingportal.shoppingportal.shared.com.shopping.model.onlineshopping.ItemModel", "Shoppingportal.shoppingportal.shared.com.shopping.model.authentication.UserModel", "Shoppingportal.shoppingportal.shared.com.shopping.viewmodel.onlineshopping.CartViewModel", "Ext.form.field.CustomDateField"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "displayName": "Cart",
               "name": "CartTreeContainer",
               "itemId": "CartTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "CartTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "layout": "fit",
                    "autoScroll": false,
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick"
                    }],
                    "items": [{
                         "name": "itemId",
                         "itemId": "itemId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "itemId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "itemId",
                         "fieldId": "784450C1-4048-424D-91E7-286C2772F903",
                         "restURL": "Item",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingportal.shoppingportal.shared.com.shopping.model.onlineshopping.ItemModel"
                         }
                    }, {
                         "name": "itemName",
                         "itemId": "itemName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "9B83296C-F8AE-4544-957F-706A4935648B",
                         "minLength": "0",
                         "maxLength": "256"
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Price",
                         "fieldId": "A0DB4F01-53C5-481F-99D5-1CC9F94EDBE2",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000"
                    }, {
                         "name": "itemQuantity",
                         "itemId": "itemQuantity",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Quantity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Quantity",
                         "fieldId": "21926414-5014-4598-B367-F87CB2567C19",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647"
                    }, {
                         "name": "subTotal",
                         "itemId": "subTotal",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sub Total",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sub Total",
                         "fieldId": "2E4E4381-9FAA-4CA8-9C86-C98F6E0C3FD3",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "xtype": "form",
                    "displayName": "Cart",
                    "name": "Cart",
                    "itemId": "CartForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "itemId",
                                   "itemId": "itemId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "itemId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "itemId<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "784450C1-4048-424D-91E7-286C2772F903",
                                   "restURL": "Item",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Shoppingportal.shoppingportal.shared.com.shopping.model.onlineshopping.ItemModel"
                                   },
                                   "forceSelection": true,
                                   "columnWidth": 0.5,
                                   "bind": "{itemId}"
                              }, {
                                   "name": "itemName",
                                   "itemId": "itemName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Name",
                                   "fieldId": "9B83296C-F8AE-4544-957F-706A4935648B",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "columnWidth": 0.5,
                                   "bind": "{itemName}"
                              }, {
                                   "name": "itemPrice",
                                   "itemId": "itemPrice",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Price",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Price",
                                   "fieldId": "A0DB4F01-53C5-481F-99D5-1CC9F94EDBE2",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "columnWidth": 0.5,
                                   "bind": "{itemPrice}"
                              }, {
                                   "name": "itemQuantity",
                                   "itemId": "itemQuantity",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Quantity",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Quantity<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "21926414-5014-4598-B367-F87CB2567C19",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "columnWidth": 0.5,
                                   "bind": "{itemQuantity}"
                              }, {
                                   "name": "subTotal",
                                   "itemId": "subTotal",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sub Total",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sub Total",
                                   "fieldId": "2E4E4381-9FAA-4CA8-9C86-C98F6E0C3FD3",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "columnWidth": 0.5,
                                   "bind": "{subTotal}"
                              }, {
                                   "name": "userId",
                                   "itemId": "userId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "User",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "User",
                                   "fieldId": "FEB30B9A-79B6-47D9-AEEC-E157D3986C6E",
                                   "restURL": "User",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Shoppingportal.shoppingportal.shared.com.shopping.model.authentication.UserModel"
                                   },
                                   "columnWidth": 0.5,
                                   "bind": "{userId}"
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "viewModel": "CartViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Cart",
                    "title": "Details Grid",
                    "name": "CartGrid",
                    "itemId": "CartGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "cartId",
                         "dataIndex": "cartId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "itemId",
                         "dataIndex": "itemId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Name",
                         "dataIndex": "itemName",
                         "flex": 1
                    }, {
                         "header": "Price",
                         "dataIndex": "itemPrice",
                         "flex": 1
                    }, {
                         "header": "Quantity",
                         "dataIndex": "itemQuantity",
                         "flex": 1
                    }, {
                         "header": "Sub Total",
                         "dataIndex": "subTotal",
                         "flex": 1
                    }, {
                         "header": "User",
                         "dataIndex": "userId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "xtype": "form",
               "displayName": "Cart",
               "name": "Cart",
               "itemId": "CartForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "itemId",
                              "itemId": "itemId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "itemId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "itemId<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "784450C1-4048-424D-91E7-286C2772F903",
                              "restURL": "Item",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Shoppingportal.shoppingportal.shared.com.shopping.model.onlineshopping.ItemModel"
                              },
                              "forceSelection": true,
                              "columnWidth": 0.5,
                              "bind": "{itemId}"
                         }, {
                              "name": "itemName",
                              "itemId": "itemName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Name",
                              "fieldId": "9B83296C-F8AE-4544-957F-706A4935648B",
                              "minLength": "0",
                              "maxLength": "256",
                              "columnWidth": 0.5,
                              "bind": "{itemName}"
                         }, {
                              "name": "itemPrice",
                              "itemId": "itemPrice",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Price",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Price",
                              "fieldId": "A0DB4F01-53C5-481F-99D5-1CC9F94EDBE2",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "columnWidth": 0.5,
                              "bind": "{itemPrice}"
                         }, {
                              "name": "itemQuantity",
                              "itemId": "itemQuantity",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Quantity",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Quantity<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "21926414-5014-4598-B367-F87CB2567C19",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "columnWidth": 0.5,
                              "bind": "{itemQuantity}"
                         }, {
                              "name": "subTotal",
                              "itemId": "subTotal",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sub Total",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sub Total",
                              "fieldId": "2E4E4381-9FAA-4CA8-9C86-C98F6E0C3FD3",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "columnWidth": 0.5,
                              "bind": "{subTotal}"
                         }, {
                              "name": "userId",
                              "itemId": "userId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "User",
                              "margin": "5 5 5 5",
                              "fieldLabel": "User",
                              "fieldId": "FEB30B9A-79B6-47D9-AEEC-E157D3986C6E",
                              "restURL": "User",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Shoppingportal.shoppingportal.shared.com.shopping.model.authentication.UserModel"
                              },
                              "columnWidth": 0.5,
                              "bind": "{userId}"
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "viewModel": "CartViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});