!function ($) {
  $(function(){
    // carousel demo
    $('#home').carousel({ pause: "" });
    $('a[href="#home"]').click(function(ev) {
      ev.preventDefault();
      $("html,body").animate({scrollTop: 0}, 500);
    });
  })
}(window.jQuery)