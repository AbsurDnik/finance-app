<#import "/parts/custom.ftl" as c>
<@c.page>
	
	
	
	
	<h3>Банк</h3>
	
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Общая сумма</th>
	      <th scope="row">Общие затраты</th>
	      <th scope="row">Отложить</th>
	      <th scope="row">Отдых</th>
	    </tr>
	  </thead>
	  <tbody>
    	<tr>
	      	<th scope="row"><#if incomeBank??>#{incomeBank}<#else>0</#if></th>
	      	<th><#if totalCostsBank??>${totalCostsBank}<#else>0</#if></th>
	      	<th><#if storageBank??>${storageBank}<#else>0</#if></th>
	      	<th><#if relaxBank??>${relaxBank}<#else>0</#if></th>
      	</tr>
	   
      </tbody>
	</table>
	
<div>
	<a class="btn btn-primary mb-2"  role="button" aria-expanded="false" href="edit">
		Редактировать текущий баланс
	</a>
</div>	
	

	
</@c.page>