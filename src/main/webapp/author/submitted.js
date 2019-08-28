$("#newstitle2").click(function () {
    $("#selects2").html($(this).text()+"<span class='caret'></span>")
})
$("#newssubtitle2").click(function () {
    $("#selects2").html($(this).text()+"<span class='caret'></span>")
})
$("#newscontent2").click(function () {
    $("#selects2").html($(this).text()+"<span class='caret'></span>")
})
//查询
function bbb(pageNum) {
    var clue2=$("#clue2").val()
    // var clue2=$("#clue2").val()
    if (clue2===""){
        showNewsList(0);
    }else {
        var selects2=$("#selects2").text()
        if (selects2[0]=="标"){
            selects2="newstitle"
        }else if (selects2[0]=="副"){
            selects2="newssubtitle"
        }else if (selects2[0]=="新"){
            selects2="newscontent"
        }

        console.log(clue2+" : "+selects2)
        if (pageNum==null){
            pageNum=0
        }
        $.ajax({
            type:"post",
            dataType:"json",
            contentType: "application/json;charset=utf-8",
            url:"/youya_news/selectNewsByClue",
            data:JSON.stringify({
                clue1:clue2,
                selects1:selects2,
                pageNum:pageNum
            }),
            success : function(result){
                newscontext(result);
                newsselectpages(result);
                console.log(result);
            },
            error : function(e){

            }
        })
    }
}
//拼接列表页
function newscontext(result){
    var trStr="";
    $(result.list).each(function(index,item){
        trStr+= "<tr id=newstr"+item.newsid+">";
        trStr+="<td>"+item.newsid+"</td>";
        trStr+="<td><input type='checkbox' class='newscheckboxs' id=newscheck_"+item.newsid+" onclick='newscheck("+item.newsid+")'></td>";
        trStr+="<td>"+item.newstitle+"</td>";
        trStr+="<td>"+item.newscreatetime+"</td>";
        trStr+="<td>"+item.newsclicks+"</td>";
        trStr+="<td>"+item.newstalks+"</td>";
        trStr+="<td id=newsstatus"+item.newsid+" class='newsstatus'><i></i>"+item.newsstatus+"</td>";
        trStr+="<td>";
        trStr+="<a onclick='showNewsdetail("+item.newsid+")' class='btn btn-primary btn-xs' ><i class=' glyphicon glyphicon-eye-open' ></i></a>&nbsp;";
        trStr+="<a onclick='removeNews("+item.newsid+")' class='btn btn-danger btn-xs' ><i class=' glyphicon glyphicon-remove'  ></i></a>";
        trStr+="</td>";
        trStr+="</tr>";
    });
    $("#dataNews").html(trStr);
    $('.newsstatus').each(function () {
        if ($(this).text()==="2"){
            $(this).html("<i class='glyphicon glyphicon-time'></i>")
        }else if ($(this).text()==="0"){
            $(this).html("<i class='glyphicon glyphicon-remove'></i>")
        }else if ($(this).text()==="1"){
            $(this).html("<i class='glyphicon glyphicon-ok'></i>")
        }
    })
}

//全选框
$("#newscheckbox").click(function () {
    var fal =$(this).prop("checked");
    $(".newscheckboxs").prop("checked",fal)
});
//异步加载的全选框
function newscheck(id){
    var flg =$("#newscheck_"+id).prop("checked");
    if (!flg){
        $("#newscheckbox").prop("checked",flg)
    } else if($(".newscheckboxs").length==$(".newscheckboxs:checked").length){
        $("#newscheckbox").prop("checked",flg)
    }
}
// 批量删除
$("#removeAllNews").click(function () {
    var a=$(".newscheckboxs:checked")
    for (var i = 0; i < a.length; i++) {
        removeNews($(a[i]).attr("id").split("_")[1])
    }
});

//删除
function removeNews(newsid) {
    $.ajax({
        url:"/youya_news/removeNews",
        type:"post",
        contentType: "application/json;charset=utf-8",
        data:JSON.stringify({
            newsid:newsid
        }),
        success: function (responseText) {
            $("#newsstatus"+newsid).html("<i class='glyphicon glyphicon-remove'></i>")
        },
        error: function (responseText) {
            alert(responseText)
        }
    })
}

//查询后分页
function newsselectpages(result){
    var splitePageStr = "<li id='newsprePage'><a onclick='bbb("+result.prePage+")' href='javascript:void(0);'>上一页</a></li>";
    for(var i=1;i<=result.pages;i++){
        splitePageStr +="<li id='newspages"+i+"'><a onclick='bbb("+i+")' href='javascript:void(0);'>"+i+"</a></li>";
    }
    splitePageStr += "<li id='newsnextPage'><a onclick='bbb("+result.nextPage+")' href='javascript:void(0);'>下一页</a></li>";
    $(".newspagination").html(splitePageStr);

    if (result.isFirstPage){
        $("#newsprePage").addClass("disabled");
        $("#newsprePage a").removeAttr('onclick');
    }
    if (result.isLastPage){
        $("#newsnextPage").addClass("disabled");
        $("#newsnextPage a").removeAttr('onclick');
    }
    $("#newspages"+result.pageNum).addClass("active");
    $("#newspages"+result.pageNum+" a").removeAttr("onclick");
}
//显示所有分页
function shownewsages(result){
    var splitePageStr = "<li id='newsprePage'><a onclick='showNewsList("+result.prePage+")' href='javascript:void(0);'>上一页</a></li>";
    for(var i=1;i<=result.pages;i++){
        splitePageStr +="<li id='newspages"+i+"'><a onclick='showNewsList("+i+")' href='javascript:void(0);'>"+i+"</a></li>";
    }
    splitePageStr += "<li id='newsnextPage'><a onclick='showNewsList("+result.nextPage+")' href='javascript:void(0);'>下一页</a></li>";
    $("#newspagination").html(splitePageStr);

    if (result.isFirstPage){
        $("#newsprePage").addClass("disabled");
        $("#newsprePage a").removeAttr('onclick');
    }
    if (result.isLastPage){
        $("#newsnextPage").addClass("disabled");
        $("#newsnextPage a").removeAttr('onclick');
    }
    $("#newspages"+result.pageNum).addClass("active");
    $("#newspages"+result.pageNum+" a").removeAttr("onclick");
}
//刷新页面
function showNewsList(pageNum) {
    $.ajax({
        type : "post",
        dataType:"json",
        contentType: "application/json;charset=utf-8",
        url : "/youya_news/getAllNewsByUserid",
        data:JSON.stringify({
            pageNum:pageNum
        }),
        success : function(result) {
            newscontext(result);
            shownewsages(result);
            console.log(result);
        },
        error : function(e){
            console.log(e.responseText);
        }
    })
}
showNewsList(0);
function showNewsdetail(newsid) {
    location.href="/youya_news/news/article.html?newsid="+newsid;
}