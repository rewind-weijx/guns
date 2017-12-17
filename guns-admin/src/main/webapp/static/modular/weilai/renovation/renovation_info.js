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
    		console.log(json.data);
    		addDetail(json.data);
    		Feng.success("添加成功!");
    	    window.parent.Renovation.table.refresh();
    	    RenovationInfoDlg.close();
    	}
    });
}
RenovationInfoDlg.updateSubmit = function() {

    this.clearData();
    this.collectData();

    $.ajax({
    	url:Feng.ctxPath + "/renovation/update",
    	type:"post",
    	async:false,
    	dataType:"json",
    	data:$("#form").serialize(),
    	success:function(json){
    		console.log(json.data);
    		deleteDetail(json.data);
    		addDetail(json.data);
    		Feng.success("修改成功!");
    	    window.parent.Renovation.table.refresh();
    	    RenovationInfoDlg.close();
    	}
    });
}
function deleteDetail(renovationId){
	$.ajax({
    	url:Feng.ctxPath + "/renovation/deleteDetail",
    	type:"post",
    	async:false,
    	dataType:"json",
    	data:{
    		renovationId:renovationId
    	},
    	success:function(json){
    		
    	}
    });
}
function addDetail(renovationId){
	var detailContent = $("#form .detailContent");
	var detailImage = $("#form .detailImage");
	$.each(detailContent,function(index,contentElement){
		var content = $(contentElement).val();
		var image = $(detailImage[index]).val();
		$.ajax({
	    	url:Feng.ctxPath + "/renovation/addDetail",
	    	type:"post",
	    	async:false,
	    	dataType:"json",
	    	data:{
	    		renovationId:renovationId,
	    		content:content,
	    		image:image
	    	},
	    	success:function(json){
	    		
	    	}
	    });
	});
}
function addSubmitCallback(){
	Feng.success("添加成功!");
    window.parent.Renovation.table.refresh();
    RenovationInfoDlg.close();
}

$(function() {
	  
});
