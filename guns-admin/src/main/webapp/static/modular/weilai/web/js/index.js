$("#nav li").mouseover(function(){
	$(this).find("ul").show();
});
$("#nav li").mouseleave(function(){
	$(this).find("ul").hide();
});
function IsPC() {
   var userAgentInfo = navigator.userAgent;
   var Agents = ["Android", "iPhone",
      "SymbianOS", "Windows Phone",
      "iPad", "iPod"];
   var flag = true;
   for (var v = 0; v < Agents.length; v++) {
      if (userAgentInfo.indexOf(Agents[v]) > 0) {
         flag = false;
         break;
      }
   }
   return flag;
}
window.onload = function(){
	if(IsPC()){
		var swiper = new Swiper('#swiper', {
		      slidesPerView: 3,
		      spaceBetween: 30,
		      slidesPerGroup: 3,
		      loop: true,
		      pagination: {
		        el: '#pagination',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-next',
		        prevEl: '#swiper-button-prev',
		      },
		    });
		var swiper = new Swiper('#swiper-03', {
		      slidesPerView: 4,
		      spaceBetween: 30,
		      slidesPerGroup: 4,
		      loop: true,
		      pagination: {
		        el: '#pagination-03',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-next-03',
		        prevEl: '#swiper-button-prev-03',
		      },
		    });
		var swiper = new Swiper('#swiper-04', {
		      slidesPerView: 3,
		      spaceBetween: 30,
		      slidesPerGroup: 3,
		      loop: true,
		      pagination: {
		        el: '#pagination-04',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-next-04',
		        prevEl: '#swiper-button-prev-04',
		      },
		    });
		    var swiper = new Swiper('#swipwe1', {
		      slidesPerView: 4,
		      spaceBetween: 30,
		      slidesPerGroup: 4,
		      loop: true,
		      pagination: {
		        el: '#pagination1',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-next1',
		        prevEl: '#swiper-button-prev1',
		      },
		    });

		    var swiper = new Swiper('#swipwe2', {
		      slidesPerView: 3,
		      spaceBetween: 30,
		      slidesPerGroup: 3,
		      loop: true,
		      pagination: {
		        el: '#pagination2',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-next2',
		        prevEl: '#swiper-button-prev2',
		      },
		    });
		}else{
			var swiper = new Swiper('#swiper', {
		      slidesPerView: 1,
		      spaceBetween: 30,
		      slidesPerGroup: 1,
		      loop: true,
		      pagination: {
		        el: '#pagination',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-next',
		        prevEl: '#swiper-button-prev',
		      },
		    });

		    var swiper = new Swiper('#swipwe1', {
		      slidesPerView: 1,
		      spaceBetween: 30,
		      slidesPerGroup: 1,
		      loop: true,
		     pagination: {
		        el: '#pagination1',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-next1',
		        prevEl: '#swiper-button-prev1',
		      },
		    });

		    var swiper = new Swiper('#swipwe2', {
		      slidesPerView: 1,
		      spaceBetween: 30,
		      slidesPerGroup: 1,
		      loop: true,
		      pagination: {
		        el: '#pagination2',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-next2',
		        prevEl: '#swiper-button-prev2',
		      },
		    });
		}
	
}