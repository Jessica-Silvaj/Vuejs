<template>
  <div id="app">
    <header id="Menu">
      <button class="Add" tag="button" @click="$root.$emit('open-modal-novo')">
        <i class="gg-add"></i> Novo
      </button>
      <modal-novo> </modal-novo>
      <button
        class="Delete"
        tag="button"
        @click="$root.$emit('open-modal-excluir')"
      >
        <i class="gg-trash"></i> Excluir
      </button>
      <modal-excluir></modal-excluir>

      <button
        class="Add"
        tag="button"
        @click="$root.$emit('open-modal-editar')"
      >
        <i class="gg-edit-markup"></i>Editar
      </button>

      <modal-editar></modal-editar>
    </header>

    <div class="container">
      <div class="Card">
        <div>
          <h4>Gerenciamento de Produtos</h4>

          <input
            type="text"
            v-model="buscar"
            placeholder="Pesquisar nome do produto"
          />
          <button class="Buscar" @click="filtroBuscar">Pesquisar</button>
        </div>

        <hr />

        <table class="table table-striped">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Código</th>
              <th scope="col">Nome</th>
              <th scope="col">Categoria</th>
              <th scope="col">Preço</th>
              <th scope="col">Status</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="produto in filtro" :key="produto.id">
              <th scope="row">{{ produto.id }}</th>
              <td>{{ produto.codigo }}</td>
              <td>{{ produto.nome }}</td>
              <td>{{ produto.categoria }}</td>
              <td>{{ produto.preco }}</td>
              <td>{{ produto.status }}</td>
            </tr>
          </tbody>
        </table>
      </div>

      <button class="Delete-2" tag="button" @click="ExcluirTodos">
        <i class="gg-trash"></i> Excluir todos produtos
      </button>
    </div>
  </div>
</template>



<script>
import ModalEditar from "./components/ModalEditar.vue";
import ModalExcluir from "./components/ModalExcluir.vue";
import ModalNovo from "./components/ModalNovo.vue";
import Produtos from "./services/produtos";

export default {
  name: "App",
  data() {
    return {
      produtos: [],
      filtro: [],
      buscar: "",
      produto: {
        Id: "",
        nome: "",
        preco: "",
        codigo: "",
        descricao: "",
        categoria: "",
        status: "",
      },
    };
  },
  components: {
    ModalNovo,
    ModalExcluir,
    ModalEditar,
  },
  mounted() {
    Produtos.getAll().then((response) => {
      this.produtos = response.data;
      this.filtro = response.data;
    });
  },

  methods: {
    filtroBuscar: function () {
      this.filtro = this.produtos;

      if (this.buscar == "" || this.buscar == " ") {
        this.filtro = this.produtos;
      } else {
        this.filtro = this.produtos.filter(
          (produto) => produto.nome == this.buscar
        );
      }
    },

    ExcluirTodos() {
      if (confirm("Quer mesmo deleta todos os pordutos?")) {
        Produtos.excluir()
          .then((response) => {
            console.log(response);
            alert("Produtos apagados!");
          })
          .catch((e) => {
            console.log(e);
          });
      }
      window.location.reload();
    },
  },
};
</script>

<style scoped>
.Buscar {
  cursor: pointer;
  border: 0;
  background: #228b22;
  border-radius: 15px;
  font-weight: bold;
  color: #eee;
  padding: 5px;
  outline: none;
}

h4 {
  padding-top: 20px;
  margin: 30px;
  display: inline-block;
  font-weight: bold;
}
form {
  padding: 0;
}
input {
  display: inline-block;
  margin-left: 400px;
  border-radius: 5px;
  border: none;

  border: 1px solid #000000;
}
header {
  border-radius: 5px;
  margin: 20px;
  padding-right: px;
  display: flex;
  align-items: center;
  width: 94%;
  height: 70px;
  background-color: #eee;
}

.container {
  padding-top: 10px;
  margin-left: 100px;
  width: 1350px;
}

.Add {
  margin: 15px;
  display: flex;
  align-items: center;
  cursor: pointer;
  border: 0;
  background: #228b22;
  padding: 5px;
  outline: none;
  border-radius: 15px;
  font-weight: bold;
  color: #eee;
}
.gg-add {
  margin: 4px;
  color: #eee;
}
.Delete {
  color: #eee;
  width: 100px;
  height: 40px;
  display: flex;
  align-items: center;
  cursor: pointer;
  border: 0;
  background: #cd5c5c;
  padding: 5px;
  outline: none;
  border-radius: 15px;
  font-weight: bold;
}

.Delete-2 {
  color: #eee;
  width: 200px;
  height: 40px;
  display: flex;
  align-items: center;
  cursor: pointer;
  border: 0;
  background: #cd5c5c;
  padding: 5px;
  outline: none;
  border-radius: 15px;
  font-weight: bold;
}

.gg-trash {
  color: #eee;
  margin: 10px;
  box-sizing: border-box;
  position: relative;
  display: block;
  transform: scale(var(--ggs, 1));
  width: 10px;
  height: 12px;
  border: 2px solid transparent;
  box-shadow: 0 0 0 2px, inset -2px 0 0, inset 2px 0 0;
  border-bottom-left-radius: 1px;
  border-bottom-right-radius: 1px;
  margin-top: 10px;
}
.gg-trash::after,
.gg-trash::before {
  content: "";
  display: block;
  box-sizing: border-box;
  position: absolute;
}
.gg-trash::after {
  background: currentColor;
  border-radius: 3px;
  width: 16px;
  height: 2px;
  top: -4px;
  left: -5px;
}
.gg-trash::before {
  width: 10px;
  height: 4px;
  border: 2px solid;
  border-bottom: transparent;
  border-top-left-radius: 2px;
  border-top-right-radius: 2px;
  top: -7px;
  left: -2px;
}
.Card {
  background: #eee;

  transition: 0.3s;
  border-radius: 5px;
}

.gg-edit-markup {
  margin: 5px;
  box-sizing: border-box;
  position: relative;
  display: block;
  transform: scale(var(--ggs, 1));
  width: 22px;
  height: 22px;
  border: 2px solid;
  border-radius: 22px;
  overflow: hidden;
  perspective: 20px;
}
.gg-edit-markup::after,
.gg-edit-markup::before {
  content: "";
  display: block;
  position: absolute;
  box-sizing: border-box;
}
.gg-edit-markup::before {
  width: 0;
  height: 6px;
  border-bottom: 6px solid;
  border-left: 3px solid transparent;
  border-right: 3px solid transparent;
  bottom: 9px;
  left: 6px;
}
.gg-edit-markup::after {
  width: 10px;
  height: 12px;
  border: 2px solid;
  border-top: 4px solid;
  border-bottom: 0;
  bottom: 0;
  left: 4px;
  transform: rotateX(60deg);
}
</style>
