/**
 * 初始化装修详情对话框
 */
var RenovationInfoDlg = {
    renovationInfoData : {}
};

/**
 * 清除数据
 */
RenovationInfoDlg.clearData = function() {
    this.renovationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RenovationInfoDlg.set = function(key, val) {
    this.renovationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RenovationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RenovationInfoDlg.close = function() {
    parent.layer.close(window.parent.Renovation.layerIndex);
}

/**
 * 收集数据
 */
RenovationInfoDlg.collectData = function() {
    this
    .set('id')
    .set('type')
    .set('title')
    .set('content')
    .set('image')
    .set('readCount')
    .set('hot')
    .set('createTime')
    .set('createBy')
    ;
}

/**
 * 提交添加
 */
RenovationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    $.ajax({
    	url:Feng.ctxPath + "/renovation/add",
    	type:"post",
    	async:false,
    	dataType:"json",
    	data:$("#form").serialize(),
    	success:function(json){
    		Feng.success("添加成功!");
    	    window.parent.Renovation.table.refresh();
    	    RenovationInfoDlg.close();
    	}
    });
}
function addSubmitCallback(){
	Feng.success("添加成功!");
    window.parent.Renovation.table.refresh();
    RenovationInfoDlg.close();
}
/**
 * 提交修改
 */
RenovationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/renovation/update", function(data){
        Feng.success("修改成功!");
        window.parent.Renovation.table.refresh();
        RenovationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.renovationInfoData);
    ajax.start();
}

$(function() {

});
