const btn = document.getElementById("btn");
const youtube = "youtube";
const twitter = "twitter";
const vimeo = "vimeo";

btn.addEventListener('click', () => {
    const url = document.getElementById("search").value;

    axios.get('/search', {
        params:{
            url : `${url}`
        }
    })
        .then(response => {
            if(!response.data){
                console.log("지원x")
            } else{
                dataOut(response.data);
            }
        })
})

const dataOut = (response) => {
    if(response.provider_url.includes(youtube)
        || response.provider_url.includes(twitter)
        || response.provider_url.includes(vimeo)
    ){
        printData(response);
    } else{
        console.log('데이터없음')
    }
}

const printData = (data) => {
    const table = document.getElementById('table');
    let str = '';
    let title = '';

    Object.entries(data).map(([key, value]) => {
        if (key == `title`) {
            title += `<tr id="table-title"><td class="key">${key}</td><td id="data-${key}" class="value"><h3>${value}</h3></td></tr>`;
        } else if (key == 'html') {
            str += `<tr><td class="key">${key}</td><td id="data-${key}" class="value">${value}</td></tr>`;
        } else if (key == 'thumbnail_url'){
            str += `<tr><td class="key">${key}</td><td id="data-${key}" class="value"><a href="${value}">${value}</a>
                    <img src="${value}"></td></tr>`;
        } else if (key.includes('url')){
            str += `<tr><td class="key">${key}</td><td id="data-${key}" class="value"><a href="${value}">${value}</a></td></tr>`;
        } else {
            str += `<tr><td class="key">${key}</td><td id="data-${key}" class="value">${value}</td></tr>`;
        }
    })
    table.innerHTML = "";
    table.innerHTML = title + str;

    if(document.getElementById('data-html')){
        const html = document.getElementById('data-html');
        if(html.innerHTML.includes('iframe')){
            let text = html.innerHTML;
            html.prepend(text);
        }
    }
}