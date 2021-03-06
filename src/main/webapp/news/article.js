let datas = new Date();
let da = datas.getDate();
let month = datas.getMonth() + 1;
let year = datas.getFullYear();
let min = datas.getMinutes();
let hours = datas.getHours();
let newsid= location.search.split("=")[1].split("&")[0];
let userid;
//获取当前时间
$(".blog_date_div").html("<p>"+
    "<i class='glyphicon glyphicon-time'></i>&ensp;"+
    year + "-" + month + "-" + da + "&nbsp" + hours + ":" + min+
    "</p>");
//更新当前时间(每隔5s)
setInterval(function() {
    datas = new Date();
    da = datas.getDate();
    month = datas.getMonth() + 1;
    year = datas.getFullYear();
    min = datas.getMinutes();
    hours = datas.getHours();
    $(".blog_date_div").html("<p>"+
        "<i class='glyphicon glyphicon-time'></i>&ensp;"+
        year + "-" + month + "-" + da + "&nbsp" + hours + ":" + min+
        "</p>");
}, 5000);
//获取用户信息
$.ajax({
    type:"get",
    url:"/youya_news/initUser",
    success:function (result) {
        if (result!="false"){
            if (result.rolename==="小编"){
                $("#user").attr("href","/youya_news/author/draftlist.html")
            }
            if (result.rolename==="会员"){
                $("#user").attr("href","/youya_news/usermanage/userpersonal.html")
            }
            if (result.rolename==="管理员"){
                $("#user").attr("href","/youya_news/administrator/articleReview.html")
            }
            $("#blogUserWrapper").html("<img src=\""+result.icon+"\" class=\"img-fluid\" height=\"40\" width=\"40\">\n" +
                ""+result.username+"<i class=\"fa fa-angle-down\" aria-hidden=\"true\"></i>");
            $("#blogUserWrapper").attr("href","javascript:void(0);");
            userid=result.userid
        }
    }
});
//获取文章内容
$.ajax({
    type:"get",
    url:"/youya_news/ReleaseSystem/getNewsDetil",
    data:{
        newsid:newsid
    },
    success:function (result) {
        console.log(result);
        $("#mainimg").attr("src",result.newsimg);
        $(".blog_post_style2_content h3").text(result.newstitle);
        $("#blog_author_data").html("<img src=\""+result.icon+"\" class=\"img-fluid\" alt=\"\" width=\"34\" height=\"34\">" + result.username);
        $("#clicks").html("<i class=\"glyphicon glyphicon-eye-open\"></i>&ensp;"+result.newsclicks+"");
        $("#talks").html("<i class=\"fa fa-comments\"></i>&ensp;"+result.newstalks+"");
        $("#createtime").html("<i class=\"glyphicon glyphicon-time\"></i>&ensp;"+result.newscreatetime+"");
        $("#content").html(result.newscontent);
    }
});
//获取评论信息
function getcomment(){
    $(".comment-list").html("");
    $.ajax({
        type:"get",
        url:"/youya_news/ReleaseSystem/getAllComment",
        // dataType:"json",
        data:{
            newsid:newsid
        },
        success:function (result) {
            let str="";
            let reply="";
            console.log(result);
            $(".blog_comment_div h3:first").html("评论<span>("+result.length+")</span>");
            $(result).each(function(index,item){
                str="<li class=\"wow fadeInUp\" style=\"visibility: visible; animation-name: fadeInUp;\">\n" +
                    "<!--评论主体-->\n" +
                    "<div class=\"blog_comment\">\n" +
                    "<!--评论者头像-->\n" +
                    "<div class=\"blog_comment_img\">\n" +
                    "<img src=\""+item.cicon+"\" class=\"img-fluid\" alt=\"\" height=\"70\" width=\"70\">\n" +
                    "</div>\n" +
                    "<!--评论数据-->\n" +
                    "<div class=\"blog_comment_data\"><h3>"+item.cusername+"<span>- "+item.commenttime+"</span></h3>\n" +
                    "<p>"+item.commentcontent+""+
                    "</p></div></div>\n" +
                    "<!--点赞和评论-->\n" +
                    "<div class=\"blog_comment_meta\"><ul>\n" +
                    "<!--点赞--><li>\n" +
                    "<a href=\"javascript:void(0);\">\n" +
                    "<i class=\"fa fa-thumbs-o-up\"></i>\n" +
                    "&ensp;26</a></li>\n" +
                    "<!--评论--><li>\n" +
                    "<a href=\"javascript:void(0);\" onclick='reply("+item.commentid+","+item.userid+","+'\"'+item.cusername+'\"'+")'>\n" +
                    "<i class=\"fa fa-comments\"></i>\n" +
                    "&ensp;"+item.replyVOList.length+"</a></li></ul></div><ul class=\"children\" id='comment"+item.commentid+"'></ul></li>";
                $(".comment-list").append(str);
                if (item.replyVOList.length!=0){
                    $(item.replyVOList).each(function(index,item){
                        reply="<li class=\"wow fadeInUp\" style=\"visibility: visible; animation-name: fadeInUp;\">\n" +
                            "<!--评论主体-->\n" +
                            "<div class=\"blog_comment\">\n" +
                            "<!--评论者头像-->\n" +
                            "<div class=\"blog_comment_img\">\n" +
                            "<img src=\""+item.ricon+"\" class=\"img-fluid\" alt=\"\" height=\"70\" width=\"70\">\n" +
                            "</div>\n" +
                            "<!--评论数据-->\n" +
                            "<div class=\"blog_comment_data\"><h3>"+item.rusername+": @"+item.rcusername+"<span>- "+item.replytime+"</span></h3>\n" +
                            "<p>"+item.replycontent+""+
                            "</p></div></div>\n" +
                            "<!--点赞和评论-->\n" +
                            "<div class=\"blog_comment_meta\"><ul>\n" +
                            "<!--点赞--><li>\n" +
                            "<a href=\"javascript:void(0);\">\n" +
                            "<i class=\"fa fa-thumbs-o-up\"></i>\n" +
                            "&ensp;26</a></li>\n" +
                            "<!--评论--><li>\n" +
                            "<a href=\"javascript:void(0);\" onclick='reply("+item.commentid+","+item.replierid+","+'\"'+item.rusername+'\"'+")'>\n" +
                            "<i class=\"fa fa-comments\"></i>\n" +
                            "&ensp;</a></li></ul></div></li>";
                        $("#comment"+item.commentid).append(reply)
                    });
                }
            });
        }
    });
}
getcomment();
//评论
function comment() {
    if (userid===undefined){
        alert("请登录");
        location.href="/youya_news/login.html";
    }else {
        if ($(".form-control").val()===""){
            alert("内容不能为空")
        }else {
            $.ajax({
                type : "post",
                contentType: "application/json;charset=utf-8",
                // async:false,
                url : "/youya_news/ReleaseSystem/createComment",
                data:JSON.stringify({
                    userid:userid,
                    newsid:newsid,
                    comment:$(".form-control").val()
                }),
                success:function (result) {
                    getcomment();
                }
            })
        }
    }
}
//弹出隐藏输入框
function reply(commentid,id,name) {
    if (userid===undefined){
        alert("请登录后回复评论");
    }else {
        $('#myModalLabel').text('回复 @'+name);
        $('#myModal').modal('show');
        $('#upreply').attr('onclick',"upreplys("+commentid+","+id+","+"\""+name+"\""+")");
    }
}
//回复
function upreplys(commentid,id,name) {
    if ($('#text1').val()===""){
        alert("内容为空")
    }else {
        $.ajax({
            type : "post",
            contentType: "application/json;charset=utf-8",
            url : "/youya_news/ReleaseSystem/createReply",
            data:JSON.stringify({
                commentid:commentid,
                userid:id,
                replierid:userid,
                newsid:newsid,
                replycontent:$("#text1").val()
            }),
            success:function (result) {
                $('#myModal').modal('hide');
                getcomment();
            }
        })
    }
}
//退出登录
function signout() {
    $.ajax({
        type : "get",
        url : "/youya_news/ReleaseSystem/signOut",
        success:function (result) {
            location.reload();
        }
    })
}

