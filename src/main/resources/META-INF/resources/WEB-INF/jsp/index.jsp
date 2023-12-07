<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  
	
  </head>
 
  <body>
  
 <!-- Start Navbar -->
 <%@ include file="common/navbar.jspf" %>
 <!-- End Navbar -->
 
 
  <!-- Start NavbarNewsletter-->
   <%@ include file="common/navbarNewsletter.jspf" %>
   <!-- End NavbarNewsletter -->
 
<h1 class="subtitle text-center">
                <a href="/" class="text-decoration-none text-reset">Cucina Italiana</a>
            </h1>
  <h3 class="subtitle text-center">Ciao <a href="/login">accedi</a> o<a href="/new"> registrati qui>></a></h3>     
 
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>    
  
  

<c:forEach items="${articoli}" var="article">
    <div class="article-section">
        <h2><c:out value="${article.titolo}" /></h2>
        <p><c:out value="${article.descrizione}" /></p>
        <p><c:out value="${article.testo}" /></p>
        <p>Data di creazione: <c:out value="${article.datacreazione}" /></p>
        <img src="${article.immagine}" alt="ragu"  style="width: 700px; height: 700px;">
        <!-- Altri dettagli o contenuti specifici dell'articolo possono essere aggiunti qui -->
    </div>
</c:forEach>
		
  </body>
</html>