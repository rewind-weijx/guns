/**
 * 管理初始化
 */
var Renovation = {
    id: "RenovationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    location:$("#type").val()
};

/**
 * 初始化表格的列
 */
Renovation.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '图片地址', field: 'image', visible: true, align: 'center', valign: 'middle'},
            {title: '查看次数', field: 'readCount', visible: true, align: 'center', valign: 'middle'},
            {title: '是否为热点文章', field: 'hot', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '创建人', field: 'createBy', visible: true, align: 'center', valign: 'middle'}
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
 * 点击添加
 */
Renovation.openAddRenovation = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/renovation/renovation_add/'+Renovation.location
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Renovation.openRenovationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/renovation/renovation_detail/' + Renovation.seItem.id
        });
        this.layerIndex = index;
    }
};
Renovation.openRenovationGoUpdate = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/renovation/renovation_goUpdate/' + Renovation.seItem.id
        });
        this.layerIndex = index;
    }
};
/**
 * 删除
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
 * 查询列表
 */
Renovation.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Renovation.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Renovation.initColumn();
    var table = new BSTable(Renovation.id, "/renovation/list/"+Renovation.location, defaultColunms);
    table.setPaginationType("client");
    Renovation.table = table.init();
});
