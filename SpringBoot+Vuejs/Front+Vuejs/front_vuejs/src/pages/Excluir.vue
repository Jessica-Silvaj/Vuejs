<template>
  <div class="container">
    <div>
      <router-link class="Add-b" tag="button" to="/" exact>
        Volta para página anterior
      </router-link>
    </div>

    <div class="Card-B">
      <div class="Titulo">
        <h2>Excluir Produtos</h2>
      </div>
      <hr />

      <div class="Formulario">
        <form @submit.prevent="salvar">
          <label class="mini">ID do Produto: </label>
          <input type="text" v-model="produto.id" />

          <div class="Posicao">
            <button @click="remover(produto)" class="Excluir">
              Excluir Dados
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Produtos from "../services/produtos";

export default {
  data() {
    return {
      produto: {
        id: "",
      },
    };
  },

  methods: {
    salvar() {
      Produtos.salvar(this.produto).then((response) => {
        this.produto = response.data;
      });
    },

    remover() {
      Produtos.apagar(this.produto.id)
        .then((response) => {
          this.produto = response.data;
          this.errors = [];
          alert("Produto apagado com sucesso!");
        })
        .catch((e) => {
          this.errors = e.response.data.errors;
        });
    },
  },
};
</script>

<style scoped>
.Excluir {
  cursor: pointer;
  border: 0;
  background: #eee;
  padding: 5px;
  outline: none;
  border-radius: 15px;
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
  background: #1e90ff;
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
  height: 418px;
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