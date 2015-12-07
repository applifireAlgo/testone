Ext.define('Shoppingportal.view.mobileview.reportui.datachart.DataChartViewPanel', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Shoppingportal.view.mobileview.reportui.datachart.DataChartPController',
			'Shoppingportal.view.mobileview.reportui.datachart.datagrid.DataGridView',
			'Shoppingportal.view.mobileview.reportui.datachart.chart.ChartTabView',
			'Shoppingportal.view.mobileview.reportui.datachart.ChartPointView' ],
	controller : 'datachartpController',
	xtype : 'datachart-panel',
	itemId : 'datachart-tabpanel',
	viewType : "panel",
	bodyStyle : 'background:#D8D8D8',

	margin : '0 0 0 0',
	autoScroll : true,
	// layout : 'fit',
	layout : {
		type : 'accordion',
		padding : 0,
		align : 'stretch',
   		multi : true,
   		titleCollapse: false
	},
	initComponent : function() {
		
		this.callParent(arguments);
	},
	listeners : {
		scope : "controller",
		tabchange : 'tabchange'
	}

});