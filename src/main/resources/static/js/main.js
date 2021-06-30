$(".list button").on("click", function(){
    const createUrl = $("#createUrl").attr("data-src");
    window.location.href = createUrl;
});

$(".todo").on("click", function(e){
    let todoId = e.currentTarget.getAttribute("data-id");
    let todoInfoUrl = $("#todoInfoUrl").attr("data-src");

    //thymeleaf url 인식
    if (todoInfoUrl == "/todo/info"){
        todoInfoUrl = "/todo/info?id=" + todoId;
    }
    window.location.href = todoInfoUrl;
});