<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="css/layui.css" media="all">
    <script src="layui.js"></script>
    <script src="jquery-1.11.3.js"></script>
    <title>1432</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    用户名
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:list();">商品列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <table id="table" lay-filter="table"></table>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    function list() {
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#table'
                ,url: '/goods/selectAll' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {field: 'goId', title: 'ID', sort: true, fixed: 'left',align:"center"}
                    ,{field: 'goName', title: '商品名称', sort: true, fixed: 'left',align:"center"}
                    ,{field: 'goSynopsis', title: '商品简介',align:"center"}
                    ,{field: 'goType', title: '商品种类',  sort: true,align:"center",templet:function (row){
                        if(row.goType==1){
                            return "种类1";
                        }else if(row.goType==2){
                            return "种类2";
                        }else if(row.goType==3){
                            return "种类3";
                        }else if(row.goType==4){
                            return "种类4";
                        }else if(row.goType==5){
                            return "种类5";
                        }else{
                            return row.getType;
                        }
                    }}
                    ,{field: 'goStates', title: '傻瓜品状态',align:"center",templet:function (row){
                        if(row.goStates==1){
                            return "状态1";
                        }else if(row.goStates==2){
                            return "状态2";
                        }else if(row.goStates==3){
                            return "状态3";
                        }else{
                            return row.goStates;
                        }
                    }}
                    ,{field: 'goDatetimes', title: '商品上架时间',align:"center"}
                    ,{field: 'goSales', title: '商品销量', sort: true,align:"center"}
                    ,{field: 'goOld', title: '商品原价',  sort: true,align:"center"}
                    ,{field: 'goNew', title: '商品现价',align:"center"}
                    ,{field: 'goNum', title: '商品库存', sort: true,align:"center"}
                    ,{title:'操作',toolbar:"#barDemo",align:"center"}
                ]]
            });
            table.on('tool(table)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象

                if (layEvent === 'detail') { //查看

                } else if (layEvent === 'del') { //删除
                    layer.confirm('确定删除['+data.goName+']吗', function (index) {
                        jQuery.ajax({
                            url:"/goods/deleteGood",
                            type:'post',
                            data:{"id":data.goId},
                            beforeSend:function () {
                                this.layerIndex = layer.load(0, { shade: [0.5, '#67231'] });
                            },
                            success:function (msg) {
                                layer.msg(msg.msg, {
                                    icon: 6,//成功的表情
                                    time: 2000 //1秒关闭（如果不配置，默认是3秒）
                                }, function(){
                                    location.reload();
                                });
                            },
                            error:function () {
                                layer.alert('ERROR', {
                                    title: '提示'
                                })
                            }
                        });
                    });
                } else if (layEvent === 'edit') { //编辑

                }
            });
        });
    }
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs layui-btn-green" lay-event="detail">编辑</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>
</body>
</html>