<!DOCTYPE html>
<html>
<head>
    <title>134</title>
<#assign path="${springMacroRequestContext.getContextPath()}">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${path}/css/layui.css" media="all">
    <script src="${path}/layui.js"></script>
    <script src="${path}/jquery-1.11.3.js"></script>
    <script type="text/javascript" charset="utf-8" src="${path}/ueditor/ueditor.config.js"></script> <!--ueditor的配置文件-->
    <script type="text/javascript" charset="utf-8" src="${path}/ueditor/ueditor.all.min.js"></script> <!--ueditor核心文件-->
    <script type="text/javascript" charset="utf-8" src="${path}/ueditor/lang/zh-cn/zh-cn.js"></script> <!--ueditor语言文件-->

</head>
<body>
<form class="layui-form" style="margin-top: 10px; padding: 20px" id = "add">
    <div class="layui-form-item">
        <label class="layui-form-label">商品名称：</label>
        <div class="layui-input-inline">
            <input type="tel" name="goName" lay-verify="title" autocomplete="off" placeholder="请输入商品名称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品简介：</label>
        <div class="layui-input-block">
            <input type="text" name="goSynopsis" lay-verify="title" autocomplete="off" placeholder="请输入商品简介" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品描述：</label>
    </div>
    <script id="container" name="goDetailed" type="text/plain">商品详情</script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container');
/*    var ues = UE.getContent();
    //对编辑器的操作最好在编辑器ready之后再做
    ues.ready(function() {
        //设置编辑器的内容
        ues.setContent('hello');
        //获取html内容，返回: <p>hello</p>
        var html = ue.getContent();
        //获取纯文本内容，返回: hello
        var txt = ue.getContentTxt();
    });*/
    </script>
    <div class="layui-form-item">
        <label class="layui-form-label">商品类型</label>
        <select name="goType" lay-verify="">
            <option value="">请选择一个类型</option>
            <option value="1">类型1</option>
            <option value="2">类型2</option>
            <option value="3">类型3</option>
            <option value="4">类型4</option>
            <option value="5">类型5</option>
            <option value="6">类型6</option>
        </select>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品状态</label>
        <div class="layui-input-block">
            <input type="radio" name="goStates" value="1" title="上架" checked="">
            <input type="radio" name="goStates" value="2" title="未上架">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品原价：</label>
        <div class="layui-input-inline" margin-top:30px>
            <input type="text" id = "old" lay-verify="required" name = "goOld" autocomplete="off" placeholder="" class="layui-input"onKeyUp="amount(this)"  onBlur="overFormat(this)">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品现价：</label>
        <div class="layui-input-inline" margin-top:30px>
            <input type="text" id = "new" lay-verify="required" name = "goNew" autocomplete="off" placeholder="" class="layui-input"onKeyUp="amount(this)"  onBlur="overFormat(this)">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品库存：</label>
        <div class="layui-input-inline" margin-top:30px>
            <input type="text"  lay-verify="required" name = "goNum" autocomplete="off" placeholder="" class="layui-input"onKeyUp="amount(this)" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品参数信息</label>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">商品颜色</label>
        <div class="layui-input-block">
            <input type="checkbox" name="paColor" lay-skin="primary" title="红色" value="1">
            <input type="checkbox" name="paColor" lay-skin="primary" title="粉色" value="2">
            <input type="checkbox" name="paColor" lay-skin="primary" title="白色" value="3">
            <input type="checkbox" name="paColor" lay-skin="primary" title="其他" value="4">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品质量：</label>
        <div class="layui-input-inline" margin-top:30px>
            <input type="text" id = "new" lay-verify="required" name = "paWeight" autocomplete="off" placeholder="" class="layui-input"onKeyUp="amount(this)">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品规格：</label>
        <div class="layui-input-inline" margin-top:30px>
            <input type="text" id = "new" lay-verify="required" name = "goSpecs" autocomplete="off" placeholder="" class="layui-input"onKeyUp="amount(this)"  onBlur="overFormat(this)">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品材料</label>
        <div class="layui-input-inline">
            <input type="text" name="goMaterial" lay-verify="title" autocomplete="off" placeholder="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品包装</label>
        <div class="layui-input-inline">
            <input type="text" name="goPacking" lay-verify="title" autocomplete="off" placeholder="" class="layui-input">
        </div>
    </div>
    <label class="layui-form-label">商品图片信息</label>
    <div class="layui-form-item">
                <label class="layui-form-label">商品图片上传</label>
                <div class="layui-input-block">
                    <button type="button" class="layui-btn" id="test1">
                        <i class="layui-icon">&#xe67c;</i>选择图片（最多选择20张，单张图片最大为10M）
                    </button>
                    <button type="button" class="layui-btn" id="test9">开始上传</button>
                    <button type="button" class="layui-btn" id="cleanImgs"> <i class="fa fa-trash-o fa-lg"></i>清空图片预览</button>
                </div>
                <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                    预览图：
                    <div class="layui-upload-list" id="demo2"></div>
                </blockquote>
            </div>
        
        <input type="text" id="imgUrls" name="imgUrls" style="display: none;" class="layui-input">
        <div class="layui-form-item">
            <div class="layui-input-block">
            
    <button class="layui-btn"  style="width: 800px;" onclick="sub()">上架</button>
            </div>
        </div>
