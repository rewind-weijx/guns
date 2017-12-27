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
		    var swiper = new Swiper('#swiper-demo', {
		      slidesPerView: 3,
		      spaceBetween: 30,
		      slidesPerGroup: 3,
		      loop: true,
		      pagination: {
		        el: '#paginationdemo',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-nextdemo',
		        prevEl: '#swiper-button-prevdemo',
		      },
		    });

		    var swiper = new Swiper('#swiper5', {
		      slidesPerView: 3,
		      spaceBetween: 30,
		      slidesPerGroup: 3,
		      loop: true,
		      pagination: {
		        el: '#pagination5',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '#swiper-button-next5',
		        prevEl: '#swiper-button-prev5',
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
			var swiper = new Swiper('#swiper-03', {
			      slidesPerView: 1,
			      spaceBetween: 30,
			      slidesPerGroup: 1,
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
			      slidesPerView: 1,
			      spaceBetween: 30,
			      slidesPerGroup: 1,
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
			    var swiper = new Swiper('#swiper-demo', {
			      slidesPerView: 1,
			      spaceBetween: 30,
			      slidesPerGroup: 1,
			      loop: true,
			      pagination: {
			        el: '#paginationdemo',
			        clickable: true,
			      },
			      navigation: {
			        nextEl: '#swiper-button-nextdemo',
			        prevEl: '#swiper-button-prevdemo',
			      },
			    });

			    var swiper = new Swiper('#swiper5', {
			      slidesPerView: 1,
			      spaceBetween: 30,
			      slidesPerGroup: 1,
			      loop: true,
			      pagination: {
			        el: '#pagination5',
			        clickable: true,
			      },
			      navigation: {
			        nextEl: '#swiper-button-next5',
			        prevEl: '#swiper-button-prev5',
			      },
			    });
		}

    setInterval(function(){
		$("#swiper-button-next").click();
	},3000);
	setInterval(function(){
		$("#swiper-button-next-03").click();
	},3000);
	setInterval(function(){
		$("#swiper-button-next-04").click();
	},3000);
	setInterval(function(){
		$("#swiper-button-next-05").click();
	},3000);
}