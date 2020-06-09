$(document).ready(function () {

    $("#detail_tb").bootstrapTable({
        url: "salelist/select",
        method: 'get',
        pagination: true, //分页
        pageSize: 5, //每页显示8条
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
            {field: 'orderNumber', align: 'center', title: '订单号'},
            {align: 'center', title: '下单日期',formatter: function (value, row) {
                    return dateTimeFormatterCN(row.orderTime);
                }},
            {field: 'customer', align: 'center', title: '客户'},
            {field: 'customerCompany', align: 'center', title: '客户公司'},
            {field: 'saler', align: 'center', title: '销售员'},
            {field: 'salerPhone', align: 'center', title: '销售员联系方式'},


            {
                align: 'center', title: '操作', formatter: function (value, row) {
                    var text = "";
                    text = text + '<a href="javascript:void(0);" data-id="' + row.id + '" class="modify_sales">修改</a>';
                    text = text + '<a href="javascript:void(0);" data-id="' + row.id + '" class="view_sales">查看</a>';
                    return text;
                }
            }

        ]
    });
    var url;
    //保存
    $("#confirm_submit").click(function () {
        // 验证
        if (checkString($("#orderNumber").val())) {
            showToast("订单号不能为空...");
            return;
        }
        if (checkString($("#orderTime").val())) {
            showToast("下单日期不能为空...");
            return;
        }
        if (checkString($("#customer").val())) {
            showToast("客户不能为空...");
            return;
        }
        if (checkString($("#customerCompany").val())) {
            showToast("客户公司不正确...");
            return;
        }
        if (checkString($("#saler").val())) {
            showToast("销售员不能为空...");
            return;
        }
        if (checkString($("#salerPhone").val())) {
            showToast("销售员联系电话不能为空...");
            return;
        }


        var sales = {
            orderNumber: $("#orderNumber").val(),
            orderTime: $("#orderTime").val(),
            customer: $("#customer").val(),
            customerCompany: $("#customerCompany").val(),
            saler: $("#saler").val(),
            saleState: $("#salerPhone").val(),
            id: $("#id").val()
        };
        //调用保存方法
        $.ajax({
            url: url,
            method: 'post',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(sales),
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
/*
    //打开新增页面
    $("#insert").on('click', function (e) {
        e.preventDefault();
        $('#model-label').text('新增表单');
        $('#locationInfoModel').show();
        // 清空数据
        $("#saleNo").val('');
        $("#saleTime").val('');
        $("#client").val('');
        $("#clientCop").val('');
        $("#salesman").val('');
        $("#select").val('');

//动态绑定select标签中的option
        $.ajax({
            url: 'http://47.112.29.9:8080/sales-0.0.1-SNAPSHOT/salelist/insert',
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
        url = "user/register"
    });*/

    // 打开修改页面
    $("#detail_tb").on('click', '.modify_sales', function (e) {
        e.preventDefault();
        $('#model-label').text('修改销售单信息');
        var id = $(this).data('id');
        $('#locationInfoModel').show();
        // 先清空下拉选择框
        $("#orderNumber").val('');
        $("#orderTime").val('');
        $("#customer").val('');
        $("#customerCompany").val('');
        $("#saler").val('');
        $("#salerPhone").val('');
        $("#id").val('');
        /*动态绑定select标签中的option
        $.ajax({
            url: 'http://localhost:8080/sales/salelist/update',
            method: 'post',
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
            url: 'salelist/update' + id,
            method: 'post',
            async: false,
            dataType: 'json',
            success: function (response) {
                if (response.status != 1) {
                    return;
                }
                var data = response.data;
                $("#id").val(data.id);
                $("#orderNumber").val(data.orderNumber);
                $("#orderTime").val(data.orderTime);
                $("#customer").val(data.customer);
                $("#customerCompany").val(data.customerCompany);
                $("#saler").val(data.saler);
                $("#salerPhone").val(data.salerPhone);
            }
        });
        url = "user/update"
    });


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


