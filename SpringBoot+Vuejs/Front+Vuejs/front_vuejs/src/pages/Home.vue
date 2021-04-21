<template>
  <div id="app">

    <div class="Filtro">
    <div class="col-md mb-5" >
      <h3
        class="mb-1"
        data-bs-toggle="collapse"
        href="#collapseExample"
        role="button"
        aria-expanded="false"
        aria-controls="collapseExample"
      >
        Filtros de busca
      </h3>

      <div class="collapse show" id="collapseExample">
        <div class="card card-body">
          <form class="row" @submit.prevent="">
            <input type="hidden" name="action" value="search" v-model="produto.nome" />

            <div class="col-md-3">
              <input
                type="text"
                class="form-control"
                id="keyword"
                name="keyword"
                placeholder="Nome do produto"
              />
            </div>

            <div class="col-md-3" id="button">
              <button type="submit" @click="BuscarNome" class="btn btn-primary">Filtrar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>


      
    <div class="container">
      <div class="Card">
        <table class="table table-striped">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Código</th>
              <th scope="col">Nome</th>
              <th scope="col">Descricão</th>
              <th scope="col">Categoria</th>
              <th scope="col">Preço</th>
              <th scope="col">Status</th>
              
              
            </tr>
          </thead>
          <tbody>
            <tr v-for="produto in produtos" :key="produto.id">
              <th scope="row">{{ produto.id }}</th>
              <td>{{ produto.codigo }}</td>
              <td>{{ produto.nome }}</td>
              <td>{{ produto.descricao }}</td>
              <td>{{ produto.categoria }}</td>
              <td>{{ produto.preco }}</td>
              <td>{{ produto.status }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

  </div>
</template>

<script>
import Produtos from "../services/produtos";

export default {
  name: "App",
  data() {
    return {
      produtos: [],
      produto: {
        nome:''
      }
      
    };
  },
  mounted() {
    Produtos.getAll().then((resposta) => {
      this.produtos = resposta.data;
    });
  },
  methods:{
     
     BuscarNome(){
       Produtos.Buscar(this.nome).then((response)=>{
         this.produto = response.data;
         console.log(response.data)
       })
     },
     
  },
  
};
</script>

<style scoped>
#button{
  margin-left: 540px;
}

input{
  margin-left: 30px;
  width: 850px;
}
.Filtro{
  padding-top: 30px;
  margin-left: 100px;
}

#collapseExample{
  width: 1150px;
}
.container {
  padding-top: 10px;
  margin-left: 100px;
  width: 1450px;
}
.Card {
  
  background: #fffff0;
  transition: 0.3s;
  border-radius: 5px;
}


</style>