</form>

<script>

    var success=0;
    var fail=0;
    var imgurls="";

    $(function (){
        var imgsName="";
        layui.use(['upload','layer'],function() {
            var upload = layui.upload;
            var layer=layui.layer;

            upload.render({
                elem: '#test1',
                url: '/upload',
                multiple: true,
                auto:false,
//			上传的单个图片大小
                size:10240,
//			最多上传的数量
                number:10,
//			MultipartFile file 对应，layui默认就是file,要改动则相应改动
                field:'file',
                bindAction: '#test9',
                before: function(obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function(index, file, result) {
                        $('#demo2').append('<img src="' + result
                                + '" alt="' + file.name
                                +'"height="92px" width="92px" class="layui-upload-img uploadImgPreView">')
                    });
                },
                done: function(res, index, upload) {
                    //每个图片上传结束的回调，成功的话，就把新图片的名字保存起来，作为数据提交
                    console.log(res.code);
                    if(res.code=="1"){
                        fail++;
                    }else{
                        success++;
                        imgurls=imgurls+""+res.data.src+",";
                        $('#imgUrls').val(imgurls);
                    }
                },
                allDone:function(obj){
                    layer.msg("总共要上传图片总数为："+(fail+success)+"\n"
                            +"其中上传成功图片数为："+success+"\n"
                            +"其中上传失败图片数为："+fail
                    )
                }
            });

        });

        //清空预览图片
        cleanImgsPreview();
        //保存商品
//        goodsSave();
    });

    /**
     * 清空预览的图片及其对应的成功失败数
     * 原因：如果已经存在预览的图片的话，再次点击上选择图片时，预览图片会不断累加
     * 表面上做上传成功的个数清0，实际后台已经上传成功保存了的，只是没有使用，以最终商品添加的提交的为准
      */
    function cleanImgsPreview(){
        $("#cleanImgs").click(function(){
            success=0;
            fail=0;
            $('#demo2').html("");
            $('#imgUrls').val("");
        });
    }

    /**
     * 保存商品
     */
//    function goodsSave() {
//        $('#btnSubmit').click(function () {
//            var tt = $("#title").val();
//            var st = $("#smallTit").val();
//            var ius = $("#imgUrls").val();
//
//            $.ajax({
//                type: "POST",
//                url: "/saveGoods",
//                data: {
//                    title: tt,
//                    smallTit: st,
//                    imgUrls: ius,
//                },
//                success: function (msg) {
//                    if (msg == "1") {
//                        alert("保存成功");
//                    } else {
//                        alert("保存失败");
//                    }
//                }
//            });
//        });
//    }
    function sub() {
        jQuery.ajax({
            url:'insertGood',
            type:'post',
            data:$("#add").serialize(),
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
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();
    });
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