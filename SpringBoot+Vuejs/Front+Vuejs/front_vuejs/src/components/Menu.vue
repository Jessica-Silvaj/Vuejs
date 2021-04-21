<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      <div class="container-fluid">
        <a class="navbar-brand" href="/" id="Titulo"
          >Gerenciamento de produtos</a
        >
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="">
          <router-link tag="button" to="/AdicionarProd" exact> Adicionar</router-link>
          <router-link tag="button" to="/Editar" exact> Editar </router-link>
           <router-link tag="button" to="/Excluir" exact> Excluir</router-link>

        </div>
      </div>
    </nav>

    <router-view />
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
button {
  justify-content: right;
  padding-right: 15px;
  margin: 15px;
  display: inline-block;
  font-family: sans-serif;
  font-size: 20px;
  font-weight: bold;
  background: #eee;
  border: 0;
  outline: none;
  border-radius: 15px;
}
</style>