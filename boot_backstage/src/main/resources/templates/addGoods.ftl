<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/layui.css" media="all">
    <script src="layui.js"></script>
    <script src="jquery-1.11.3.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">商品名称</label>
        <div class="layui-input-block">
            <input type="text" name="goName" lay-verify="title" autocomplete="off" placeholder="请输入商品名称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品简介</label>
        <div class="layui-input-block">
            <input type="text" name="goSynopsis" lay-verify="title" autocomplete="off" placeholder="请输入商品简介" class="layui-input">
        </div>
    </div>
    <select name="goType" lay-verify="">
        <option value="">请选择一个类型</option>
        <option value="1">类型1</option>
        <option value="2">类型2</option>
        <option value="3">类型3</option>
        <option value="4">类型4</option>
        <option value="5">类型5</option>
        <option value="6">类型6</option>
    </select>
</form>
</body>
</html>