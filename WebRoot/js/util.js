function onRow(E){
  E.className = "dark";
}
function leaveRow(E){
  E.className = "";
}

function getChecked(form) {
  for (var i = 0; i < form.elements.length; i++) {
    var e = form.elements[i];
	if (e.name == "chk") {
	  if (e.checked) {
		break;
	  }
	}		
  }
  return e.value;
}

function checkNull(form) {
		checked = false;
		for (var i = 0; i < form.elements.length; i++) {
			var e = form.elements[i];
			
			if (e.name == "chk") {
				if (e.checked) {
					checked = true;
					break;
				}
			}		
		}
		return checked;
	}