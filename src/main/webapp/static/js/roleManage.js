$(function () {

    // var bootstrapButton = $.fn.button.noConflict();
    //  $.fn.bootstrapBtn = bootstrapButton;
    var roleId = [],
        table,
        operaType;

    var validator =  $('#roleForm').validate({
        errorPlacement: function(error, element) {
            // Append error within linked label
            $( element )
                .closest( "form" )
                .find( "label[for='" + element.attr( "id" ) + "']" )
                // .find("")
                .append( error );
        },
        errorElement: "span",
        rules: {
            role: "required",
            description: "required"
        },
        messages:{
            role: "(必填)",
            description: "(必填)",
        }
    });


    // 初始化表格内容
    + function initForm() {
        table = $("#role-table").DataTable({
            serverSide: true,
            ajax: {
                url: "/sys/role/list",
                type: "post"
            },
            columnDefs: [
                {
                    targets: 0,
                    data: "id",
                    title: "ID",
                    render: function (value) {
                        return "<input type='checkbox' value='" + value + "' id='id" + value + "'>";
                    }
                },
                {
                    targets: 1,
                    data: "role",
                    title: "用户级别",
                },
                {
                    targets: 2,
                    data: "description",
                    title: "描述说明",
                },
                {
                    targets: 3,
                    data: "available",
                    title: "是否可用",
                },
            ],

            lengthChange: false,//关闭记录条数选项
            searching: false,//关闭搜索,
            rowCallback: function (row, data, index) {
                // 绑定复选框事件
                // $("#role-table :checkbox").on("click", function (p1) {
                //     $("#role-table :checkbox").each(function (i) {
                //         console.log(i);
                //         roleId.push(1);
                //     })
                // });
            },
        });
        $("#role-table").on("click", "tr", function () {
            // var data = table.row(this).data();
            var chks = $("input[type='checkbox']", this);
            if (chks.prop('checked')) {
                chks.prop("checked", false);
            } else {
                chks.prop("checked", true);
            }
            //计算选择行
            getRowIds();
        });
        // $("#role-table tr").slice(1).click(function () {
        //     // var data = table.row(this).data();
        //
        //     var chks = $("input[type='checkbox']", this);
        //     if (chks.prop('checked')) {
        //         chks.prop("checked", false);
        //     } else {
        //         chks.prop("checked", true);
        //     }
        //     console.log('sdsf');
        // });
    }();

    //初始化事件
    +function initEvent() {
        //似乎不成功
        $("#role-table input[type='checkbox']").on('click', function (p1) {
            if ($(this).prop('checked')) {
                $(this).prop('checked', true);
            } else {
                $(this).prop('checked', false);
            }
        });

        /**
         * 绑定新增按钮事件
         */
        $("#submit").on('click', function (p1) {
            if (!$("#roleForm").valid()) {
                return;
            }
            _save();
            $("#contentModal").modal("hide");
        });

        /**
         * 绑定重置按钮事件
         */
        $("#reset").on('click', function (p1) {
            document.getElementById("roleForm").reset();
            // $("#roleForm").reset();
        });

        /**
         * 绑定重置按钮事件
         */
        $("#close").on('click', function (p1) {
            document.getElementById("roleForm").reset();
        });


        // 绑定新增按钮事件
        $("#add").on("click", function () {
            operaType = "add";
            $("#contentModal").modal("show");

            $(".modal-footer #reset").show();
            $(".modal-footer #submit").show();

            $(".modal-body input,select").attr("readonly", false);

        });

        // 绑定新增按钮事件
        $("#edit").on("click", function () {
            operaType = "edit";
            // getRowIds();

            $(".modal-footer #reset").hide();
            $(".modal-body input,select").attr("readonly", false);

            if (roleId.length < 1) {
                // $("#rowWarning strong").text("请选择行！！！")
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            }else if (roleId.length > 1) {
                $("#rowWarning strong").text("只能选择一行！！！");
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            }
            // 从后台获取数据填充到模态框中，也可以在模态框打开事件中执行
            _view(roleId[0]);

            $("#contentModal").modal("show");
        });

        // 绑定查看按钮事件
        $("#view").on("click", function () {
            operaType = "view";
            // getRowIds();

            $(".modal-body input,select").attr("readonly", true);

            $(".modal-footer #reset").hide();
            $(".modal-footer #submit").hide();

            if (roleId.length < 1) {
                // $("#rowWarning strong").text("请选择行！！！")
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            }else if (roleId.length > 1) {
                $("#rowWarning strong").text("只能选择一行！！！");
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            }
            // 从后台获取数据填充到模态框中，也可以在模态框打开事件中执行
            _view(roleId[0]);


            $("#contentModal").modal("show");
        });

        // 绑定删除按钮事件
        $("#delete").on("click", function () {
            // $("#dialog-confirm").dialog("open");
            // 计算行
            // getRowIds();

            if (roleId.length < 1) {
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            }
            $("#deleteModal").modal("show");
        });

    }();

    /**
     * 初始化警告事件
     */
    +function initWarningEvent() {
        $(".close").on('click', function (p1) {
            roleId = [];//重置
            $("#rowWarning").removeClass("in").addClass("hide");
        })

        //不生效
        $('#rowWarning').bind('closed.bs.alert', function () {
            // 执行一些动作...
            console.log('关闭警告框！');
        })
    }();

    /**
     * 初始化模态框事件
     */
    +function initModalEvent() {
        $("#deleteSubmit").on("click", function () {
            _delete();
            $("#deleteModal").modal("hide");
        });

        $("#deleteClose").on("click", function () {
            $("#deleteModal").modal("hide");
        });

        $("#deleteModal").on('hidden.bs.modal', function () {
            //可以在里面清除内容
            roleId = [];//重置
        });

        $("#contentModal").on('hidden.bs.modal', function () {
            //可以在里面清除内容
            // roleId = [];//重置
            document.getElementById("roleForm").reset();
            $("#roleForm").find(".error").remove("span");
            $("#roleForm").find("input").removeClass("error");
        });

    }();

    /**
     * 删除用户
     */
    function _delete() {
        //后台发送请求
        $.ajax({
            url: "/sys/role/delete",
            data: {
                ids: roleId.toString()
            },
            type: "post",
            success: function (result) {
                table.ajax.reload();
            }
        });
    }
    /**
     * 添加用户
     */
    function _save() {
        var url = "";
        if (operaType === "add") {
            url = "/sys/role/add";
        }else if (operaType === "edit") {
            url = "/sys/role/update";
        }
        //后台发送请求
        var data = formSerialize();
        if (roleId.length > 0) {
            data["id"] = roleId[0];
            //角色id

        }
        // console.log($("#role").val());
        $.ajax({
            url: url,
            type: "post",
            data: JSON.stringify(data),
            contentType: 'application/json;charset=UTF-8',
            success: function () {
                table.ajax.reload();
            }
        });
    }
    
    
    function _save1() {
        var data = $("#roleForm").serialize();
        var url = "";
        if (operaType === "add") {
            url = "/sys/role/add";
        }else if (operaType === "edit") {
            url = "/sys/role/update";
        }
        //后台发送请求
        // var data = formSerialize();
        // if (roleId.length > 0) {
        //     data["id"] = roleId[0];
        // }
        $.ajax({
            url: url,
            type: "post",
            data: data,
            contentType: 'application/x-www-form-urlcoded;charset=UTF-8',
            success: function () {
                table.ajax.reload();
            }
        });
    }
    /**
     * 查询用户
     */
    function _view(id) {
        //后台发送请求
        $.ajax({
            url: "/sys/role/view/"+id,
            type: "get",
            success: function (result) {
                // table.ajax.reload();
                //将内容填充至表格，类型为查看，则设置为只读
                debugger;
                $("#roleForm input[name='role']").val(result.role);
                $("#roleForm input[name='description']").val(result.description);

            }
        });
    }

    /**
     * 序列化表格
     */
    function formSerialize() {
        var data = $("#roleForm").serializeArray();
        var dataJson = {};
        $.each(data, function (i, item) {
            dataJson[item.name] = item.value;
        });
        return dataJson;
    }

    /**
     * 获取选择行的id
     */
    function getRowIds() {
        roleId = [];
        $("#role-table input[type='checkbox']").each(function (i) {
            if ($(this).prop('checked')) {
                roleId.push($(this).val());
                console.log(roleId);
            }
        });
    }
});