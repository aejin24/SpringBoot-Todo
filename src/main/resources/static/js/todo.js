function resetData() {
    $("input[name='title']").val("");
    $("textarea").val("");
}

//등록하기
$(".btn-wrap button:first-child").on("click", function() {
    let title = $("input[name='title']").val();
    let content = $("textarea").val();

    if(!title){
        alert("제목을 입력해주세요!");
        $("input[name='title']").focus();
    }else if(!content){
        alert("내용을 입력해주세요!");
        $("textarea").focus();
    }else {
        console.log("ajax로 데이터 보내기");
        resetData();
    }
});

//메인 화면으로 돌아가기
$(".btn-wrap button:nth-child(2)").on("click", function(){
    const listUrl = $("#listUrl").attr("data-src");
    window.location.href = listUrl;
});


//내용 초기화
$(".btn-wrap button:last-child").on("click", function(){
    resetData();
});