const resetData = () => {
    $("input[name='title']").val("");
    $("textarea").val("");
}

//등록하기
$(".btn-wrap button:first-child").on("click", () => {
    let title = $("input[name='title']").val();
    let content = $("textarea").val();

    if(!title){
        alert("제목을 입력해주세요!");
        $("input[name='title']").focus();
    }else if(!content){
        alert("내용을 입력해주세요!");
        $("textarea").focus();
    }else {
        $.ajax({
            type: "POST",
            url: "/todo/newToDo",
            data: {
                title: $("input[name='title']").val(),
                content: $("textarea").val()
            },
            success: () => {
                resetData();
                alert("To Do를 저장했습니다!");
            },
            error: (request) => {
                alert("error: " + request.status);
            }
        });
    }
});

//메인 화면으로 돌아가기
$(".btn-wrap button:nth-child(2)").on("click", () => {
    const listUrl = $("#listUrl").attr("data-src");
    window.location.href = listUrl;
});


//내용 초기화
$(".btn-wrap button:last-child").on("click", () => {
    resetData();
});