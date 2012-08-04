Ext.Loader.setConfig({
	enabled : true
});

Ext.Loader.setPath('Ext.ux', 'ext4/ux/');

Ext.require([ 'Ext.ux.data.PagingMemoryProxy', 'Ext.ux.ProgressBarPager' ]);

Ext.onReady(function() {

	// 0 : add ; 1: modify; 2: view
	var state = 0;
	// register model
	Ext.define('Cpxxk', {
		extend : 'Ext.data.Model',
		idProperty : 'id',
		fields : [ {
			name : 'id',
			type : 'long'
		}, {
			name : 'productId',
			type : 'long'
		}, {
			name : 'desc'
		}, {
			name : 'innerQty',
			type : 'double'
		}, {
			name : 'cartonQty',
			type : 'double'
		}, {
			name : 'packingInfo'
		}, {
			name : 'innerSize'
		}, {
			name : 'cartonSize'
		}, {
			name : 'fcl20',
			type : 'double'
		}, {
			name : 'fcl40',
			type : 'double'
		}, {
			name : 'hq40',
			type : 'double'
		}, {
			name : 'price'
		}, {
			name : 'pict'
		} ]
	});

	// create the data store
	var store = Ext.create('Ext.data.Store', {
		autoDestroy : true,
		model : 'Cpxxk',
		pageSize : appVar.pageSize,
		autoLoad : true,
		baseParams : {
			max : appVar.pageSize
		},
		proxy : {
			type : 'ajax',
			url : 'cpxxk/list',
			method : 'GET',
			reader : {
				type : 'json',
				totalProperty : 'total',
				root : 'items'
			}
		}
	});

	var toolbar = Ext.create('Ext.Toolbar', [ {
		text : '新增',
		iconCls : 'add'
	}, '-', {
		text : '修改',
		iconCls : 'option'
	}, '-', {
		text : '删除',
		iconCls : 'remove'
	} ]);

	var bbar = Ext.create('Ext.PagingToolbar', {
		pageSize : appVar.pageSize,
		store : store,
		displayInfo : true,
		plugins : Ext.create('Ext.ux.ProgressBarPager', {})
	})

	var sm = Ext.create('Ext.selection.CheckboxModel');

	var selModel = Ext.create('Ext.selection.CheckboxModel', {
		listeners : {
			selectionchange : function(sm, selections) {
				grid.down('#removeButton').setDisabled(selections.length == 0);
				grid.down('#optionButton').setDisabled(selections.length != 1);
			}
		}
	});

	// 获取选中的行
	function getSelIdList() {
		var recs = selModel.getSelection();
		var list = [];
		for ( var i = 0; i < recs.length; i++) {
			list.push(recs[i].get('id'));
		}
		return list;
	}

	var grid = Ext.create('Ext.grid.GridPanel', {
		// renderTo : 'gridPanel',
		frame : false,
		store : store,
		height : 500,
		selModel : selModel,
		columnLines : true,
		columns : [ {
			text : "id",
			dataIndex : 'id',
			sortable : false
		}, {
			text : "货号",
			dataIndex : 'productId',
			sortable : false
		}, {
			text : "产品描述",
			dataIndex : 'desc',
			sortable : true
		}, {
			text : "内盒装箱率",
			dataIndex : 'innerQty',
			sortable : true
		}, {
			text : "外箱装箱率",
			dataIndex : 'cartonQty',
			sortable : true
		}, {
			text : "包装信息",
			dataIndex : 'packingInfo',
			sortable : true
		}, {
			text : "内盒尺寸",
			dataIndex : 'innerSize',
			sortable : true
		}, {
			text : "外箱尺寸",
			dataIndex : 'cartonSize',
			sortable : true
		}, {
			text : "FCL20装柜量",
			dataIndex : 'fcl20',
			sortable : true
		}, {
			text : "FCL40装柜量",
			dataIndex : 'fcl40',
			sortable : true
		}, {
			text : "HQ40装柜量",
			dataIndex : 'hq40',
			sortable : true
		}, {
			text : "单价",
			dataIndex : 'price',
			sortable : false
		}, {
			text : "pict",
			dataIndex : 'pict',
			sortable : false
		} ],
		dockedItems : [ {
			xtype : 'toolbar',
			dock : 'top',
			items : [ {
				xtype : 'button',
				text : '添加',
				tooltip : '添加产品信息',
				iconCls : 'add',
				handler : showAdd
			}, '-', {
				xtype : 'button',
				itemId : 'optionButton',
				text : '修改',
				tooltip : '修改选择的产品信息',
				iconCls : 'option',
				disabled : true,
				handler : showModify
			}, '-', {
				itemId : 'removeButton',
				xtype : 'button',
				text : '删除',
				tooltip : '删除选择的产品信息',
				iconCls : 'remove',
				disabled : true,
				handler : handleDel
			}, '->', {
				xtype : "label",
				text : "输入关键字："
			}, {
				xtype : "textfield",
				id : "q"
			}, {
				text : "搜索",
				iconCls : 'search'
			} ]
		}, {
			xtype : 'pagingtoolbar',
			id : 'pt',
			store : store, // 分页store与grid一致
			dock : 'bottom',
			displayInfo : true,
			plugins : Ext.create('Ext.ux.ProgressBarPager', {})
		} ],

		listeners : {
			itemdblclick : function(view, record, item, index, e) {
				showDetail()
			}
		}
	});

	grid.render('gridPanel')

	var formPanel = Ext.create('Ext.form.Panel', {
		// renderTo : 'gridPanel',
		id : 'formPanel',
		frame : true,
		// title: '产品信息库',
		bodyStyle : 'padding:5px 5px 0',
		width : 600,
		fieldDefaults : {
			labelAlign : 'left',
			msgTarget : 'side',
			labelWidth : 80
		},

		items : [{
			xtype : 'container',
			anchor : '100%',
			layout : 'column',
			items : [ {
				xtype : 'container',
				columnWidth : .3,
				layout : 'anchor',
				items : [ {
					xtype : 'box', // 或者xtype: 'component',
					fieldLabel : '图片预览',
					id : 'photoImg',
					anchor : '90%', // 图片宽度
					height : 270,
					autoEl : {
						tag : 'img', // 指定为img标签
						src : 'myphoto.gif' // 指定url路径
					}
				}, {
					xtype : 'filefield',
					id : 'pict_file',
					emptyText : '选择图片上传',
					fieldLabel : '产品图片',
					name : 'pict_file',
					anchor : '90%',
					buttonText : '',
					labelAlign : 'left',
					labelWidth : 60,
					buttonConfig : {
						iconCls : 'upload-icon'
					}
				// listeners : {
				// 'render' : function() {
				// var logoFileCmp = Ext.get('pict');
				// logoFileCmp.on('change', function(field, newValue,
				// oldValue) {
				// var picPath = logoFileCmp.getValue();
				// var url = 'file:///' + picPath;
				// if (Ext.isIE) {
				// var image = Ext.get('logoPic').dom;
				// image.src = Ext.BLANK_IMAGE_URL;
				// image.filters
				// .item("DXImageTransform.Microsoft.AlphaImageLoader").src =
				// url;
				// } else {
				// // 支持FF
				// alert(this)
				// alert(this.files)
				// Ext.get('logoPic').dom.src = this.files.item(0)
				// .getAsDataURL();
				// }
				// }, this);
				// }
				// }
				} ]
			}, {
				xtype : 'container',
				columnWidth : .7,
				layout : 'anchor',
				items : [ {
					xtype : 'hiddenfield',
					name : 'id'
				},{
					xtype : 'textfield',
					fieldLabel : '货号',
					name : 'productId',
					anchor : '48%',
					allowBlank : false

				}, {
					xtype : 'textarea',
					fieldLabel : '产品描述',
					anchor : '98%',
					name : 'desc'
				}, {
					xtype : 'textarea',
					fieldLabel : '包装信息',
					anchor : '98%',
					name : 'packingInfo'
				}, {
					xtype : 'container',
					anchor : '100%',
					layout : 'column',
					items : [ {
						xtype : 'container',
						columnWidth : .5,
						layout : 'anchor',
						items : [ {
							xtype : 'numberfield',
							fieldLabel : '内盒装箱率',
							name : 'innerQty',
							anchor : '96%'
						}, {
							xtype : 'textfield',
							fieldLabel : '内盒尺寸',
							name : 'innerSize',
							anchor : '96%'
						}, {
							xtype : 'numberfield',
							fieldLabel : 'FCL20装柜量',
							name : 'fcl20',
							anchor : '96%'
						}, {
							xtype : 'numberfield',
							fieldLabel : 'HQ40装柜量',
							name : 'hq40',
							anchor : '96%'
						} ]
					}, {
						xtype : 'container',
						columnWidth : .5,
						layout : 'anchor',
						items : [ {
							xtype : 'numberfield',
							fieldLabel : '外箱装箱率',
							name : 'cartonQty',
							anchor : '100%'
						}, {
							xtype : 'textfield',
							fieldLabel : '外箱尺寸',
							name : 'cartonSize',
							anchor : '100%'
						}, {
							xtype : 'numberfield',
							fieldLabel : 'FCL40装柜量',
							name : 'fcl40',
							anchor : '100%'
						}, {
							xtype : 'numberfield',
							fieldLabel : '单价',
							name : 'price',
							anchor : '100%'
						} ]
					} ]
				} ]
			} ]
		} ],
		buttons : [ {
			text : '保存',
			id : 'saveButton',
			handler : function() {
				var form = this.up('form').getForm();
				if (form.isValid()) {
					if (state == 0) {
						form.submit({
							url : 'cpxxk/save',
							waitMsg : '正在处理...',
							success : function(fp, msg) {
								store.load();
								Ext.MessageBox.alert('提示', '操作成功...')
								win.hide();
							},
							failure : function(fp, msg) {
								Ext.MessageBox.alert('提示', '操作失败...')
							}
						});
					}

					if (state == 1) {
						form.submit({
							url : 'cpxxk/update',
							waitMsg : '正在处理...',
							success : function(fp, msg) {
								store.load();
								Ext.MessageBox.alert('提示', '操作成功...')
								win.hide();
							},
							failure : function(fp, msg) {
								Ext.MessageBox.alert('提示', '操作失败...')
							}
						});
					}
				}
			}
		}, {
			text : '重置',
			id : 'resetButton',
			handler : function() {
				if (state == 0) {
					this.up('form').getForm().reset();
				}
				if (state == 1) {
					showModify()
				}

			}
		}, {
			text : '关闭',
			handler : function() {
				this.up('window').hide();
			}
		} ]
	});

	// 创建弹出窗口
	var win = new Ext.Window({
		layout : 'fit',
		width : 800,
		closeAction : 'hide',
		height : 400,
		resizable : false,
		shadow : true,
		modal : true,
		closable : true,
		bodyStyle : 'padding:5 5 5 5',
		animCollapse : true,
		items : [ formPanel ]
	});

	function resetForm() {
		// alert(formPanel == Ext.getCmp('formPanel'))
		// formPanel.getForm().reset()
	}

	function showAdd() {
		state = 0
		win.setTitle("添加产品信息");
		Ext.getCmp('saveButton').show()
		Ext.getCmp('resetButton').show()
		win.show();
		formPanel.getForm().reset()
		Ext.getCmp("photoImg").el.dom.src = ''
	}

	// 显示修改窗口
	function showModify() {
		state = 1
		var ids = getSelIdList();
		var num = ids.length;
		if (1 == num) {
			win.setTitle("修改产品信息");
			Ext.getCmp('saveButton').show()
			Ext.getCmp('resetButton').show()
			win.show();
			loadForm(ids[0]);
		} else {
			Ext.MessageBox.alert("提示", "请选择一条记录进行修改！")
		}
	}

	// 显示修改窗口
	function showDetail() {
		state = 2
		var ids = getSelIdList();
		var num = ids.length;
		if (1 == num) {
			win.setTitle("查看产品信息");
			win.show();
			loadForm(ids[0]);
			Ext.getCmp('saveButton').hide()
			Ext.getCmp('resetButton').hide()
		} else {
			Ext.MessageBox.alert("提示", "请选择一条记录进行修改！")
		}
	}

	function loadForm(id) {
		formPanel.form.load({
			waitMsg : '正在加载数据请稍后',
			waitTitle : '提示',
			url : "cpxxk/show/" + id,
			method : 'GET',
			success : function(form, action) {
				 Ext.getCmp("photoImg").el.dom.src = "upload/"+action.result.data.pict
			},
			failure : function(form, action) {
				Ext.Msg.alert('提示', '数据加载失败');
			}
		});
	}

	function handleDel() {
		var ids = getSelIdList();
		var num = ids.length;
		if (0 == num) {
			Ext.MessageBox.alert("提示", "请选择带删除的行");
		} else {
			Ext.MessageBox.confirm("提示", "您确定要删除 " + num + " 行数据吗？", function(
					btnId) {
				if (btnId == 'yes') {
					deleteData(ids.join(','));
				}
			})
		}
	}
	function deleteData(ids) {
		var msgTip = Ext.MessageBox.show({
			title : '提示',
			width : 250,
			msg : '正在删除信息请稍后......'
		});
		Ext.Ajax.request({
			url : 'cpxxk/delete',
			params : {
				id : ids
			},
			method : 'POST',
			success : function(response, options) {
				msgTip.hide();
				Ext.Msg.alert('提示', '删除信息成功。');
				store.load();
			},
			failure : function(response, options) {
				msgTip.hide();
				Ext.Msg.alert('提示', '删除请求失败！');
			}
		});
	}

	// grid.render('gridPanel');

});