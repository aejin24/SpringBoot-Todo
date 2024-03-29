//js parameter 값 가져오기
var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
                   sURLVariables = sPageURL.split("&"),
                   sParameterName,
                   i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split("=");

        if (sParameterName[0] === sParam) {
            return typeof sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
    return false;
};

//메인 화면으로 돌아가기
$(".btn-wrap button:last-child").on("click", () => {
    const listUrl = $("#listUrl").attr("data-src");
    window.location.href = listUrl;
});

//삭제하기
$(".btn-wrap button:nth-child(2)").on("click", () => {
    $.ajax({
        type: "POST",
        url: "/todo/delete",
        data: {
            id: getUrlParameter("id")
        },
        success: () => {
            alert("삭제 성공했습니다.");
            window.location.href = $("#listUrl").attr("data-src");
        },
        error: (request) => {
            alert("error: " + request.status);
        }
    });
});

//수정하기
$(".btn-wrap button:first-child").on("click", () => {
    let todoModifyUrl = $("#modifyUrl").attr("data-src");
    if (todoModifyUrl == "/todo/modify"){
        todoModifyUrl = "/todo/modify?id=" + getUrlParameter("id");
    }
    window.location.href = todoModifyUrl;
});