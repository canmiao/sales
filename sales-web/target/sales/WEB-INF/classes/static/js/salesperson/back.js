$(document).ready(function () {

    $("#detail_tb").bootstrapTable({
        url: "sales/refund/select",
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
                    return dateTimeFormatterCN(row.tableMakedate);
                }},
            {field: 'customer', align: 'center', title: '供应商'},
            {field: 'customerPhone', align: 'center', title: '供应商联系电话'},
            {field: 'returnManber', align: 'center', title: '退货员'},
            {field: 'returnManberPhone', align: 'center', title: '退货员联系电话'},
            {align: 'center', title: '收货日期',formatter: function (value, row) {
                    return dateTimeFormatterCN(row.receiveDate);
                }},
            {align: 'center', title: '退货日期',formatter: function (value, row) {
                    return dateTimeFormatterCN(row.sreturnDate);
                }},
            {field: 'warehouseNumber', align: 'center', title: '仓库号'},

            {field: 'productName', align: 'center', title: '名称'},
            {field: 'product', align: 'center', title: '产品'},
            {field: 'model', align: 'center', title: '型号'},
            {field: 'number', align: 'center', title: '数量'},
            {field: 'unit', align: 'center', title: '单位'},
            {field: 'unitPrice', align: 'center', title: '单价'},
            {field: 'totalNumber', align: 'center', title: '合计'},
            {field: 'warehouseAddress', align: 'center', title: '库位地址'},
            {field: 'reasion', align: 'center', title: '退货原因'},

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
        if (checkString($("#tableMakedate").val())) {
            showToast("制表日期不能为空...");
            return;
        }
        if (checkString($("#customer").val())) {
            showToast("供应商不能为空...");
            return;
        }
        if (checkString($("#customerPhone").val())) {
            showToast("供应商联系电话不能为空...");
            return;
        }
        if (checkString($("#returnManber").val())) {
            showToast("退货员不能为空...");
            return;
        }
        if (checkString($("#receiveDate").val())) {
            showToast("收货日期不能为空...");
            return;
        }
        if (checkString($("#sreturnDate").val())) {
            showToast("退货日期不能为空...");
            return;
        }
        if (checkString($("#returnManberPhone").val())) {
            showToast("退货员联系电话不能为空...");
            return;
        }
        if (checkString($("#warehouseNumber").val())) {
            showToast("仓库号不能为空...");
            return;
        }
        if (checkString($("#productName").val())) {
            showToast("名称不能为空...");
            return;
        }
        if (checkString($("#product").val())) {
            showToast("产品不能为空...");
            return;
        }
        if (checkString($("#model").val())) {
            showToast("型号不能为空...");
            return;
        }
        if (checkString($("#number").val())) {
            showToast("数量不正确...");
            return;
        }
        if (checkString($("#unit").val())) {
            showToast("产品单位不正确...");
            return;
        }
        if (checkString($("#unitPrice").val())) {
            showToast("产品单价不能为空...");
            return;
        }
        if (checkString($("#totalNumber").val())) {
            showToast("合计不正确...");
            return;
        }
        if (checkString($("#warehouseAddress").val())) {
            showToast("库位地址不正确...");
            return;
        }
        if (checkString($("#reasion").val())) {
            showToast("退货原因不能为空...");
            return;
        }

        var back = {
            orderNumber: $("#orderNumber").val(),
            tableMakedate: $("#tableMakedate").val(),
            provider: $("#customer").val(),
            providerPhone: $("#customerPhone").val(),
            returnManber: $("#returnManber").val(),
            receiveDate: $("#receiveDate").val(),
            sreturnDate: $("#sreturnDate").val(),
            returnManberPhone: $("#returnManberPhone").val(),
            warehouseNumber: $("#warehouseNumber").val(),

            productName: $("#productName").val(),
            product: $("#product").val(),
            model: $("#model").val(),
            number: $("#number").val(),
            unit: $("#unit").val(),
            unitPrice: $("#unitPrice").val(),
            totalNumber: $("#totalNumber").val(),
            warehouseAddress: $("#warehouseAddress").val(),
            reasion: $("#reasion").val(),
            id: $("#id").val()
        };
        //调用保存方法
        $.ajax({
            url: url,
            method: 'post',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(back),
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
        $("#customer").val('');
        $("#customerPhone").val('');
        $("#returnManber").val('');
        $("#returnManberPhone").val('');
        $("#receiveDate").val('');
        $("#sreturnDate").val('');
        $("#warehouseNumber").val('');
        $("#productName").val('');
        $("#product").val('');
        $("#model").val('');
        $("#number").val('');
        $("#unit").val('');
        $("#unitPrice").val('');
        $("#totalNumber").val('');
        $("#warehouseAddress").val('');
        $("#reasion").val('');
        $("#id").val('');

        $.ajax({
            url: 'sales/refund/select',
            method: 'get',
            dataType: 'json',
            success: function (response) {
                if (response.status != 1) {
                    return;
                }
            }
        });

        // 准备参数
        url = "sales/refund/insert"
    });


    // 打开修改页面
    $("#detail_tb").on('click', '.modify_sales', function (e) {
        e.preventDefault();
        $('#model-label').text('修改退货单信息');
        var id = $(this).data('id');
        $('#locationInfoModel').show();
        // 先清空下拉选择框
        $("#orderNumber").val('');
        $("#tableMakedate").val('');
        $("#customer").val('');
        $("#customerPhone").val('');
        $("#returnManber").val('');
        $("#returnManberPhone").val('');
        $("#receiveDate").val('');
        $("#sreturnDate").val('');
        $("#warehouseNumber").val('');
        $("#productName").val('');
        $("#product").val('');
        $("#model").val('');
        $("#number").val('');
        $("#unit").val('');
        $("#unitPrice").val('');
        $("#totalNumber").val('');
        $("#warehouseAddress").val('');
        $("#reasion").val('');
        $("#id").val('');


        $.ajax({
            url: 'sales/refund/select' + id,
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
                 $("#tableMakeDate").val(data.tableMakedate);
                 $("#provider").val(data.provider);
                 $("#providerPhone").val(data.providerPhone);
                 $("#returnManber").val(data.returnManber);
                 $("#receiveDate").val(data.receiveDate);
                 $("#sreturnDate").val(data.sreturnDate);
                 $("#returnManberPhone").val(data.returnManberPhone);
                 $("#warehouseNumber").val(data.warehouseNumber);

                 $("#productName").val(data.productName);
                 $("#product").val(data.product);
                 $("#model").val(data.model);
                 $("#specification").val(data.specification);
                 $("#number").val(data.number);
                 $("#unit").val(data.unit);
                 $("#unitPrice").val(data.unitPrice);
                 $("#totalNumber").val(data.totalNumber);
                 $("#warehouseAddress").val(data.warehouseAddress);
                 $("#reasion").val(data.reasion);
            }
        });
        url = "sales/refund/update"
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


