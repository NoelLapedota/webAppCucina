<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
   <%@ include file="common/head.jspf" %>

 
  <body>
  
 <%@ include file="common/navbar.jspf" %>
 
 
  <div class="col-lg-4 col-md-6 me-auto">
		  
		   </div>
<h1 class="subtitle text-center">
   <a href="/" class="text-decoration-none text-reset">Cucina Italiana</a></h1>
    
  <h3 class="title">Ciao ${name}, questi sono gli articoli disponibili: </h3>
  
  <table class="table">
	<thead>
		<tr>
			<th>Descrizione</th>
			<th>Titolo</th>
			<th>Testo</th>
			<th>Data creazione</th>
			
		</tr>
	</thead>
	<tbody>	
		
		<c:forEach items="${articoli}" var="article">
               <tr>
                  <td><c:out value="${article.descrizione}" /></td>
                  <td><c:out value="${article.titolo}" /></td>
                  <td><c:out value="${article.testo}" /></td>
                  <td><c:out value="${article.datacreazione}" /></td>
                    
					<td class="text-end">
					 <a href="<spring:url value="/articoli/elimina/${article.codart}" /> " class="btn btn-light text-danger">Elimina</a>
                  </td>
               </tr>
            </c:forEach>
		
	</tbody>
 </table>
 
  
    <%@ include file="common/foot.jspf" %>
    
  </body>
  
  
</html>





