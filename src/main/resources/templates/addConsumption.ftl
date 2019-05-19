<#import "/parts/custom.ftl" as c>
<@c.page>
<#if noType>
<h2>Выберите тип рассхода</h2>

<div class="list-group">
	<a href="add-consumption/total-costs" class="list-group-item list-group-item-action">Общие затраты</a>
	<a href="add-consumption/relax" class="list-group-item list-group-item-action">Отдых</a>
</div>
<#else>
<form method = "post">

  	
  	<div class="form-row">
	  	<div class="col-auto">
		    <div class="input-group mb-2">
		    
			    <input type="number" 
			    class="form-control mb-2 ${(dataError?? || myConsumptionError??)?string('is-invalid','')}" 
			    placeholder="Введите ваш расход"
			    name="myConsumption">
			    <#if dataError?? || myConsumptionError??>
			        <div class="invalid-feedback">
			          	<#if dataError??>${dataError}</#if>
			          	<#if myConsumptionError??>	${myConsumptionError}</#if>	
			        </div>
		        </#if>
			    <div class="input-group-postpend">
			          <div class="input-group-text">Ваш лимит на ${consumptionType}: ${limit}</div>
			  	</div>
			  	
		  	</div>
	  	</div>
  	</div>
	
	<div class="form-row">
	  	<div class="col-auto">
		    <div class="input-group mb-2">
		    
			    <input type="text" class="form-control mb-2" placeholder="..." name="subCategory">
			    <div class="input-group-postpend">
			          <div class="input-group-text">Описание расхода</div>
			  	</div>
			  	
		  	</div>
	  	</div>
  	</div>
	
  	<button type="submit" class="btn btn-primary">Записать расход</button>
</form>
</#if>
</@c.page>