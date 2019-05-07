<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品类型查询界面</title>
    <#assign path="${springMacroRequestContext.getContextPath()}">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/layui.css" media="all">
    <script src="${path}/jquery-1.11.3.js"></script>
    <script src="${path}/layui.js" charset="utf-8"></script>

</head>

<body>

<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.config({
        version: '123456789' //为了更新 js 缓存，可忽略
    });

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
        var laydate = layui.laydate //日期
                ,laypage = layui.laypage //分页
                ,layer = layui.layer //弹层
                ,table = layui.table //表格
                ,carousel = layui.carousel //轮播
                ,upload = layui.upload //上传
                ,element = layui.element //元素操作
                ,slider = layui.slider //滑块

        //向世界问个好
        layer.msg('Hello World');

        //监听Tab切换
        element.on('tab(demo)', function(data){
            layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
                tips: 1
            });
        });

        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 400
            ,url:'/type/selectAll' //数据接口
            ,title: '商品类型表'
            ,page: true //开启分页
            ,totalRow: false //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'typeId', title: 'ID', width:'22%', sort: true}
                ,{field: 'typeName', title: '名称', width:'22%'}
                ,{fixed: 'right', width: '30%', align:'center', toolbar: '#barDemo'}
            ]]
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                    ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    //layer.msg('添加');

                    break;
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                    ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    //console.info(data.typeId);
                   // obj.del(); //删除对应行（tr）的DOM结构
                    //layer.close(index);
                    //向服务端发送删除指令
                    typeDelete(data.typeId);
                });
            } else if(layEvent === 'edit'){
                layer.msg('编辑操作');
            }
        });
    });
</script>

<form id="addType">
    <div class="layui-form-item">

        <label class="layui-form-label">类型名称</label>

        <div class="layui-input-inline">
            <input type="text" name="typeName" id="typeName" autocomplete="off" placeholder="请输入商品类型名称" class="layui-input">
        </div>

        <div class="layui-btn-group">
            <button class="layui-btn layui-btn-normal" onclick="add()">增加</button>
        </div>

    </div>
</form>

<script>
    //新增
    function add() {
        $.ajax({
            type:'post',
            url:'insertType',
            data:$("#addType").serialize(),
            dataType:"json",
            success:function (msg) {
                alert("新增成功！！！");
                //重新加载父页面
                location.reload();
            },
            error:function () {
                alert("系统错误");
            }
        })
    }

    //删除
    function typeDelete(index) {
        $.ajax({
            type:'post',
            url:'deleteType',
            data:{"typeId":index},
            success:function (msg) {
                alert("删除成功！！！");
                //重新加载父页面
                location.reload();
            },
            error:function(){
                alert("系统错误！！！");
            }
        })
    }
</script>

</body>
</html>