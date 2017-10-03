
var REQUEST_SUCCESS = 10000;
// var REQUEST_ERROR

/**
 * 发送数据
 * @todo AJAX同步请求发送
 * @param sendurl 发送消息的路径
 * @param data 发送消息的数据
 * @return 服务器返回的数据
 */
function requestSend(sendurl, data){
    var res;
    $.ajax({
        url:sendurl,
        type:'post',
        async:false,
        data:data,
        dataType:'json',
        error:function(resData){
            console.log(resData);
        },
        success:function(resData){
            console.log(resData);
            res = resData;
        }
    });
    return res;
}

/**
 * @TODO 错误消息弹出框
 * @param Mess 错误信息
 *
 */
function alerterror(Mess){
    swal("警告", Mess, "error");
}
function add0(m){return m<10?'0'+m:m }
function format(shijianchuo)
{
    //shijianchuo是整数，否则要parseInt转换
    var time = new Date(shijianchuo);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm);
}
function isRead(isread){
    if(isread == 1){
        return "未读";
    }else{
        return "已读";
    }
}


/**
 * function
 * @author ZLei
 * @date 2017/9/18
 * @param feedback 请求状态信息
 * @return boolean true:请求成功, false:请求失败
 * @todo
 */
function loadResult(feedback) {

    if(feedback == REQUEST_SUCCESS){
        return true;
    }else{
        alerterror(loadErrorMsg(feedback));
        return false;
    }
}

/**
 * function
 * @author ZLei
 * @date 2017/9/18
 * @param 请求状态
 * @return 请求错误信息
 * @todo
 */
function loadErrorMsg(feedback) {
    if(feedback == 10001){ // 登录失败
        return "登录失败,请重试";
    }else if(feedback == 10002){ // 文件上传出错
        return "文件上上传出错请重试";
    }
    return "";
}

