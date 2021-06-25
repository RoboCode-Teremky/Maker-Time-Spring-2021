let socket = new WebSocket

}
function Reg() {
    var str = document.getElementById("email").value; //запис рядка для пошти
    var status = document.getElementById("status");
    var re = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i;
    if(isEmpty(str)) status.innerHTML = "Поле не може бути пустим";
       else status.innerHTML=""
    var str2 = document.getElementById("pass").value;
    var status2 = document.getElementById("status2");
    if(isEmpty(str2)) status2.innerHTML = "Поле не може бути пустим";
       else status2.innerHTML="";
        let val = {
  type: value,
login: str.value,
pass: str2.value
button: reg

}
      let json = JSON.stringify(val)
      socket.send(json);


}
   function Login() {
       var str = document.getElementById("email").value; //запис рядка для пошти
       var status = document.getElementById("status");
       var re = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i;
       if(isEmpty(str)) status.innerHTML = "Поле не може бути пустим";
       else status.innerHTML=""
       var str2 = document.getElementById("pass").value; //запис рядка для паролля
       var status2 = document.getElementById("status2");
       if(isEmpty(str2)) status2.innerHTML = "Поле не може бути пустим";
       else status2.innerHTML="";
              let val = {
                 type: value,e
                 login: str.value,
                 pass: str2.value
                 button: log

                 }
                 let json = JSON.stringify(val)
                 socket.send(json);
      }

   function isEmpty(str){
    return (str == null) || (str.length == 0);
   }
      function isEmpty(str2){
       return (str2 == null) || (str2.length == 0);
      }



socket.onmessage = function(message){
alert(message.data)
if(message=="ok"){
window.open ('Products.html', '_self', false)
}
if(message=="error"){
alert("пароль або email хибні")
}
if(message=="error1"){
alert("користавуч с таким email вже існує")}
}


}
socket.onstart = function(){
alert(socket is OK
)}
