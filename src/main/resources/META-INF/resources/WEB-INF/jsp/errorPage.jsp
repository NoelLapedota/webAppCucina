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
              <img src="<c:url value="/static/images/errore.jpg" />" width="650" alt="Page Not Found">
               
      <h3 class="mt-4">Oh! E' molto imbarazzante!</h3>
      <h4>Sembra che qualcosa di brutto si accaduto! Ci scusiamo, per l'incoveniente.</h4>
      <h5> Riprova fra qualche minuto.</h5>
      <a href="login" class="btn btn-primary mt-4">Torna al main</a>
          </div>
      </div>
  </div>
 </section>
  
  <%@ include file="common/foot.jspf" %>
      
  </body>
</html>


