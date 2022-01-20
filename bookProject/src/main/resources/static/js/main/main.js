var main = {
    init : function () {
    	 
      //초기 메인화면 	
      $('#main').load('/main');
    	
      
      //버튼 이벤트들
      
      //메인
	  $("#mainMenuBtn").on("click", function () {
		  $('#main').load('/main');
         
      });
	  //책
	  $("#bookMenuBtn").on("click", function () {
		  $('#main').load('/app/book/web/bookList');
      });
	  
	  //테스트버튼
	  $("#testMenuBtn").on("click", function () {
		  alert("테스트버튼");
      });


    }
}

main.init();