$(".btn-wrap button:nth-child(2)").on("click", function(){
    const listUrl = $("#listUrl").attr("data-src");
    window.location.href = listUrl;
});

$(".btn-wrap button:last-child").on("click", function(){
    $("input[name='title']").val("");
    $("textarea").val("");
});
