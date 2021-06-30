//메인 화면으로 돌아가기
$(".btn-wrap button:last-child").on("click", () => {
    const listUrl = $("#listUrl").attr("data-src");
    window.location.href = listUrl;
});