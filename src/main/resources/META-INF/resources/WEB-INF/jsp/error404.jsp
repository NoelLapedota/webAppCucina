<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
  <%@ include file="common/head.jspf" %>
	 
  <body>
  
  <%@ include file="common/navbar.jspf" %>
  
  <section class="content-main">
  <div class="row" style="margin-top:60px">
      <div class="col-sm-12">
          <div class="w-50 mx-auto text-center">
              <img src="<c:url value="/static/images/not-found.png" />" width="350" alt="Page Not Found">
               
      <h3 class="mt-4">Oops! Pagina non trovata</h3>
      <p>Sembra che tu abbia preso una via sbagliata. Non preoccuparti... succede anche ai migliori di noi. Ecco un piccolo consiglio che potrebbe aiutarti a rimetterti in carreggiata.</p>
      <a href="login" class="btn btn-primary mt-4">Torna al main</a>
          </div>
      </div>
  </div>
</section>
  
 
 
  <%@ include file="common/foot.jspf" %>
      
  </body>
</html>


