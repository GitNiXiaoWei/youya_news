let datas = new Date();
let da = datas.getDate();
let month = datas.getMonth() + 1;
let year = datas.getFullYear();
let min = datas.getMinutes();
let hours = datas.getHours();
let newsid= location.search.split("=")[1].split("&")[0];
alert(newsid)
//获取当前时间
$(".blog_date_div").html("<p>"+
    "<i class='glyphicon glyphicon-time'></i>"+
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
        "<i class='glyphicon glyphicon-time'></i>"+
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
                $("#blogUserWrapper").attr("href","/youya_news/author/draftlist.html")
            }
            if (result.rolename==="会员"){
                $("#blogUserWrapper").attr("href","/youya_news/usermanger/message.html")
            }
            if (result.rolename==="管理员"){
                $("#blogUserWrapper").attr("href","/youya_news/administrator/articleReview.html")
            }
            $("#blogUserWrapper").html("" +
                "<img src=\""+result.icon+"\" class=\"img-fluid\" height=\"40\" width=\"40\">\n" +
                ""+result.username+"")
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
        $("#clicks").html("<i class=\"glyphicon glyphicon-eye-open\"></i>"+result.newsclicks+"");
        $("#talks").html("<i class=\"fa fa-comments\"></i>"+result.newstalks+"");
        $("#createtime").html("<i class=\"glyphicon glyphicon-time\"></i>"+result.newscreatetime+"");
        $("#content").html(result.newscontent);
    }
});

