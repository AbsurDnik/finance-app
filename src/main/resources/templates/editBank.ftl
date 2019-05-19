<#import "/parts/custom.ftl" as c>
<@c.page>
<#if noAct>
<h2>Выберите желаемое действие</h2>

<div class="list-group">
	<a href="edit/replenish" class="list-group-item list-group-item-action">Пополнить</a>
	<a href="edit/write-off" class="list-group-item list-group-item-action">Списать</a>
</div>
<#else>
<form method = "post">
  <div class="form-group">
    <label>Категория : Общие затраты</label>
    <input type="number" class="form-control" placeholder="" name="totalCosts" value = "0">
    <small class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label>Категория : Отложка</label>
    <input type="number" class="form-control" placeholder="" name="storage" value = "0">
  </div>
  <div class="form-group">
    <label>Категория : Отдых</label>
    <input type="number" class="form-control" placeholder="" name="relax" value = "0">
  </div>
  <button type="submit" class="btn btn-primary">${button}</button>
</form>

</#if>
</@c.page>