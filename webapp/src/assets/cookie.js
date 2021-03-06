var cookie = {
	setCookie: function(name, value, time) {
		var Days = time;
		var exp = new Date();
		exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
		document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
	},
	getCookie: function(name) {
		var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
		if(arr = document.cookie.match(reg))
			return unescape(arr[2]);
		else
			return null;
	},
	delCookie: function (name) {
		var exp = new Date();
		exp.setTime(exp.getTime() - 1);
		var cval = this.getCookie(name);
		if(cval != null)
			document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
	}
}
export default cookie;