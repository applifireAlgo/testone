Ext.define('Shoppingportal.shoppingportal.web.com.shopping.view.contacts.ContactTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ContactTypeMainController",
     "restURL": "/ContactType",
     "defaults": {
          "split": true
     },
     "requires": ["Shoppingportal.shoppingportal.shared.com.shopping.model.contacts.ContactTypeModel", "Shoppingportal.shoppingportal.web.com.shopping.controller.contacts.ContactTypeMainController", "Shoppingportal.shoppingportal.shared.com.shopping.viewmodel.contacts.ContactTypeViewModel", "Ext.form.field.CustomDateField"],
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
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Contact Type",
               "name": "ContactTypeTreeContainer",
               "itemId": "ContactTypeTreeContainer",
               "restURL": "/ContactType",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "ContactTypeTree",
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
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "contactType",
                         "itemId": "contactType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type",
                         "fieldId": "7E253693-E246-44F1-8EE7-13FE5BDFD981",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter contact type"
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
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "ContactTypeViewModel",
                    "xtype": "form",
                    "displayName": "Contact Type",
                    "title": "Contact Type",
                    "name": "ContactType",
                    "itemId": "ContactType",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "contactType",
                         "itemId": "contactType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7E253693-E246-44F1-8EE7-13FE5BDFD981",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter contact type",
                         "bind": "{contactType}",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactTypeDesc",
                         "itemId": "contactTypeDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Contact Type Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Description",
                         "fieldId": "AF128CFE-EDD2-402D-8C26-A4B83D87C97F",
                         "bind": "{contactTypeDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactTypeIcon",
                         "itemId": "contactTypeIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Icon",
                         "fieldId": "779F3A18-DA62-430E-9BA1-D54ABFAB9539",
                         "minLength": "0",
                         "maxLength": "128",
                         "bind": "{contactTypeIcon}",
                         "columnWidth": 0.5
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 552,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 552,
                              "customId": 348
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 552,
                              "customId": 349,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 552,
                              "customId": 350,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Contact Type",
                    "title": "Details Grid",
                    "name": "ContactTypeGrid",
                    "itemId": "ContactTypeGrid",
                    "restURL": "/ContactType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Contact Type Id",
                         "dataIndex": "contactTypeId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Contact Type",
                         "dataIndex": "contactType",
                         "flex": 1
                    }, {
                         "header": "Contact Type Description",
                         "dataIndex": "contactTypeDesc",
                         "flex": 1
                    }, {
                         "header": "Contact Type Icon",
                         "dataIndex": "contactTypeIcon",
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
               "customWidgetType": "vdFormpanel",
               "viewModel": "ContactTypeViewModel",
               "xtype": "form",
               "displayName": "Contact Type",
               "title": "Contact Type",
               "name": "ContactType",
               "itemId": "ContactType",
               "bodyPadding": 10,
               "items": [{
                    "name": "contactType",
                    "itemId": "contactType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7E253693-E246-44F1-8EE7-13FE5BDFD981",
                    "minLength": "0",
                    "maxLength": "128",
                    "errorMessage": "Please enter contact type",
                    "bind": "{contactType}",
                    "columnWidth": 0.5
               }, {
                    "name": "contactTypeDesc",
                    "itemId": "contactTypeDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Contact Type Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Description",
                    "fieldId": "AF128CFE-EDD2-402D-8C26-A4B83D87C97F",
                    "bind": "{contactTypeDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "contactTypeIcon",
                    "itemId": "contactTypeIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Icon",
                    "fieldId": "779F3A18-DA62-430E-9BA1-D54ABFAB9539",
                    "minLength": "0",
                    "maxLength": "128",
                    "bind": "{contactTypeIcon}",
                    "columnWidth": 0.5
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 552,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 552,
                         "customId": 348
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 552,
                         "customId": 349,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 552,
                         "customId": 350,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});