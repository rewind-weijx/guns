/**
 * 管理初始化
 */
var Contact = {
    id: "ContactTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Contact.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '手机', field: 'mobile', visible: true, align: 'center', valign: 'middle'},
            {title: '留言', field: 'description', visible: true, align: 'center', valign: 'middle'},
            {title: '阅读状态', field: 'statusName', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Contact.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
    	Contact.seItem = selected[0];
        return true;
    }
};


/**
 * 打开查看详情
 */
Contact.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/contact/detail/' + Contact.seItem.id
        });
        this.layerIndex = index;
    }
};
Contact.read = function(){
	 if (this.check()) {
	        var ajax = new $ax(Feng.ctxPath + "/contact/read", function (data) {
	            Feng.success("操作成功!");
	            Contact.table.refresh();
	        }, function (data) {
	            Feng.error("操作失败!" + data.responseJSON.message + "!");
	        });
	        ajax.set("id",this.seItem.id);
	        ajax.start();
	    }
}
/**
 * 删除
 */
Contact.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/contact/delete", function (data) {
            Feng.success("删除成功!");
            Contact.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
Contact.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Contact.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Contact.initColumn();
    var table = new BSTable(Contact.id, "/contact/list/", defaultColunms);
    table.setPaginationType("client");
    Contact.table = table.init();
});
