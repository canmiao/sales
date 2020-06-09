$(document).ready(function () {

    $("#detail_tb").bootstrapTable({
        url: "sales/manager/receive/noengouh",
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
            {align: 'center', title: '制表日期',formatter: function (value, row) {
                    return dateTimeFormatterCN(row.tableMakeTime);
                }},
            {field: 'customer', align: 'center', title: '客户'},
            {field: 'customerCompany', align: 'center', title: '客户公司'},
            {field: 'customerPhone', align: 'center', title: '客户电话'},
            {field: 'paymentType', align: 'center', title: '付款方式'},
            {field: 'cuType', align: 'center', title: '币种'},
            {field: 'paymentAccount', align: 'center', title: '客户付款账户'},
            {field: 'saler', align: 'center', title: '销售员'},
            {field: 'salerPhone', align: 'center', title: '销售员电话'},
            {field: 'orderTime', align: 'center', title: '下单日期'},
            {field: 'salerRemark', align: 'center', title: '销售员备注'},

        /*    {field: 'productName', align: 'center', title: '产品名称'},
            {field: 'product', align: 'center', title: '产品'},
            {field: 'model', align: 'center', title: '产品型号'},
            {field: 'size', align: 'center', title: '产品规格'},
            {field: 'number', align: 'center', title: '产品数'},
            {field: 'unit', align: 'center', title: '产品单位'},
            {field: 'unitPrice', align: 'center', title: '产品单价'},
            {field: 'combine', align: 'center', title: '合计'},
            {field: 'warehouseAddress', align: 'center', title: '库位地址'},
            {field: 'productComment', align: 'center', title: '产品信息备注'},*/

            {
                align: 'center', title: '审核', formatter: function (value, row) {
                    var text = "";
                    text = text + '<a href="javascript:void(0);" data-id="' + row.id + '" class="modify_sales">通过</a>';
                    text = text + '<a href="javascript:void(0);" data-id="' + row.id + '" class="view_sales">不通过</a>';
                    return text;
                }
            }

        ]
    });
    var url;

/*
    //打开新增页面
    $("#insert").on('click', function (e) {
        e.preventDefault();
        $('#model-label').text('新增表单');
        $('#locationInfoModel').show();
        // 清空数据
        $("#orderNumber").val('');
        $("#tableMakeTime").val('');
        $("#customer").val('');
        $("#customerCompany").val('');
        $("#paymentType").val('');
        $("#cuType").val('');
        $("#paymentAccount").val('');
        $("#saler").val('');
        $("#customerPhone").val('');
        $("#salerPhone").val('');
        $("#orderTime").val('');
        $("#salerRemark").val('');
        $("#productName").val('');
        $("#product").val('');
        $("#model").val('');
        $("#size").val('');
        $("#number").val('');
        $("#unit").val('');
        $("#unitPrice").val('');
        $("#combine").val('');
        $("#warehouseAddress").val('');
        $("#salerRemark").val('');
        $("#id").val('');

        $.ajax({
            url: 'http://localhost:8080/sales/salelist/select',
            method: 'post',
            dataType: 'json',
            success: function (response) {
                if (response.status != 1) {
                    return;
                }
            }
        });

        // 准备参数
        url = "http://localhost:8080/sales/salelist/insert"
    });
*/

    // 打开修改页面
    $("#detail_tb").on('click', '.modify_sales', function (e) {

        console.log("hhhhh")
        e.preventDefault();
        $('#model-label').text('审核销售单');
        var id = $(this).data('id');
        $('#locationInfoModel').show();
        // 先清空下拉选择框
        $("#orderNumber").val('');
        $("#tableMakeTime").val('');
        $("#customer").val('');
        $("#customerCompany").val('');
        $("#paymentType").val('');
        $("#cuType").val('');
        $("#paymentAccount").val('');
        $("#saler").val('');
        $("#customerPhone").val('');
        $("#salerPhone").val('');
        $("#orderTime").val('');
        $("#salerRemark").val('');
        $("#productName").val('');
        $("#product").val('');
        $("#model").val('');
        $("#size").val('');
        $("#number").val('');
        $("#unit").val('');
        $("#unitPrice").val('');
        $("#combine").val('');
        $("#warehouseAddress").val('');
        $("#salerRemark").val('');
        $("#id").val('');


        $.ajax({
            url: 'sales/manager/receive/noengouh' + id,
            method: 'get',
            async: false,
            dataType: 'json',
            success: function (response) {
                if (response.status != 1) {
                    return;
                }
                var data = response.data;
                $("#id").val(data.id);
                $("#orderNumber").val(data.orderNumber);
                $("#tableMakeTime").val(data.tableMakeTime);
                $("#customer").val(data.customer);
                $("#customerCompany").val(data.customerCompany);
                $("#paymentType").val(data.paymentType);
                $("#cuType").val(data.cuType);
                $("#paymentAccount").val(data.paymentAccount);
                $("#saler").val(data.saler);
                $("#customerPhone").val(data.customerPhone);
                $("#salerPhone").val(data.salerPhone);
                $("#orderTime").val(data.orderTime);
                $("#salerRemark").val(data.salerRemark);
                $("#productName").val(data.productName);
                $("#product").val(data.product);
                $("#model").val(data.model);
                $("#size").val(data.size);
                $("#number").val(data.number);
                $("#unit").val(data.unit);
                $("#unitPrice").val(data.unitPrice);
                $("#combine").val(data.combine);
                $("#warehouseAddress").val(data.warehouseAddress);
                $("#salerRemark").val(data.salerRemark);
            }
        });
        url = "sales/noenough/manager/pass"
    });

    $("#detail_tb").on('click', '.view_sales', function (e) {

        console.log("hhhhh")
        e.preventDefault();
        $('#model-label').text('审核销售单');
        var id = $(this).data('id');
        $('#locationInfoModel').show();
        // 先清空下拉选择框
        $("#orderNumber").val('');
        $("#tableMakeTime").val('');
        $("#customer").val('');
        $("#customerCompany").val('');
        $("#paymentType").val('');
        $("#cuType").val('');
        $("#paymentAccount").val('');
        $("#saler").val('');
        $("#customerPhone").val('');
        $("#salerPhone").val('');
        $("#orderTime").val('');
        $("#salerRemark").val('');
        $("#productName").val('');
        $("#product").val('');
        $("#model").val('');
        $("#size").val('');
        $("#number").val('');
        $("#unit").val('');
        $("#unitPrice").val('');
        $("#combine").val('');
        $("#warehouseAddress").val('');
        $("#salerRemark").val('');
        $("#id").val('');


        $.ajax({
            url: 'sales/manager/receive/noengouh' + id,
            method: 'get',
            async: false,
            dataType: 'json',
            success: function (response) {
                if (response.status != 1) {
                    return;
                }
                var data = response.data;
                $("#id").val(data.id);
                $("#orderNumber").val(data.orderNumber);
                $("#tableMakeTime").val(data.tableMakeTime);
                $("#customer").val(data.customer);
                $("#customerCompany").val(data.customerCompany);
                $("#paymentType").val(data.paymentType);
                $("#cuType").val(data.cuType);
                $("#paymentAccount").val(data.paymentAccount);
                $("#saler").val(data.saler);
                $("#customerPhone").val(data.customerPhone);
                $("#salerPhone").val(data.salerPhone);
                $("#orderTime").val(data.orderTime);
                $("#salerRemark").val(data.salerRemark);
                $("#productName").val(data.productName);
                $("#product").val(data.product);
                $("#model").val(data.model);
                $("#size").val(data.size);
                $("#number").val(data.number);
                $("#unit").val(data.unit);
                $("#unitPrice").val(data.unitPrice);
                $("#combine").val(data.combine);
                $("#warehouseAddress").val(data.warehouseAddress);
                $("#salerRemark").val(data.salerRemark);
            }
        });
        url = "sales/noenough/manager/nopass"
    });

    //保存
    $("#confirm_submit").click(function () {
        console.log("提交")
        // 验证
        // if (checkString($("#orderNumber").val())) {
        //     showToast("订单号不能为空...");
        //     return;
        // }
        // if (checkString($("#tableMakeTime").val())) {
        //     showToast("制表日期不能为空...");
        //     return;
        // }
        // if (checkString($("#customer").val())) {
        //     showToast("客户不能为空...");
        //     return;
        // }
        // if (checkString($("#customerCompany").val())) {
        //     showToast("客户公司不能为空...");
        //     return;
        // }
        // if (checkString($("#customerPhone").val())) {
        //     showToast("客户联系电话不能为空...");
        //     return;
        // }
        // if (checkString($("#paymentType").val())) {
        //     showToast("付款方式不正确...");
        //     return;
        // }
        // if (checkString($("#cuType").val())) {
        //     showToast("币种不能为空...");
        //     return;
        // }
        // if (checkString($("#paymentAccount").val())) {
        //     showToast("客户付款账户不能为空...");
        //     return;
        // }
        // if (checkString($("#saler").val())) {
        //     showToast("销售员不能为空...");
        //     return;
        // }
        // if (checkString($("#orderTime").val())) {
        //     showToast("下单日期不能为空...");
        //     return;
        // }
        // if (checkString($("#salerRemark").val())) {
        //     showToast("销售员备注不能为空...");
        //     return;
        // }
        // if (checkString($("#salerPhone").val())) {
        //     showToast("销售员联系电话不能为空...");
        //     return;
        // }
        // if (checkString($("#productName").val())) {
        //     showToast("产品名称不能为空...");
        //     return;
        // }
        // if (checkString($("#product").val())) {
        //     showToast("产品不能为空...");
        //     return;
        // }
        // if (checkString($("#model").val())) {
        //     showToast("产品型号不能为空...");
        //     return;
        // }
        // if (checkString($("#size").val())) {
        //     showToast("产品规格不正确...");
        //     return;
        // }
        // if (checkString($("#number").val())) {
        //     showToast("产品数不正确...");
        //     return;
        // }
        // if (checkString($("#unit").val())) {
        //     showToast("产品单位不正确...");
        //     return;
        // }
        // if (checkString($("#unitPrice").val())) {
        //     showToast("产品单价不能为空...");
        //     return;
        // }
        // if (checkString($("#combine").val())) {
        //     showToast("合计不正确...");
        //     return;
        // }
        // if (checkString($("#warehouseAddress").val())) {
        //     showToast("库位地址不正确...");
        //     return;
        // }
        // if (checkString($("#productComment").val())) {
        //     showToast("产品信息备注不能为空...");
        //     return;
        // }
        console.log("orderNumber"+$("#orderNumber").val());
        var sale = {
            orderNumber: $("#orderNumber").val(),
            // tableMakeTime: $("#tableMakeTime").val(),
            // customer: $("#customer").val(),
            // customerCompany: $("#customerCompany").val(),
            // paymentType: $("#paymentType").val(),
            // cuType: $("#cuType").val(),
            // paymentAccount: $("#paymentAccount").val(),
            // saler: $("#saler").val(),
            // customerPhone: $("#customerPhone").val(),
            // salerPhone: $("#salerPhone").val(),
            // orderTime: $("#orderTime").val(),
            // salerRemark: $("#salerRemark").val(),
            /*productName: $("#productName").val(),
            product: $("#product").val(),
            model: $("#model").val(),
            size: $("#size").val(),
            number: $("#number").val(),
            unit: $("#unit").val(),
            unitPrice: $("#unitPrice").val(),
            combine: $("#combine").val(),
            warehouseAddress: $("#warehouseAddress").val(),
            salerRemark: $("#salerRemark").val(),*/
            id: $("#id").val()
        };
        console.log("传递参数"+sale);
        //调用保存方法
        $.ajax({
            url: url,
            method: 'post',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(sale),
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


