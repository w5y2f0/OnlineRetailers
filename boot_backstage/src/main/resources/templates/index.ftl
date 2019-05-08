<!DOCTYPE html>
<html>
<head>
<#assign path="${springMacroRequestContext.getContextPath()}">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${path}/css/layui.css" media="all">
    <script src="${path}/layui.js"></script>
    <script src="${path}/jquery-1.11.3.js"></script>
    <script type="text/javascript" charset="utf-8" src="${path}/ueditor/ueditor.config.js"></script> <!--ueditor的配置文件-->
    <script type="text/javascript" charset="utf-8" src="${path}/ueditor/ueditor.all.min.js"></script> <!--ueditor核心文件-->
    <script type="text/javascript" charset="utf-8" src="${path}/ueditor/lang/zh-cn/zh-cn.js"></script> <!--ueditor语言文件-->
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
                        <dd><a href="javascript:add();">商品上架</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">优惠券信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:list1();">优惠券列表</a></dd>
                        <dd><a href="javascript:add1();">添加优惠券</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div id="ert">
            <div id = "qqq">
                <table id="table" lay-filter="table"></table>
            </div>
            <div id = "www">
                <iframe src="" frameborder="0" id="demoAdmin" style="width: 100%; height: 1200px;"></iframe>
            </div>
        </div>
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
    function add() {
        document.getElementById("qqq").style.display="none";//隐藏
        document.getElementById("www").style.display="";//显示
        $("#demoAdmin").attr("src","goods/addGoods");
    }
    function add1() {
        document.getElementById("qqq").style.display="none";//隐藏
        document.getElementById("www").style.display="";//显示
        $("#demoAdmin").attr("src","coupon/addCoupon");
    }
    function list() {
        document.getElementById("www").style.display="none";//隐藏
        document.getElementById("qqq").style.display="";//显示
//        $('#qqq').html("<table id="table" lay-filter="table"></table>");
//        $('#ert').empty();//jQuery方法一
//        $('#ert').html('');//jQuery方法二
        $("#demoAdmin").attr("src","");
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                id:'table'
                ,elem: '#table'
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
                    document.getElementById("qqq").style.display="none";//隐藏
                    document.getElementById("www").style.display="";//显示
                    $("#demoAdmin").attr("src","goods/selectByIdS?id="+data.goId);
                } else if (layEvent === 'del') { //删除
                    layer.confirm('确定删除['+data.goName+']吗', function (index) {
                        jQuery.ajax({
                            url:"/goods/deleteGood",
                            type:'post',
                            data:{"id":data.goId},
                            success:function (msg) {
                                list();
                                layer.closeAll('dialog');
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
    function list1() {
        document.getElementById("www").style.display="none";//隐藏
        document.getElementById("qqq").style.display="";//显示
//        $('#qqq').html("<table id="table" lay-filter="table"></table>");
//        $('#ert').empty();//jQuery方法一
//        $('#ert').html('');//jQuery方法二
        $("#demoAdmin").attr("src","");
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                id:'table'
                ,elem: '#table'
                ,url: '/coupon/selectAll' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {field: 'coId', title: 'ID', sort: true, fixed: 'left',align:"center"}
                    ,{field: 'coMoney', title: '优惠券价值', sort: true, fixed: 'left',align:"center"}
                    ,{field: 'coLimit', title: '优惠条件',align:"center"}
                    ,{field: 'coValid', title: '有效时间',  sort: true,align:"center"}
                    ,{field: 'coStates', title: '优惠券状态',align:"center",templet:function (row){
                        if(row.coStates==1){
//                            return "可领取";
                            return '<span class="layui-btn layui-btn-green layui-btn-xs">可领取</span>';
                        }else if(row.coStates==2){
//                            return "不可领取";
                            return '<span class="layui-btn layui-btn-warm layui-btn-xs">不可领取</span>';
                        }else if(row.coStates==3){
//                            return "已领完";
                            return '<span class="layui-btn layui-btn-danger layui-btn-xs">已领完</span>';
                        }else{
                            return row.coStates;
                        }
                    }}
                    ,{field: 'coNum', title: '优惠券数量',align:"center"}
                    ,{title:'操作',toolbar:"#barDemo1",align:"center"}
                ]]
            });
            table.on('tool(table)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象

                if (layEvent === 'detail1') { //查看
                    document.getElementById("qqq").style.display="none";//隐藏
                    document.getElementById("www").style.display="";//显示
                    $("#demoAdmin").attr("src","coupon/selectByIds?id="+data.coId);
                } else if (layEvent === 'del1') { //删除
                    layer.confirm('确定删除['+data.coId+']吗', function (index) {
                        jQuery.ajax({
                            url:"/coupon/deleteCoupon",
                            type:'post',
                            data:{"id":data.coId},
                            success:function (msg) {
                                list1();
                                layer.closeAll('dialog');
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
    <a class="layui-btn layui-btn-primary layui-btn-xs " lay-event="detail">编辑</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs layui-btn-danger" lay-event="del" id = "del">删除</a>
</script>
<script type="text/html" id="barDemo1">
    <a class="layui-btn layui-btn-primary layui-btn-xs " lay-event="detail1">编辑</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs layui-btn-danger" lay-event="del1" >删除</a>

</script>
</body>
</html>