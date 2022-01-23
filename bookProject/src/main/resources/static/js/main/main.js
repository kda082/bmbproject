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
	  
	  //게시판버튼
	  $("#boardMenuBtn").on("click", function () {
		  $(document).off(); // 동적 이벤트 초기화
		  $('#main').load('/app/board/web/board');
      });
	  
	  

    }
}

main.init();