var book = {
    init : function () {
    	//book.getList();
    },
    getList : function(){
	     $.ajax({
             type: 'GET',
             url: '/app/book/api/getList',
             dataType: 'json',
             contentType: 'application/json; charset=utf-8',
         }).done(function (data) {
        	 console.log(data);
         }).fail(function (error) {
         });
	}
}

book.init();