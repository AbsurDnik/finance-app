<#import "/parts/custom.ftl" as c>
<@c.page>
	
<table class="table table-striped table-dark">
	<thead>
		<tr>
			
			<th scope="col">Расход</th>
			<th scope="col">Категория расхода</th>
			<th scope="col">Подробнее о расходе</th>
	      	<th scope="col">Удалить</th>
		</tr>
	</thead>
	<tbody>
		<#list сonsumptionList as consumption>
		<tr>
			<td scope="row">-${consumption.myConsumption}</td>
			<td>${consumption.category}</td>
			<td>
			<a class="btn btn-secondary mb-2 " role="button" aria-expanded="false"
	      		href="my-consumption/more-info/${consumption.id}">
	      		...
	      	</a>
			</td>
			<td>
	      	<a class="btn btn-danger mb-2 " role="button" aria-expanded="false"
	      		href="my-consumption/${consumption.id}">
	      		X
	      	</a>
	      	</td>
		</tr>
	    <#else>
	    <tr>
			<td colspan="5" class="text-center">
	     		У вас пока нету рассходов
	      	</td>
	    </tr>
	    </#list>
	</tbody>
</table>

<#if сonsumptionList??>
<div>
	<a class="float-right btn btn-dark mb-2" role="button" aria-expanded="false"
	      		href="my-consumption/delete-history">

			Очистить историю расходов
	    
	</a>
</div>
</#if>

<div>
	<a class="btn btn-primary mb-2"  role="button" aria-expanded="false" href="my-consumption/add-consumption">
		Новый расход
	</a>
</div>


</@c.page>