CpxxPanel = Ext.extend(Ext.form.FormPanel, {
    title: 'My Form',
    width: 643,
    height: 549,
    padding: 10,
    initComponent: function() {
        this.items = [
            {
                xtype: 'textfield',
                fieldLabel: 'Label',
                anchor: '100%'
            },
            {
                xtype: 'textarea',
                anchor: '100%',
                fieldLabel: 'Label'
            },
            {
                xtype: 'textarea',
                anchor: '100%',
                fieldLabel: 'Label'
            },
            {
                xtype: 'numberfield',
                fieldLabel: 'Label',
                anchor: '100%'
            },
            {
                xtype: 'numberfield',
                fieldLabel: 'Label',
                anchor: '100%'
            }
        ];
        MyFormUi.superclass.initComponent.call(this);
    }
});