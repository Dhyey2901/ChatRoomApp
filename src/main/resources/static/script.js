var stompClient = null


function  sendMessage()
{
    let jasonOb={
        name:localStorage.getItem("name"),
        content:$("#message-value").val()
    }
    stompClient.send("/app/message" , {} ,JSON.stringify(jasonOb) );
    let messageData = {
        chat_message :$("#message-value").val()
    }

    $.ajax({
        type: "POST",
        url: "api/groups/4567/messages",
        data: messageData
    });




}
function connect()
{

    let socket = new SockJS("/server1");            //http://localhost:9090
    stompClient = Stomp.over(socket);
    stompClient.connect({} , function (frame){
        $("#name-form").addClass('d-none')
        $("#chat-room").removeClass('d-none')
        //suscribe
        stompClient.subscribe("/topic/return-to" , function(response){

            showMessage((JSON).parse(response.body))
        })
    })
}




 function showMessage(message)
{
       $("#message-container-table").prepend(`<tr><td><b>${message.name} :</b> ${message.content}</td></tr>`)
}




$(document).ready((e)=>{

    $("#login").click(()=>{
        let name=$("#name-value").val()
        localStorage.setItem("name",name)
        $("#name-title").html(`Welcome , <b>${name} </b>`)
        connect();
    })


    $("#send-btn").click(()=>{
        sendMessage()
    })

    $("#logout").click(()=> {

        localStorage.removeItem("name")
        if(stompClient !== null)
        {
            stompClient.disconnect()
            $("#name-form").removeClass('d-none')
            $("#chat-room").addClass('d-none')
            console.log(stompClient)
        }
    })


})