Ext.require(['*']);

//Ext.BLANK_IMAGE_URL = 'ext4/resources/images/default/s.gif';
// Ext.form.Field.prototype.msgTarget = 'side';

appVar = {
	pageSize : 20
}

Ext.onReady(function() {
			Ext.QuickTips.init();

			Ext.state.Manager.setProvider(new Ext.state.CookieProvider());

			var viewport = Ext.create('Ext.Viewport',{
						layout : 'border',
						items : [
								// create instance immediately
								Ext.create('Ext.Component',{
											region : 'north',
											height : 60, // give north and
											// south regions a
											// height
											contentEl : 'north',
											margins : '0 0 0 0'
										}), {
											// lazily created panel
											// (xtype:'panel' is default)
											region : 'south',
											contentEl : 'south',
											height : 40,
											margins : '0 0 0 0'
										}, {
									region : 'west',
									id : 'west-panel', // see Ext.getCmp()
									// below
									title : 'Menu',
									split : true,
									width : 200,
									minSize : 175,
									maxSize : 400,
									margins : '0 0 0 5',
									layout : {
										type : 'accordion',
										animate : true
									},
									items : [{
												title : '产品信息库',
												contentEl : 'cpxx_accord',
												border : false,
												iconCls : 'nav'
											}, {
												contentEl : 'west',
												title : '我的工作流平台',
												border : false,
												iconCls : 'info' // see the HEAD
												// section for
											// style used
										}	, {
												title : '最新发起的流程',
												html : '<p>Some settings in here.</p>',
												border : false,
												iconCls : 'settings'
											}, {
												title : '个人信息管理',
												html : '<p>Some settings in here.</p>',
												border : false,
												iconCls : 'settings'
											}, {
												title : '数据管理',
												contentEl : 'tableManager',
												border : false,
												iconCls : 'nav'
											}]
								},
								Ext.create('Ext.tab.Panel', {
											id : 'centerTab',
											region : 'center', // a center
											activeTab : 0, // first tab
											// initially active
											items : [{
														contentEl : 'about',
														title : 'about',
														closable : true,
														autoScroll : true,
														autoLoad : {
															url : "cpxxk",
															scripts : true
														}
													}]
										})]
					});
		});

function opentable(arg, title) {
	var centerPanel = Ext.getCmp("centerTab")
	var tab = centerPanel.child("#"+arg)
	if (tab) {
		centerPanel.setActiveTab(tab);
	} else {
		tab = new Ext.Panel({
					title : title,
					id : arg,
					closable : true,
					autoScroll : true,
					autoLoad : {
						url : arg,
						scripts : true
					}
				})
		//centerPanel.setActiveTab(tab);
		centerPanel.add(tab).show()
	}
}
