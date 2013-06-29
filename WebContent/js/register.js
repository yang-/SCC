  !function ($) {
    $(function(){
      $('input, textarea').placeholder();
      $('a[href="#home"]').click(function(ev) {
        ev.preventDefault();
        $("html,body").animate({scrollTop: 0}, 500);
      });

      //datepicker
      var today = new Date();
      var startDate = new Date(2013, 7, 9);
      startDate = today.getTime()<startDate.getTime()?startDate:today;
      $('#form-flightArrivalDate').datepicker({
        startDate: startDate,
        endDate: new Date(2013, 7, 18),
        autoclose: true,
        daysOfWeekDisabled: [1,2,3,4],
        keyboardNavigation: false
      }).on('hide', function(e) {
        // # `e` here contains the extra attributes
        $( this ).valid();
      });
      //datepicker end

      $("#form-flightArrivalTime").mask("99:99");

      $('input').keypress(function(e){
        if ( e.which == 13 ) return false;
      });
      $.validator.addMethod("chinese", function(value, element) { 
        return this.optional(element) || !/[u4e00-u9fa5]/.test(value); 
      }, "Please enter chinese characters.");
      $.validator.addMethod("time12", function(value, element) { 
        return this.optional(element) || /^(([0]?[1-9])|([1][0-2])):([0-5]?[0-9])?$/.test(value); 
      }, "Please valid time.");
      $.validator.addMethod("time24", function(value, element) { 
        return this.optional(element) || /^(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9])?$/.test(value); 
      }, "Please valid time.");
      var validator = $("#signUpForm").validate({
        focusInvalid: true,
        errorElement: 'span',
        // submitHandler: function(form) {
        //   // var formDataString = JSON.stringify($(form).serializeObject());
        //   var $form = $('form');
        //   $.ajax({
        //     type: "POST",
        //     url: $form.attr( 'action' ),
        //     data: form.serialize()
        //   }).done(function(data) {
        //     if (data == "good") {
        //       alert("success!");
        //     } else {
        //       alert("fail!");
        //     }
        //   }).fail(function() {
        //     alert("fail!");
        //   });
        // },
        onkeyup: function(element) {$(element).valid()},
        onfocusout: function(element) {$(element).valid()},
        highlight: function(element, errorClass, validClass) {
          $(element).closest('.control-group').addClass(errorClass).removeClass(validClass);
          // $(element).next().addClass('help-inline');
        },
        unhighlight: function(element, errorClass, validClass) {
          $(element).closest('.control-group').removeClass(errorClass).addClass(validClass);
          $(element).next().remove();
        },
        errorPlacement: function(error, element) {
          var temp = element.siblings('span');
          if (temp.length == 0) {
          error.removeAttr("for").removeClass('error').addClass('help-inline').insertAfter(element);
        }
        },
        rules: {
          "lastName": {
            required: true,
            chinese: true
          },
          "firstName": {
            required: true,
            chinese: true
          },
          "email": {
            required: true,
            email: true
          },
          "emergencyContact": {
            required: true,
            minlength: 10
          },
          "flightArrivalDate": "required",
          "flightArrivalTime": "required time24",
          "flightNumber": "required",
          "flightArrivalTerminal": "required",
          "destination": "required",
          "offCampus-addr1": {
            required: function(){
              return $("#form-destination").val() == 'other';
            }
          },
          "offCampus-city": {
            required: function(){
              return $("#form-destination").val() == 'other';
            }
          },
          "offCampus-zip": {
            required: function(){
              return $("#form-destination").val() == 'other';
            },
            number: true
          },
          "studentId": {
            required: true,
            number: true,
            minlength: 9
          },
          "major": "required",
          "qq": {
            required: true,
            number: true
          },
          "qqName": "required"
        },
        messages: {
          "lastName": "请输入真实中文姓名。",
          "firstName": "请输入真实中文姓名。",
          "email": {
            required: "请输入常用邮箱。",
            email: "请正确输入常用邮箱。"
          },
          "emergencyContact": {
            required: "请输入国内联系电话。",
            minlength: "请正确输入国内电话。"
          },
          "flightArrivalDate": "请选择到达日期(EST)",
          "flightArrivalTime": "请输入到达时间(EST)",
          "flightNumber": "请输入航班号",
          "flightArrivalTerminal": "请选择到达航站楼。",
          "destination": "请选择你在石溪的住址。",
          "offCampus-addr1": "请输入校外住址。",
          "offCampus-city": "请输入校外住址。",
          "offCampus-zip": {
            required: "请输入住址的邮编。",
            number: "请正确输入住址邮编。"
          },
          "studentId": {
            required: "请输入你的学号。",
            number: "请正确输入你的学号。",
            minlength: "请正确输入你的学号。"
          },
          "major": "请选择你的专业。",
          "qq": {
            required: "请输入你的QQ号。",
            number: "请正确输入你的QQ号。"
          },
          "qqName": "请输入你的QQ群名片。"
        }
      });

      //recaptcha
      initRecaptcha();

      //form 
      // $('input[type="submit"]').toggle();
      $('#signUpForm').submit(function(e) {
        if (validator.form()) {
        e.preventDefault();
        var $form = $(this);
          $.ajax({
            type: "POST",
            url: $form.attr( 'action' ),
            data: $form.serialize()
          }).done(function(data) {
            if (data == "good") {
              // alert("success!");
              $('.signUpResult').addClass('alert-success').find('.alert-heading').text('报名成功').next().html('报名成功了哦~~~');
            } else {
              // alert("fail!");              
              $('.signUpResult').addClass('alert-error').find('.alert-heading').text('报名失败').next().html('服务器异常了哦~~~<a id="retry" href="#">重试</a>');
            }
          }).fail(function() {
            // alert("fail!");
            $('.signUpResult').addClass('alert-error').find('.alert-heading').text('报名失败').next().html('服务器请求超时了哦~~~<a id="retry" href="#">重试</a>');
          }).always(function() {
            $("html,body").animate({scrollTop: 236}, 500, function() {
              $('.signUpForm').fadeOut(500, function() {
              $('.signUpResult').fadeIn(500);
            });
            });
            
          });
        }
      });

      $('.signUpResult').on('click', '#retry', function(event) {
        event.preventDefault();
        initRecaptcha();
        $('div.row.recaptcha').show();
        $('input.captcha').show();
        $('input[type="submit"]').hide();
        $('.signUpResult').fadeOut(500, function() {
          $('.signUpForm').fadeIn(500);
        });
      });

    })
  }(window.jQuery)

  function initRecaptcha(){
  Recaptcha.create("6LcQjOASAAAAAOb3OKWr6GfOVHhdkEjgdfkBzxwy", 'captchadiv', {
    theme : "clean",
    callback : function(){
      $('input[type=text]').keypress(function(e){
        if ( e.which == 13 ) return false;
      });
    }
  });
}

