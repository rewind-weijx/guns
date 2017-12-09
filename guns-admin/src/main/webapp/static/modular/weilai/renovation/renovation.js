/**
 * 装修管理初始化
 */
var Renovation = {
    id: "RenovationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Renovation.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '装修类型：1：智能家居2：定制木门3：软装部', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '图片地址', field: 'image', visible: true, align: 'center', valign: 'middle'},
            {title: '查看次数', field: 'readCount', visible: true, align: 'center', valign: 'middle'},
            {title: '是否为热点文章：0：不是1：是', field: 'hot', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人', field: 'createBy', visible: true, align: 'center', valign: 'middle'},
            {title: '删除标志：0：正常1：已删除', field: 'delFlag', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Renovation.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Renovation.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加装修
 */
Renovation.openAddRenovation = function () {
    var index = layer.open({
        type: 2,
        title: '添加装修',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/renovation/renovation_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看装修详情
 */
Renovation.openRenovationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '装修详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/renovation/renovation_update/' + Renovation.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除装修
 */
Renovation.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/renovation/delete", function (data) {
            Feng.success("删除成功!");
            Renovation.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("renovationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询装修列表
 */
Renovation.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Renovation.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Renovation.initColumn();
    var table = new BSTable(Renovation.id, "/renovation/list", defaultColunms);
    table.setPaginationType("client");
    Renovation.table = table.init();
});
