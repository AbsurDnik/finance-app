<#import "/parts/custom.ftl" as c>
<@c.page>

<ul class="list-group">
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Расход
    <span class="badge badge-primary badge-pill">${currentConsumption.myConsumption} грн.</span>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Дата и время создание
    <span class="badge badge-primary badge-pill">${currentConsumption.creationDateTime}</span>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Категория расхода
    <span class="badge badge-primary badge-pill">${currentConsumption.category}</span>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Описание расхода
    <span class="badge badge-primary badge-pill">${currentConsumption.subCategory}</span>
  </li>
</ul>

</@c.page>