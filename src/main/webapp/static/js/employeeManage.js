$(function () {

    // var bootstrapButton = $.fn.button.noConflict();
    //  $.fn.bootstrapBtn = bootstrapButton;
    var employeeId = [],
        table,
        operaType;

    var validator = $('#userForm').validate({
        errorPlacement: function (error, element) {
            // Append error within linked label
            $(element)
                .closest("form")
                .find("label[for='" + element.attr("id") + "']")
                // .find("")
                .append(error);
        },
        errorElement: "span",
        rules: {
            account: "required",
            username: "required",
            iphone: {
                required: true,
                number: true,
                minlength: 3
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            account: "(必填)",
            username: "(必填)",
            iphone: {
                required: "(必填)",
                number: "(必为数字)",
                minLength: "（最少3位）"
            },
            email: {
                required: "（必填）",
                email: "（邮箱格式）"
            }
        }
    });


    // 初始化表格内容
    +function initForm() {
        table = $("#employee-table").DataTable({
            serverSide: true,
            ajax: {
                url: "/sys/user/list",
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
                    data: "account",
                    title: "账户",
                },
                {
                    targets: 2,
                    data: "username",
                    title: "用户名",
                },
                {
                    targets: 3,
                    data: "iphone",
                    title: "电话",
                },
                {
                    targets: 4,
                    data: "email",
                    title: "邮箱",
                },
                {
                    targets: 5,
                    data: "roles",
                    title: "角色",
                    render: function (data, type, row, meta) {
                        if (data && data.length > 0) {
                            return "<strong>" + data[0].role + ";</strong>";
                        }
                        return null;
                    }
                },
                {
                    targets: 6,
                    data: "permissions",
                    title: "权限",
                    render: function (data, type, row, meta) {
                        var permissions = data.join(";");
                        return "<strong>" + permissions + "</strong>";
                    }
                },
                {
                    targets: 7,
                    data: "id",
                    title: "Id",
                    visible: false
                },


            ],

            lengthChange: false,//关闭记录条数选项
            searching: false,//关闭搜索,
            rowCallback: function (row, data, index) {
                // 绑定复选框事件
                // $("#employee-table :checkbox").on("click", function (p1) {
                //     $("#employee-table :checkbox").each(function (i) {
                //         console.log(i);
                //         employeeId.push(1);
                //     })
                // });
            },
        });
        $("#employee-table").on("click", "tr", function () {
            // var data = table.row(this).data();
            var chks = $("input[type='checkbox']", this);
            if (chks.prop('checked')) {
                chks.prop("checked", false);
            } else {
                chks.prop("checked", true);
            }
            //计算选择行
            getRowIds();

            if (employeeId.length == 1) {
                $("#rowWarning").removeClass("in").addClass("hide");
            }
        });
        // $("#employee-table tr").slice(1).click(function () {
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
        $("#employee-table input[type='checkbox']").on('click', function (p1) {
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
            if (!$("#userForm").valid()) {
                return;
            }
            _save();
            $("#contentModal").modal("hide");
        });

        /**
         * 绑定重置按钮事件
         */
        $("#reset").on('click', function (p1) {
            document.getElementById("userForm").reset();
            // $("#userForm").reset();
        });

        /**
         * 绑定重置按钮事件
         */
        $("#close").on('click', function (p1) {
            document.getElementById("userForm").reset();
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

            if (employeeId.length < 1) {
                $("#rowWarning strong").text("请选择行！！！");
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            } else if (employeeId.length > 1) {
                $("#rowWarning strong").text("只能选择一行！！！");
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            }
            // 从后台获取数据填充到模态框中，也可以在模态框打开事件中执行
            _view(employeeId[0]);

            $("#contentModal").modal("show");
        });

        // 绑定查看按钮事件
        $("#view").on("click", function () {
            operaType = "view";
            // getRowIds();

            $(".modal-body input,select").attr("readonly", true);

            $(".modal-footer #reset").hide();
            $(".modal-footer #submit").hide();

            if (employeeId.length < 1) {
                $("#rowWarning strong").text("请选择行！！！");
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            } else if (employeeId.length > 1) {
                $("#rowWarning strong").text("只能选择一行！！！");
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            }
            // 从后台获取数据填充到模态框中，也可以在模态框打开事件中执行
            _view(employeeId[0]);


            $("#contentModal").modal("show");
        });

        // 绑定删除按钮事件
        $("#delete").on("click", function () {
            // $("#dialog-confirm").dialog("open");
            // 计算行
            // getRowIds();

            if (employeeId.length < 1) {
                $("#rowWarning").removeClass("hide").addClass("in");
                return;
            }
            $("#deleteModal").modal("show");
        });

        $("#export").on("click", function (p1) {
            //后台发送请求
            $.ajax({
                url: "/sys/user/export",
                type: "get",
                success: function (result) {
                    location.href = "/sys/user/export";
                    // table.ajax.reload();
                    //将内容填充至表格，类型为查看，则设置为只读
                }
            });
        });

        $("#fileSubmit").on("click", function (p1) {
            var formData = new FormData($('#fileForm')[0]);
            $.ajax({
                type: 'post',
                url: "/sys/user/import",
                data: formData,
                cache: false,
                processData: false,
                contentType: false,
                success: function (data) {
                    $("#fileModal").modal("hide");
                    setTimeout(function () {
                        alert(data);
                    }, 200);
                },
                error: function (data) {
                    $("#fileModal").modal("hide");
                    alert("上传失败");
                }
            });
        })

    }();

    /**
     * 初始化警告事件
     */
    +function initWarningEvent() {
        $(".close").on('click', function (p1) {
            employeeId = [];//重置
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
            employeeId = [];//重置
        });

        $("#contentModal").on('hidden.bs.modal', function () {
            //可以在里面清除内容
            // employeeId = [];//重置
            document.getElementById("userForm").reset();
            $("#userForm").find(".error").remove("span");
            $("#userForm").find("input").removeClass("error");
        });

    }();

    /**
     * 删除用户
     */
    function _delete() {
        //后台发送请求
        $.ajax({
            url: "/sys/user/delete",
            data: {
                ids: employeeId.toString()
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
            url = "/sys/user/add";
        } else if (operaType === "edit") {
            url = "/sys/user/update";
        }
        //后台发送请求
        var data = formSerialize();
        if (employeeId.length > 0) {
            data["id"] = employeeId[0];
            //角色id

        }
        // console.log($("#role").val());
        data["roleIds"] = $("#role").val();
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


    function saveUser1() {
        var data = $("#userForm").serialize();
        var url = "";
        if (operaType === "add") {
            url = "/sys/user/add";
        } else if (operaType === "edit") {
            url = "/sys/user/update";
        }
        //后台发送请求
        // var data = formSerialize();
        // if (employeeId.length > 0) {
        //     data["id"] = employeeId[0];
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
            url: "/sys/user/view/" + id,
            type: "get",
            success: function (result) {
                // table.ajax.reload();
                //将内容填充至表格，类型为查看，则设置为只读

                $("#userForm input[name='account']").val(result.account);
                $("#userForm input[name='username']").val(result.username);
                $("#userForm input[name='iphone']").val(result.iphone);
                $("#userForm input[name='email']").val(result.email);

            }
        });
    }

    /**
     * 序列化表格
     */
    function formSerialize() {
        var data = $("#userForm").serializeArray();
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
        employeeId = [];
        $("#employee-table input[type='checkbox']").each(function (i) {
            if ($(this).prop('checked')) {
                employeeId.push($(this).val());
            }
        });
        console.log(employeeId);
    }
});