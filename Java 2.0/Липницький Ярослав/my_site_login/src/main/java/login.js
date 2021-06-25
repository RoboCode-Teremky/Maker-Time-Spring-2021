let connection = new WebSocket("ws://127.0.0.1:5555")
//let connection = new WebSocket("ws://127.0.0.1:5555")

connection.onopen = function(){
    console.log("Connection ok!")
}

connection.onerror = function(error){
    console.log(error)
}

connection.onmessage = function(message){
    alert(message.data)
}

function pressButton(velue){
    let n = document.getElementById("name")
    let p = document.getElementById("pass")
    let val = {
        type: value,
        name: n.value,
        pass: p.value
    }
    let json = JSON.stringify(val)
    connection.send(json)
}

function pressReg(){
    let n = document.getElementById("name")
    let p = document.getElementById("pass")
    let val = {
        type: "reg",
        name: n.value,
        pass: p.value
    }
    let json = JSON.stringify(val)
    connection.send(json)
}

/*
function pressButton(command){
    let n = document.getElementById("name")
    let p = document.getElementById("pass")
    let val = {
            type: command,
            name: n.value,
            pass: p.value
            }
    let json = JSON.stringify(val)
    connection.send(json)
}
*/

