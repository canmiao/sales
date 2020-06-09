$(document).ready(function () {

    $("#detail_tb").bootstrapTable({
        url: "http://localhost:8080/sales/check/select",
        method: 'get',
        pagination: true, //分页
        pageSize: 8, //每页显示8条
        singleSelect: false,
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        sidePagination: "server", //可选值为 'client' 或者 'server'
        clickToSelect: true,

        queryParams: function (params) {
            return custQueryParams(params);
        },
        responseHandler: function (res) {
            return responseBeanHandler(res);
        },
        columns: [
            {checkbox: true},
            {field: 'checkOrder', align: 'center', title: '送检单号'},
            {align: 'center', title: '制单日期',formatter: function (value, row) {
                    return dateTimeFormatterCN(row.tableMakedate);
                }},
            {align: 'center', title: '送检时间',formatter: function (value, row) {
                    return dateTimeFormatterCN(row.checkDate);
                }},
            {field: 'checker', align: 'center', title: '送检员'},
            //{field: 'checkerPhone', align: 'center', title: '送检员电话'},
            {field: 'cheeckNumber', align: 'center', title: '送检数量'},
            {field: 'checkType', align: 'center', title: '送检类型'},
            {field: 'specification', align: 'center', title: '送检规格'},
            {field: 'produceName', align: 'center', title: '产品名'},
            {field: 'checkProduceNumber', align: 'center', title: '产品编号'},
            {field: 'checkAmount', align: 'center', title: '抽样数量'},
            {field: 'checkResult', align: 'center', title: '检验情况'},
            {field: 'badNumber', align: 'center', title: '不良数量'},
            {field: 'judge', align: 'center', title: '判定'},
            //{field: 'checkNote', align: 'center', title: '备注'},

            {
                align: 'center', title: '操作', formatter: function (value, row) {
                    var text = "";
                    text = text + '<a href="javascript:void(0);" data-id="' + row.id + '" class="modify_user">修改</a>';
                    text = text + '<a href="javascript:void(0);" data-id="' + row.id + '" class="view_user">查看</a>';
                    return text;
                }
            }

        ]
    });
    var url;
    //保存
    $("#confirm_submit").click(function () {
        // 验证
        if (checkString($("#checkOrder").val())) {
            showToast("送检单号不能为空...");
            return;
        }
        if (checkString($("#tableMakedate").val())) {
            showToast("制单日期不能为空...");
            return;
        }
        if (checkString($("#checkDate").val())) {
            showToast("送检时间不能为空...");
            return;
        }
        if (checkString($("#checkType").val())) {
            showToast("送检类型不正确...");
            return;
        }
        if (checkString($("#specification").val())) {
            showToast("规格不能为空...");
            return;
        }
        if (checkString($("#produceName").val())) {
            showToast("产品名不正确...");
            return;
        }
        if (checkString($("#checkProduceNumber").val())) {
            showToast("送检产品编号不能为空...");
            return;
        }
        if (checkString($("#checkAmount").val())) {
            showToast("抽样数量不能为空...");
            return;
        }
        if (checkString($("#checkResult").val())) {
            showToast("检验情况不能为空...");
            return;
        }
        if (checkString($("#badNumber").val())) {
            showToast("不良数量不能为空...");
            return;
        }
        if (checkString($("#judge").val())) {
            showToast("判定不能为空...");
            return;
        }
        if (checkString($("#checkNote").val())) {
            showToast("备注不能为空...");
            return;
        }

        var check = {
            checkOrder: $("#checkOrder").val(),
            tableMakedate: $("#tableMakedate").val(),
            checkDate: $("#checkDate").val(),
            checkType: $("#checkType").val(),
            specification: $("#specification").val(),
            produceName: $("#produceName").val(),
            checkProduceNumber: $("#checkProduceNumber").val(),
            checkAmount: $("#checkAmount").val(),
            checkResult: $("#checkResult").val(),
            badNumber: $("#badNumber").val(),
            judge: $("#judge").val(),
           // checkNote: $("#checkNote").val(),
            id: $("#id").val()
        };
        //调用保存方法
        $.ajax({
            url: url,
            method: 'post',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(check),
            success: function (response) {
                if (response != undefined && response.status == 1) {
                    //保存成功后关闭modal, 刷新Table
                    $('#locationInfoModel').hide();
                    refreshTable();
                } else {
                    // 显示错误信息
                }
            }
        })
    });

    //打开新增页面
    $("#insert").on('click', function (e) {
        e.preventDefault();
        $('#model-label').text('新增质检单');
        $('#locationInfoModel').show();
        // 清空数据
        $("#checkOrder").val('');
        $("#tableMakedate").val('');
        $("#checkDate").val('');
        $("#checkType").val('');
        $("#specification").val('');
        $("#produceName").val('');
        $("#checkProduceNumber").val('');
        $("#checkAmount").val('');
        $("#checkResult").val('');
        $("#badNumber").val('');
        $("#judge").val('');
       // $("#checkNote").val('');

        $("#id").val('');
        //动态绑定select标签中的option
        $.ajax({
            url: 'http://localhost:8080/sales/check/select',
            method: 'get',
            dataType: 'json',
            success: function (response) {
                if (response.status != 1) {
                    return;
                }
                var data = response.data;
                $("#select").empty();
                $("#select").append("<option value='0'>" + "=====请选择=====" + "</option>");
                data.forEach(function (item, index) {
                    $("#select").append("<option value='" + item.id + "'>" + item.title + "</option>");
                });
            }
        });
        // 准备参数
        url = "http://localhot:8080/sales/check/insert"
    });


    // 打开修改页面
    $("#detail_tb").on('click', '.modify_user', function (e) {
        e.preventDefault();
        $('#model-label').text('修改表单');
        var id = $(this).data('id');
        $('#locationInfoModel').show();
        // 先清空下拉选择框
        $("#checkOrder").val('');
        $("#tableMakedate").val('');
        $("#checkDate").val('');
        $("#checkType").val('');
        $("#specification").val('');
        $("#produceName").val('');
        $("#checkProduceNumber").val('');
        $("#checkAmount").val('');
        $("#checkResult").val('');
        $("#badNumber").val('');
        $("#judge").val('');
      //  $("#checkNote").val('');
        $("#id").val('');
        //动态绑定select标签中的option
        /* $.ajax({
             url: 'user/roles',
             method: 'get',
             async: false,
             dataType: 'json',
             success: function (response) {
                 if (response.status != 1) {
                     return;
                 }
                 var data = response.data;
                 $("#select").empty();
                 $("#select").append("<option value='0'>" + "=====请选择=====" + "</option>");
                 data.forEach(function (item, index) {
                     $("#select").append("<option value='" + item.id + "'>" + item.title + "</option>");
                 });
             }
         });*/

        $.ajax({
            url: 'http://localhost:8080/sales/check/select' + id,
            method: 'get',
            async: false,
            dataType: 'json',
            success: function (response) {
                if (response.status != 1) {
                    return;
                }
                var data = response.data;
                $("#id").val(data.id);
                $("#checkOrder").val(data.checkOrder);
                $("#tableMakedate").val(data.tableMakedate);
                $("#checkDate").val(data.checkDate);
                $("#checkType").val(data.checkType);
                $("#specification").val(data.specification);
                $("#produceName").val(data.produceName);
                $("#checkProduceNumber").val(data.checkProduceNumber);
                $("#checkAmount").val(data.checkAmount);
                $("#checkResult").val(data.checkResult);
                $("#badNumber").val(data.badNumber);
                $("#judge").val(data.judge);
                //$("#checkNote").val(data.checkNote);
            }
        });
        url = "http://localhost:8080/sales/check/update"
    });

    /*
    // 一键锁解
    $("#lock").click(function () {
        var selecteds = $("#detail_tb").bootstrapTable('getSelections');
        var array = [];
        $.each(selecteds, function (index, row) {
            array.push(row.id);
        });

        if (array.length != 0) {
            $.ajax({
                url: 'user/lock?ids=' + array,
                method: 'get',
                async: false,
                dataType: 'json',
                success: function (response) {
                    if (response.status != 1) {
                        return;
                    }
                    showToast("共成功锁定或解锁" + response.data + "个用户...");
                    refreshTable();
                }
            });

        } else {
            showToast("请先勾选需要锁定或解锁的用户...");
        }

    });
*/

    // 关闭模态框
    $('#cancel, #locationInfoModel .imgP').click(function () {
        $('#locationInfoModel').hide();
    });

    //根据关键字查询
    $("#search").click(function () {
        refreshTable();
    });

    //回车即可根据keyWord查询
    $('#keyWord').bind('keypress', function (event) {//监听回车事件
        if (event.keyCode == "13") {
            refreshTable();
        }
    });

    //刷新Table
    var refreshTable = function () {
        var param = {
            keyWord: $("#keyWord").val()

        };
        reloadTable("detail_tb", param);
    };

    var reloadTable = function (tableId, jsonDataParam) {
        $("#" + tableId).bootstrapTable('refreshOptions', {
            pageNumber: 1,
            queryParams: function (params) {
                return custQueryParams(params, jsonDataParam);
            }
        });
    };

    // 显示信息
    var showToast = function (message) {
        $('.toast').text(message).show().delay(3000).fadeOut();
    };

    // 判断字符串是否为空
    var checkString = function (str) {
        if (str.replace(/(^s*)|(s*$)/g, "").length == 0) {
            return true;
        }
        return false;
    };





});