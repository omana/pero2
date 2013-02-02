$(function () {
     $('img').error(function(){
          $(this).attr({src:'img/noImage.jpg',alt:'画像が見つかりません'});
     });
});
