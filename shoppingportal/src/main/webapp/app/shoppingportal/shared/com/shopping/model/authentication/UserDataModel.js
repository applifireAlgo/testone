Ext.define('Shoppingportal.shoppingportal.shared.com.shopping.model.authentication.UserDataModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userDataId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "password",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "oneTimePassword",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "oneTimePasswordExpiry",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "oneTimePasswordGenDate",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "last5Passwords",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "User",
          "reference": "UserModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});