function getXMLHttpRequest() {　
	var request = false;　
	try {
		request = new XMLHttpRequest();　
	} catch (trymicrosoft) {　　
		try {　　　
			request = new ActiveXObject("Msxml2.XMLHTTP");　　
		} catch (othermicrosoft) {　　　
			try {　　　　
				request = new ActiveXObject("Microsoft.XMLHTTP");　　　
			} catch (failed) {　　　　
				request = false;　　　
			}　　
		}　
	}　
	return request;
}

/**点击事件中触发*/
function alerterror(Mess){
    swal("警告", Mess, "error");
}

