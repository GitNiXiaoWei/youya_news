$("#newstitle1").click(function () {
    $("#selects1").html($(this).text()+"<span class='caret'></span>")
})
$("#newssubtitle1").click(function () {
    $("#selects1").html($(this).text()+"<span class='caret'></span>")
})
$("#newscontent1").click(function () {
    $("#selects1").html($(this).text()+"<span class='caret'></span>")
})

function aaa(pageNum) {
    var clue1=$("#clue1").val()
    if (clue1===""){
        reloadpage(0)
    }else {
        var selects1=$("#selects1").text()
        if (selects1[0]=="标"){
            selects1="newstitle"
        }else if (selects1[0]=="副"){
            selects1="newssubtitle"
        }else if (selects1[0]=="新"){
            selects1="newscontent"
        }

        console.log(clue1+" : "+selects1)
        if (pageNum==null){
            pageNum=0
        }
        $.ajax({
            type:"post",
            dataType:"json",
            contentType: "application/json;charset=utf-8",
            url:"/youya_news/selectDraftsByClue",
            data:JSON.stringify({
                clue1:clue1,
                selects1:selects1,
                pageNum:pageNum
            }),
            success : function(result){
                context(result);
                selectpages(result);
                console.log(result);
            },
            error : function(e){

            }
        })
    }

}
function selectpages(result){
    var splitePageStr = "<li id='prePage'><a onclick='aaa("+result.prePage+")' href='javascript:void(0);'>上一页</a></li>";
    for(var i=1;i<=result.pages;i++){
        splitePageStr +="<li id='pages"+i+"'><a onclick='aaa("+i+")' href='javascript:void(0);'>"+i+"</a></li>";
    }
    splitePageStr += "<li id='nextPage'><a onclick='aaa("+result.nextPage+")' href='javascript:void(0);'>下一页</a></li>";
    $(".pagination").html(splitePageStr);

    if (result.isFirstPage){
        $("#prePage").addClass("disabled");
        $("#prePage a").removeAttr('onclick');
    }
    if (result.isLastPage){
        $("#nextPage").addClass("disabled");
        $("#nextPage a").removeAttr('onclick');
    }
    $("#pages"+result.pageNum).addClass("active");
    $("#pages"+result.pageNum+" a").removeAttr("onclick");
}
