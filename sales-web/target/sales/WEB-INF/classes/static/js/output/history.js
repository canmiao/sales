$(document).ready(function () {

    $("#detail_tb").bootstrapTable({
        url: "output/select",
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
            {field: 'goodsName', align: 'center', title: '货物名称'},
            {field: 'model', align: 'center', title: '型号'},
            {field: 'number', align: 'center', title: '数量'},
            {field: 'shippingAddress', align: 'center', title: '收货地址'},

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
        if (checkString($("#goodsNameName").val())) {
            showToast("货物名称不能为空...");
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
        if (checkString($("#shippingAddress").val())) {
            showToast("收货地址不能为空...");
            return;
        }


        var output = {
            goodsName: $("#goodsNameName").val(),
            model: $("#model").val(),
            number: $("#number").val(),
            shippingAddress: $("#shippingAddress").val(),
            id: $("#id").val()
        };
        //调用保存方法
        $.ajax({
            url: url,
            method: 'post',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(output),
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

    // 打开修改页面
    $("#detail_tb").on('click', '.modify_sales', function (e) {
        e.preventDefault();
        $('#model-label').text('修改库存信息');
        var id = $(this).data('id');
        $('#locationInfoModel').show();
        // 先清空下拉选择框
        $("#goodsName").val('');
        $("#model").val('');
        $("#number").val('');
        $("#shippingAdress").val('');
        $("#id").val('');


        $.ajax({
            url: 'output/insert' + id,
            method: 'post',
            async: false,
            dataType: 'json',
            success: function (response) {
                if (response.status != 1) {
                    return;
                }
                var data = response.data;
                $("#id").val(data.id);
                $("#goodsName").val(data.goodsName);
                $("#model").val(data.model);
                $("#number").val(data.number);
                $("#shippingAdress").val(data.shippingAddress);
            }
        });
        url = "output/update"
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


