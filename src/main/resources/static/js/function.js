function checkForm() {
 var genreArray = new Array(); 
 $('input:checkbox[name=genre]:checked').each(function() { 
 	genreArray.push(this.value); }); //other code 
}

