function search(){
    const url = document.getElementById("search").value;
    console.log("search 함수 실행")
    $.ajax({
        type: 'GET',
        url: `/search?url=${url}`,
        success: data => {
            console.log(url);
            console.log(data);
            console.log(data.title);
            // resultHtml(data);
            console.log(data.thumbnail_url);
            var str = `${data.thumbnail_url}`;
            console.log(str);
            $("#content").empty();
            $("#content").append('<iframe src=\"https://player.vimeo.com/video/20097015?h=08095da358&amp;app_id=122963\" width=\"640\" height=\"480\" frameborder=\"0\" allow=\"autoplay; fullscreen; picture-in-picture\" allowfullscreen title=\"A Time Artifact - work in progress\"></iframe>');

        },
        error:error => {
            console.log(error);
        }
    })
}