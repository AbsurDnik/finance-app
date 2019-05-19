<#import "/parts/custom.ftl" as c>
<@c.page>

	<#assign 
			totalIncome = 0
			summTotalCosts = 0
			summStorage = 0
			summRelax = 0
	>


	<table class="table table-striped table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Дата</th>
	      <th scope="col">Доход</th>
	      <th scope="col">Соотношения в процента</th>
	      
	      <th scope="col">Общие затраты</th>
	      <th scope="col">Отложить</th>
	      <th scope="col">Отдых</th>
	      
	      <th scope="col">Удалить</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<#list incomeList as income>
	  	
	  	<#assign 
	  		totalCostsUAH = income.totalCosts*income.myIncome/100
	  		storageUAH = income.storage*income.myIncome/100
	  		relaxUAH = income.relax*income.myIncome/100
	  	>
	    <tr>
	      <th scope="row">${income.creationDate}</th>
	      <td>+${income.myIncome}</td>
	      <td>${income.totalCosts}/${income.storage}/${income.relax}</td>
	      <td>${totalCostsUAH}</td>
	      <td>${storageUAH}</td>
	      <td>${relaxUAH}</td>
	      <td>
	      	<a class="btn btn-danger mb-2 " role="button" aria-expanded="false"
	      		href="my-income/${income.id}">
	      		X
	      	</a>
	      </td>
	    </tr>
	    <#else>
	    <tr>
	      <td colspan="7" class="text-center">
	     		У вас пока нету доходов
	      </td>
	    </tr>
	    </#list>
	  </tbody>
	</table>
	
<#if incomeList??>	
<div>
	<a class="float-right btn btn-dark mb-2" role="button" aria-expanded="false"
	      		href="my-income/delete-history">
		Очистить историю доходов
	</a>
</div>
</#if>


<div>
	<a class="btn btn-primary mb-2" data-toggle="collapse" 
		href="#collapseEx" role="button" aria-expanded="false" 
		aria-controls="collapseExample">

			Добавить доход
	    
	</a>
</div>

<div class="collapse <#if newIncome??>show</#if>" id="collapseEx">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
        
        	<div class="form-group">
                <input type="number" class="form-control mb-2 ${(myIncomeError??)?string('is-invalid','')}" 
                		name="myIncome" placeholder="Доход"
                	   value = "<#if newIncome??>${newIncome.myIncome?if_exists}</#if>" >
               	<#if myIncomeError??>
			        <div class="invalid-feedback">
			          	${myIncomeError}
			        </div>
		        </#if>
            </div>
            
            
        	
            <div class="form-group">
                <input type="number" class="form-control mb-2 ${(dataError?? || totalCostsError??)?string('is-invalid','')}" 
                name="totalCosts" placeholder="На общие затраты в %"
                	   value = "<#if newIncome??>${newIncome.totalCosts?if_exists}</#if>" >
               	<#if dataError?? || totalCostsError??>
			        <div class="invalid-feedback">
			          	<#if dataError??>${dataError}</#if>
			          	<#if totalCostsError??>	${totalCostsError}</#if>	
			        </div>
		        </#if>
            </div>
            
            
            <div class="form-group">	
                <input type="number" class="form-control mb-2 ${(dataError?? || storageError??)?string('is-invalid','')}" 
                name="storage" placeholder="Отложить в %"
                	   value = "<#if newIncome??>${newIncome.storage?if_exists}</#if>" >
               	<#if dataError?? || storageError??>
			        <div class="invalid-feedback">
			          	<#if dataError??>${dataError}</#if>
			          	<#if storageError??>${storageError}</#if>
			        </div>
		        </#if>
            </div>
            
            <div class="form-group">	
                <input type="number" class="form-control mb-2 ${(dataError?? || relaxError??)?string('is-invalid','')}" 
                name="relax" placeholder="На отдых в %"
                	   value = "<#if newIncome??>${newIncome.relax?if_exists}</#if>" >
                <#if dataError?? || relaxError??>
			        <div class="invalid-feedback">
			          	<#if dataError??>${dataError}</#if>
			          	<#if relaxError??>${relaxError}</#if>
			        </div>
		        </#if>
            </div>
            
            
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
        </form>
    </div>
</div>
</@c.page>