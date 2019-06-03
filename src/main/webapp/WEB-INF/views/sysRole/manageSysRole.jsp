<%--
  Created by IntelliJ IDEA.
  User: TYK
  Date: 2019/5/21
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, width=device-width, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" />
    <title>角色列表</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Roles</h1>
                <ol class="breadcrumb">
                    <li><i class="fa fa-dashboard"></i><a href="/dashboard">Dashboard</a></li>
                    <li class="active"><i class="fa fa-table"></i> Roles</li>
                </ol>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <%--<div class="col-lg-12">--%>
                    <%--<h2>员工信息表</h2>--%>
                    <%--<div class="btn-toolbar">--%>
                    <%--<button class="btn btn-default" type="submit">Button</button>--%>
                    <%--<button class="btn btn-default" type="submit">Button</button>--%>
                    <%--</div>--%>


                    <%--</div>--%>
                    <button class="btn btn-info" id="add">新增</button>
                    <button class="btn btn-success" id="edit">编辑</button>
                    <button class="btn btn-danger" id="delete">删除</button>
                    <button class="btn btn-warning" id="view">查看</button>
                </div>
                <div class="table-responsive" style="min-height: 494px">
                    <table class="table table-bordered table-hover table-striped" id="role-table">
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%--警告框--%>
    <div class="alert alert-warning  alert-dismissable hide" id="rowWarning">
        <button type="button" class="close"
                aria-hidden="true">
            &times;
        </button>
        <strong>
            请选择行！！！
        </strong>
    </div>
    <!-- 用户删除模态框（Modal） -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">删除</h4>
                </div>
                <div class="modal-body">确认删除该行吗？</div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="deleteClose">关闭</button>
                    <button type="button" class="btn btn-primary" id="deleteSubmit">确定</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <!-- 用户新增模态框（Modal） -->
    <div class="modal fade" id="contentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">新增角色</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="roleForm">
                        <div class="form-group">
                            <label for="role" class="col-md-2 control-label">角色名</label>
                            <div class="col-md-3">
                                <input type="text" class="form-control" id="role" placeholder="输入角色名" name="role">
                            </div>
                            <label for="description" class="col-md-2 control-label col-md-offset-1">描述</label>
                            <div class="col-md-3">
                                <input type="text" class="form-control" id="description" placeholder="输入角色描述" name="description">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="close">关闭</button>
                    <button type="reset" class="btn btn-default" id="reset">重置</button>
                    <button type="submit" class="btn btn-primary" id="submit">提交</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
<script type="text/javascript" src="/static/js/roleManage.js"></script>
</body>
</html>
