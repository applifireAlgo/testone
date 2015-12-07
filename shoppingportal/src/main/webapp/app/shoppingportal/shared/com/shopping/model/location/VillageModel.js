Ext.define('Shoppingportal.shoppingportal.shared.com.shopping.model.location.VillageModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "villageId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "villageName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "villageDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "villageFlag",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "countryid",
          "reference": "Country",
          "defaultValue": ""
     }, {
          "name": "stateid",
          "reference": "State",
          "defaultValue": ""
     }, {
          "name": "regionid",
          "reference": "Region",
          "defaultValue": ""
     }, {
          "name": "districtid",
          "reference": "District",
          "defaultValue": ""
     }, {
          "name": "talukaaid",
          "reference": "Taluka",
          "defaultValue": ""
     }, {
          "name": "villageCode",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "villageLatitude",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "villageLongtitude",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});