<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=GBK">
<title>Home</title>
	<link rel="stylesheet" href="../css/HomeCss/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="../css/HomeCss/css/animate.css">
    <link rel="stylesheet" href="../css/HomeCss/fonts/ionicons/css/ionicons.min.css">

    <link rel="stylesheet" href="../css/HomeCss/fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/HomeCss/css/slick.css">
    <link rel="stylesheet" href="../css/HomeCss/css/slick-theme.css">

    <link rel="stylesheet" href="../css/HomeCss/css/helpers.css">
    <link rel="stylesheet" href="../css/HomeCss/css/style.css">
    
    
</head>
<body>
 

<%String Uname = (String)session.getAttribute("Uname"); 
  int sSuper = (Integer)session.getAttribute("sSuper");
  System.out.println("Uname="+Uname);

  String i = null;
  if(sSuper == 1)
	  i = "Administrator";
  else if(sSuper == 2)
	  i = "Examiner";
  else if(sSuper == 3)  
	  i = "User";
%>

<nav class="navbar navbar-expand-lg navbar-dark probootstrap_navbar probootstrap_scrolled-light" id="probootstrap-navbar">
      <div class="container">
        <a class="navbar-brand" href="Home.jsp">God's Activity System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#probootstrap-menu" aria-controls="probootstrap-menu" aria-expanded="false" aria-label="Toggle navigation">
          <span><i class="ion-navicon"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="probootstrap-menu">
          <ul class="navbar-nav ml-auto">
          
            <li class="nav-item active">
            <a class="nav-link" href="#">
            <font color="orange" ><%=i %>:</font><%=Uname %>
            </a>
            </li>
             <li class="nav-item active">
           <a class="nav-link" href="LogOut">Logout</a>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
    <!-- END nav -->

    <section class="probootstrap_cover_v3 overflow-hidden relative text-center" id="section-home" style="background-image: url('../css/HomeCss/images/bg.jpg');">
      <div class="overlay"></div>
      <a class="ytp_player"  data-property="{videoURL:'http://youtu.be/BsekcY04xvQ',containment:'#section-home', showControls:false, autoPlay:true, loop:true, mute:true, startAt:40, opacity:1, quality:'default'}"></a> 
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md">
            <h2 class="heading mb-2 probootstrap-animate">We provid better service for  activity system in university</h2>
            <p class="lead mb-5 probootstrap-animate">Fucking amazing activity system</p>
            <p class="probootstrap-animate">
              <a href="AllTable?sSuper=<%=sSuper %>&Uname=<%=Uname %>" role="button" class="btn btn-primary p-3 mr-3 pl-5 pr-5 text-uppercase d-lg-inline d-md-inline d-sm-block d-block mb-3">Go to system now</a> 
            </p>
          </div> 
        </div>
      </div>
      <div class="scroll-wrap js-scroll-wrap probootstrap-animate">
        <a href="#section-feature" class="text-white probootstrap_font-24 smoothscroll"><i class="ion-chevron-down"></i></a>
      </div>
    </section>
    <!-- END section -->
    

    <section class="probootstrap_section" id="section-feature">
      <div class="container">
        <div class="row justify-content-center mb-5">
          <div class="col-md-6 text-center mb-5 probootstrap-animate">
            <h2>The Features</h2>
          </div>
        </div>
        <div class="row">
          
          <div class="col-md-3 col-sm-6 probootstrap-animate">
            <div class="media d-block text-center probootstrap-media">
              <img class="mr-0 mb-3 w-50 img-fluid rounded-circle" src="../css/HomeCss/images/img_1.jpg" alt="Generic placeholder image">
              <div class="media-body">
                <h5 class="mt-3">Video Background</h5>
                <p class="probootstrap_font-14">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                <p class="read-more"><a href="#"><span class="ion-ios-arrow-thin-right probootstrap_font-30"></span></a></p>
              </div>
            </div>
          </div>
          <div class="col-md-3 col-sm-6 probootstrap-animate">
            <div class="media d-block text-center probootstrap-media">
              <img class="mr-0 mb-3 w-50 img-fluid rounded-circle" src="../css/HomeCss/images/img_2.jpg" alt="Generic placeholder image">
              <div class="media-body">
                <h5 class="mt-3">Popup Image</h5>
                <p class="probootstrap_font-14">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                <p class="read-more"><a href="#"><span class="ion-ios-arrow-thin-right probootstrap_font-30"></span></a></p>
              </div>
            </div>
          </div>
          <div class="col-md-3 col-sm-6 probootstrap-animate">
            <div class="media d-block text-center probootstrap-media">
              <img class="mr-0 mb-3 w-50 img-fluid rounded-circle" src="../css/HomeCss/images/img_3.jpg" alt="Generic placeholder image">
              <div class="media-body">
                <h5 class="mt-3">Testimonial</h5>
                <p class="probootstrap_font-14">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                <p class="read-more"><a href="#"><span class="ion-ios-arrow-thin-right probootstrap_font-30"></span></a></p>
              </div>
            </div>
          </div>
          <div class="col-md-3 col-sm-6 probootstrap-animate">
            <div class="media d-block text-center probootstrap-media">
              <img class="mr-0 mb-3 w-50 img-fluid rounded-circle" src="../css/HomeCss/images/img_4.jpg" alt="Generic placeholder image">
              <div class="media-body">
                <h5 class="mt-3">Table Pricing</h5>
                <p class="probootstrap_font-14">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                <p class="read-more"><a href="#"><span class="ion-ios-arrow-thin-right probootstrap_font-30"></span></a></p>
              </div>
            </div>
          </div>

        </div>
      </div>
    </section><div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >网站建设</a></div>
    <!-- END section -->
  


    


    <section class="probootstrap-section-half d-md-flex" id="section-about">
      <div class="probootstrap-image probootstrap-animate" data-animate-effect="fadeIn" style="background-image: url(../css/HomeCss/images/img_2.jpg)"></div>
      <div class="probootstrap-text">
        <div class="probootstrap-inner probootstrap-animate" data-animate-effect="fadeInRight">
          <h2 class="heading mb-4">About Us</h2>
          <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
          <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
          <p><a href="single-page.html" class="btn btn-primary">Read More</a></p>
        </div>
      </div>
    </section>
    <section class="probootstrap-section-half d-md-flex">
      <div class="probootstrap-image order-2 probootstrap-animate" data-animate-effect="fadeIn" style="background-image: url(../css/HomeCss/images/img_3.jpg)"></div>
      <div class="probootstrap-text order-1">
        <div class="probootstrap-inner probootstrap-animate" data-animate-effect="fadeInLeft">
          <h2 class="heading mb-4">Created with love</h2>
          <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
          <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
          <p><a href="single-page.html" class="btn btn-primary">Read More</a></p>
        </div>
      </div>
    </section>
    <!-- END section -->

    <section class="probootstrap_section">
      <div class="container">
        <div class="row justify-content-center mb-5">
          <div class="col-md-8 text-center mb-5 probootstrap-animate">
            <h2>Testimonial</h2>
            <p class="probootstrap_font-18">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
          </div>
        </div>
        <div class="row">
          <div class="col-md probootstrap-animate">
            <div class="media d-block text-center testimonial_v1 probootstrap_quote_v1">
              <div class="media-body">
                <div class="quote">&ldquo;</div>
                <blockquote class="mb-5">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</blockquote>
                <img class="d-flex text-center mx-auto mb-3 rounded-circle" src="../css/HomeCss/images/person_1.jpg" alt="Generic placeholder image">
                <h3 class="heading">Garry Alexander</h3>
                <p class="subheading">@garry</p>
              </div>
            </div>
          </div>
          <div class="col-md probootstrap-animate">
            <div class="media d-block text-center testimonial_v1 probootstrap_quote_v1">
              <div class="media-body">
                <div class="quote">&ldquo;</div>
                <blockquote class="mb-5">A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</blockquote>
                <img class="d-flex text-center mx-auto mb-3 rounded-circle" src="../css/HomeCss/images/person_5.jpg" alt="Generic placeholder image">
                <h3 class="heading">Deborah Smith</h3>
                <p class="subheading">@deborah</p>
                
              </div>
            </div>
          </div>
          <div class="col-md probootstrap-animate">
            <div class="media d-block text-center testimonial_v1 probootstrap_quote_v1">
              
              <div class="media-body">
                <div class="quote">&ldquo;</div>
                <blockquote class="mb-5">Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</blockquote>
                <img class="d-flex text-center mx-auto mb-3 rounded-circle" src="../css/HomeCss/images/person_2.jpg" alt="Generic placeholder image">
                <h3 class="heading">James Robertson</h3>
                <p class="subheading">@james</p>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- END section -->


    <footer class="probootstrap_section probootstrap-border-top">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
            <ul class="list-unstyled">
              <li><a href="#">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Services</a></li>
              <li><a href="#">Contact</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
            <ul class="list-unstyled">
              <li><a href="#">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Services</a></li>
              <li><a href="#">Contact</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
            <ul class="list-unstyled">
              <li><a href="#">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Services</a></li>
              <li><a href="#">Contact</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <h3 class="probootstrap_font-18 mb-3">Quick Links</h3>
            <ul class="list-unstyled">
              <li><a href="#">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Services</a></li>
              <li><a href="#">Contact</a></li>
            </ul>
          </div>
        </div>
      
      </div>
    </footer>

    
    <script src="../css/HomeCss/js/jquery.min.js"></script>
    
    <script src="../css/HomeCss/js/popper.min.js"></script>
    <script src="../css/HomeCss/js/bootstrap.min.js"></script>
    <script src="../css/HomeCss/js/slick.min.js"></script>
    <script src="../css/HomeCss/js/jquery.mb.YTPlayer.min.js"></script>

    <script src="../css/HomeCss/js/jquery.waypoints.min.js"></script>
    <script src="../css/HomeCss/js/jquery.easing.1.3.js"></script>

    <script src="../css/HomeCss/js/main.js"></script>
	</body>
</html>