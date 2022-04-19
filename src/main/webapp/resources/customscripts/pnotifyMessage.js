function pnotifyInfoMessage(message){
	if(messageNotEmpty(message)){
		window.onload = new PNotify({
			title : 'Message',
			text : message,
			type : 'info',
			styling : 'bootstrap3'			
		});
	}	
}

function pnotifySuccessMessage(message){
	if(messageNotEmpty(message)){
		window.onload = new PNotify({
			title : 'Message',
			text : message,
			type : 'success',
			styling : 'bootstrap3',
			nonblock: {nonblock: true}
		});
	}
}

function pnotifyFailedMessage(message){
	if(messageNotEmpty(message)){
		window.onload = new PNotify({
			title : 'Message',
			text : message,
			type : 'danger',
			styling : 'bootstrap3',
			nonblock: {nonblock: true}
		});
	}
}

function messageNotEmpty(message){
	if((typeof message !== "undefined") && (message.length !== 0) && (message !== "")){
		return true;
	}else{
		return false;
	}
}