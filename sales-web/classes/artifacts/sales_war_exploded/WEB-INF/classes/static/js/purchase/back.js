$(document).ready(function () {

    $("#detail_tb").bootstrapTable({
        url: "http://localhost:8080/sales/purchase/retund/select",
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
            {field: 'orderNumber', align: 'center', title: '采购退货订单号'},
            {align: 'center', title: '制表日期',formatter: function (value, row) {
                    return dateTimeFormatterCN(row.tableMakedate);
                }},
            {align: 'center', title: '退货日期',formatter: function (value, row) {
                    return dateTimeFormatterCN(row.returnDate);
                }},
            {align: 'center', title: '预收货日期',formatter: function (value, row) {
                    return dateTimeFormatterCN(row.predictReceiveTime);
                }},
            {field: 'provider', align: 'center', title: '供应商'},
            {field: 'providerLinkmanPhone', align: 'center', title: '供应商电话'},
            {field: 'providerCode', align: 'center', title: '供应商代码'},
            {field: 'returnMan', align: 'center', title: '退货员'},
            {field: 'returnManPhone', align: 'center', title: '退货员电话'},
            {field: 'returnManCode', align: 'center', title: '退货员代码'},
            {field: 'returnDate', align:'center', title:'退货日期'},
            {field: 'predictReceiveTime', align:'center', title:'预收货日期'},
            {field: 'warehouseNumber', align:'center', title:'仓库号'},
            {field: 'returnProduce', align:'center', title:'退货产品'},
            {field: 'returnReasion', align:'center', title:'退货原因'},
            {field: 'returnProduceAmount', align:'center', title:'退货数量'},
            {field: 'returnProduceUnitPrice', align:'center', title:'退货单价'},
            {field: 'combine', align:'center', title:'合计'},


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
            showToast("采购订单号不能为空...");
            return;
        }
        if (checkString($("#tableMakedate").val())) {
            showToast("采购订单制表日期不能为空...");
            return;
        }
        if (checkString($("#provider").val())) {
            showToast("供应商不能为空...");
            return;
        }
        if (checkString($("#providerCode").val())) {
            showToast("供应商代码不正确...");
            return;
        }
        if (checkString($("#providerLinkmanPhone").val())) {
            showToast("供应商电话不能为空...");
            return;
        }
        if (checkString($("#returnMan").val())) {
            showToast("退货员不能为空...");
            return;
        }
        if (checkString($("#returnManPhone").val())) {
            showToast("退货员联系电话不能为空...");
            return;
        }
        if (checkString($("#returnManCode").val())) {
            showToast("退货员代码不能为空...");
            return;
        }
        if (checkString($("#returnDate").val())) {
            showToast("退货日期不能为空...");
            return;
        }
        if (checkString($("#predictReceiveTime").val())) {
            showToast("预收货日期不能为空...");
            return;
        }
        if (checkString($("#warehouseNumber").val())) {
            showToast("仓库号不能为空...");
            return;
        }
        if (checkString($("#returnReasion").val())) {
            showToast("退货原因不能为空...");
            return;
        }
        if (checkString($("#returnProduce").val())) {
            showToast("退货产品不能为空...");
            return;
        }
        if (checkString($("#returnProduceAmount").val())) {
            showToast("退货数量不能为空...");
            return;
        }
        if (checkString($("#returnProduceUnitPrice").val())) {
            showToast("退货单价不能为空...");
            return;
        }
        if (checkString($("#combine").val())) {
            showToast("合计不能为空...");
            return;
        }



        var sales = {
            orderNumber: $("#orderNumber").val(),
            tableMakedate: $("#tableMakedate").val(),
            provider: $("#provider").val(),
            providerCode: $("#providerCode").val(),
            providerLinkmanPhone: $("#providerLinkmanPhone").val(),
            returnMan: $("#returnMan").val(),
            returnManPhone: $("#returnManPhone").val(),
            returnManCode: $("#returnManCode").val(),
            returnDate:$("#returnDate").val(),
            predictReceiveTime:$("#predictReceiveTime").val(),
            warehouseNumber:$("#warehouseNumber").val(),
            returnReasion:$("#returnReasion").val(),
            returnProduce:$("#returnProduce").val(),
            returnProduceAmount:$("#returnProduceAmount").val(),
            returnProduceUnitPrice:$("#returnProduceUnitPrice").val(),
            combine:$("#combine").val(),
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


    //打开新增页面
    $("#insert").on('click', function (e) {
        e.preventDefault();
        $('#model-label').text('新增表单');
        $('#locationInfoModel').show();
        // 清空数据
         $("#orderNumber").val('');
         $("#tableMakedate").val('');
             $("#provider").val('');
             $("#providerCode").val('');
           $("#providerLinkmanPhone").val('');
           $("#returnMan").val('');
           $("#returnManPhone").val('');
           $("#returnManCode").val('');
           $("#returnDate").val('');
            $("#predictReceiveTime").val('');
            $("#warehouseNumber").val('');
            $("#returnReasion").val('');
            $("#returnProduce").val('');
            $("#returnProduceAmount").val('');
            $("#returnProduceUnitPrice").val('');
            $("#combine").val('');


//动态绑定select标签中的option
        $.ajax({
            url: 'http://localhost:8080/sales/purchase/retund/select',
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
        url = "http://localhost:8080/sales/purchase/retund/insert"
    });


    // 打开修改页面
    $("#detail_tb").on('click', '.modify_sales', function (e) {
        e.preventDefault();
        $('#model-label').text('修改采购退货单信息');
        var id = $(this).data('id');
        $('#locationInfoModel').show();
        // 先清空下拉选择框
        $("#orderNumber").val('');
        $("#tableMakedate").val('');
        $("#provider").val('');
        $("#providerCode").val('');
        $("#providerLinkmanPhone").val('');
        $("#returnMan").val('');
        $("#returnManPhone").val('');
        $("#returnManCode").val('');
        $("#returnDate").val('');
        $("#predictReceiveTime").val('');
        $("#warehouseNumber").val('');
        $("#returnReasion").val('');
        $("#returnProduce").val('');
        $("#returnProduceAmount").val('');
        $("#returnProduceUnitPrice").val('');
        $("#combine").val('');
        $("#id").val('');
        //动态绑定select标签中的option

        $.ajax({
            url: 'http://locahost:8080/sales/purchase/retund/select' + id,
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
                $("#tableMakedate").val(data.tableMakedate);
                $("#provider").val(data.provider);
                $("#providerCode").val(data.providerCode);
                $("#providerLinkmanPhone").val(data.providerLinkmanPhone);
                $("#returnMan").val(data.returnMan);
                $("#returnManPhone").val(data.returnManberPhone);
                $("#returnManCode").val(data.returnManCode);
                $("#returnDate").val(data.returnDate);
                $("#predictReceiveTime").val(data.predictReceiveTime);
                $("#warehouseNumber").val(data.warehouseNumber);
                $("#returnReasion").val(data.returnReasion);
                $("#returnProduce").val(data.returnProduce);
                $("#returnProduceAmount").val(data.returnProduceAmount);
                $("#returnProduceUnitPrice").val(data.returnProduceUnitPrice);
                $("#combine").val(data.combine);
            }
        });
        url = "http://localhost:8080/sales/purchase/retund/update"
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


