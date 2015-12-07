Ext.define('Shoppingportal.view.mobileview.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Shoppingportal.view.mobileview.reportui.datachart.DataChartTController',
			'Shoppingportal.view.mobileview.reportui.datachart.datagrid.DataGridView','Shoppingportal.view.mobileview.reportui.datachart.chart.ChartTabView','Shoppingportal.view.mobileview.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',

	margin : '0 0 0 0',
	initComponent : function() {
		/*this.items */

		this.callParent(arguments);
	},
	listeners : {
		scope : "controller",
		tabchange : 'tabchange'
	}

});