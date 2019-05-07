<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
<#assign path="${springMacroRequestContext.getContextPath()}">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${path}/css/layui.css" media="all">
    <script src="${path}/layui.js"></script>
    <script src="${path}/jquery-1.11.3.js"></script>

</head>
<body>
<form class="layui-form" style="margin-top: 10px; padding: 20px" id = "cou">
    <div class="layui-form-item">
        <label class="layui-form-label">优惠券价值</label>
        <div class="layui-input-inline">
            <input type="tel" name="coMoney" lay-verify="title" autocomplete="off" placeholder="" class="layui-input" onKeyUp="amount(this)"  onBlur="overFormat(this)">
        </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">优惠券条件</label>
      <div class="layui-input-inline">
          <input type="tel" name="coLimit" lay-verify="title" autocomplete="off" placeholder="" class="layui-input" onKeyUp="amount(this)"  onBlur="overFormat(this)">
      </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">优惠券有效期至</label>
        <div class="layui-input-inline">
            <input type="text" name="coValid" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">优惠券数量</label>
        <div class="layui-input-inline">
            <input type="tel" name="coNum" lay-verify="title" autocomplete="off" placeholder="" class="layui-input" onKeyUp="amount(this)">
    </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
                    <button class="layui-btn"  style="width: 800px;" onclick="sub()">添加</button>
        </div>
    </div>
</div>
</form>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#date' //指定元素
        });
    });
    function sub() {
        jQuery.ajax({
            url:'insertCoupon',
            type:'post',
            data:$("#cou").serialize(),
            success:function (data) {
                if(data.code=="200"){
                    layer.msg(data.msg, {
                        icon: 6,//成功的表情
                        time: 1000 //1秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        location.reload();
                    });
                }else{
                    layer.msg(data.msg, {
                        icon: 5,//成功的表情
                        time: 1000 //1秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        location.reload();
                    });
                }
            },
            error:function () {
                alert("系统错误");
            }
        });
    }
    /**
     * 实时动态强制更改用户录入
     * arg1 inputObject
     **/
    function amount(th) {
        var regStrs = [
            ['^0(\\d+)$', '$1'], //禁止录入整数部分两位以上，但首位为0
            ['[^\\d\\.]+$', ''], //禁止录入任何非数字和点
            ['\\.(\\d?)\\.+', '.$1'], //禁止录入两个以上的点
            ['^(\\d+\\.\\d{2}).+', '$1'] //禁止录入小数点后两位以上
        ];
        for (var i = 0; i < regStrs.length; i++) {
            var reg = new RegExp(regStrs[i][0]);
            th.value = th.value.replace(reg, regStrs[i][1]);
        }
    }
    /**
     * 录入完成后，输入模式失去焦点后对录入进行判断并强制更改，并对小数点进行0补全
     * arg1 inputObject
     **/
    function overFormat(th) {
        var v = th.value;
        if (v === '') {
            v = '0.00';
        } else if (v === '0') {
            v = '0.00';
        } else if (v === '0.') {
            v = '0.00';
        } else if (/^0+\d+\.?\d*.*$/.test(v)) {
            v = v.replace(/^0+(\d+\.?\d*).*$/, '$1');
            v = inp.getRightPriceFormat(v).val;
        } else if (/^0\.\d$/.test(v)) {
            v = v + '0';
        } else if (!/^\d+\.\d{2}$/.test(v)) {
            if (/^\d+\.\d{2}.+/.test(v)) {
                v = v.replace(/^(\d+\.\d{2}).*$/, '$1');
            } else if (/^\d+$/.test(v)) {
                v = v + '.00';
            } else if (/^\d+\.$/.test(v)) {
                v = v + '00';
            } else if (/^\d+\.\d$/.test(v)) {
                v = v + '0';
            } else if (/^[^\d]+\d+\.?\d*$/.test(v)) {
                v = v.replace(/^[^\d]+(\d+\.?\d*)$/, '$1');
            } else if (/\d+/.test(v)) {
                v = v.replace(/^[^\d]*(\d+\.?\d*).*$/, '$1');
                ty = false;
            } else if (/^0+\d+\.?\d*$/.test(v)) {
                v = v.replace(/^0+(\d+\.?\d*)$/, '$1');
                ty = false;
            } else {
                v = '0.00';
            }
        }
        th.value = v;
    }
</script>
</body>
</html>