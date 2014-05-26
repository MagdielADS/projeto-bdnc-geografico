/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Info(evt){
//    alert(evt.target.getAttribute("id")); 
    document.getElementById('municipio').innerHTML = evt.target.getAttribute("id");
}

function Destaca(evt){
	evt.target.setAttribute("fill", "blue");
}

function Normal(evt){
	evt.target.setAttribute("fill", "green");
}