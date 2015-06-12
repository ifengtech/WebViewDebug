function sayHello()
{
alert("Hi How are you");
}

function prompter() {
var reply = prompt("Hey there, good looking stranger!  What's your name?", "")
alert ( "Nice to see you around these parts " + reply + "!")
}
function confirmation() {
var answer = confirm("Are You sure You want to leave this page")
if (answer){
alert("Bye bye!")
window.location = "http://www.google.com/";
}
else{
alert("Thanks for sticking around!")
}
}