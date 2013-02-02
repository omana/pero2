$(function(){
     $("#toTop a").click(function(){
     $('html,body').animate({ scrollTop: $($(this).attr("href")).offset().top }, 'fast','swing');
     return false;
     })
});
