<template>
  <div class="container">
    <div>
      <router-link class="Add-b" tag="button" to="/" exact>
        Volta para página anterior
      </router-link>
    </div>

    <div class="Card-B">
      <div class="Titulo">
        <h2>Editar Produtos</h2>
      </div>
      <hr />

      <div class="Formulario">
        <form @submit.prevent="salvarCadastro">
          <label class="mini">ID do Produto: </label>
          <input type="text" v-model="produto.id" />

          <label class="mini">Nome do Produto: </label>
          <input type="text" v-model="produto.nome" />

          <label class="mini">Categoria: </label>
          <div class="combobox">
            <ejs-combobox
              id="combobox"
              :dataSource="categoria"
              v-model="produto.categoria"
              placeholder="Selecione a categoria"
            ></ejs-combobox>
          </div>

          <label class="mini">Código: </label>
          <input type="text" v-model="produto.codigo" />

          <label class="mini">Status: </label>
          <div class="combobox">
            <ejs-combobox
              id="combobox"
              :dataSource="status"
              placeholder="Selecione a categoria"
              v-model="produto.status"
            ></ejs-combobox>
          </div>

          <label class="mini">Descricão: </label>
          <textarea v-model="produto.descricao">
 
                    Descricão do produto
                </textarea
          >

          <label class="mini">Preço: </label>
          <input type="number" step="0.01" min="0.01" v-model="produto.preco" />

          <div class="Posicao">
            <button @click="editar(produto)" class="Editar">
              Editar Dados
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import { ComboBoxPlugin } from "@syncfusion/ej2-vue-dropdowns";
Vue.use(ComboBoxPlugin);

import Produtos from "../services/produtos";

export default {
  name: "cotainer",
  data() {
    return {
      categoria: [],
      status: [],
      produto: {
        id: null,
        nome: "",
        categoria: "",
        codigo: "",
        status: "",
        descricao: "",
        preco: "",
      },
    };
  },

  mounted() {
    Produtos.ListCateg().then((response) => {
      this.categoria = response.data;
    });

    Produtos.ListStatus().then((response) => {
      this.status = response.data;
    });

    this.listar();
  },

  methods: {
    listar() {
      Produtos.getAll().then((response) => {
        this.Produtos = response.data;
      });
    },

    salvarCadastro() {
      if (!this.produto.id) {
        Produtos.salvar(this.produto)
          .then((response) => {
            this.produto = response.data;
            this.listar();
            alert("Salvo com sucesso!");
          })
          .catch((e) => {
            this.errors = e.response.data.errors;
          });
      } else {
        Produtos.atualizar(this.id, this.produto)
          .then((response) => {
            this.produto = response.data;
            this.listar();
            alert("Atualizado com sucesso!");
            this.errors = [];
          })
          .catch((e) => {
            this.errors = e.response.data.errors;
          });
      }
    },

    editar(produto) {
      this.produto = produto;
    },
  },
};
</script>

<style scoped>
.combobox {
  padding-top: -20px;
  flex-direction: column;
  margin-left: 80px;
  width: 500px;
  border-radius: 10px;
  border: none;
}

textarea {
  margin-left: 80px;
  width: 500px;
  border-radius: 10px;
  border: none;
  -moz-border-radius: 4px;
  -webkit-border-radius: 4px;
  box-shadow: 1px 1px 2px #333333;
  -moz-box-shadow: 1px 1px 2px #333333;
  -webkit-box-shadow: 1px 1px 2px #333333;
  background: #eee;
  border: 1px solid #000000;
}

.Posicao {
  margin-left: 10px;
  text-align: center;
}

button {
  margin: 15px;
  font-family: sans-serif;
  font-size: 20px;
  font-weight: bold;
  padding-top: 10px;
  justify-content: center;
  display: inline-block;
}
.Editar {
  cursor: pointer;
  border: 0;
  background: #eee;
  padding: 5px;
  outline: none;
  border-radius: 15px;
}
.mini {
  margin-left: 80px;
  margin-right: 5px;
  font-weight: bold;
  font-size: 20px;
  display: flex;
  flex-direction: column;
}
input {
  flex-direction: column;
  margin-left: 80px;
  width: 500px;
  border-radius: 10px;
  border: none;
  -moz-border-radius: 4px;
  -webkit-border-radius: 4px;
  box-shadow: 1px 1px 2px #333333;
  -moz-box-shadow: 1px 1px 2px #333333;
  -webkit-box-shadow: 1px 1px 2px #333333;
  background: #eee;
  border: 1px solid #000000;
}
.Formulario {
  margin-left: 55px;
  padding-top: 15px;
  display: flex;
}
.Titulo {
  padding-top: 15px;
  margin-left: 15px;
  font-family: sans-serif;
  font-size: 28px;
  font-weight: bold;
  padding-top: 50px;
  justify-content: center;
  display: flex;
  color: #eee;
}
.container {
  padding-top: 0;
  margin-left: 30px;
  width: 400px;
}

.Add-b {
  margin: 15px;
  display: flex;
  align-items: center;
  cursor: pointer;
  border: 0;
  background: #1e90ff;
  padding: 5px;
  outline: none;
  border-radius: 15px;
  font-weight: bold;
}

.Card-B {
  margin-left: 200px;
  width: 850px;
  background: #fffff0;
  box-shadow: 0 4px 8px 0 grey;
  transition: 0.3s;
  border-radius: 10px;
  background: rgb(200, 200, 233);
  background: linear-gradient(
    90deg,
    rgba(200, 200, 233, 1) 0%,
    rgba(27, 74, 148, 1) 100%
  );
  box-shadow: 1px 1px 2px #333333;
  -moz-box-shadow: 1px 1px 2px #333333;
  -webkit-box-shadow: 1px 1px 2px #333333;
  border: 1px solid #000000;
}
</style>