function verify(){
  var response = Recaptcha.get_response();
  if (response == "") {
    Recaptcha.focus_response_field();
  } else{
    var jqxhr = $.ajax({
      type: "POST",
      url: "Recaptcha",
      data: { 
        recaptcha_challenge_field: Recaptcha.get_challenge(), 
        recaptcha_response_field: response
      },
      beforeSend: function() {
        $('input.captcha').val('Verifying..').prop('disabled', true);
      }
    }).done(function( data ) {
      if (data == "good") {
        $('div.row.recaptcha').slideUp();
        $('input.captcha').css("display","none");
        $('input[type="submit"]').css("display","inline-block");
        // $('input[type="submit"]').removeAttr('disabled');
        Recaptcha.destroy();
      } else{
        Recaptcha.reload();
        
      };
    }).fail(function() { 
      Recaptcha.destroy();
      $("div#captchadiv").text("Error #1");
    }).always(function() {
      $('input.captcha').val('Verify').prop('disabled', false);
    });
    
  };
}

function formDestinationChange(select){
  var maxHeight, minHeight;
  if (window.innerWidth < 768) {
    maxHeight = '680px';
    minHeight = '430px';
  } else {
    maxHeight = '390px';
    minHeight = '310px';
  }
  if (select == "other") {
    $(".movingRow").slideUp(function() {
      $('.form-stonyBrookInfo').animate({
        height: maxHeight
      });
      $(this).prependTo("#sbRight").slideDown();
      $(".offCampusRow").slideDown();
    });
    // $(".offCampus:input").prop("required", true);
  } else {
    if( $('.offCampusRow').css("display") == 'block') {
      $(".offCampusRow").slideUp();
      $('.form-stonyBrookInfo').animate({
        height: minHeight
      });
      $(".movingRow").slideUp(function() {
        $(this).appendTo("#sbLeft").slideDown();
      });
      // $(".offCampus:input").prop("required", false);
    }
  };      
}


$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};