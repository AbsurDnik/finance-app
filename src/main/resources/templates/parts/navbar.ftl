<nav class="navbar  navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/">Подсчет финансов</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item <#if currentPage=="mainPage">active</#if>">
        <a class="nav-link" href="/">Домашняя страница</a>
      </li>
      <li class="nav-item <#if currentPage=="incomePage">active</#if>">
        <a class="nav-link" href="/my-income">Учет доходов</a>
      </li>
      <li class="nav-item <#if currentPage=="consumptionPage">active</#if>">
        <a class="nav-link" href="/my-consumption">Учет рассходов</a>
      </li>
    </ul>
  </div>
</nav>